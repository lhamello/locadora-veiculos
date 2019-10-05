package br.com.tt.locadoraveiculos.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.tt.locadoraveiculos.excecao.DataInvalidaException;
import br.com.tt.locadoraveiculos.model.enums.SituacaoLocacao;

public class Locacao {

	private Cliente cliente;
	private Veiculo veiculo;
	private LocalDate dataLocacao;
	private LocalDate dataEntrega;
	private Double valor;
	private SituacaoLocacao situacao;

	public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao) throws DataInvalidaException {
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.setDataLocacao(dataLocacao);
		this.dataEntrega = null;
		this.valor = 0.0;
		this.situacao = SituacaoLocacao.ATIVA;
	}

	private void setDataLocacao(LocalDate dataLocacao) throws DataInvalidaException {
		LocalDate dataAtual = LocalDate.now();

		if (dataLocacao.isAfter(dataAtual)) {
			throw new DataInvalidaException("   >>> Data da locação não pode ser maior que data atual. <<<");
		}

		this.dataLocacao = dataLocacao;
	}
	
	public void encerrar(Float kmAtualVeiculo) {
		this.dataEntrega = LocalDate.now();
		this.situacao = SituacaoLocacao.FINALIZADA;
		this.valor = this.calcularValorLocacao(kmAtualVeiculo); 
		this.veiculo.atualizarQuilometragem(kmAtualVeiculo);
	}
	
	private Double calcularValorLocacao(Float kmAtualVeiculo) {
		long diarias = ChronoUnit.DAYS.between(dataLocacao, dataEntrega) + 1;
		Float kmAnterior = veiculo.getQuilometragem();
		Double valorDiaria = 47.35;
		Double valorKmRodado = veiculo.getValorKmRodado();
		
		return (diarias * valorDiaria) + 
				((kmAtualVeiculo - kmAnterior) * valorKmRodado);
	}

	public boolean isAtiva() {
		return SituacaoLocacao.ATIVA == situacao;
	}

	public Double getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Locacao[cliente=%s,veiculo=%s,dataLocacao=%s," + "dataEntrega=%s,valor=R$ %.2f,situacao=%s]", cliente,
				veiculo, dataLocacao, dataEntrega, valor, situacao);
	}
}

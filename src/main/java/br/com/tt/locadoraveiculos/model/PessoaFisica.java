package br.com.tt.locadoraveiculos.model;

import br.com.tt.locadoraveiculos.model.enums.TipoDocumento;

public class PessoaFisica extends Cliente {

  private TipoDocumento tipoDocumento;
  private String numeroDocumento;

  public PessoaFisica(String nome, TipoDocumento tipoDocumento, String numeroDocumento) {
    super(nome);
    this.tipoDocumento = tipoDocumento;
    this.numeroDocumento = numeroDocumento;
  }

  @Override
  public String toString() {
    return String.format("Cliente#PessoaFisica[nome=%s,tipoDocumento=%s,numeroDocumento=%s]", 
        nome, 
        tipoDocumento,
        numeroDocumento);
  }
}

package br.com.tt.locadoraveiculos.view;

import java.util.List;

import br.com.tt.locadoraveiculos.infra.BancoDados;
import br.com.tt.locadoraveiculos.model.Cliente;
import br.com.tt.locadoraveiculos.model.PessoaFisica;
import br.com.tt.locadoraveiculos.model.PessoaJuridica;
import br.com.tt.locadoraveiculos.model.enums.TipoCliente;
import br.com.tt.locadoraveiculos.model.enums.TipoDocumento;

public class TelaCliente extends Tela {

  @Override
  public void apresentarTela() {
    do {
      this.imprimirMenu();
      int opcaoUsuario = super.solicitarOpcaoNumerica();
      
      switch (opcaoUsuario) {
      case 1:
        this.cadastrarCliente();
        break;

      case 2:
        this.listarClientes();
        break;

      case 0:
        return;

      default:
        System.out.println("   >>> Opção inválida! Digite novamente. <<<");
        break;
      }

    } while (true);
  }
  
  private void imprimirMenu() {
    StringBuilder menu = new StringBuilder()
        .append(System.getProperty("line.separator"))
        .append("+============== MENU CLIENTES ==============+").append(System.getProperty("line.separator"))
        .append("|  Digite:                                  |").append(System.getProperty("line.separator"))
        .append("|    - [1] para Cadastrar Cliente           |").append(System.getProperty("line.separator"))
        .append("|    - [2] para Listar Clientes             |").append(System.getProperty("line.separator"))
        .append("|    - [0] para Retornar ao Menu Principal  |").append(System.getProperty("line.separator"))
        .append("+===========================================+").append(System.getProperty("line.separator"));
    System.out.println(menu.toString());
  }
  
  private void cadastrarCliente() {
    TipoCliente tipoCliente = this.solicitarTipoCliente();
    String nome = this.solicitarNome();
    Cliente cliente;
    
    if (TipoCliente.PESSOA_FISICA == tipoCliente) {
      TipoDocumento tipoDocumento = this.solicitarTipoDocumento();
      String numeroDocumento = this.solicitarNumeroDocumento();
      
      cliente = new PessoaFisica(nome, tipoDocumento, numeroDocumento);
    } else {
      String cnpj = this.solicitarCnpj();
      
      cliente = new PessoaJuridica(nome, cnpj);
    }
    
    BancoDados bancoDeDados = BancoDados.getUnicaInstancia();
    bancoDeDados.adicionarCliente(cliente);
    
    System.out.println(" >>> Cliente adicionado com sucesso! <<<");
  }
  
  private TipoCliente solicitarTipoCliente() {
    TipoCliente tipoCliente = null;

    do {
      System.out.print("Digite tipo de cliente [PESSOA_FISICA], ou [PESSOA_JURIDICA]:");
      String valorDigitado = scanner.nextLine();

      try {
        tipoCliente = TipoCliente.valueOf(valorDigitado.toUpperCase());
      } catch (IllegalArgumentException excecao) {
        System.out.println("  >>> Tipo de cliente inválido! Digite novamente. <<<");
      }
    } while (tipoCliente == null);

    return tipoCliente;
  }
  
  private String solicitarNome() {
    System.out.print("Digite o nome:");
    return super.solicitarTexto();
  }
  
  private TipoDocumento solicitarTipoDocumento() {
    TipoDocumento tipoCliente = null;

    do {
      System.out.print("Digite tipo de documento [CPF], [CNH] ou [RG]:");
      String valorDigitado = scanner.nextLine();

      try {
        tipoCliente = TipoDocumento.valueOf(valorDigitado.toUpperCase());
      } catch (IllegalArgumentException excecao) {
        System.out.println("  >>> Tipo de documento inválido! Digite novamente. <<<");
      }
    } while (tipoCliente == null);

    return tipoCliente;
  }
  
  private String solicitarNumeroDocumento() {
    System.out.print("Digite o número do documento:");
    return super.solicitarTexto();
  }
  
  private String solicitarCnpj() {
    System.out.print("Digite o número do CNPJ:");
    return super.solicitarTexto();
  }
  
  private void listarClientes() {
    BancoDados bancoDeDados = BancoDados.getUnicaInstancia();
    List<Cliente> clientes = bancoDeDados.listarTodosClientes();
    
    for (Cliente cliente : clientes) {
      System.out.println(cliente);
    }
  }
}

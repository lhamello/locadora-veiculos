# Uso das palavras This e Super
## This
*This* é usado para fazer auto-referência ao próprio contexto em que se encontra. Resumidamente, *this* sempre será a própria classe ou o objeto já instanciado e utilizamos para nos referenciar à um método ou atributo da própria classe.

## Super
Já a palavra *Super* é utilizada para fazer referência à um método ou atributo da classe pai.

Exemplo:
```Java
public class PessoaFisica extends Cliente {

  private TipoDocumento tipoDocumento;
  private String numeroDocumento;

  public PessoaFisica(String nome, TipoDocumento tipoDocumento, String numeroDocumento) {
    super(nome);
    this.tipoDocumento = tipoDocumento;
    this.numeroDocumento = numeroDocumento;
    super.fazAlgumaCoisa();
    this.fazOutraCoisa();
  }  
  ...
```

Neste exemplo, no método construtor (o único da classe), na primeira linha dentro dele temos:
```Java
super(nome);
```
Isto indica que está sendo chamado o construtor da classe pai que recebe uma String como argumento.

Nas duas próximas linhas temos:
```Java
this.tipoDocumento = tipoDocumento;
this.numeroDocumento = numeroDocumento;
```
Isto indica que os atributos, desta classe, *this.tipoDocumento* e *this.numeroDocumento* estão recebendo os valores dos parâmetros (de mesmo nome) *tipoDocumento* e *numeroDocumento*.

Na linha seguinte temos:
```Java
super.fazAlgumaCoisa();
```
Isto indica que está sendo chamado o método *fazAlgumaCoisa()* da classe pai.

E por último temos:
```Java
this.fazOutraCoisa();
```
Isto indica que está sendo chamado o método *fazOutraCoisa()* da própria classe.

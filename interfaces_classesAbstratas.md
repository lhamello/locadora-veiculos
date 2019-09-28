# Polimorfismo, Interfaces e Classes Abstratas, Sobrescritas e Overload de Métodos

## Polimorfismo
O polimorfismo, como o nome indica, permite à um mesmo objeto assumir diferentes formas. Desta forma, permite que classes abstratas possam receber comportamentos através de classes concretas.
Em Java, fazemos o uso do polimorfismo a partir da implementação de *interfaces* ou da herança de *classes abstratas*, como veremos abaixo.

## Interfaces
- Interface definem um contrato para as classes concretas que as implementarem.
- As classes concretas, que implementarem uma interface, serão obrigados a sobrescreverem os métodos da mesma.
- Cada classe concreta pode implementar os métodos da interface de uma forma diferente.
- As interfaces são formadas por um ou mais métodos, e também podem possuir constantes.
Exemplo:
```Java
public inteface FiguraGeometrica {
  String getFigura();
  double calcularArea();
}
 ```
```Java
public class Quadrado implements FiguraGeometrica {
	private double lado;
    ...
    @Override
	public String getFigura() {
		return "Quadrado";
	}
	
	@Override
	public double calcularArea() {
		return lado * lado;
	}
}
 ```
```Java
public class Circulo implements FiguraGeometrica {
	private double raio;
    ...
    
	@Override
	public String getFigura() {
		return "Circulo";
	}

	@Override
	public double calcularArea() {
		return Mathi.PI * (Math.pow(raio, 2));
	}
}
 ```
Notem que as classes **Circulo** e **Quadrado** possuem (ambas) os método *getFigura()* e *calcularArea()* e que os mesmos possuem a anotação *@Override*. Esta anotação indica que estas classes estão sobrescrevendo os métodos *getFigura()* e *calcularArea()* definido na interface **FiguraGeometrica**.
Outro ganho que tenho é que agora eu posso ter uma lista de figuras geométricas e ter dentro desta lista figuras diferentes.

```Java
public class Programa {
	public static void main() {
		List<FiguraGeometrica> figuras = bancoDados.listarFigurasGeometricas();
		Figura figura = figuras.get(0);
		figura.calcularArea();
	}
}
 ```

Dado que eu tenha figuras na minha lista, eu só saberei o que será impresso na linha *figura.getFigura()* em tempo de execução, pois ela pode ser tanto um círculo como um quadrado. Isto é um ganho do polimofirmos.

## Classes Abstratas
- São parecidas com interfaces, a diferença é que podem conter atributos e também podem conter métodos concretos, ou seja, que contenham implementação.
- A classes concretas herdam (*extends*) de uma classe abstrata.
- Também posso utilizar a classe abstrata para evitar a repetição de código.

Exemplo:
```Java
package br.com.lhamello.model;

import br.com.lhamello.enums.TipoCombustivel;

public abstract class Veiculo {

  protected String placa;
  protected String marca;
  protected String modelo;
  protected float quilometragem;
  protected TipoCombustivel tipoCombustivel;

  public Veiculo(String placa, String marca, String modelo, float quilometragem, TipoCombustivel tipoCombustivel) {
    this.placa = placa;
    this.marca = marca;
    this.modelo = modelo;
    this.quilometragem = quilometragem;
    this.tipoCombustivel = tipoCombustivel;
  }

  public void atualizarQuilometragem(float kmAtualVeiculo) {
    this.quilometragem = kmAtualVeiculo;
  }
  
  public float getQuilometragem() {
    return quilometragem;
  }
  
  public abstract double getValorKmRodado();
}

```
```Java
public class Moto extends Veiculo {

  private Cilindrada cilindrada;

  public Moto(String placa, String marca, String modelo, float quilometragem, TipoCombustivel tipoCombustivel, Cilindrada cilindrada) {
    super(placa, marca, modelo, quilometragem, tipoCombustivel);
    this.cilindrada = cilindrada;
  }
  
  @Override
  public double getValorKmRodado() {
    switch (cilindrada) {
    case CC125:
      return 1.25;
    case CC250:
      return 1.50;
    case CC500:
      return 1.75;
    default:
      return 1.99;
    }
  }
}
```
```Java
package br.com.lhamello.model;

import br.com.lhamello.enums.Cambio;
import br.com.lhamello.enums.NumeroPortas;
import br.com.lhamello.enums.TipoCarro;
import br.com.lhamello.enums.TipoCombustivel;

public class Carro extends Veiculo {

  private TipoCarro tipo;
  private Cambio cambio;
  private NumeroPortas numeroPortas;

  public Carro(String placa, String marca, String modelo, float quilometragem, TipoCombustivel tipoCombustivel, TipoCarro tipoCarro, Cambio cambio, NumeroPortas numeroPortas) {
    super(placa, marca, modelo, quilometragem, tipoCombustivel);
    this.tipo = tipoCarro;
    this.cambio = cambio;
    this.numeroPortas = numeroPortas;
  }

  @Override
  public double getValorKmRodado() {
    switch (tipo) {
    case HATCH:
      return 2.19;
    case SEDAN:
      return 2.37;
    case SUV:
      return 2.54;
    default:
      return 3.71;
    }
  }
}

```
Neste exemplo temos as classes **Carro** e **Moto** herdando da classe **Veículo**. Com isto, os atributos definidos na classe **Veículo** também fazem parte da classe **Carro** e **Moto** e evitamos de termos que definí-los em mais de mais de uma classe.
A classe **Veículo** também possuim 3 métodos, dois são concretos *atualizarQuilometragem(float kmAtualVeiculo)* e *getQuilometragem()* que podem ser acessados também de suas classes filhas. O outro método *getValorKmRodado()* é abstrato o que faz com que as classes filhas tenham que obrigatoriamente implementá-lo, mesmo compartamento da interface.

## Sobrescrita e Overload de Métodos
- Sobrescrita de método é quando sobrescrevemos um método de uma interface ou de uma classe abstrata, como vimos nos exemplos acima.
- Já *Overload* de método é quando temos dois ou mais métodos com assinatura nomes iguais, mas a assinatura difere-se nos parâmetros destes métodos.

Exemplo:
```Java
public class Exemplo {
...
	public void fazAlgumaCoisa() {
		...
	}
	
	public void fazAlgumaCoisa(String s) {
		...
	}

	public void fazAlgumaCoisa(Integer i) {
		...
	}
	
	public void fazAlgumaCoisa(String s, Integer i) {
		...
	}
}
```

Vejam a classe acima, eu tenho 4 métodos com o mesmo nome, porém a assinatura delas são diferentes, pois os parâmetros são diferentes.
Portanto está classe acima é válida e este é o conceito de Overload.

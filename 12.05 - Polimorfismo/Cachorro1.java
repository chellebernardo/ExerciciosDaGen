package ExerciciosJavaTurma22;

public class Cachorro1 extends AnimalPOO{

	public Cachorro1 (String nome, int idade) {
		
		super (nome, idade);
	}
	
	public void imprimir () {
		System.out.print("\nNome do animal: "+getNome()+"\nIdade: "+getIdade());
	}
	
	@Override
	public void emitirSom () {
		System.out.println("\nSom emitido: Latindo e fazendo jutsu morde canela...");
	}
	
	@Override
	public void comportamento(){
		
		System.out.print("\nComportamento: Corre atrás do rabo e diz que precisa encontrar um 'certo' alguém...");
	}

}

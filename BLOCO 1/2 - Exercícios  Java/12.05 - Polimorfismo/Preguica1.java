package ExerciciosJavaTurma22;

public class Preguica1 extends AnimalPOO {
	
	public Preguica1 (String nome, int idade) {
		
		super (nome, idade);
	}
	
	public void imprimir () {
		System.out.print("\nNome do animal: "+getNome()+"\nIdade: "+getIdade());
	}
	
	@Override
	public void emitirSom () {
		System.out.println("\nSom emitdo: Grunhindo em som de AAA AAA e pergunta onde está o Many...");
	}
	
	@Override
	public void comportamento(){
		
		System.out.print("\nComportamento: Sobindo em árvores e irritando o Diego...");
	
	}
}

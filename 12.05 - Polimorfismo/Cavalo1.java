package ExerciciosJavaTurma22;

public class Cavalo1 extends AnimalPOO{
	
	public Cavalo1 (String nome, int idade) {
		
		super (nome, idade);
	}
	
	public void imprimir () {
	System.out.print("\nNome do animal: "+getNome()+"\nIdade: "+getIdade());
	}
	
	@Override
	public void emitirSom () {
		System.out.println("\nSom emitido: Relinchando e debochando dos caras pálidas...");
	}
	
	@Override
	public void comportamento(){
	
		System.out.print("\nComportamento: Trota pelos belos pastos e dá coice nas falsieles...");
	
	}
}

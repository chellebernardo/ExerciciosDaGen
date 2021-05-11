package ExerciciosJavaTurma22;

public class cavalo extends animal{

	private String correCavalga;
	
	public cavalo (String nome, int idade, String som, String correCavalga){
		
		super(nome, idade, som);
		
		this.correCavalga = correCavalga;
	}
	public void imprimir () {
		System.out.print("\nNome do animal: "+getNome()+"\nIdade: "+getIdade()+"\nSom que faz: "+getSom()+"\nComportamento: "+correCavalga);
	}
	public String getCorreCalvaga() {
		return correCavalga;
	}
	public void setCorreCalvaga(String correCalvaga) {
		this.correCavalga = correCalvaga;
	}
	
}




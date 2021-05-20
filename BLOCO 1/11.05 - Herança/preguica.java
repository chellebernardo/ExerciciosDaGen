package ExerciciosJavaTurma22;

public class preguica extends animal {

	private String sobeArvores;
	
	public preguica (String nome, int idade, String som, String sobeArvores) {
		
		super(nome, idade, som);
		
		this.sobeArvores = sobeArvores;
	}
	public void imprimir() {
		
		System.out.print("\nNome do animal: "+getNome()+"\nIdade: "+getIdade()+"\nSom que faz: "+getSom()+"\nComportamento: "+sobeArvores);
	}
}

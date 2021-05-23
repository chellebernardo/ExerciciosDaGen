package ExerciciosJavaTurma22;

public class cachorro extends animal {
	
	private String corre;
	
	public cachorro (String nome, int idade, String som, String corre) {
		
		super (nome, idade, som);
		
		this.corre = corre;
		
	}
	public void imprimir () {
		System.out.print("\nNome do animal: "+getNome()+"\nIdade: "+getIdade()+"\nSom que faz: "+getSom()+"\nComportamento: "+corre);
	}
	public String getCorre() {
		return corre;
	}
	public void setCorre(String corre) {
		this.corre = corre;
	}
	
}

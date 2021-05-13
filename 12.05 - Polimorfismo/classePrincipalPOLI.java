package ExerciciosJavaTurma22;

public class classePrincipalPOLI {
	
	public static void main(String[] args) {
		
		Cachorro1 toto = new Cachorro1 ("SASUKEEEE", 1);
		Cavalo1 pocoto = new Cavalo1 ("Spirit", 5);
		Preguica1 lazy = new Preguica1 ("Sid", 13);
		
		toto.imprimir();
		toto.comportamento();
		toto.emitirSom();
		
		System.out.println("\n\t\t***************");
		
		pocoto.imprimir();
		pocoto.comportamento();
		pocoto.emitirSom();
		
		System.out.println("\n\t\t***************");
		
		lazy.imprimir();
		lazy.comportamento();
		lazy.emitirSom();
		
		
	}

}

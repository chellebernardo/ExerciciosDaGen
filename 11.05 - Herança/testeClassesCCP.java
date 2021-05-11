package ExerciciosJavaTurma22;

public class testeClassesCCP {

	public static void main(String[] args) {
		
		cachorro dog1 = new cachorro("Sasuke", 1, "Late e e faz o jutsu morde canela", "corre em circulos e atrás do rabo!");
		cavalo horse1 = new cavalo ("Spirit", 5, "Relincha e da coice nos falsos", "corre cavalgando pelos belos pastos!");
		preguica lazy1 = new preguica ("Sid", 13, "Faz um grunido quando está se sentindo ameaçada e diz 'Hey Many' e 'A gente vai morrer!'", "sobe em arvores e dorme de cabeça pra baixo!");
		
		
		dog1.imprimir();
		System.out.println("\n\n\t*********************");
		horse1.imprimir();
		System.out.println("\n\n\t*********************");
		lazy1.imprimir();
	}
}

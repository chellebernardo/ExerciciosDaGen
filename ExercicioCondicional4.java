package ExerciciosJavaTurma22;

/*4-	Fa�a um programa em que permita a entrada de um n�mero qualquer e exiba se este n�mero � par ou �mpar. 
 * Se for par exiba tamb�m a raiz quadrada do mesmo; 
 * se for �mpar exiba o n�mero elevado ao quadrado.*/

		import java.util.*;

public class ExercicioCondicional4 {

		public static void main(String[] args) {
			
			Scanner ler = new Scanner (System.in);
			
			System.out.println("\n\t\tSeja bem-vinde!\n");
			
			double num;
			
			System.out.printf ("\nDigite um n�mero: ");
			num = ler.nextDouble();
			
			if (num%2==0) {
		
				num = Math.sqrt(num);
				System.out.printf("\nO n�mero digitado � par e a raiz quadrada dele �: %2.2f", num); 
			}
			else {
				num = Math.pow(num, 2);
				System.out.printf ("\nO n�mero digitado � �mpar e o resultado desse n�mero ao quadrado �: "+num); 
			}
			System.out.print("\n\n\t\tAgrade�o pela participa��o!");
			
		}
}

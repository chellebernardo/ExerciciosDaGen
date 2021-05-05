package ExerciciosJavaTurma22;

/*4-	Faça um programa em que permita a entrada de um número qualquer e exiba se este número é par ou ímpar. 
 * Se for par exiba também a raiz quadrada do mesmo; 
 * se for ímpar exiba o número elevado ao quadrado.*/

		import java.util.*;

public class ExercicioCondicional4 {

		public static void main(String[] args) {
			
			Scanner ler = new Scanner (System.in);
			
			System.out.println("\n\t\tSeja bem-vinde!\n");
			
			double num;
			
			System.out.printf ("\nDigite um número: ");
			num = ler.nextDouble();
			
			if (num%2==0) {
		
				num = Math.sqrt(num);
				System.out.printf("\nO número digitado é par e a raiz quadrada dele é: %2.2f", num); 
			}
			else {
				num = Math.pow(num, 2);
				System.out.printf ("\nO número digitado é ímpar e o resultado desse número ao quadrado é: "+num); 
			}
			System.out.print("\n\n\t\tAgradeço pela participação!");
			
		}
}

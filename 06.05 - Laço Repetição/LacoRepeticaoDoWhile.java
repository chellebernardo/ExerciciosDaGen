package ExerciciosJavaTurma22;

/*La�o Repeti��o Do While: 
 *Escrever um programa que receba v�rios n�meros inteiros no teclado. 
 *E no final imprimir a m�dia dos n�meros m�ltiplos de 3. 
 *Para sair digitar 0(zero).(DO...WHILE)*/

import java.util.Scanner;

public class LacoRepeticaoDoWhile {
	
	public static void main(String[] args) {
		
		System.out.print("\n\t\tSeja bem-vinde, usu�rio!\n\n");
		
		Scanner leia = new Scanner (System.in);
		
		int num, somanum=0, cont=0;
		float media;
		
		System.out.print("\nDigite um n�mero: ");
		num = leia.nextInt();
		
		do {
			
			if (num%3==0) {
				somanum = somanum +num;
				cont++;
			}
			System.out.print("\nDigite um n�mero: ");
			num = leia.nextInt();
		}
		while (num!=0);
		
		media = somanum / cont;
		System.out.printf("\nA m�dia dos n�meros m�ltiplos de 3 inseridos �: %2.2f", media);
	
		System.out.print("\n\n\t\tAgrade�o pela participa��o!\n\n");
	}
}
	

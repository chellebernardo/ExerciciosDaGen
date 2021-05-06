package ExerciciosJavaTurma22;

/*Laço Repetição Do While: 
 *Escrever um programa que receba vários números inteiros no teclado. 
 *E no final imprimir a média dos números múltiplos de 3. 
 *Para sair digitar 0(zero).(DO...WHILE)*/

import java.util.Scanner;

public class LacoRepeticaoDoWhile {
	
	public static void main(String[] args) {
		
		System.out.print("\n\t\tSeja bem-vinde, usuário!\n\n");
		
		Scanner leia = new Scanner (System.in);
		
		int num, somanum=0, cont=0;
		float media;
		
		System.out.print("\nDigite um número: ");
		num = leia.nextInt();
		
		do {
			
			if (num%3==0) {
				somanum = somanum +num;
				cont++;
			}
			System.out.print("\nDigite um número: ");
			num = leia.nextInt();
		}
		while (num!=0);
		
		media = somanum / cont;
		System.out.printf("\nA média dos números múltiplos de 3 inseridos é: %2.2f", media);
	
		System.out.print("\n\n\t\tAgradeço pela participação!\n\n");
	}
}
	

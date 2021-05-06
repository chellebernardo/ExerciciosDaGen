package ExerciciosJavaTurma22;

/*Laço Repetição WHILE: 
 *Solicitar a idade de várias pessoas e imprimir: Total de pessoas com menos de 21 anos. 
 *Total de pessoas com mais de 50 anos. O programa termina quando idade for =-99.*/

import java.util.Scanner;

public class LacoRepeticao3 {
		
	public static void main(String[] args) {
		
		System.out.print("\n\t\tSeja bem-vinde, usuário!\n\n");
		
		int idade, totalMenorIdade=0, totalMaiorIdade=0;
		
		Scanner leia = new Scanner (System.in);
		
		System.out.print("\nDigite uma idade: ");
		idade = leia.nextInt();
		
		while (idade!=-99) {
			
			
			if (idade<21) {
				
				totalMenorIdade++;
			}
			if (idade>50) {
				
				totalMaiorIdade++;
			}
			
			System.out.print("\nDigite uma idade: ");
			idade = leia.nextInt();

		}
		System.out.print("\nO total de pessoas com menos de 21 anos é: "+totalMenorIdade);
		System.out.print("\nO total de pessoas com mais de 50 anos é: "+totalMaiorIdade);
		
		System.out.print("\n\n\t\tAgradeço pela participação!\n\n");
		
	}
}

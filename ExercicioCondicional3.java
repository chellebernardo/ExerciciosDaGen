package ExerciciosJavaTurma22;

/*3 - Faça um programa que receba a idade de uma pessoa e mostre na saída em qual categoria ela se encontra:
      •	10-14 infantil
      •	15-17 juvenil
      •	18-25 adulto*/

	import java.util.Scanner;

public class ExercicioCondicional3 {
	
	public static void main(String[] args) {
		
		Scanner leia = new Scanner (System.in);
		
		int idade;
		String nome;
		
		System.out.print("\n\t\tSeja bem-vinde. Para saber qual é a sua categoria, informe os dados solicitados!\n");
		
		System.out.printf("\nDigite seu nome: ");
		nome = leia.nextLine();
		System.out.printf("\nDigite sua idade: ");
		idade = leia.nextInt();
		
		if (idade>10 && idade <14) {
			
			System.out.printf("\nOlá, "+nome+ " você tem "+idade+ " anos e se encontra na categoria Infantil!");
		}
		else if (idade>15 && idade<17) {
			
			System.out.printf("\nOlá, "+nome+ " você tem "+idade+ " anos e se encontra na categoria Juvenil!");
		}
		else if (idade>18) {
			
			System.out.printf("\nOlá, "+nome+ " você tem "+idade+ " anos e se encontra na categoria Adulto!");
		}
		else {
			System.out.printf("\nOlá, "+ nome+ " você digitou uma idade sem categoria!");
		}
		
		System.out.print("\n\n\t\tAgradeço pela participação!");
	}

}

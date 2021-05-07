package ExerciciosJavaTurma22;

import java.util.*;

/*3 - Leia uma matriz 3 x 3, conte e escreva quantos valores maiores que 10 ela possui.*/

public class Matrizes {
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner (System.in);
		
		int [][] valores = new int[3][3];
		int i=0, j=0, cont=0;
		
		for (i=0; i<3; i++) {
			for (j=0; j<3; j++) {
				System.out.printf("\nDigite um número para prencher a M[%d][%d]: ", i+1,j+1 );
				valores [i][j] = ler.nextInt();
			}
		}
		for (i=0; i<3; i++) {
			for (j=0; j<3; j++) {
				
				if (valores[i][j]>10) {
					cont++;
				}
			}
		}
		
		System.out.print("\n\t\tEsses são os valores maiores que 10 que foram digitados: "+cont+"\n\n");
		
	}

}

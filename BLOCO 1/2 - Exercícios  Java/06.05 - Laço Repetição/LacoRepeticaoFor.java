package ExerciciosJavaTurma22;

/*Laço Repetição For:
 *Informar todos os números de 1000 a 1999 que quando divididos por 11 obtemos resto = 5. (FOR)*/

public class LacoRepeticao {
	
	public static void main(String[] args) {
		
		System.out.print("\n\t\tSeja bem-vinde, usuário!\n\n");
		
		int num;
		
		System.out.print("\n\t\tTodos esses números quando divididos por 11 tem resultado 5: \n\n");
		
		for (num=1000; num <=2000; num++) {
			
			if (num%11==5) {
					
				System.out.print("\n"+num);
				
			}
				
		}
	}
}


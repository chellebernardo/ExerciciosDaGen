package ExerciciosJavaTurma22;

/*La�o Repeti��o For:
 *Informar todos os n�meros de 1000 a 1999 que quando divididos por 11 obtemos resto = 5. (FOR)*/

public class LacoRepeticao {
	
	public static void main(String[] args) {
		
		System.out.print("\n\t\tSeja bem-vinde, usu�rio!\n\n");
		
		int num;
		
		System.out.print("\n\t\tTodos esses n�meros quando divididos por 11 tem resultado 5: \n\n");
		
		for (num=1000; num <=2000; num++) {
			
			if (num%11==5) {
					
				System.out.print("\n"+num);
				
			}
				
		}
	}
}


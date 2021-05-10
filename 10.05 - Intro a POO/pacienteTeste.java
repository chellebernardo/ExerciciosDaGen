package ExerciciosJavaTurma22;

public class pacienteTeste {

	public static void main(String[] args) {
		
		paciente p1 = new paciente ("Aline", "Rua Maria Del Bairro", "O+", "amendoin e cacau", "08/08/1994", 14253208, 27);
		
		p1.imprimir();
		
		paciente p2 = new paciente ("Gisele", "Rua Somewhere Over the Rainbows", "A+", "leite", "06/06/1998", 41285796, 23);
		p2.imprimir();
	}
}

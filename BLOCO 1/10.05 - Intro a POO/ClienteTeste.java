package ExerciciosJavaTurma22;

public class TesteCliente {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente ("Helena", "Rua Amor", "11 2564-1234", "Feminino", 44);
		
		cliente1.imprimir();
		
		System.out.println("\n***Este é seu primeiro cliente!***");
		
		Cliente cliente2 = new Cliente ("Nilva", "Rua Empatia", "11 2564-4321", "Feminino", 30);
		
		cliente2.imprimir();
		
		System.out.println("\n***Este é seu segundo cliente!***");
		
	}
}

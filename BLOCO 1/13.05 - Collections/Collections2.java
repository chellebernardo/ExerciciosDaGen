package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Collections2 {

	public static void main(String[] args) {
		
		int op = 0; 
		
		Scanner read = new Scanner (System.in);
		
		ArrayList <String> estoque = new ArrayList();
		
		System.out.println("\n\t\tSeja bem-vinde. Por favor, escolha uma opção abaixo! ");
		
		
		do {
			System.out.println("\n\t\t****************************************************\n\n");
			System.out.println("\n1 - Deseja adicionar produtos ao estoque?");
			System.out.println("\n2 - Deseja remover produtos do estoque?");
			System.out.println("\n3 - Atualizar produtos do estoque?");
			System.out.println("\n4 - Mostrar todos os produtos do estoque?");
			System.out.println("\n0 -  Encerrra o programa?");
			System.out.println("\nPor favor, digite sua opção: ");
			op = read.nextInt();
		
		switch(op)
			{
		case 1:
			read.nextLine();
			System.out.println("\nPor favor, insira o nome do produto para adicionar ao estoque: ");
			String produto = read.nextLine();
			estoque.add(produto);
			break;
		case 2:
			read.nextLine();
			System.out.println("\nPor favor, insira o nome produto para remover do estoque: ");
			String produto1 = read.nextLine();
			if(estoque.contains(produto1))
			{
				estoque.remove(produto1);
			}
			else
			{
				System.out.println("\nProduto não identificado em estoque!");
			}
			break;
		case 3:
			read.nextLine();
			System.out.println("\nPor favor, insira o nome do produto que quer atualizar: ");
			String verifica = read.nextLine();
			System.out.println("\nPor favor, insira o nome do produto que entrará no lugar de "+verifica+": ");
			String novo = read.nextLine();
			if(estoque.contains(verifica))
			{
				estoque.remove(verifica);
				estoque.add(novo);
			}
			else
			{
				System.out.println("\nProduto não identificado em estoque!");
			}
			break;
		case 4:
			System.out.println("\nProdutos em estoque no momento: \n");
			System.out.println(estoque);
			break;
			default:
				System.out.println("\nPrograma finalizado!");
			
			}
		}while (op!=0);
		
	}
	
}

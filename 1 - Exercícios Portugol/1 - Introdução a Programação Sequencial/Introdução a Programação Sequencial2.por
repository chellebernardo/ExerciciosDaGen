programa
{

	/*Faça um sistema que leia as 3 notas de um aluno e calcule a média final deste aluno. 
	Considerar que a média é ponderada e que o peso das notas é: 2,3 e 5, respectivamente. */
	
	funcao inicio()
	{
		escreva("\n\n\t\tOlá, Alune. Seja bem-vinde!\n\n")
		
		cadeia nome
		real n1, n2, n3, mediaFinal

		escreva ("\nPor favor, entre com o seu nome: ")
		leia (nome)

		escreva ("\nDigite o valor da primeira nota: ")
		leia (n1)

		escreva ("\nDigite o valor da segunda nota: ")
		leia (n2)
		
		escreva ("\nDigite o valor da terceira nota: ")
		leia (n3)

		mediaFinal = ((n1*2)+(n2*3)+(n3*5))/10

		escreva ("\n\t\tA média final de ", nome, " é: ", mediaFinal, "\n\n")

		

		

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 613; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
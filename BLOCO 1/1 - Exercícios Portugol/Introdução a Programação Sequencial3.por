programa
{
	/*6. Construa um programa em c que, tendo como dados de entrada dois pontos quaisquer no plano, 
	P(x1, y1) e P(x2, y2), escreva a distância entre eles. A fórmula que efetua tal cálculo é: 
	D = a raiz quadrada de ((x2-x1)²+(y2-y1)²)*/

	inclua biblioteca Matematica --> Math

	
	funcao inicio()
	{
		escreva("\n\t\tOlá, Usuário. Seja bem-vinde!\n\n")

		real x1, y1, x2, y2, p1, p2, d
		
		escreva ("\nPor favor, digite o valor do primeiro A: ")
		leia (x1)

		escreva ("\nPor favor, digite o valor do segundo A: ")
		leia (y1)

		escreva ("\nPor favor, digite o valor do terceiro B: ")
		leia (x2)

		escreva ("\nPor favor, digite o valor do quarto B: ")
		leia (y2)

		p1 = Math.potencia(x2-x1, 2.0)
		p2 = Math.potencia(y2-y1, 2.0)

		d = Math.raiz(p1 + p2, 2.0)

		escreva ("\n\t\tA distância entre o ponto A e o ponto B é de: ", Math.arredondar (d, 2),"\n\n")


		
	}
}

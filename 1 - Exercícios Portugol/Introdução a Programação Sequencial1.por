programa
{
	/*4. Escreva  um sistema que leia três números inteiros e positivos (A, B, C) e calcule a seguinte expressão: 
	D = R+S/2, onde R = (A+B)² e S = (B+C)². */
	
	inclua biblioteca Matematica --> Math

	
	funcao inicio()
	{
		escreva("\n\t\tOlá, Usuário. Seja bem-vinde!\n\n")

		real a, b, c, d, r, s, soma1, soma2

		escreva ("\nPor favor, digite o valor de A: ")
		leia (a)

		escreva ("\nPor favor, digite o valor de B: ")
		leia (b)

		escreva ("\nPor favor, digite o valor de C: ")
		leia (c)

		soma1 = a+b
		soma2 = b+c

		r = Math.potencia(soma1, 2)
		s = Math.potencia(soma2, 2)

		d = (r+s)/2

		escreva ("\n\n\t\tO resultado da operação é: ", d,"\n\n")
	}
}

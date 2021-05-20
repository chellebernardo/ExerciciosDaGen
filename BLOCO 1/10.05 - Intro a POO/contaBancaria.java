package ExerciciosJavaTurma22;

import java.text.NumberFormat;

public class contaBancaria {

	/*6) Crie uma classe conta bancaria e apresente os atributos e métodos referentes esta classe, 
	 *em seguida crie um objeto conta bancaria, defina as instancias deste objeto e apresente 
	 *as informações deste objeto no console.*/
		
		//Atributos da classe 
	
	private String nomeTitular;
	private String numeroConta;
	private String agencia;
	private float saldo;
		
		//Criando o construtor
		
	public contaBancaria (String nomeTitular, String numeroConta, String agencia, float saldo) {
			
		this.nomeTitular = nomeTitular;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void imprimir() {
		
		System.out.println("\n\t\tSeja bem-vinde, "+nomeTitular+"."+"\n\n"+"Seu saldo atual é de: "+this.formatarMoeda()+"\n\n"+"DADOS DA CONTA: "+"\n\n"+"Ag: "+agencia+"\n"+"Numero da conta: "+numeroConta);
	
	}
	
	//para formatar a moeda para Real
	
	public String formatarMoeda()
	{
		NumberFormat nfsaldo = NumberFormat.getCurrencyInstance();
		nfsaldo.setMinimumFractionDigits(2);
		String formatoMoeda = nfsaldo.format(saldo);
		return formatoMoeda;
	}
}

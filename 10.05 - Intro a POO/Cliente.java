package ExerciciosJavaTurma22;

/*1) Crie uma classe cliente e apresente os atributos e métodos referentes
esta classe, em seguida crie um objeto cliente, defina as instancias deste
objeto e apresente as informações deste objeto no console.*/

public class Cliente {

	//Atributos da classe Cliente
	private String nomeCliente;
	private String endereco;
	private String telefone;
	private String sexo;
	private int idade;
	
	//Construtor
	
	public Cliente (String nomeCliente, String endereco, String telefone, String sexo, int idade) {
		
		this.nomeCliente = nomeCliente;
		this.endereco = endereco;
		this.telefone = telefone;
		this.sexo = sexo;
		this.idade = idade;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void imprimir() {
		System.out.println("\nNome: "+nomeCliente+"\n"+"Endereço: "+endereco+"\n"+"Telefone: "+telefone+"\n"+"Sexo: "+sexo+"\n"+"Idade: "+idade+" anos");
	}
}

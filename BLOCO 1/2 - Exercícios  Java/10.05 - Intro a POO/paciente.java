package ExerciciosJavaTurma22;

public class paciente {

/*7) Crie uma classe paciente e apresente os atributos e métodos referentes esta classe, 
 *em seguida crie um objeto paciente, defina as instancias deste objeto e 
 *apresente as informações deste objeto no console.*/
	
	private String nomePaciente;
	private String endereco;
	private String tipoSangue;
	private String alergias;
	private String dataNasc;
	private int cartaoSus;
	private int idade;
	
	public paciente (String nomePaciente, String endereco, String tipoSangue, String alergias, String dataNasc, int cartaoSus, int idade) {
		this.nomePaciente = nomePaciente;
		this.endereco = endereco;
		this.tipoSangue = tipoSangue;
		this.alergias = alergias;
		this.dataNasc = dataNasc;
		this.cartaoSus = cartaoSus;
		this.idade = idade;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public int getCartaoSus() {
		return cartaoSus;
	}

	public void setCartaoSus(int cartaoSus) {
		this.cartaoSus = cartaoSus;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void imprimir () {
		
		System.out.println("\n\n\t\t**********FICHA do PACIENTE**********\n\n");
		System.out.println ("Nome: "+nomePaciente+"\n"+"Data de Nascimento: "+dataNasc+"\n"+"Idade: "+idade+"\n"+
		"Endereço: "+endereco+"\n"+"Tipo Sanguíneo: "+tipoSangue+"\n"+"Alergias: "+alergias+"\n"+"Número do Cartão SUS: "+cartaoSus);
	}
		
}
	

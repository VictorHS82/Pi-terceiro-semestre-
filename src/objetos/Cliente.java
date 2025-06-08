package objetos;

/**
 * Representa um cliente do sistema, com informações pessoais e ações relacionadas a compras.
 */
public class Cliente extends Usuario {
	private String cpf;
	private String endereco;
	private String telefone;

	public Cliente(int cod_usuario, String nome, String senha, String email, String cpf, String endereco, String telefone) {
		super(cod_usuario, nome, senha, email);
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	/**
	 * @return o CPF do cliente
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf define o CPF do cliente
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return o endereço do cliente
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endreço define o endereço do cliente
	 */
	public void setEndreço(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}

package objetos;

/**
 * Representa um cliente do sistema, com informações pessoais e ações relacionadas a compras.
 */
public class Cliente extends Usuario {
	private String cpf;
	private String endereco;
	private String telefone;

/**
 * Constructor da classe cliente
 * @param cod_usuario
 * @param nome
 * @param senha
 * @param email
 * @param cpf
 * @param endereco
 * @param telefone
 */
	public Cliente(int cod_usuario, String nome, String senha, String email, String cpf, String endereco, String telefone) {
		super(cod_usuario, nome, senha, email);
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	/**
	 * Retorna o CPF do cliente.
	 * @return String contendo o CPF do cliente
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Define o CPF do cliente.
	 * @param cpf CPF do cliente
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna o endereço do cliente.
	 * @return String contendo o endereço do cliente
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Define o endereço do cliente.
	 * @param endereco endereço do cliente
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Retorna o telefone do cliente.
	 * @return String contendo o telefone do cliente
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Define o telefone do cliente.
	 * @param telefone telefone do cliente
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

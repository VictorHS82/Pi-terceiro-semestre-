package objetos;

/**
 * Classe que representa um cliente do sistema, com informações pessoais e ações relacionadas a compras.
 * Esta classe herda de Usuario e adiciona informações específicas de cliente como CPF, endereço e telefone.
 */
public class Cliente extends Usuario {
	/** CPF do cliente para identificação */
	private String cpf;
	/** Endereço completo do cliente para entrega */
	private String endereco;
	/** Telefone do cliente para contato */
	private String telefone;

/**
 * Constructor da classe cliente
 * @param cod_usuario código único do cliente no sistema
 * @param nome nome completo do cliente
 * @param senha senha de acesso do cliente
 * @param email email do cliente para contato
 * @param cpf CPF do cliente para identificação
 * @param endereco endereço completo do cliente para entrega
 * @param telefone telefone do cliente para contato
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

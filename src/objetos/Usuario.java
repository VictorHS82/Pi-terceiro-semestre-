package objetos;

/**
 * Classe abstrata que modela as informações básicas das contas do sistema
 */
public abstract class Usuario {
    private int cod_usuario;
	private String nome;
	private String senha;
	private String email;
	
	/**
	 * Constructor da classe usuario
	 * @param cod_usuario código du usários
	 * @param nome nome do usuário
	 * @param senha senha do usuário
	 * @param email email do usuário
	 */
	public Usuario(int cod_usuario, String nome, String senha, String email) {
		super();
		this.cod_usuario = cod_usuario;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	/**
	 * Retorna o código do usuário.
	 * @return int contendo o código do usuário
	 */
	public int getCod_usuario() {
		return cod_usuario;
	}
	/**
	 * Define o código do usuário.
	 * @param cod_usuario código do usuário
	 */
	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	/**
	 * Retorna o nome do usuário.
	 * @return String contendo o nome do usuário
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Define o nome do usuário.
	 * @param nome nome do usuário
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Retorna a senha do usuário.
	 * @return String contendo a senha do usuário
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Define a senha do usuário.
	 * @param senha senha do usuário
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Retorna o email do usuário.
	 * @return String contendo o email do usuário
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Define o email do usuário.
	 * @param email email do usuário
	 */
	public void setEmail(String email) {
		this.email = email;
	}	
}

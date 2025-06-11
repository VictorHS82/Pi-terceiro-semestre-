package objetos;

/**
 * Classe que modela usuário Administrador
 */
public class Administrador extends Usuario {

	/** Nome do administrador que criou esta conta */
	private String criado_por;

	/**
	 * Constructor da classe Administrador
	 * @param cod_usuario código do admin
	 * @param nome nome do admin
	 * @param senha senha do admin
	 * @param email email do admin
	 * @param criado_por qual admin criou esta conta
	 */
	public Administrador(int cod_usuario, String nome, String senha, String email, String criado_por) {
		super(cod_usuario, nome, senha, email);
		this.criado_por = criado_por;
	}

	/**
	 * Retorna quem criou o administrador.
	 * @return String contendo o nome de quem criou o administrador
	 */
	public String getCriado_por() {
		return criado_por;
	}

	/**
	 * Define quem criou o administrador.
	 * @param criado_por nome de quem criou o administrador
	 */
	public void setCriado_por(String criado_por) {
		this.criado_por = criado_por;
	}
}

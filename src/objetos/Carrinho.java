package objetos;

/**
 * Classe que modela o Carrinho
 */
public class Carrinho {
	/** Código único do carrinho */
	private int cod_carrinho;
	/** Código do cliente dono do carrinho */
	private int cod_cliente;
	
	/**
	 * Constructor da classe Carrinho
	 * @param cod_carrinho código do carrinho
	 * @param cod_cliente código do cliente quê é dono do carrinho
	 */
	public Carrinho(int cod_carrinho, int cod_cliente) {
		super();
		this.cod_carrinho = cod_carrinho;
		this.cod_cliente = cod_cliente;
	}
	
	/**
	 * Retorna o código do carrinho.
	 * @return int contendo o código do carrinho
	 */
	public int getCod_carrinho() {
		return cod_carrinho;
	}
	
	/**
	 * Define o código do carrinho.
	 * @param cod_carrinho código do carrinho
	 */
	public void setCod_carrinho(int cod_carrinho) {
		this.cod_carrinho = cod_carrinho;
	}
	
	/**
	 * Retorna o código do cliente.
	 * @return int contendo o código do cliente
	 */
	public int getCod_cliente() {
		return cod_cliente;
	}
	
	/**
	 * Define o código do cliente.
	 * @param cod_cliente código do cliente
	 */
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
}
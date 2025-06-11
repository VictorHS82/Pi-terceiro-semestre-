package objetos;

/**
 * Classe que representa os itens de um pedido 
 */
public class Item_pedido {

	/** Código único do item no pedido */
	private int cod_item_pedido;
	/** Código do pedido ao qual o item pertence */
	private int cod_pedido;
	/** Código do livro no pedido */
	private int cod_livro;
	/** Quantidade do livro no pedido */
	private int quantidade;
	/** Preço do livro no momento da compra */
	private float preco_na_compra;

	/**
	 * Constructor da classe item_pedido
	 * @param cod_item_pedido código do item pedido
	 * @param cod_pedido código do pedido
	 * @param cod_livro código do livro
	 * @param quantidade quantidade no carrinho
	 * @param preco_na_compra preco ao adicionar o item no carrinho
	 */
	public Item_pedido(int cod_item_pedido, int cod_pedido, int cod_livro, int quantidade, float preco_na_compra) {
		super();
		this.cod_item_pedido = cod_item_pedido;
		this.cod_pedido = cod_pedido;
		this.cod_livro = cod_livro;
		this.quantidade = quantidade;
		this.preco_na_compra = preco_na_compra;
	}

	/**
	 * Retorna o código do item do pedido.
	 * @return int contendo o código do item do pedido
	 */
	public int getCod_item_pedido() {
		return cod_item_pedido;
	}

	/**
	 * Define o código do item do pedido.
	 * @param cod_item_pedido código do item do pedido
	 */
	public void setCod_item_pedido(int cod_item_pedido) {
		this.cod_item_pedido = cod_item_pedido;
	}

	/**
	 * Retorna o código do pedido.
	 * @return int contendo o código do pedido
	 */
	public int getCod_pedido() {
		return cod_pedido;
	}

	/**
	 * Define o código do pedido.
	 * @param cod_pedido código do pedido
	 */
	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	/**
	 * Retorna o código do livro.
	 * @return int contendo o código do livro
	 */
	public int getCod_livro() {
		return cod_livro;
	}

	/**
	 * Define o código do livro.
	 * @param cod_livro código do livro
	 */
	public void setCod_livro(int cod_livro) {
		this.cod_livro = cod_livro;
	}

	/**
	 * Retorna a quantidade do item.
	 * @return int contendo a quantidade do item
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Define a quantidade do item.
	 * @param quantidade quantidade do item
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o preço na compra.
	 * @return float contendo o preço na compra
	 */
	public float getPreco_na_compra() {
		return preco_na_compra;
	}

	/**
	 * Define o preço na compra.
	 * @param preco_na_compra preço na compra
	 */
	public void setPreco_na_compra(float preco_na_compra) {
		this.preco_na_compra = preco_na_compra;
	}
}

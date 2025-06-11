package objetos;

/**
 * Classe que representa um item no carrinho de compras.
 * Esta classe mantém informações sobre um livro específico adicionado ao carrinho,
 * incluindo sua quantidade e preço atual.
 */
public class Item_carrinho{
	/** Código único do item no carrinho */
	private int cod_item_carrinho;
	/** Código do carrinho ao qual o item pertence */
	private int cod_carrinho;
	/** Código do livro adicionado ao carrinho */
	private int cod_livro;
	/** Nome do livro adicionado ao carrinho */
	private String nome_livro;
	/** Quantidade do livro no carrinho */
	private int quantidade;
	/** Preço unitário do livro no momento da adição ao carrinho */
	private float preco;

	/**
	 * Constructor da classe item_carrinho
	 * @param cod_item_carrinho código único do item no carrinho
	 * @param cod_carrinho código do carrinho ao qual o item pertence
	 * @param cod_livro código do livro adicionado ao carrinho
	 * @param nome_livro nome do livro adicionado ao carrinho
	 * @param quantidade quantidade do livro no carrinho
	 * @param preco preço unitário do livro no momento da adição ao carrinho
	 */
	public Item_carrinho(int cod_item_carrinho, int cod_carrinho, int cod_livro, String nome_livro, int quantidade,
			float preco) {
		super();
		this.cod_item_carrinho = cod_item_carrinho;
		this.cod_carrinho = cod_carrinho;
		this.cod_livro = cod_livro;
		this.nome_livro = nome_livro;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	/**
	 * Retorna o código do item do carrinho.
	 * @return int contendo o código do item do carrinho
	 */
	public int getCod_item_carrinho() {
		return cod_item_carrinho;
	}

	/**
	 * Define o código do item do carrinho.
	 * @param cod_item_carrinho código do item do carrinho
	 */
	public void setCod_item_carrinho(int cod_item_carrinho) {
		this.cod_item_carrinho = cod_item_carrinho;
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
	 * Retorna o nome do livro.
	 * @return String contendo o nome do livro
	 */
	public String getNome_livro() {
		return nome_livro;
	}

	/**
	 * Define o nome do livro.
	 * @param nome_livro nome do livro
	 */
	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
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
	 * Retorna o preço do item.
	 * @return float contendo o preço do item
	 */
	public float getPreco() {
		return preco;
	}

	/**
	 * Define o preço do item.
	 * @param preco preço do item
	 */
	public void setPreco(float preco) {
		this.preco = preco;
	}
}

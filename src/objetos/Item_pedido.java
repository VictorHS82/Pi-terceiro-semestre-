package objetos;

/**
 * Classe que representa os itens de um pedido 
 */
public class Item_pedido {

	private int cod_item_pedido;
	private int cod_pedido;
	private int cod_livro;
	private int quantidade;
	private float preco_na_compra;

	/**
	 * Constructor da classe item_pedido
	 * @param cod_item_pedido
	 * @param cod_pedido
	 * @param cod_livro
	 * @param quantidade
	 * @param preco_na_compra
	 */
	public Item_pedido(int cod_item_pedido, int cod_pedido, int cod_livro, int quantidade, float preco_na_compra) {
		super();
		this.cod_item_pedido = cod_item_pedido;
		this.cod_pedido = cod_pedido;
		this.cod_livro = cod_livro;
		this.quantidade = quantidade;
		this.preco_na_compra = preco_na_compra;
	}
	public int getCod_item_pedido() {
		return cod_item_pedido;
	}
	public void setCod_item_pedido(int cod_item_pedido) {
		this.cod_item_pedido = cod_item_pedido;
	}
	public int getCod_pedido() {
		return cod_pedido;
	}
	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}
	public int getCod_livro() {
		return cod_livro;
	}
	public void setCod_livro(int cod_livro) {
		this.cod_livro = cod_livro;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getPreco_na_compra() {
		return preco_na_compra;
	}
	public void setPreco_na_compra(float preco_na_compra) {
		this.preco_na_compra = preco_na_compra;
	}
	
	
	
}

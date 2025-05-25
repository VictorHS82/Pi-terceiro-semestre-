package objetos;

/**
 * Representa um pedido feito por um cliente, contendo informações sobre o livro,
 * a quantidade solicitada, o carrinho e os códigos relacionados.
 */
public class Pedido {
	private int cod_compra;
	private int cod_livro;
	private int cod_cliente;
	private int quantidade;
	private int cod_carrinho;

	/**
	 * Cria um novo pedido no sistema.
	 * (Método ainda não implementado)
	 */
	public static void CriarPedido() {
		
	}

	/**
	 * @return o código da compra
	 */
	public int getCod_compra() {
		return cod_compra;
	}

	/**
	 * @param cod_compra define o código da compra
	 */
	public void setCod_compra(int cod_compra) {
		this.cod_compra = cod_compra;
	}

	/**
	 * @return o código do livro relacionado ao pedido
	 */
	public int getCod_livro() {
		return cod_livro;
	}

	/**
	 * @param cod_livro define o código do livro relacionado ao pedido
	 */
	public void setCod_livro(int cod_livro) {
		this.cod_livro = cod_livro;
	}

	/**
	 * @return o código do cliente que fez o pedido
	 */
	public int getCod_cliente() {
		return cod_cliente;
	}

	/**
	 * @param cod_cliente define o código do cliente que fez o pedido
	 */
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	/**
	 * @return a quantidade de livros no pedido
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade define a quantidade de livros no pedido
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return o código do carrinho associado ao pedido
	 */
	public int getCod_carrinho() {
		return cod_carrinho;
	}

	/**
	 * @param cod_carrinho define o código do carrinho associado ao pedido
	 */
	public void setCod_carrinho(int cod_carrinho) {
		this.cod_carrinho = cod_carrinho;
	}
}

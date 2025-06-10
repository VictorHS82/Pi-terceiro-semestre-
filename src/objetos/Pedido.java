package objetos;

/**
 * Representa um pedido feito por um cliente, contendo informações sobre o livro,
 * a quantidade solicitada, o carrinho e os códigos relacionados.
 */
public class Pedido {
	private int cod_pedido;
	private int cod_cliente;
	private float desconto;
	private float valor_frete;
	private float subtotal;
	private float valor_total;
	private String status;

	/**
	 * Constructor da classe pedido
	 * @param cod_pedido código do pedido
	 * @param cod_cliente código do cliente
	 * @param desconto desconto aplicado sobre o preço total
	 * @param valor_frete valor de frete do pedido
	 * @param subtotal subtotal do pedido
	 * @param valor_total valor a ser pago
	 * @param status status do pedido
	 */
	public Pedido(int cod_pedido, int cod_cliente, float desconto, float valor_frete, float subtotal, float valor_total,
			String status) {
		super();
		this.cod_pedido = cod_pedido;
		this.cod_cliente = cod_cliente;
		this.desconto = desconto;
		this.valor_frete = valor_frete;
		this.subtotal = subtotal;
		this.valor_total = valor_total;
		this.status = status;
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

	/**
	 * Retorna o desconto aplicado.
	 * @return float contendo o valor do desconto
	 */
	public float getDesconto() {
		return desconto;
	}

	/**
	 * Define o desconto aplicado.
	 * @param desconto valor do desconto
	 */
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	/**
	 * Retorna o valor do frete.
	 * @return float contendo o valor do frete
	 */
	public float getValor_frete() {
		return valor_frete;
	}

	/**
	 * Define o valor do frete.
	 * @param valor_frete valor do frete
	 */
	public void setValor_frete(float valor_frete) {
		this.valor_frete = valor_frete;
	}

	/**
	 * Retorna o subtotal do pedido.
	 * @return float contendo o subtotal do pedido
	 */
	public float getSubtotal() {
		return subtotal;
	}

	/**
	 * Define o subtotal do pedido.
	 * @param subtotal valor do subtotal
	 */
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * Retorna o valor total do pedido.
	 * @return float contendo o valor total do pedido
	 */
	public float getValor_total() {
		return valor_total;
	}

	/**
	 * Define o valor total do pedido.
	 * @param valor_total valor total do pedido
	 */
	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}

	/**
	 * Retorna o status do pedido.
	 * @return String contendo o status do pedido
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Define o status do pedido.
	 * @param status status do pedido
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
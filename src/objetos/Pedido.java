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
	 * @param cod_pedido
	 * @param cod_cliente
	 * @param desconto
	 * @param valor_frete
	 * @param subtotal
	 * @param valor_total
	 * @param status
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


	public int getCod_pedido() {
		return cod_pedido;
	}



	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}



	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public float getValor_frete() {
		return valor_frete;
	}

	public void setValor_frete(float valor_frete) {
		this.valor_frete = valor_frete;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getValor_total() {
		return valor_total;
	}

	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
     
}
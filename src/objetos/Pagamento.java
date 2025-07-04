package objetos;

/**
 * Classe que modela pagamento
 */
public class Pagamento {
	/** Código único do pagamento */
	private int cod_pagamento;
	/** Código do pedido associado ao pagamento */
	private int cod_pedido;
	/** Valor total da compra */
	private float valor_compra;
	/** Forma de pagamento utilizada (ex: cartão, boleto) */
	private String forma_pagamento;
	/** Status atual do pagamento (ex: pendente, aprovado) */
	private String status;

	/**
	 * Constructor da classe pagamento
	 * @param cod_pagamento código pagamento
	 * @param cod_pedido codigo pedido
	 * @param valor_compra valor da compra
	 * @param forma_pagamento forma de pagamento
	 * @param status status do pagamento
	 */
	public Pagamento(int cod_pagamento, int cod_pedido, float valor_compra, String forma_pagamento, String status) {
		super();
		this.cod_pagamento = cod_pagamento;
		this.cod_pedido = cod_pedido;
		this.valor_compra = valor_compra;
		this.forma_pagamento = forma_pagamento;
		this.status = status;
	}

	/**
	 * Retorna o código do pagamento.
	 * @return int contendo o código do pagamento
	 */
	public int getCod_pagamento() {
		return cod_pagamento;
	}

	/**
	 * Define o código do pagamento.
	 * @param cod_pagamento código do pagamento
	 */
	public void setCod_pagamento(int cod_pagamento) {
		this.cod_pagamento = cod_pagamento;
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
	 * Retorna o valor da compra.
	 * @return float contendo o valor da compra
	 */
	public float getValor_compra() {
		return valor_compra;
	}

	/**
	 * Define o valor da compra.
	 * @param valor_compra valor da compra
	 */
	public void setValor_compra(float valor_compra) {
		this.valor_compra = valor_compra;
	}

	/**
	 * Retorna a forma de pagamento.
	 * @return String contendo a forma de pagamento
	 */
	public String getForma_pagamento() {
		return forma_pagamento;
	}

	/**
	 * Define a forma de pagamento.
	 * @param forma_pagamento forma de pagamento
	 */
	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	/**
	 * Retorna o status do pagamento.
	 * @return String contendo o status do pagamento
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Define o status do pagamento.
	 * @param status status do pagamento
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}

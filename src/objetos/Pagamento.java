package objetos;

/**
 * Representa as informações de um pagamento realizado em uma compra,
 * incluindo o código, data, valor e forma de pagamento.
 */
public class Pagamento {
	private int cod_pagamento;
	private String data_pagamento;
	private float valor_compra;
	private String forma_pagamento;

	/**
	 * Cria um novo registro de pagamento no sistema.
	 * (Método ainda não implementado)
	 */
	public static void CriarPagamento() {
		
	}

	/**
	 * Consulta as informações de um pagamento existente.
	 * (Método ainda não implementado)
	 */
	public static void ConsultarPagamento() {
		
	}

	/**
	 * Obtém o código do pagamento.
	 * 
	 * @return o código do pagamento
	 */
	public int getCod_pagamento() {
		return cod_pagamento;
	}

	/**
	 * Define o código do pagamento.
	 * 
	 * @param cod_pagamento o código do pagamento
	 */
	public void setCod_pagamento(int cod_pagamento) {
		this.cod_pagamento = cod_pagamento;
	}

	/**
	 * Obtém a data do pagamento.
	 * 
	 * @return a data do pagamento como um número inteiro
	 */
	public String getData_pagamento() {
		return data_pagamento;
	}

	/**
	 * Define a data do pagamento.
	 * 
	 * @param data_pagamento a data do pagamento como número inteiro
	 */
	public void setData_pagamento(String data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	/**
	 * Obtém o valor total da compra.
	 * 
	 * @return o valor da compra
	 */
	public float getValor_compra() {
		return valor_compra;
	}

	/**
	 * Define o valor total da compra.
	 * 
	 * @param valor_compra o valor da compra
	 */
	public void setValor_compra(float valor_compra) {
		this.valor_compra = valor_compra;
	}

	/**
	 * Obtém a forma de pagamento utilizada.
	 * 
	 * @return a forma de pagamento (ex: cartão, boleto, etc.)
	 */
	public String getForma_pagamento() {
		return forma_pagamento;
	}

	/**
	 * Define a forma de pagamento.
	 * 
	 * @param forma_pagamento a forma de pagamento (ex: cartão, boleto, etc.)
	 */
	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
}

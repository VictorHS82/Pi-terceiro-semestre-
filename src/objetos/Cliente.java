package objetos;

/**
 * Representa um cliente do sistema, com informações pessoais e ações relacionadas a compras.
 */
public class Cliente {
	private int cod_cliente;
	private String nome;
	private String cpf;
	private String endereco;

	/**
	 * Realiza um pedido com os itens adicionados ao carrinho.
	 * (Método ainda não implementado)
	 */
	public static void FazerPedido() {
		
	}

	/**
	 * Adiciona um livro ao carrinho de compras do cliente.
	 * (Método ainda não implementado)
	 */
	public static void AdicionarAoCarrinho() {
		
	}

	/**
	 * Permite ao cliente visualizar os detalhes de um livro.
	 * (Método ainda não implementado)
	 */
	public static void VizualisarLivro() {
		
	}

	/**
	 * Realiza o pagamento do pedido efetuado pelo cliente.
	 * (Método ainda não implementado)
	 */
	public static void RealizarPagamento() {
		
	}

	/**
	 * @return o código identificador do cliente
	 */
	public int getCod_cliente() {
		return cod_cliente;
	}

	/**
	 * @param cod_cliente define o código identificador do cliente
	 */
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	/**
	 * @return o nome do cliente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome define o nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return o CPF do cliente
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf define o CPF do cliente
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return o endereço do cliente
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endreço define o endereço do cliente
	 */
	public void setEndreço(String endereco) {
		this.endereco = endereco;
	}
}

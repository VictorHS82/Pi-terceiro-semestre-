package interfacesDAO;

import objetos.Cliente;

/**
 * Interface do clienteDAO
 */
public interface BaseClienteDAO {

	/**
	 * Cadastra uma nova conta de Cliente no banco de dados
	 * @param cliente objeto cliente a ser cadastrado
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean cadastrarCliente(Cliente cliente);

	/**
	 * Valida as informações para login do usuário
	 * @param email email a ser validado
	 * @param senha senha a ser validada
	 * @return boolean para sinalizar se foi bem sucedida
	 */
	boolean validarLogin(String email, String senha);

	/**
	 * Atualiza as informações de uma conta Cliente
	 * @param cliente objeto cliente a ser atulizado
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean atualizarCliente(Cliente cliente);

	/**
	 * Busca uma conta cliente pelo código fornecido
	 * @param cod_cliente código do cliente a ser buscado
	 * @return objeto cliente
	 */
	Cliente buscarCliente(int cod_cliente);

	/**
	 * Exclui um conta cliente pelo código fornecido
	 * @param cod_cliente código do cliente a ser excluído
	 * @return boolean para sinlizar se foi bem sucedido
	 */
	boolean excluirCliente(int cod_cliente);

}
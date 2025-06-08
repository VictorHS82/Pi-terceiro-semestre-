package interfacesDAO;

import objetos.Cliente;

public interface BaseClienteDAO {

	/**
	 * Cadastra uma nova conta de Cliente no banco de dados
	 * @param admin
	 * @return boolean
	 */
	boolean cadastrarCliente(Cliente cliente);

	/**
	 * Valida as informações para login do usuário
	 * @param email
	 * @param senha
	 * @return boolean
	 */
	boolean validarLogin(String email, String senha);

	/**
	 * Atualiza as informações de uma conta Administradora
	 * @param admin
	 * @return boolean
	 */
	boolean atualizarCliente(Cliente cliente);

	/**
	 * Busca uma conta cliente pelo código fornecido
	 * @param cod_admin
	 * @return Administrador
	 */
	Cliente buscarCliente(int cod_cliente);

	/**
	 * Exclui um conta cliente pelo código fornecido
	 * @param cod_admin
	 * @return boolean
	 */
	boolean excluirCliente(int cod_cliente);

}
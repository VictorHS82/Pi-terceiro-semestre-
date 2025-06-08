package interfacesDAO;

import objetos.Administrador;

public interface BaseAdministradorDAO {

	/**
	 * Cadastra uma nova conta de Adiministrador no banco de dados
	 * @param admin
	 * @return boolean
	 */
	boolean cadastrarAdministrador(Administrador admin);

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
	boolean atualizarAdministrador(Administrador admin);

	/**
	 * Busca uma conta administrador pelo código fornecido
	 * @param cod_admin
	 * @return Administrador
	 */
	Administrador buscarAdministrador(int cod_admin);

	/**
	 * Exclui um conta administradora pelo código fornecido
	 * @param cod_admin
	 * @return boolean
	 */
	boolean excluirAdministrador(int cod_admin);

}
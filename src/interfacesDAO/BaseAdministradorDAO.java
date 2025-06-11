package interfacesDAO;

import objetos.Administrador;

/**
 * Interface de administradorDAO
 */
public interface BaseAdministradorDAO {

	/**
	 * Cadastra uma nova conta de Adiministrador no banco de dados
	 * @param admin objeto admin a ser criado
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean cadastrarAdministrador(Administrador admin);

	/**
	 * Valida as informações para login do usuário
	 * @param email email digitado
	 * @param senha senha digitada
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean validarLogin(String email, String senha);

	/**
	 * Atualiza as informações de uma conta Administradora
	 * @param admin administrador a ser atulizado
	 * @return boolea para sinalizar se foi bem sucedido
	 */
	boolean atualizarAdministrador(Administrador admin);

	/**
	 * Busca uma conta administrador pelo código fornecido
	 * @param cod_admin código do administrador
	 * @return objeto administrador 
	 */
	Administrador buscarAdministrador(int cod_admin);

	/**
	 * Exclui um conta administradora pelo código fornecido
	 * @param cod_admin códido do administrador a excluir
	 * @return boolean para sianlizar se foi bem sucedido ou não
	 */
	boolean excluirAdministrador(int cod_admin);

}
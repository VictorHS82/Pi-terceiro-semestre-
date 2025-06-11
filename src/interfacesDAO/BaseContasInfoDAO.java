package interfacesDAO;

import java.util.List;

import objetos.ContaInfo;

/**
 * Interface do contasInfoDAO
 */
public interface BaseContasInfoDAO {

	/**
	 * Listas todas as contas do sistema, seja administradores ou clientes
	 * @return lista com todas as contas do sistema
	 */
	List<ContaInfo> listarTodasContas();

}
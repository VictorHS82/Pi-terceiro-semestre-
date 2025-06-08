package interfacesDAO;

import java.util.List;

import objetos.ContaInfo;

public interface BaseContasDAO {

	/**
	 * Listas todas as contas do sistema, seja administradores ou clientes
	 * @return list
	 */
	List<ContaInfo> listarTodasContas();

}
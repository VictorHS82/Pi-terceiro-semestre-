package interfacesDAO;

import java.util.List;

/**
 * Interace para a criação das classes DAO
 */
public interface BaseDAO {
	
	/**
	 * Registra nova informação no banco de dados
	 * @return boolean
	 */
	public abstract boolean post();
	/**
	 * Pega informação existente no banco de dados
	 * @return object adequado
	 */
	public abstract Object get();
	/**
	 * Atuliza tupla existente no banco de dados
	 * @return boolean
	 */
	public abstract boolean update();
	/**
	 * Deleta uma tupla do banco de dados
	 * @return boolean
	 */
	public abstract boolean delete();
	/**
	 * Retorna uma lista de itens das entidades dos bancos de dados
	 * @return list
	 */
	public abstract List<Object> list();

}

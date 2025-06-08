package interfacesDAO;

import java.util.List;

import objetos.Carrinho;
import objetos.Item_carrinho;

public interface BaseCarrinhoDAO {

	/**
	 * Classe para criar um carrinho
	 * @param carrinho
	 * @return boolean
	 */

	boolean criarCarrinho(Carrinho carrinho);

	/**
	 * Classe para deletar um carrinho
	 * @param cod_carrinho
	 * @return boolean
	 */
	boolean deletarCarrinho(int cod_carrinho);

	/**
	 * Classe para criar um item_carrinho
	 * @param item_carrinho
	 * @return boolean
	 */

	boolean post(Item_carrinho item_carrinho);

	/**
		 * Lista todos os itens_pedido vinculados ao carrinho
		 * Do usuário
		 * @param cod_carrinho
		 * @return lista de itens do carrinho
		 */
	List<Item_carrinho> get(int cod_carrinho);

	/**
	    * Exclui um item_pedido do carrinho
	    * @param cod_item_carrinho
	    * @return boolean
	    */
	boolean delete(int cod_item_carrinho);

}
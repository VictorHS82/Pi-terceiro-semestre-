package interfacesDAO;

import java.util.List;

import objetos.Carrinho;
import objetos.Item_carrinho;

/**
 * Interface do carrinhoDAO
 */
public interface BaseCarrinhoDAO {

	/**
	 * Classe para criar um carrinho
	 * @param carrinho objeto carrinho
	 * @return boolean para sinalizar se foi bem sucedido
	 */

	boolean criarCarrinho(Carrinho carrinho);

	/**
	 * Classe para deletar um carrinho
	 * @param cod_carrinho código do carrinho a ser deletado
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean deletarCarrinho(int cod_carrinho);

	/**
	 * Classe para criar um item_carrinho
	 * @param item_carrinho objeto item_carrinho a ser registrado
	 * @return boolean para sinalizar se foi bem sucedido
	 */

	boolean post(Item_carrinho item_carrinho);

	/**
		 * Lista todos os itens_pedido vinculados ao carrinho
		 * Do usuário
		 * @param cod_carrinho código do carrinho que irá ter seus itens listados
		 * @return lista de itens do carrinho
		 */
	List<Item_carrinho> get(int cod_carrinho);

	/**
	    * Exclui um item_pedido do carrinho
	    * @param cod_item_carrinho código do item a ser deletado
	    * @return boolean para sinalizar se foi bem sucedido
	    */
	boolean delete(int cod_item_carrinho);

}
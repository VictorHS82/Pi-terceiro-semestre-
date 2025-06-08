package interfacesDAO;

import java.util.List;

import objetos.Item_pedido;
import objetos.Pedido;

public interface BasePedidoDAO {

	/**
	 * Cadastra um novo pedido no banco de dados
	 * @param pedido
	 * @return boolean
	 */
	boolean criarPedido(Pedido pedido);

	/**
	 * Adiciona um item_pedido ao banco de dados, e o vínculo a um pedidos
	 * @param item
	 * @return boolean
	 */
	boolean adicionarItemPedido(Item_pedido item);

	/**
	 * Lista todos os itens_pedido vinculados a um pedido
	 * @param cod_pedido
	 * @return list
	 */
	List<Item_pedido> listarItensPedido(int cod_pedido);

	/**
	 * Exclui um item pedido do banco de dados
	 * @param cod_item_pedido
	 * @return boolean
	 */
	boolean excluirItemPedido(int cod_item_pedido);

	/**
	 * Exclui um pedido bo banco de dados
	 * @param cod_pedido
	 * @return boolean
	 */
	boolean excluirPedido(int cod_pedido);

	/**
	 * Atualiza o status de um pedido segundo o cod_pedido
	 * @param cod_pedido
	 * @param novoStatus
	 * @return boolean
	 */
	boolean atualizarStatus(int cod_pedido, String novoStatus);

}
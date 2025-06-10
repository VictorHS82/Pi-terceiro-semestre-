package interfacesDAO;

import java.util.List;

import objetos.Item_pedido;
import objetos.Pedido;

/**
 * Interface de pedidoDAO
 */
public interface BasePedidoDAO {

	/**
	 * Cadastra um novo pedido no banco de dados
	 * @param pedido objeto pedido a ser cadastrado
	 * @return boolean para sinalizar se foi bem sucedidos
	 */
	boolean criarPedido(Pedido pedido);

	/**
	 * Adiciona um item_pedido ao banco de dados, e o vínculo a um pedidos
	 * @param item objeto item_pedido a ser cadastrado
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean adicionarItemPedido(Item_pedido item);

	/**
	 * Lista todos os itens_pedido vinculados a um pedido
	 * @param cod_pedido código do pedido a ter seus itens listados
	 * @return lista com tuplas item_pedido ligadas ao código inserido
	 */
	List<Item_pedido> listarItensPedido(int cod_pedido);

	/**
	 * Exclui um item pedido do banco de dados
	 * @param cod_item_pedido código do item a ser excluído
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean excluirItemPedido(int cod_item_pedido);

	/**
	 * Exclui um pedido bo banco de dados
	 * @param cod_pedido código do pedido a ser excluído
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean excluirPedido(int cod_pedido);

	/**
	 * Atualiza o status de um pedido segundo o cod_pedido
	 * @param cod_pedido código do pedido a ser atualizado
	 * @param novoStatus novo status a ser registrado no banco de dados
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean atualizarStatus(int cod_pedido, String novoStatus);

	/**
	 * Lista todos os pedidos no banco de dados
	 * @return lista com os todos os pedidos do banco de dados
	 */
	List<Pedido> listarTodosPedidos();

}
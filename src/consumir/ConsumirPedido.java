package consumir;

import banco_de_dados.PedidoDAO;
import objetos.Item_pedido;
import objetos.Pedido;

import java.util.List;

/**
 * Classe teste de consumir pedido
 */
public class ConsumirPedido {

	/**
	 * Método main de ConsumirPedido
	 * @param args
	 */
    public static void main(String[] args) {
        // Você pode chamar os métodos de teste individualmente aqui
    	testarCriarPedido();
    	//testarAdicionarItemPedido();
    	//testarListarItensPedido();
    	//testarExcluirItemPedido();
    	//testarExcluirPedido();
    	
    }

    /**
     * Método para criar pedido
     */
    public static void testarCriarPedido() {
        Pedido pedido = new Pedido(
        		8,          // cod_pedido
                1,          // cod_cliente
                10.0f,      // desconto
                5.0f,       // valor_frete
                100.0f,     // subtotal
                95.0f,      // valor_total
                "Pendente"  // status
        );

        PedidoDAO dao = new PedidoDAO();
        boolean sucesso = dao.criarPedido(pedido);
        System.out.println("Criar pedido: " + sucesso);
    }

    /**
     * Método para adicionar item ao pedido
     */
    public static void testarAdicionarItemPedido() {
        Item_pedido item = new Item_pedido(
                1,  // cod_item_pedido
                8,  // cod_pedido (deve já existir)
                1,  // cod_livro
                2,  // quantidade
                45.0f // preco_na_compra
        );

        PedidoDAO dao = new PedidoDAO();
        boolean sucesso = dao.adicionarItemPedido(item);
        System.out.println("Adicionar item ao pedido: " + sucesso);
    }

    /**
     * Classe para listar iten do pedido
     */
    public static void testarListarItensPedido() {
        PedidoDAO dao = new PedidoDAO();
        List<Item_pedido> itens = dao.listarItensPedido(8); // cod_pedido existente

        System.out.println("Itens do pedido:");
        for (Item_pedido item : itens) {
            System.out.printf("Item: %d | Livro: %d | Quantidade: %d | Preço: %.2f%n",
                    item.getCod_item_pedido(), item.getCod_livro(), item.getQuantidade(), item.getPreco_na_compra());
        }
    }

    /**
     * Método para excluir item do pedido
     */
    public static void testarExcluirItemPedido() {
        PedidoDAO dao = new PedidoDAO();
        boolean sucesso = dao.excluirItemPedido(1); // cod_item_pedido existente
        System.out.println("Excluir item do pedido: " + sucesso);
    }

    /**
     * Método para excluir pedido
     */
    public static void testarExcluirPedido() {
        PedidoDAO dao = new PedidoDAO();
        boolean sucesso = dao.excluirPedido(8); // cod_pedido existente
        System.out.println("Excluir pedido: " + sucesso);
    }
}

package consumir;

import banco_de_dados.PedidoDAO;
import interfacesDAO.BasePedidoDAO;
import objetos.Item_pedido;
import objetos.Pedido;

import java.util.List;

public class ConsumirPedido {

    public static void main(String[] args) {
        // Você pode chamar os métodos de teste individualmente aqui
    	testarCriarPedido();
    	//testarAdicionarItemPedido();
    	//testarListarItensPedido();
    	//testarExcluirItemPedido();
    	//testarExcluirPedido();
    	
    }

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

        BasePedidoDAO dao = new PedidoDAO();
        boolean sucesso = dao.criarPedido(pedido);
        System.out.println("Criar pedido: " + sucesso);
    }

    public static void testarAdicionarItemPedido() {
        Item_pedido item = new Item_pedido(
                1,  // cod_item_pedido
                8,  // cod_pedido (deve já existir)
                1,  // cod_livro
                2,  // quantidade
                45.0f // preco_na_compra
        );

        BasePedidoDAO dao = new PedidoDAO();
        boolean sucesso = dao.adicionarItemPedido(item);
        System.out.println("Adicionar item ao pedido: " + sucesso);
    }

    public static void testarListarItensPedido() {
        BasePedidoDAO dao = new PedidoDAO();
        List<Item_pedido> itens = dao.listarItensPedido(8); // cod_pedido existente

        System.out.println("Itens do pedido:");
        for (Item_pedido item : itens) {
            System.out.printf("Item: %d | Livro: %d | Quantidade: %d | Preço: %.2f%n",
                    item.getCod_item_pedido(), item.getCod_livro(), item.getQuantidade(), item.getPreco_na_compra());
        }
    }

    public static void testarExcluirItemPedido() {
        BasePedidoDAO dao = new PedidoDAO();
        boolean sucesso = dao.excluirItemPedido(1); // cod_item_pedido existente
        System.out.println("Excluir item do pedido: " + sucesso);
    }

    public static void testarExcluirPedido() {
        BasePedidoDAO dao = new PedidoDAO();
        boolean sucesso = dao.excluirPedido(8); // cod_pedido existente
        System.out.println("Excluir pedido: " + sucesso);
    }
}

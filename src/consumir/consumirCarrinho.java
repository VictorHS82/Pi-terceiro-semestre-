package consumir;

import banco_de_dados.CarrinhoDAO;
import objetos.Carrinho;
import objetos.Item_carrinho;
import java.util.List;

/**
 * Classe de testes de CarrinoDAO
 */
public class consumirCarrinho {

    static CarrinhoDAO dao = new CarrinhoDAO();

    /**
     * Método main de consumiraCarrinhoDAO
     * @param args
     */
    public static void main(String[] args) {
        //criarCarrinhoDeTeste();
    	//excluirCarrinhoDeTeste();
    	//adicionarItemAoCarrinhoDeTeste();
    	//listarItensDoCarrinhoDeTeste();
    	removerItemDoCarrinhoDeTeste();
    }

    /**
     * Método para criar carrinho
     */
    public static void criarCarrinhoDeTeste() {
        Carrinho carrinho = new Carrinho(9, 1); // cod_carrinho, cod_cliente
        boolean sucesso = dao.criarCarrinho(carrinho);
        System.out.println("Carrinho criado: " + sucesso);
    }

    /**
     * Método para adicionar Item ao carrinho S
     */
    public static void adicionarItemAoCarrinhoDeTeste() {
        Item_carrinho item = new Item_carrinho(
            10, // cod_item_carrinho
            9, // cod_carrinho
            1, // cod_livro
            "Livro Teste", // nome_livro
            2, // quantidade
            59.90f // preco
        );
        boolean sucesso = dao.post(item);
        System.out.println("Item adicionado ao carrinho: " + sucesso);
    }

    /**
     * Classe para listar todos os itens do carrinho
     */
    public static void listarItensDoCarrinhoDeTeste() {
        List<Item_carrinho> itens = dao.get(9); // cod_carrinho
        System.out.println("Itens do carrinho:");
        for (Item_carrinho i : itens) {
            System.out.println("ID Item: " + i.getCod_item_carrinho() +
                               ", Livro: " + i.getNome_livro() +
                               ", Quantidade: " + i.getQuantidade() +
                               ", Preço: " + i.getPreco());
        }
    }

    /**
     * Metodo para remover um item do carrinho
     */
    public static void removerItemDoCarrinhoDeTeste() {
        boolean sucesso = dao.delete(10); // cod_item_carrinho
        System.out.println("Item removido do carrinho: " + sucesso);
    }

    /**
     * Metodo para excluir um carrinho de teste
     */
    public static void excluirCarrinhoDeTeste() {
        boolean sucesso = dao.deletarCarrinho(1); // cod_carrinho
        System.out.println("Carrinho removido: " + sucesso);
    }
}

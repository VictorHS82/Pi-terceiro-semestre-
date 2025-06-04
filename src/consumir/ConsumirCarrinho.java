package consumir;

import banco_de_dados.CarrinhoDAO;
import objetos.Carrinho;

public class ConsumirCarrinho {

	public static void main(String[] args) {
		
	}
	
	public static void criarCarrinho(){
		CarrinhoDAO dao = new CarrinhoDAO();
		
		Carrinho carrinho = new Carrinho
		(
			5, 5	
		);
		dao.criarCarrinho(carrinho);
	}
	
	public static void deletarCarrinho() {
		
	}
	
	public static void post() {
		
	}
	
    public static void get() {
		
	}

    public static void delete() {
	
    }
	
}

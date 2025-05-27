package banco_de_dados;

import java.sql.*;

public class CarrinhoDAO {

	private final BD bd = new BD();
	
	private static String criarCarrinho = "INSERT INTO carrinho"
			+ "(cod_carrinho, cod_cliente)"
			+ "VALUES(?,?)";
	
	private static String adicionarItemAoCarrinho = "";
	
	private static String pegarItensDoCarrinho = "";
	
	private static String excluirItemDoCarrinho = "";
	
	public CarrinhoDAO() {
		bd.getConnection();
	}
	
	
	public boolean criarCarrinho(String cod_cliente) {
		String sql = criarCarrinho;
	}
}

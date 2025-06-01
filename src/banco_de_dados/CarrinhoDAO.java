package banco_de_dados;

import java.sql.*;
import java.util.List;

import objetos.Carrinho;
import objetos.Item_carrinho;

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

	public boolean criarCarrinho(Carrinho carrinho) {
		String sql = criarCarrinho;
		try { PreparedStatement preparedstatement = bd.connection.prepareStatement(sql);
			
			int i = 1;
			preparedstatement.setInt(i++, carrinho.getCod_carrinho());
			preparedstatement.setInt(i++, carrinho.getCod_cliente());
			preparedstatement.executeUpdate();
			bd.connection.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			bd.close();
		}
	}
	
	public boolean deletarCarrinho(int cod_carrinho) {
		
	}
	
	public boolean post(Item_carrinho item_carrinho) {
		String sql = adicionarItemAoCarrinho;
		try { PreparedStatement preparedstatement = bd.connection.prepareStatement(sql);
		
		int i = 1;
		preparedstatement.setInt(i++, item_carrinho.getCod_item_carrinho());
		preparedstatement.setInt(i++, item_carrinho.getCod_carrinho());
		preparedstatement.setInt(i++, item_carrinho.getCod_livro());
		preparedstatement.setString(i++, item_carrinho.getNome_livro());
		preparedstatement.setInt(i++, item_carrinho.getQuantidade());
		preparedstatement.setFloat(i++, item_carrinho.getPreco());
		preparedstatement.executeUpdate();
		bd.connection.commit();
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	} finally {
		bd.close();
	}	
		}
	}

   public boolean get(int cod_item_carrinho) {
	   String sql = "";
   }
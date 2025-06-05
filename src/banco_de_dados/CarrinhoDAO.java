package banco_de_dados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import objetos.Carrinho;
import objetos.Item_carrinho;

/**
 * Classe DAO para o controle de carrinho, e itens do carrinho
 */
public class CarrinhoDAO {

	private final BD bd = new BD();
	
	private static String criarCarrinho = "INSERT INTO carrinho"
			+ "(cod_carrinho, cod_cliente)"
			+ "VALUES(?,?)";
	
	private static String adicionarItemAoCarrinho = "INSERT INTO item_carrinho"
			+"(cod_item_carrinho, cod_carrinho, cod_livro, nome_livro, quantidade, preco_livro)"
			+ "VALUES(?,?,?,?,?,?)";
	
	private static String pegarItensDoCarrinho = "SELECT * FROM item_carrinho"
			+" WHERE cod_carrinho = ?";
	
	private static String excluirItemDoCarrinho = "DELETE FROM item_carrinho"
			+" WHERE cod_item_carrinho = ?";
	
	private static String excluirCarrinho = "DELETE FROM carrinho"
			+" WHERE cod_carrinho = ?";
	
	public CarrinhoDAO() {
		bd.getConnection();
	}
	
	/**
	 * Classe para criar um carrinho
	 * @param carrinho
	 * @return boolean
	 */

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
	
	/**
	 * Classe para deletar um carrinho
	 * @param cod_carrinho
	 * @return boolean
	 */
	public boolean deletarCarrinho(int cod_carrinho) {
		String sql = excluirCarrinho;
        try (PreparedStatement stmt = bd.connection.prepareStatement(sql)) {
            stmt.setInt(1, cod_carrinho);

            int linhasAfetadas = stmt.executeUpdate();
            bd.connection.commit();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            bd.close();
        }
    }
	
	/**
	 * Classe para criar um item_carrinho
	 * @param item_carrinho
	 * @return boolean
	 */
	
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

	/**
	 * Lista todos os itens_pedido vinculados ao carrinho
	 * Do usuário
	 * @param cod_carrinho
	 * @return lista de itens do carrinho
	 */
   public List<Item_carrinho> get(int cod_carrinho) {
	   List<Item_carrinho> lista = new ArrayList<>();
	   String sql = pegarItensDoCarrinho;
	   
	   try(PreparedStatement preparedstatement = bd.connection.prepareStatement(sql)){
		   preparedstatement.setInt(1, cod_carrinho);   
		   ResultSet rs = preparedstatement.executeQuery();

				while (rs.next()) {
				 Item_carrinho item = new Item_carrinho(
					rs.getInt("cod_item_carrinho"),
					rs.getInt("cod_carrinho"),
					rs.getInt("cod_livro"),
					rs.getString("nome_livro"),
					rs.getInt("quantidade"),
					rs.getFloat("preco_livro")
					);
				 lista.add(item);
				}
			   } catch (SQLException e) {
				   e.printStackTrace();
			   } finally {
				   bd.close();
			   }
	   return lista;
   }
   
   /**
    * Exclui um item_pedido do carrinho
    * @param cod_item_carrinho
    * @return boolean
    */
   public boolean delete(int cod_item_carrinho) {
	   String sql = excluirItemDoCarrinho;

       try (PreparedStatement stmt = bd.connection.prepareStatement(sql)) {
           stmt.setInt(1, cod_item_carrinho);

           int linhasAfetadas = stmt.executeUpdate();
           bd.connection.commit();
           return linhasAfetadas > 0;
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       } finally {
           bd.close();
       }
   }
   }
package banco_de_dados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import interfacesDAO.BasePedidoDAO;
import objetos.Item_pedido;
import objetos.Pedido;
/**
 * Classe DAO que controle pedidos e item_pedido
 * 
 * */
public class PedidoDAO implements BasePedidoDAO {

	    private final BD bd = new BD();

	    private static final String criar_pedido = "INSERT INTO pedido"
	    		+ "(cod_pedido, cod_cliente, desconto, valor_frete, subtotal, valor_total, status)" 
	    		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

	    private static final String ADICIONAR_ITEM_PEDIDO = "INSERT INTO item_pedido" 
	    		+ " (cod_item_pedido, cod_pedido, cod_livro, quantidade, preco_na_compra)" 
	    		+ " VALUES (?, ?, ?, ?, ?)";

	    private static final String LISTAR_ITENS_PEDIDO = "SELECT * FROM item_pedido" 
	    		+" WHERE cod_pedido = ?";

	    private static final String EXCLUIR_ITEM_PEDIDO = "DELETE FROM item_pedido"
	    		+ " WHERE cod_item_pedido = ?";

	    private static final String EXCLUIR_PEDIDO = "DELETE FROM pedido" 
	    		+" WHERE cod_pedido = ?";

	    private static final String ATUALIZAR_STATUS = "UPDATE pedido"
	    		+ " SET status = ?" 
	    		+ " WHERE cod_pagamento = ?";
	    
	    public PedidoDAO() {
	        bd.getConnection();
	    }

	    /**
	     * Cadastra um novo pedido no banco de dados
	     * @param pedido
	     * @return boolean
	     */
	    @Override
		public boolean criarPedido(Pedido pedido) {
	        try (PreparedStatement stmt = bd.connection.prepareStatement(criar_pedido)) {
	            int i = 1;
	            stmt.setInt(i++, pedido.getCod_pedido());	            
	            stmt.setInt(i++, pedido.getCod_cliente());
	            stmt.setFloat(i++, pedido.getDesconto());
	            stmt.setFloat(i++, pedido.getValor_frete());
	            stmt.setFloat(i++, pedido.getSubtotal());
	            stmt.setFloat(i++, pedido.getValor_total());
	            stmt.setString(i++, pedido.getStatus());
	            stmt.executeUpdate();
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
	     * Adiciona um item_pedido ao banco de dados, e o vínculo a um pedidos
	     * @param item
	     * @return boolean
	     */
	    @Override
		public boolean adicionarItemPedido(Item_pedido item) {
	        try (PreparedStatement stmt = bd.connection.prepareStatement(ADICIONAR_ITEM_PEDIDO)) {
	            int i = 1;
	            stmt.setInt(i++, item.getCod_item_pedido());
	            stmt.setInt(i++, item.getCod_pedido());
	            stmt.setInt(i++, item.getCod_livro());
	            stmt.setInt(i++, item.getQuantidade());
	            stmt.setFloat(i++, item.getPreco_na_compra());
	            stmt.executeUpdate();
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
	     * Lista todos os itens_pedido vinculados a um pedido
	     * @param cod_pedido
	     * @return list
	     */
	    @Override
		public List<Item_pedido> listarItensPedido(int cod_pedido) {
	        List<Item_pedido> lista = new ArrayList<>();
	        try (PreparedStatement stmt = bd.connection.prepareStatement(LISTAR_ITENS_PEDIDO)) {
	            stmt.setInt(1, cod_pedido);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    Item_pedido item = new Item_pedido(
	                        rs.getInt("cod_item_pedido"),
	                        rs.getInt("cod_pedido"),
	                        rs.getInt("cod_livro"),
	                        rs.getInt("quantidade"),
	                        rs.getFloat("preco_na_compra")
	                    );
	                    lista.add(item);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            bd.close();
	        }
	        return lista;
	    }

	    /**
	     * Exclui um item pedido do banco de dados
	     * @param cod_item_pedido
	     * @return boolean
	     */
	    @Override
		public boolean excluirItemPedido(int cod_item_pedido) {
	        try (PreparedStatement stmt = bd.connection.prepareStatement(EXCLUIR_ITEM_PEDIDO)) {
	            stmt.setInt(1, cod_item_pedido);
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
	     * Exclui um pedido bo banco de dados
	     * @param cod_pedido
	     * @return boolean
	     */
	    @Override
		public boolean excluirPedido(int cod_pedido) {
	        try (PreparedStatement stmt = bd.connection.prepareStatement(EXCLUIR_PEDIDO)) {
	            stmt.setInt(1, cod_pedido);
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
	     * Atualiza o status de um pedido segundo o cod_pedido
	     * @param cod_pedido
	     * @param novoStatus
	     * @return boolean
	     */
	    @Override
		public boolean atualizarStatus(int cod_pedido, String novoStatus) {
	        try (PreparedStatement stmt = bd.connection.prepareStatement(ATUALIZAR_STATUS)) {
	            stmt.setString(1, novoStatus);
	            stmt.setInt(2, cod_pedido);
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

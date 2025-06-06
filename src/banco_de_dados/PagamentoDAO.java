package banco_de_dados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import objetos.Pagamento;

public class PagamentoDAO {

    private final BD bd = new BD();

    private static final String INSERIR_PAGAMENTO = "INSERT INTO pagamento" 
    	+ "(cod_pagamento, cod_pedido, valor_compra, forma_pagamento, status)"
        + " VALUES (?, ?, ?, ?, ?)";
    
    private static final String LISTAR_PAGAMENTOS =  "SELECT * FROM pagamento";
    
    private static final String BUSCAR_PAGAMENTO =  "SELECT * FROM pagamento"
    		+ " WHERE cod_pagamento = ?";
    
    private static final String EXCLUIR_PAGAMENTO = "DELETE FROM pagamento"
    		+ " WHERE cod_pagamento = ?";
    
    private static final String ATUALIZAR_STATUS = "UPDATE pagamento"
    		+ " SET status = ?" 
    		+ " WHERE cod_pagamento = ?";

    public PagamentoDAO() {
        bd.getConnection();
    }

    public boolean registrarPagamento(Pagamento pagamento) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(INSERIR_PAGAMENTO)) {
            int i = 1;
            stmt.setInt(i++, pagamento.getCod_pagamento());
            stmt.setInt(i++, pagamento.getCod_pedido());
            stmt.setFloat(i++, pagamento.getValor_compra());
            stmt.setString(i++, pagamento.getForma_pagamento());
            stmt.setString(i++, pagamento.getStatus());
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

    public List<Pagamento> listarPagamentos() {
        List<Pagamento> lista = new ArrayList<>();
        try (PreparedStatement stmt = bd.connection.prepareStatement(LISTAR_PAGAMENTOS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pagamento pagamento = new Pagamento(
                    rs.getInt("cod_pagamento"),
                    rs.getInt("cod_pedido"),
                    rs.getFloat("valor_compra"),
                    rs.getString("forma_pagamento"),
                    rs.getString("status")
                );
                lista.add(pagamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();
        }
        return lista;
    }

    public Pagamento getPagamento(int cod_pagamento) {
        Pagamento pagamento = null;
        try (PreparedStatement stmt = bd.connection.prepareStatement(BUSCAR_PAGAMENTO)) {
            stmt.setInt(1, cod_pagamento);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pagamento = new Pagamento(
                        rs.getInt("cod_pagamento"),
                        rs.getInt("cod_pedido"),
                        rs.getFloat("valor_compra"),
                        rs.getString("forma_pagamento"),
                        rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();
        }
        return pagamento;
    }

    public boolean atualizarStatus(int cod_pagamento, String novoStatus) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(ATUALIZAR_STATUS)) {
            stmt.setString(1, novoStatus);
            stmt.setInt(2, cod_pagamento);
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

    public boolean excluirPagamento(int cod_pagamento) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(EXCLUIR_PAGAMENTO)) {
            stmt.setInt(1, cod_pagamento);
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

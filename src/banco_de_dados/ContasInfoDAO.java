package banco_de_dados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import interfacesDAO.BaseContasInfoDAO;
import objetos.ContaInfo;

public class ContasInfoDAO implements BaseContasInfoDAO {

    private final BD bd = new BD();

    private static final String LISTAR_USUARIOS = "SELECT cod_cliente"
    		+ " AS id, nome, email, telefone, endereco"
    		+ " FROM cliente";
    private static final String LISTAR_ADMINS = "SELECT cod_admin ="
    		+ " AS id, nome, email, telefone, endereco, criado_por"
    		+ " FROM administrador";

    /**
	 * Listas todas as contas do sistema, seja administradores ou clientes
	 * @return lista com todas as contas do sistema
	 */
    @Override
	public List<ContaInfo> listarTodasContas() {
        List<ContaInfo> contas = new ArrayList<>();
        try {
            bd.getConnection();

            // Clientes
            try (PreparedStatement stmt = bd.connection.prepareStatement(LISTAR_USUARIOS);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    contas.add(new ContaInfo("Usuário",
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("telefone"),
                            rs.getString("endereco"),
                            null));
                }
            }

            // Administradores
            try (PreparedStatement stmt = bd.connection.prepareStatement(LISTAR_ADMINS);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    contas.add(new ContaInfo("Administrador",
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("telefone"),
                            rs.getString("endereco"),
                            rs.getString("criado_por")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();
        }
        return contas;
    }
}

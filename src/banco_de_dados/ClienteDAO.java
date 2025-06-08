package banco_de_dados;

import java.sql.*;

import interfacesDAO.BaseClienteDAO;
import objetos.Cliente;

/**
 * Classe DAO para o controle de contas clientes
 */
public class ClienteDAO implements BaseClienteDAO {

    private final BD bd = new BD();

    private static final String CADASTRAR = "INSERT INTO cliente"
    		+ " (nome, senha, email, cpf, endereco, telefone)" 
    		+ " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String VALIDAR_LOGIN = "SELECT * FROM cliente"
    		+" WHERE email = ? AND senha = ?";
    private static final String ATUALIZAR = "UPDATE cliente SET"
    		+ " nome = ?, email = ?, senha = ?, cpf = ?, endereco = ?, telefone = ?"
    		+ " WHERE cod_cliente = ?";
    private static final String BUSCAR = "SELECT * FROM cliente"
    		+" WHERE cod_cliente = ?";
    private static final String EXCLUIR = "DELETE FROM cliente"
    		+ " WHERE cod_cliente = ?";

    public ClienteDAO() {
        bd.getConnection();
    }

    /**
     * Cadastra uma nova conta de Cliente no banco de dados
     * @param admin
     * @return boolean
     */
    @Override
	public boolean cadastrarCliente(Cliente cliente) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(CADASTRAR)) {
            int i = 0;
        	stmt.setString(i++, cliente.getNome());
            stmt.setString(i++, cliente.getEmail());
            stmt.setString(i++, SegurancaUtil.gerarHash(cliente.getSenha()));
            stmt.setString(i++, cliente.getCpf());
            stmt.setString(i++, cliente.getEndereco());
            stmt.setString(i++, cliente.getTelefone());
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
     * Valida as informações para login do usuário
     * @param email
     * @param senha
     * @return boolean
     */
    @Override
	public boolean validarLogin(String email, String senha) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(VALIDAR_LOGIN)) {
            int i = 0;
        	stmt.setString(i++, email);
            stmt.setString(i++, SegurancaUtil.gerarHash(senha));
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            bd.close();
        }
    }

    /**
     * Atualiza as informações de uma conta Administradora
     * @param admin
     * @return boolean
     */
    @Override
	public boolean atualizarCliente(Cliente cliente) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(ATUALIZAR)) {
            int i = 0;
        	stmt.setString(i++, cliente.getNome());
            stmt.setString(i++, cliente.getEmail());
            stmt.setString(i++, SegurancaUtil.gerarHash(cliente.getSenha()));
            stmt.setString(i++, cliente.getCpf());
            stmt.setString(i++, cliente.getEndereco());
            stmt.setString(i++, cliente.getTelefone());
            stmt.setInt(i++, cliente.getCod_usuario());
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
     * Busca uma conta cliente pelo código fornecido
     * @param cod_admin
     * @return Administrador
     */
    @Override
	public Cliente buscarCliente(int cod_cliente) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(BUSCAR)) {
            stmt.setInt(1, cod_cliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                    rs.getInt("cod_cliente"),
                    rs.getString("nome"),
                    rs.getString("senha"), // hash da senha
                    rs.getString("email"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("endereco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();
        }
        return null;
    }

    /**
     * Exclui um conta cliente pelo código fornecido
     * @param cod_admin
     * @return boolean
     */
    @Override
	public boolean excluirCliente(int cod_cliente) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(EXCLUIR)) {
            stmt.setInt(1, cod_cliente);
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

package banco_de_dados;

import java.sql.*;

import interfacesDAO.BaseAdministradorDAO;
import objetos.Administrador;

/**
 * Classe DAO para o comtrole de contas de administrador
 */
public class AdministradorDAO implements BaseAdministradorDAO {

    private final BD bd = new BD();

    private static final String INSERIR = "INSERT INTO administrador"
    		+ "(nome, email, senha, criado_por)"
    		+ " VALUES (?, ?, ?, ?)";
    private static final String VALIDAR_LOGIN = "SELECT * FROM administrador"
    		+" WHERE email = ? AND senha = ?";
    private static final String ATUALIZAR = "UPDATE administrador"
    		+" SET nome = ?, email = ?, senha = ?, criado_por = ? "
    		+ "WHERE cod_admin = ?";
    private static final String BUSCAR = "SELECT * FROM administrador" 
    		+" WHERE cod_admin = ?";
    private static final String EXCLUIR = "DELETE FROM administrador "
    		+" WHERE cod_admin = ?";

   /**
    * Inicia AdministradorDAO
    */
    public AdministradorDAO() {
        bd.getConnection();
    }

    /**
     * Cadastra uma nova conta de Adiministrador no banco de dados
     * @param admin objeto admin a ser criado
     * @return boolean para sinalizar se foi bem sucedido
     */
    @Override
	public boolean cadastrarAdministrador(Administrador admin) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(INSERIR)) {
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getEmail());
            stmt.setString(3, SegurancaUtil.gerarHash(admin.getSenha()));
            stmt.setString(4, admin.getCriado_por());
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
     * @param email email digitado
     * @param senha senha digitada
     * @return boolean para sinalizar se foi bem sucedido
     */
    @Override
	public boolean validarLogin(String email, String senha) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(VALIDAR_LOGIN)) {
            stmt.setString(1, email);
            stmt.setString(2, SegurancaUtil.gerarHash(senha));
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
     * @param admin administrador a ser atulizado
     * @return boolea para sinalizar se foi bem sucedido
     */
    @Override
	public boolean atualizarAdministrador(Administrador admin) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(ATUALIZAR)) {
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getEmail());
            stmt.setString(3, SegurancaUtil.gerarHash(admin.getSenha()));
            stmt.setString(4, admin.getCriado_por());
            stmt.setInt(5, admin.getCod_usuario());
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
     * Busca uma conta administrador pelo código fornecido
     * @param cod_admin código do administrador
     * @return objeto administrador 
     */
    @Override
	public Administrador buscarAdministrador(int cod_admin) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(BUSCAR)) {
            stmt.setInt(1, cod_admin);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Administrador(
                    rs.getInt("cod_admin"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("criado_por")
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
     * Exclui um conta administradora pelo código fornecido
     * @param cod_admin códido do administrador a excluir
     * @return boolean para sianlizar se foi bem sucedido ou não
     */
    @Override
	public boolean excluirAdministrador(int cod_admin) {
        try (PreparedStatement stmt = bd.connection.prepareStatement(EXCLUIR)) {
            stmt.setInt(1, cod_admin);
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

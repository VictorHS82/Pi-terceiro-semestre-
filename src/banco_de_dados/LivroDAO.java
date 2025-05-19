package banco_de_dados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import objetos.Livros;
public class LivroDAO {
public Livros livros;
public BD bd;

 private static PreparedStatement preparedstatement = null;
 
 private static String cadastrar_livro = " INSERT INTO LIVRO "
		 + "(cod_livro, titulo, autor, descricao, anopublicacao, isbn, genero, idioma, formato,"
		 + "acabamento, corte, paginas, quantidade, peso, precoUnid)"
		 + "VALUES (NULL, ?,?,?,?,?,?,?,?,?,?,?,?,? ";
 
 private static String consultar_livro = " SELECT * FROM LIVRO "
		 + "WHERE cod_livro = ?";
 
 private static String alterar_livro = " UPDATE LIVRO "
		 + " titulo = ?, autor = ?, descricao = ?, anopublicacao = ?, isbn = ?, genero = ?, idioma = ?, formato = ?"
		 + " acabamento = ?, corte = ?, paginas = ?, quantidade = ?, peso = ?, precoUnid = ?)"
		 + " WHERE cod_livro = ?";
 
 private static String deletar_livro = " DELETE * FROM * LIVRO "
		 + "WHERE ID = ?";
 
public LivroDAO() {
	bd = new BD();
	livros = new Livros();
}

public boolean cadastrarLivro(Livros livros) {
	String query = cadastrar_livro;
	try {
		preparedstatement = bd.connection.prepareStatement(query);
	
		int i = 1;
		preparedstatement.setString(i++, livros.getTitulo());
		preparedstatement.setString(i++, livros.getAutor());
		preparedstatement.setString(i++, livros.getDescricao());
		preparedstatement.setString(i++, livros.getAnoPublicacao());
		preparedstatement.setString(i++, livros.getIsbn());
		preparedstatement.setString(i++, livros.getGenero());
		preparedstatement.setString(i++, livros.getFormato());
		preparedstatement.setString(i++, livros.getAcabamento());
		preparedstatement.setString(i++, livros.getCorte());
		preparedstatement.setLong(i++, livros.getPaginas());
		preparedstatement.setInt(i++, livros.getQuantidade());
		preparedstatement.setFloat(i++, livros.getPeso());
		preparedstatement.setFloat(i++, livros.getPrecoUnid());
		
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

public List<Livros> listarTodos() {
    List<Livros> lista = new ArrayList<>();
    String sql = "SELECT * FROM livros";

    try (PreparedStatement preparedsatatement = bd.connection.prepareStatement(sql);
         ResultSet rs = preparedstatement.executeQuery()) {

        while (rs.next()) {
            Livros livro = new Livros(
                rs.getString("cod_livro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("descricao"),
                rs.getString("anopublicacao"),
                rs.getString("isbn"),
                rs.getString("genero"),
                rs.getString("idioma"),
                rs.getString("formato"),
                rs.getString("acabamento"),
                rs.getString("corte"),
                rs.getInt("paginas"),
                rs.getInt("quantidade"),
                rs.getFloat("peso"),
                rs.getFloat("precoUnid")
            );
            lista.add(livro);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        bd.close();
    }

    return lista;
}

public Livros buscarPorCodigo(String cod) {
    String query = consultar_livro;
    Livros livro = null;

    try (PreparedStatement stmt = bd.connection.prepareStatement(query)) {
        stmt.setString(1, cod);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            livro = new Livros(
                rs.getString("cod_livro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("descricao"),
                rs.getString("anopublicacao"),
                rs.getString("isbn"),
                rs.getString("genero"),
                rs.getString("idioma"),
                rs.getString("formato"),
                rs.getString("acabamento"),
                rs.getString("corte"),
                rs.getInt("paginas"),
                rs.getInt("quantidade"),
                rs.getFloat("peso"),
                rs.getFloat("precoUnid")
            );
        }

        rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        bd.close();
    }

    return livro;
}

public boolean atualizarLivro(Livros livro) {
    String sql = alterar_livro;

    try (PreparedStatement stmt = bd.connection.prepareStatement(sql)) {
        int i = 1;
        stmt.setString(i++, livro.getTitulo());
        stmt.setString(i++, livro.getAutor());
        stmt.setString(i++, livro.getDescricao());
        stmt.setString(i++, livro.getAnoPublicacao());
        stmt.setString(i++, livro.getIsbn());
        stmt.setString(i++, livro.getGenero());
        stmt.setString(i++, livro.getIdioma());
        stmt.setString(i++, livro.getFormato());
        stmt.setString(i++, livro.getAcabamento());
        stmt.setString(i++, livro.getCorte());
        stmt.setInt(i++, livro.getPaginas());
        stmt.setInt(i++, livro.getQuantidade());
        stmt.setFloat(i++, livro.getPeso());
        stmt.setFloat(i++, livro.getPrecoUnid());
        stmt.setString(i, livro.getCod_livro());

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

    public boolean deletarLivro(String cod_livro) {
        String query = deletar_livro;

        try (PreparedStatement stmt = bd.connection.prepareStatement(query)) {
            stmt.setString(1, cod_livro);

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

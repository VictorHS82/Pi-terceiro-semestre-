package banco_de_dados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import interfacesDAO.BaseLivroDAO;
import objetos.Livros;

/**
 * Classe DAO (Data Acess Object) da classe Livro.
 * Capaz de manipular a entidade livro do Banco de dados
 */

public class LivroDAO implements BaseLivroDAO {

private final BD bd = new BD();

//Strings de consultas SQL, servem para cadastrar, cosnultar, alterar e excluir um livro.
//cosnultar estoque ecnontra somente as informações da ID, título e quantidade em estoque de um livro 
//listar tudo pega todas as infromações disponivéis da entidade livro
 private static String cadastrar_livro = " INSERT INTO LIVRO "
		 + "(titulo, autor, descricao, anopublicacao, isbn, genero, idioma, formato,"
		 + "paginas, quantidade, peso, preco_unitario, imagem)"
		 + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
 
 private static String consultar_livro = " SELECT * FROM LIVRO "
		 + "WHERE cod_livro = ?";
 
 private static String alterar_livro = " UPDATE LIVRO SET"
		 + " titulo = ?, autor = ?, descricao = ?, anopublicacao = ?, isbn = ?, genero = ?, idioma = ?, formato = ?,"
		 + " paginas = ?, quantidade = ?, peso = ?, preco_unitario = ?, imagem = ?"
		 + " WHERE cod_livro = ?";
 
 private static String deletar_livro = " DELETE FROM LIVRO "
		 + "WHERE cod_livro = ?";

private static String consultar_estoque = "SELECT cod_livro, ttitulo, quantidade FROM LIVRO";

private static String listar_tudo = "SELECT * FROM LIVRO";
 
public LivroDAO() {
	bd.getConnection();
}

/**
 * Cadastra um livro no banco de dados
 * @param livros recebe um novo objeto livro
 * @return true or false
 */
@Override
public boolean cadastrarLivro(Livros livros) {
	String query = cadastrar_livro;
	try { PreparedStatement preparedstatement = bd.connection.prepareStatement(query);
	
		int i = 1;
		preparedstatement.setString(i++, livros.getTitulo());
		preparedstatement.setString(i++, livros.getAutor());
		preparedstatement.setString(i++, livros.getDescricao());
		preparedstatement.setString(i++, livros.getAnoPublicacao());
		preparedstatement.setString(i++, livros.getIsbn());
		preparedstatement.setString(i++, livros.getGenero());
		preparedstatement.setString(i++, livros.getIdioma());
		preparedstatement.setString(i++, livros.getFormato());
		preparedstatement.setLong(i++, livros.getPaginas());
		preparedstatement.setInt(i++, livros.getQuantidade());
		preparedstatement.setFloat(i++, livros.getPeso());
		preparedstatement.setFloat(i++, livros.getPrecoUnid());
		preparedstatement.setString(i++, livros.getImagem());
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
 * Lista todos as tuplas/linhas da entidade livro do banco de dados
 * @return lista lista com todos os itens cadastrados no banco
 */
@Override
public List<Livros> listarTodos() {
    List<Livros> lista = new ArrayList<>();
    String sql = listar_tudo;

    try (PreparedStatement stmt = bd.connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Livros livro = new Livros(
                rs.getInt("cod_livro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("descricao"),
                rs.getString("anopublicacao"),
                rs.getString("isbn"),
                rs.getString("genero"),
                rs.getString("idioma"),
                rs.getString("formato"),
                rs.getInt("paginas"),
                rs.getInt("quantidade"),
                rs.getFloat("peso"),
                rs.getFloat("preco_unitario"),
                rs.getString("imagem")
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

/**
 * Busca as informações de um livro com base no código fornecido
 * @param cod cod do livro a ser procurado
 * @return livro livro quê foi encontrado pela consulta
 */
@Override
public Livros buscarPorCodigo(int cod) {
    String query = consultar_livro;
    Livros livro = null;

    try (PreparedStatement stmt = bd.connection.prepareStatement(query)) {
        stmt.setInt(1, cod);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            livro = new Livros(
                rs.getInt("cod_livro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("descricao"),
                rs.getString("anopublicacao"),
                rs.getString("isbn"),
                rs.getString("genero"),
                rs.getString("idioma"),
                rs.getString("formato"),
                rs.getInt("paginas"),
                rs.getInt("quantidade"),
                rs.getFloat("peso"),
                rs.getFloat("preco_unitario"),
                rs.getString("imagem")
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

/**
 * Busca todas as tuplas/linhas do banco, mas retorna apenas os atributos cod_livro, titulo e quantidade
 * @return estoque lista com o cod_livro, titulo e quantidade de todas as linhas/tuplas do banco da entidade livro
 */
@Override
public List<Livros> consultarEstoque() {
	List<Livros> estoque = new ArrayList<>();
	String query = consultar_estoque;

	try (PreparedStatement preparestatement =  bd.connection.prepareStatement(query);
		 ResultSet rs = preparestatement.executeQuery()) {

		while ( rs.next()) {
		Livros livro = new Livros(
		rs.getInt("cod_livro"),
		rs.getString("titulo"),
		null,
		null,
		null,
		null,
		null,
		null,
		null,
		0,
		rs.getInt("quantidade"),
		0f,
		0f,
		rs.getString("imagem")
	);
		estoque.add(livro);
		}
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	bd.close();
}
	return estoque;
}

/**
 * Atualiza os atributos de um livro
 * @param livro recebe objeto com os todos os parametros, e verifica quais colunas devem ser alteradas
 * @return linhasAfetadas mostra quantas infromações foram modificadas
 * @return false caso a operação falhe
 */
@Override
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
        stmt.setInt(i++, livro.getPaginas());
        stmt.setInt(i++, livro.getQuantidade());
        stmt.setFloat(i++, livro.getPeso());
        stmt.setFloat(i++, livro.getPrecoUnid());
        stmt.setString(i++, livro.getImagem());
        stmt.setInt(i, livro.getCod_livro());

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
 * Deleta um livro do banco de dados
 * @param cod_livro código do livro a ser deletado
 * @return linhasAfetadas quantida de linhas deletadas
 */
@Override
public boolean deletarLivro(int cod_livro) {
        String query = deletar_livro;

        try (PreparedStatement stmt = bd.connection.prepareStatement(query)) {
            stmt.setInt(1, cod_livro);

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

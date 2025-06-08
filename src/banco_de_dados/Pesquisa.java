package banco_de_dados;

import objetos.Livros;
import java.util.*;

import interfacesDAO.BasePesquisa;

import java.sql.*;

/**
 * Classe responsavél por lidar com as pesquisa realizadas pelo usuário
 */
public class Pesquisa implements BasePesquisa {

	private final BD bd;
	
	public Pesquisa(){
		bd = new BD();
		bd.getConnection();
	}
	/**
	 * Classe para criar uma query de busca
	 * @param termoBusca titulo ou autor de um livro
	 * @param maxPaginas maximo de paginas de um livro
	 * @param precoMaximo maximo de preco de um livro
	 * @param formato formato desejado da midia
	 * @return lista com os itens correspondentes
	 */
	@Override
	public List<Livros> pesquisarLivro(String termoBusca, Integer maxPaginas, Float precoMaximo, String formato){
		List<Livros> livros = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder("SELECT * FROM livro WHERE 1=1");
		List<Object> parametros = new ArrayList<>();
		
		if (termoBusca != null && termoBusca.isEmpty()) {
			sql.append(" AND (titulo LIKE ? or autor LIKE ?)");
			String termo = "%" + termoBusca + "%";
			parametros.add(termo);
			parametros.add(termo);
			
		}
		
		if (maxPaginas != null) {
			sql.append(" AND paginas <= ?");
			parametros.add(maxPaginas);
		}
		
		if (precoMaximo != null) {
			sql.append(" AND preco_unitario <= ?");
			parametros.add(precoMaximo);
		}
		
		if (formato != null && !formato.isEmpty()) {
			sql.append(" AND formato = ?");
			parametros.add(formato);
		}
		
		try {
		
		PreparedStatement stmt = bd.connection.prepareStatement(sql.toString());
		for (int i = 0; i < parametros.size(); i++) {
			stmt.setObject(i +1, parametros.get(i));
		}
		
		ResultSet rs = stmt.executeQuery();
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
                  livros.add(livro);
		}
		 stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.close();
		}
		return livros;
		}
	}


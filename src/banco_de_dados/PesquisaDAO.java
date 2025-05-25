package banco_de_dados;

import objetos.Livros;
import java.util.*;
import java.sql.*;

/**
 * Classe responsavél por lidar com as pesquisa realizadas pelo usuário
 */
public class PesquisaDAO {

	private final BD bd = new BD();
	
	public PesquisaDAO(){
		bd.getConnection();
	}
	
	public List<Livros> pesquisarLivro(String termoBusca, Integer maxPaginas, Float precoMaximo, String formato){
		List<Livros> livros = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder("SELECT * FROM livros WHERE 1=1");
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
			sql.append(" AND precoUnid <= ?");
			sql.append(formato);
		}
		
		if (formato != null && !formato.isEmpty()) {
			sql.append(" AND formato = ?");
			parametros.add(formato);
		}
		
		try {
			
		if (!bd.getConnection()){
			 System.out.println("Erro ao se conectar");
			 return livros;
		}
		
		PreparedStatement stmt = bd.connection.prepareStatement(sql.toString());
		for (int i = 0; i < parametros.size(); i++) {
			stmt.setObject(i +1, parametros.get(i));
		}
		
		ResultSet rs = stmt.executeQuery();
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
	                rs.getInt("paginas"),
	                rs.getInt("quantidade"),
	                rs.getFloat("peso"),
	                rs.getFloat("preco_unitario")
	            );
                  livros.add(livro);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.close();
		}
		return livros;
		}
	}


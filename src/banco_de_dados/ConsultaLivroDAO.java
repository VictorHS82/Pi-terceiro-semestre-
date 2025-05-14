package banco_de_dados;

import java.sql.*;

public class ConsultaLivroDAO {
 BD bd = new BD();

 private static PreparedStatement preparedstatement = null;
 private static ResultSet resultset = null; 
 
 private static String cadastrar_livro = " INSERT INTO LIVRO "
		 + "(cod_livro, titulo, autor, descricao, anopublicacao, isbn, genero, idioma, formato,"
		 + "acabamento, corte, paginas, quantidade, peso, precoUnid)"
		 + "VALUES (NULL, ?,?,?,?,?,?,?,?,?,?,?,?,? ";
 
 private static String consultar_livro = " SELECT * FROM * LIVRO "
		 + "WHERE ID = ?";
 
 private static String alterar_livro = " UPDATE LIVRO "
		 + " titulo = ?, autor = ?, descricao = ?, anopublicacao = ?, isbn = ?, genero = ?, idioma = ?, formato = ?"
		 + " acabamento = ?, corte = ?, paginas = ?, quantidade = ?, peso = ?, precoUnid = ?)"
		 + " WHERE cod_livro = ?";
 
 private static String deletar_livro = " DELETE * FROM * LIVRO "
		 + "WHERE ID = ?";
 
public void DAO() {
	
}
}

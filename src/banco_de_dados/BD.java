package banco_de_dados;
import java.sql.*;

/**
 * Classe genárica de conexão com banco de dados
 */
public class BD {
   public Connection connection = null;
   private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private final String DBNAME = "livraria";
   private final String URL = "jdbc:sqlserver://localhost:1433;database=" + DBNAME + ";encrypt=false";
   private final String LOGIN = "pi";
   private final String SENHA = "1234";

   /**
    * Método responsavél pora realizar a conexão com o banco de dados
    * @return true caso se conecte
    */
   public boolean getConnection() {
	   try{
		  Class.forName(DRIVER);
		  connection = DriverManager.getConnection(URL, LOGIN, SENHA);
		  System.out.println("Conectou");
		  return true;
	   } catch (ClassNotFoundException erro) {
		   System.out.println("Driver não ecnontrado" + erro.toString());
		   return false;
	   } catch (SQLException erro) {
		   System.out.println("Falha ao conectar" + erro.toString());
		   return false;
	   }
   }

   /**
    * Método responsavél por fechar a conexão com o banco de dados
    */
   public void close() {
	   try {
		   connection.close();
		   System.out.println("Desconectou");
	   } catch (SQLException erro) {
		   
	   }
   }
}

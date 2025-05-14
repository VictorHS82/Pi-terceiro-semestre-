package banco_de_dados;
import java.sql.*;
public class BD {
   public Connection connection = null;
   private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private final String DBNAME = "";
   private final String URL = "" + DBNAME;
   private final String LOGIN = "";
   private final String SENHA = "";
   
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
   
   public void close() {
	   try {
		   connection.close();
		   System.out.println("Desconectou");
	   } catch (SQLException erro) {
		   
	   }
   }
}

package banco_de_dados;
import java.sql.*;
public class bd {
   public Connection connection = null;
   private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private final String DBNAME = "livraria";
   private final String URL = "jdbc:sqlserver://localhost:1433;" + DRIVER;
   private final String LOGIN = "";
   private final String SENHA = "";
   
   public boolean getConnection() {
	   
   }
   
   public void close() {
	   
   }
}

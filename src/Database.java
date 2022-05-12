import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
      
public Connection connection;

public Connection getconnection(){
      
    String dbName = "Form";
    String user = "sqluser" ;
    String password = "password";
     String url = "jdbc:mysql://localhost:3306/"+dbName;

    try {
        connection = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      System.out.println(e);
    }
    return connection;
}

}
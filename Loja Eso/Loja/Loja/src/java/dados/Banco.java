package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
	
	
	    public Connection getConnection() {
	        Connection conexao = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "123456");
	            System.out.println("conectou!");
	            return conexao;
	        }
	        catch (SQLException e) {
                    System.out.println("error!");
	            throw new RuntimeException(e);
                    
	        }
	        catch(ClassNotFoundException e){
	            throw new RuntimeException(e);
	        }
	    }   
            
           
	

}

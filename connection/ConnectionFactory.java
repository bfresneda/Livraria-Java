package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConexao() {
		try {
		final String url = "jdbc:h2:~/LivrariaQintess";
		final String usuario = "sa";
		final String senha = "";
		
		return DriverManager.getConnection(url, usuario, senha);
	} catch (SQLException e) {
			throw new RuntimeException(e);
	}

		}
}
	
	
	
	
	
	
	
	
	
	
	
	
//    {
//    	System.out.println("Inicio da execução");
//    	try(Connection conn = DriverManager.getConnection("jdbc:h2:~/bananaSplit", "sa", "")) {
//    		
//    		Class.forName("org.h2.Driver");
//    		
//    		
//    		
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 	
//    	System.out.println("Fim da execução");
//    }
//
//	public static Connection getConnection() {
//		
//		return null;
//	}


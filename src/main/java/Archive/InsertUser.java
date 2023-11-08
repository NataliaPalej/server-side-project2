package Archive;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertUser {
	public static void main(String[] args) {
		try {
			String name = "Test" ;
			String password = "test" ;
			String email = "test@gmail.com";
			
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection(
			"jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO USER (name, password, email)"
						+ "VALUES ('" + name + "','" + password + "','" + email + "')");
	
			stmt.close();
			con.close();
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
}

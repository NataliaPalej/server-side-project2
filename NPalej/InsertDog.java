import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDog {

	public static void main(String[] args) {
		try {
			String name = "Test" ;
			int age = 0;
			String breed = "Test";
			String colour = "Test";
			String activity = "Test";
			String maintenance = "Test";
			String owner_name = "Test";
			String owner_email = "Test";
			String owner_password = "Test";
			
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection(
			"jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO DOGS (name, age, breed, colour, activity, maintenance, owner_name, owner_email, owner_password)"
						+ "VALUES ('" + name + "','" + age + "','" + breed + "','" + colour + "','" 
						+ activity + "','" + maintenance + "','" + owner_name + "','" + owner_email 
						+ "','" + owner_password + "')");
	
			System.out.println("Successfully added.");
			stmt.close();
			con.close();
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
}

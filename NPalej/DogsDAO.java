import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum DogsDAO {
	instance;
	List<Dogs> dogsList;
	
	static Connection getConnection() throws SQLException, ClassNotFoundException{
		String DRIVER_URL = "jdbc:hsqldb:hsql://localhost/oneDB";
		String USERNAME = "SA";
		String PASSWORD = "";
		
		try {
	        Class.forName("org.hsqldb.jdbc.JDBCDriver");
	    } catch (ClassNotFoundException e) {
	        throw new ClassNotFoundException("HSQLDB JDBC driver not found.", e);
	    }
			
	    Connection connection = DriverManager.getConnection(DRIVER_URL, USERNAME, PASSWORD);
	    return connection;
	}
	
	
	public static boolean checkLogin(String email, String password) throws Exception {
		
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = getConnection();

	        String query = "SELECT * FROM DOGS WHERE owner_email = ? AND owner_password = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, password);

	        // Execute the query.
	        resultSet = preparedStatement.executeQuery();

	        // Check if there is any user that matches input
	        if (resultSet.next() && resultSet.getInt(1) > 0) {
	        	System.out.println("User " + email + " exists.");
	            return true;
	        } else {
	        	System.out.println("User " + email + " doesn't exist");
	            return false;
	        }
	    } catch (SQLException e) {
	        throw new Exception("Database connection error: " + e.getMessage());
	    } finally {
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }
	}
		
	/**
	 * CRUD for Dogs
	 * @return 
	 * @return 
	 */
	public void insertDog(Dogs newDog) throws Exception {
		// Get connection
		Connection connection = getConnection();
		
		// Create prepared statement with placeholders for the parameters
		PreparedStatement query = connection.prepareStatement("INSERT INTO \"PUBLIC\".\"DOGS\" (name, age, breed, colour, activity, maintenance, owner_email, owner_name, owner_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
		// Update placeholders with the attributes
		query.setString(1, newDog.getName());
		query.setString(2, newDog.getAge());
		query.setString(3, newDog.getBreed());
		query.setString(4, newDog.getColor());
		query.setString(5, newDog.getActivity());
		query.setString(6, newDog.getMaintenance());
		query.setString(7, newDog.getOwner_email());
		query.setString(8, newDog.getOwner_name());
		query.setString(9, newDog.getOwner_password());
				
		// Execute the statement
		query.executeUpdate();
		
		System.out.println("Dog " + newDog.getName() + " was successfully created!");
	}
	
	public void deleteDog(int dogID) throws Exception{
		Connection connection = getConnection();
			
		PreparedStatement query = connection.prepareStatement("DELETE FROM \"PUBLIC\".\"DOGS\" WHERE id = ?");
		query.setInt(1, dogID);
		query.executeUpdate();
		System.out.println("Dog " + dogID + " was successfully deleted.");
	}
		
	public List<Dogs> getDogs() throws Exception {
	    Connection connection = getConnection();
	    // Create a list to store dogs
	    List<Dogs> dogsList = new ArrayList<Dogs>(); 
	    
	    Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * from DOGS");

		while (resultSet.next()) {
			long dogId = resultSet.getLong("id");
			String dogName = resultSet.getString("name");
			String age = resultSet.getString("age");
		    String breed = resultSet.getString("breed");
		    String colour = resultSet.getString("colour");
		    String activity = resultSet.getString("activity");
		    String maintenance = resultSet.getString("maintenance");
		    String owner_email = resultSet.getString("owner_email");
		    String owner_name = resultSet.getString("owner_name");
		    String owner_password = resultSet.getString("owner_password");

		     // Create a Dogs object and add it to the list
		     Dogs dog = new Dogs();
		     dog.setID((int) dogId);
		     dog.setName(dogName);
		     dog.setAge(age);
		     dog.setBreed(breed);
		     dog.setColor(colour);
		     dog.setActivity(activity);
		     dog.setMaintenance(maintenance);
		     dog.setOwner_email(owner_email);
		     dog.setOwner_name(owner_name);
		     dog.setOwner_password(owner_password);
		     dogsList.add(dog);

		     //System.out.println("\n\tGET DOGS:\t");
		     System.out.println("Dog ID: " + dogId);
		     System.out.println("Name: " + dogName + "\tAge: " + age + "\nBreed: " + breed + "\tColor: " 
		        					+ colour + "\nActivity: " + activity + "\tMaintenance: " + maintenance 
		        					+ "\nOwner Name: " + owner_name + "\nOwner Email: " + owner_email 
		        					+ "\nOwner Password: " + owner_password);
		     }
		return dogsList;
	}
	
	public void getDog(int dogID) throws Exception {
		Connection connection = getConnection();

		String selectQuery = "SELECT * from DOGS where id = ?";
		PreparedStatement statement = connection.prepareStatement(selectQuery);

		statement.setInt(1, dogID);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			long dogId = resultSet.getLong("id");
		    String dogName = resultSet.getString("name");
		    String age = resultSet.getString("age");
		    String breed = resultSet.getString("breed");
		    String colour = resultSet.getString("colour");
		    String activity = resultSet.getString("activity");
		    String maintenance = resultSet.getString("maintenance");
		    String owner_email = resultSet.getString("owner_email");
		    String owner_name = resultSet.getString("owner_name");
		    String owner_password = resultSet.getString("owner_password");
		        
		    //System.out.println("\tGET DOG BY ID:\t");
		    System.out.println("Dog ID: " + dogId);
		    System.out.println("Name: " + dogName + "\tAge: " + age + "\nBreed: " + breed + "\tColor: " 
		        				+ colour + "\nActivity: " + activity + "\tMaintenance: " + maintenance 
		        				+ "\nOwner Name: " + owner_name + "\nOwner Email: " + owner_email
		        				+ "\nOwner Password: " + owner_password);
		    }
	}
	
	public void updateDogAge(int dogID, int newAge) throws Exception {
		Connection connection = getConnection();
		String updateAge = "UPDATE \"PUBLIC\".\"DOGS\" SET age = ? WHERE id = ?";
			
		PreparedStatement statement = connection.prepareStatement(updateAge);
		statement.setInt(1, newAge);
		statement.setInt(2, dogID);
		statement.executeUpdate();
		    
		System.out.println("Dog's " + dogID + " age was successfully updated.");
	}
		
	public void updateDogBreed(int dogID, String newBreed) throws Exception {
		Connection connection = getConnection();
		String updateBreed = "UPDATE \"PUBLIC\".\"DOGS\" SET breed = ? WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(updateBreed);
		statement.setString(1, newBreed);
		statement.setInt(2, dogID);
		statement.executeUpdate();
		    
		System.out.println("Dog's " + dogID + " breed was successfully updated.");
	}
		
	public void updateColour(int dogID, String newColor) throws Exception {
		Connection connection = getConnection();
		String updateColor = "UPDATE \"PUBLIC\".\"DOGS\" SET color = ? WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(updateColor);
		statement.setString(1, newColor);
		statement.setInt(2, dogID);
		statement.executeUpdate();
		    
		System.out.println("Dog's " + dogID + " colour was successfully updated.");
	}
		
	public void updateActivity(int dogID, String newActivity) throws Exception {
		Connection connection = getConnection();
		String updateActivity = "UPDATE \"PUBLIC\".\"DOGS\" SET activity = ? WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(updateActivity);
		statement.setString(1, newActivity);
		statement.setInt(2, dogID);
		statement.executeUpdate();
		   
		System.out.println("Dog's " + dogID + " activity was successfully updated.");
	}
		
	public void updateMaintenance(int dogID, String newMaintenance) throws Exception {
			Connection connection = getConnection();
			String updateMaintenance = "UPDATE \"PUBLIC\".\"DOGS\" SET meintenance = ? WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(updateMaintenance);
			statement.setString(1, newMaintenance);
			statement.setInt(2, dogID);
			statement.executeUpdate();
			System.out.println("Dog's " + dogID + " maintenance was successfully updated.");
		} catch (Exception e) {
			System.out.println("Couldn't update dog's maintenance level.");
		} finally {
			connection.close();
		}    
	}
		
//	public List<Dogs> dogsList() throws ClassNotFoundException, SQLException {
//		
//		Connection connection = null;
//		List<Dogs> dogsList = new ArrayList<Dogs>();
//		
//		try {
//			connection = getConnection();
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("SELECT * from DOGS");
//			
//			while (resultSet.next()) {
//				Dogs dog = new Dogs();
//		        dog.setID((int) resultSet.getLong("id"));
//		        dog.setName(resultSet.getString("name"));
//		        dog.setAge((int) resultSet.getLong("age"));
//		        dog.setBreed(resultSet.getString("breed"));
//		        dog.setColor(resultSet.getString("colour"));
//		        dog.setActivity(resultSet.getString("activity"));
//		        dog.setMaintenance(resultSet.getString("maintenance"));
//		        dog.setOwner_email(owner_email);
//		        dog.setOwner_name(owner_name);
//		        dog.setOwner_password(owner_password);
//		        dogsList.add(dog);
//		        }
//		}finally {
//			if (connection != null) {
//				connection.close();
//				}
//			}
//		return dogsList;
//	}
		
	/**
	* Main method
	*/
	//public static void main(String[] args) throws Exception {
	//	// Call methods to fetch and display all dogs
	//	getAllDogs();
	//}
	
//	public static void getAllDogs() throws Exception {
//		List<Dogs> dogs = instance.getDogs();
//		if (dogs != null) {
//			for (Dogs dog : dogs) {
//				System.out.println("Dog ID: " + dog.getID());
//				System.out.println("Name: " + dog.getName());
//		        System.out.println("Age: " + dog.getAge());
//		        System.out.println("Breed: " + dog.getBreed());
//		        System.out.println("Color: " + dog.getColor());
//		        System.out.println("Activity: " + dog.getActivity());
//		        System.out.println("Maintenance: " + dog.getMaintenance());
//		        System.out.println("Owner name: " + dog.getOwner_name());
//		        System.out.println("Owner email: " + dog.getOwner_email());
//		       System.out.println("-------------------------");
//		   }
//		}
//	}

	List<Dogs> getDogByUserEmail(String email) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();

		String selectQuery = "SELECT * FROM dogs WHERE owner_email = ?"; 
		PreparedStatement statement = connection.prepareStatement(selectQuery);

		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			long dogId = resultSet.getLong("id");
		    String dogName = resultSet.getString("name");
		    String age = resultSet.getString("age");
		    String breed = resultSet.getString("breed");
		    String colour = resultSet.getString("colour");
		    String activity = resultSet.getString("activity");
		    String maintenance = resultSet.getString("maintenance");
		    String owner_name = resultSet.getString("owner_name");
		    String owner_email = resultSet.getString("owner_email");
		        
		    //System.out.println("\tGET DOG:\t");
		    System.out.println("Dog ID: " + dogId);
		    System.out.println("Name: " + dogName + "\tAge: " + age + "\nBreed: " + breed + "\tColor: " 
		        				+ colour + "\nActivity: " + activity + "\tMaintenance: " + maintenance 
		        				+ "\nOwner: " + owner_name + "\nOwner email: " + owner_email);
		    }
		return dogsList;
	}
}

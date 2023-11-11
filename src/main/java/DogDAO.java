import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum DogDAO {
	instance;
	List<Dog> dogsList = new ArrayList<Dog>();
	
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

	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next() && resultSet.getInt(1) > 0) {
	        	System.out.println("checkLogin(): User " + email + " exists.\n");
	            return true;
	        } else {
	        	System.out.println("checkLogin(): User " + email + " either doesn't exist or incorrect credentials were provided.");
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
	public void insertDog(Dog newDog) throws Exception {
		// Get connection
		Connection connection = getConnection();
		
		// Create prepared statement with placeholders for the parameters
		PreparedStatement query = connection.prepareStatement("INSERT INTO \"PUBLIC\".\"DOGS\" (name, age, breed, colour, activity, maintenance, owner_email, owner_name, owner_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
		// Update placeholders with the attributes
		query.setString(1, newDog.getName());
		query.setString(2, newDog.getAge());
		query.setString(3, newDog.getBreed());
		query.setString(4, newDog.getColour());
		query.setString(5, newDog.getActivity());
		query.setString(6, newDog.getMaintenance());
		query.setString(7, newDog.getOwner_email());
		query.setString(8, newDog.getOwner_name());
		query.setString(9, newDog.getOwner_password());
				
		// Execute the statement
		query.executeUpdate();
		
		System.out.println("insertDog(): Dog " + newDog.getName() + " was successfully created.");
	}
	
	public void deleteDog(int dogID) throws Exception{
		Connection connection = getConnection();
			
		PreparedStatement query = connection.prepareStatement("DELETE FROM \"PUBLIC\".\"DOGS\" WHERE id = ?");
		query.setInt(1, dogID);
		query.executeUpdate();
		System.out.println("deleteDog(): Dog " + dogID + " was successfully deleted.\n");
	}
	
	public Dog getDogByName(String email, String dogName) throws Exception {
		Connection connection = getConnection();

		String selectQuery = "SELECT * FROM DOGS WHERE owner_email = ? AND name = ?";
        PreparedStatement statement = connection.prepareStatement(selectQuery);

        statement.setString(1, email);
        statement.setString(2, dogName);
        
        ResultSet resultSet = statement.executeQuery();
		
		Dog dog = new Dog();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
		    String name = resultSet.getString("name");
		    String age = resultSet.getString("age");
		    String breed = resultSet.getString("breed");
		    String colour = resultSet.getString("colour");
		    String activity = resultSet.getString("activity");
		    String maintenance = resultSet.getString("maintenance");
		    String owner_email = resultSet.getString("owner_email");
		    String owner_name = resultSet.getString("owner_name");
		    String owner_password = resultSet.getString("owner_password");
		        
		    System.out.println("getDog(id):\nId: " + id + "\tName: " + name + "\tAge: " + age 
		    		+ "\nBreed: " + breed + "\tColor: "	+ colour 
		    		+ "\nActivity: " + activity + "\tMaintenance: " + maintenance 
		        	+ "\nOwner Details: \nName: " + owner_name + "\tEmail: " + owner_email 
		        	+ "\tPassword: " + owner_password + "\n");
		    
			dog.setID(id);
			dog.setName(name);
			dog.setAge(age);
			dog.setBreed(breed);
			dog.setColour(colour);
			dog.setActivity(activity);
			dog.setMaintenance(maintenance);
			dog.setOwner_email(owner_email);
			dog.setOwner_name(owner_name);
			dog.setOwner_password(owner_password);	
		    }	
		return dog;
	}
	
	public void updateDog(Dog dog) throws Exception {
		Connection connection = getConnection();

		String updateQuery = "UPDATE dogs SET age = ?, breed = ?, colour = ?, activity = ?, maintenance = ?, owner_email = ?, owner_name = ?, owner_password = ? WHERE name = ?";
	    PreparedStatement statement = connection.prepareStatement(updateQuery);

	    statement.setString(1, dog.getAge());
	    statement.setString(2, dog.getBreed());
	    statement.setString(3, dog.getColour());
	    statement.setString(4, dog.getActivity());
	    statement.setString(5, dog.getMaintenance());
	    statement.setString(6, dog.getOwner_email());
	    statement.setString(7, dog.getOwner_name());
	    statement.setString(8, dog.getOwner_password());
	    statement.setString(9, dog.getName());
	    
	    int rowsAffected = statement.executeUpdate();
	    
	    if (rowsAffected > 0) {
	        System.out.println("updateDog(): Dog " + dog.getName() + " was successfully updated.\n");
	    } else {
	        System.out.println("updateDog(): Dog " + dog.getName() + " not found.\n");
	    }	
	}
	
	public List<Dog> dogsList() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		List<Dog> dogsList = new ArrayList<Dog>();
		
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * from DOGS");
			
			while (resultSet.next()) {
				Dog dog = new Dog();
		        dog.setID((int) resultSet.getLong("id"));
		        dog.setName(resultSet.getString("name"));
		        dog.setAge(resultSet.getString("age"));
		        dog.setBreed(resultSet.getString("breed"));
		        dog.setColour(resultSet.getString("colour"));
		        dog.setActivity(resultSet.getString("activity"));
		        dog.setMaintenance(resultSet.getString("maintenance"));
		        dog.setOwner_email(resultSet.getString("owner_email"));
		        dog.setOwner_name(resultSet.getString("owner_name"));
		        dog.setOwner_password(resultSet.getString("owner_password"));
		        dogsList.add(dog);
		        }
		}finally {
			if (connection != null) {
				connection.close();
				}
			}
		return dogsList;
	}

	List<Dog> getDogByEmail(String email) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();

		String selectQuery = "SELECT * FROM dogs WHERE owner_email = ?";
		PreparedStatement statement = connection.prepareStatement(selectQuery);

		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			Dog dog = new Dog();
			dog.setID(resultSet.getInt("id"));
	        dog.setName(resultSet.getString("name"));
	        dog.setAge(resultSet.getString("age"));
	        dog.setBreed(resultSet.getString("breed"));
	        dog.setColour(resultSet.getString("colour"));
	        dog.setActivity(resultSet.getString("activity"));
	        dog.setMaintenance(resultSet.getString("maintenance"));
	        dog.setOwner_name(resultSet.getString("owner_name"));
	        dog.setOwner_email(resultSet.getString("owner_email"));
	        dog.setOwner_password(resultSet.getString("owner_password"));
	        
	        
	        boolean dogExists = false;
	        for (Dog existingDog : dogsList) {
	            if (checkDog(existingDog, dog)) {
	                dogExists = true;
	                System.out.println("Dog already exists.");
	                break;
	            }
	        }
	        if (!dogExists) {
	            dogsList.add(dog);
	            System.out.println("getDogByEmail(): \n" + dog.printDetails());
	        }
		}
		return dogsList;
	}

	private boolean checkDog(Dog dog1, Dog dog2) {
	    return dog1.getName().equals(dog2.getName()) &&
	           dog1.getID() == (dog2.getID());
	    }
	
	int ownersCount() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		int count = 0;
		
		try {
			connection = getConnection();

			// Get amount of owners
            String selectQuery = "SELECT COUNT(DISTINCT owner_name) AS owner_count FROM DOGS";
            PreparedStatement statement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                count = resultSet.getInt("owner_count");
            }
		} finally {
            if (connection != null) {
                connection.close();
            }
        }
		return count;
	}
	
	int dogsCount() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		int count = 0;
		
		try {
			connection = getConnection();

			// Get amount of owners
            String selectQuery = "SELECT COUNT(DISTINCT name) AS dogs_count FROM DOGS";
            PreparedStatement statement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                count = resultSet.getInt("dogs_count");
            }
		} finally {
            if (connection != null) {
                connection.close();
            }
        }
		return count;
	}
}
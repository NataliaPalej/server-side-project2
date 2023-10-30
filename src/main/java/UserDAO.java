import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// ENUM is NOT a class
public enum UserDAO {
	
	// Essential as it is an entry point
	instance;
	
	List<User> usersList;
	List<Dogs> dogsList;
	
	// Get Connection method
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		String DRIVER_URL = "jdbc:hsqldb:hsql://localhost/oneDB";
		String USERNAME = "sa";
		String PASSWORD = "";
		
		try {
	        // Load the driver class
	        Class.forName("org.hsqldb.jdbc.JDBCDriver");
	    } catch (ClassNotFoundException e) {
	        throw new ClassNotFoundException("HSQLDB JDBC driver not found.", e);
	    }
		
		// Get connection from DriverManager
	    Connection connection = DriverManager.getConnection(DRIVER_URL, USERNAME, PASSWORD);
	    return connection;
	}
	
	/**
	 * CRUD for Users
	 */
	public void insertUser(User newUser) throws Exception{
		// Get connection
		Connection connection = getConnection();
		
		// Create prepared statement with placeholders for the parameters
		PreparedStatement query = connection.prepareStatement("INSERT INTO \"PUBLIC\".\"USERS\" (name, password, email) VALUES (?, ?, ?)");
		
		// Update placeholders with the properties
		query.setString(1, newUser.getName());
		query.setString(2, newUser.getPassword());
		query.setString(3,  newUser.getEmail());
		
		// Execute the statement
		query.executeUpdate();
	}
	
	public void deleteUser(String name) throws Exception{
		Connection connection = getConnection();
		
		PreparedStatement query = connection.prepareStatement("DELETE FROM \"PUBLIC\".\"USERS\" WHERE name = ?");
		query.setString(1, name);
		query.executeUpdate();
	}
	
	public List<User> getUsers() throws Exception{
		Connection connection = getConnection();
	    List<User> usersList = new ArrayList<User>(); // Create a list to store users

	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM \"PUBLIC\".\"USERS\"");

	    while (resultSet.next()) {
	    	long userId = resultSet.getLong("id");
	        String name = resultSet.getString("name");
	        String password = resultSet.getString("password");
	        String email = resultSet.getString("email");
	        
	        // Create a User object and add it to the list
	        User user = new User();
	        user.setID((int) userId);
	        user.setName(name);
	        user.setPassword(password);
	        user.setEmail(email);
	        usersList.add(user);

	        System.out.println("Name: " + name + "\nPassword: " + password + "\nEmail: " + email);
	    }

	    return usersList;
	}
	
	public void getUser(String name) throws Exception {
	    Connection connection = getConnection();

	    String selectQuery = "SELECT * FROM \"PUBLIC\".\"USERS\" WHERE name = ?";
	    PreparedStatement statement = connection.prepareStatement(selectQuery);

	    statement.setString(1, name);
	    ResultSet resultSet = statement.executeQuery();

	    while (resultSet.next()) {
	    	long userId = resultSet.getLong("id");
	        String userName = resultSet.getString("name");
	        String password = resultSet.getString("password");
	        String email = resultSet.getString("email");
	        System.out.println("User ID: " + userId + "\nName: " + userName + "\nPassword: " + password + "\nEmail: " + email);
	    }
	}

	public void updateUser(User updatedUser) throws Exception {
	    Connection connection = getConnection();
	    
	    String updateQuery = "UPDATE \"PUBLIC\".\"USERS\" SET name = ?, password = ?, email = ? WHERE name = ?";
	    
	    PreparedStatement statement = connection.prepareStatement(updateQuery);
	    
	    // Set the updated values for name, password, email
	    statement.setString(1, updatedUser.getName());
	    statement.setString(2, updatedUser.getPassword());
	    statement.setString(3, updatedUser.getEmail());
	    
	    // Specify the user to update 
	    statement.setString(4, updatedUser.getName());
	    statement.executeUpdate();
	}
	
	// Get user ID for new Dog insert method
	private long getUserID(String name) throws Exception {
	    Connection connection = getConnection();
	    String selectQuery = "SELECT id FROM \"PUBLIC\".\"USERS\" WHERE name = ?";
	    PreparedStatement statement = connection.prepareStatement(selectQuery);
	    statement.setString(1, name);

	    ResultSet resultSet = statement.executeQuery();

	    if (resultSet.next()) {
	        return resultSet.getLong("id");
	    } else {
	        // User not found
	        return -1;
	    }
	}
	
	
	/**
	 * CRUD for Dogs
	 */
	public void insertDog(Dogs newDog, String userName) throws Exception {
		// Get connection
		Connection connection = getConnection();
		
		// Get the user's ID based on the provided user name
	    long userId = getUserID(userName);
	    long newDogId = -1;
	    
	    if (userId == -1) {
	        System.out.println("User not found. Cannot insert dog.");
	        return;
	    }
		
	    PreparedStatement query = connection.prepareStatement("INSERT INTO \"PUBLIC\".\"DOGS\" "
                + "(name, age, breed, colour, activity, maintenance, userID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);
		
	    query.setString(1, newDog.getName());
	    query.setLong(2,  newDog.getAge());
	    query.setString(3,  newDog.getBreed());
	    query.setString(4,  newDog.getColor());
	    query.setString(5,  newDog.getActivity());
	    query.setString(6,  newDog.getMaintenance());
	    query.setLong(7, userId);
	    
	    query.executeUpdate();
		
	    ResultSet generatedKeys = query.getGeneratedKeys();
	    if (generatedKeys.next()) {
	        newDogId = generatedKeys.getLong(1);
	        newDog.setID((int) newDogId);
	    } else {
	        System.out.println("Failed to retrieve the generated ID.");
	    }
		
		System.out.println("Dog " + newDog.getID() + " " + newDog.getName() + " was successfully added.");
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
	    ResultSet resultSet = statement.executeQuery("SELECT D.*, U.name AS ownerName FROM \"PUBLIC\".\"DOGS\" D\r\n"
	    		+ "INNER JOIN \"PUBLIC\".\"USERS\" U ON D.userID = U.id");

	    while (resultSet.next()) {
	    	long dogId = resultSet.getLong("id");
	        String dogName = resultSet.getString("name");
	        int age = resultSet.getInt("age");
	        String breed = resultSet.getString("breed");
	        String colour = resultSet.getString("colour");
	        String activity = resultSet.getString("activity");
	        String maintenance = resultSet.getString("maintenance");
	        String ownerName = resultSet.getString("ownerName");

	        // Create a Dogs object and add it to the list
	        Dogs dog = new Dogs();
	        dog.setID((int) dogId);
	        dog.setName(dogName);
	        dog.setAge(age);
	        dog.setBreed(breed);
	        dog.setColor(colour);
	        dog.setActivity(activity);
	        dog.setMaintenance(maintenance);
	        dogsList.add(dog);

	        //System.out.println("\n\tGET DOGS:\t");
	        System.out.println("Dog ID: " + dogId);
	        System.out.println("Name: " + dogName + "\tAge: " + age + "\nBreed: " + breed + "\tColor: " 
	        					+ colour + "\nActivity: " + activity + "\tMaintenance: " + maintenance + "\nOwner: " + ownerName);
	    }

	    return dogsList;
	}
	
	public void getDog(int dogID) throws Exception {
	    Connection connection = getConnection();

	    String selectQuery = "SELECT D.*, U.name AS ownerName FROM \"PUBLIC\".\"DOGS\" D " +
	            "INNER JOIN \"PUBLIC\".\"USERS\" U ON D.userID = U.id " +
	            "WHERE D.id = ?";;
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
	        String ownerName = resultSet.getString("ownerName");
	        
	        //System.out.println("\tGET DOG:\t");
	        System.out.println("Dog ID: " + dogId);
	        System.out.println("Name: " + dogName + "\tAge: " + age + "\nBreed: " + breed + "\tColor: " 
	        					+ colour + "\nActivity: " + activity + "\tMaintenance: " + maintenance + "\nOwner: " + ownerName);
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
	
	
	/**
	 *  
	 * @return Users / Dogs list
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<User> userList() throws ClassNotFoundException, SQLException {
	    Connection connection = null;
	    List<User> userList = new ArrayList<User>();

	    try {
	        connection = getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"PUBLIC\".\"USERS\"");

	        while (resultSet.next()) {
	            User user = new User();
	            user.setID((int) resultSet.getLong("id"));
	            user.setName(resultSet.getString("name"));
	            user.setPassword(resultSet.getString("password"));
	            user.setEmail(resultSet.getString("email"));
	            userList.add(user);
	        }
	    } finally {
	        if (connection != null) {
	            connection.close();
	        }
	    }

	    return userList;
	}
	
	public List<Dogs> dogsList() throws ClassNotFoundException, SQLException {
	    Connection connection = null;
	    List<Dogs> dogsList = new ArrayList<Dogs>();

	    try {
	    	connection = getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT D.*, U.name AS ownerName FROM \"PUBLIC\".\"DOGS\" D " +
	                "INNER JOIN \"PUBLIC\".\"USERS\" U ON D.userID = U.id");

	        while (resultSet.next()) {
	            Dogs dog = new Dogs();
	            String ownerName = resultSet.getString("ownerName");
	            dog.setOwnerName(ownerName);
	            dog.setID((int) resultSet.getLong("id"));
	            dog.setName(resultSet.getString("name"));
	            dog.setAge((int) resultSet.getLong("age"));
	            dog.setBreed(resultSet.getString("breed"));
	            dog.setColor(resultSet.getString("colour"));
	            dog.setActivity(resultSet.getString("activity"));
	            dog.setMaintenance(resultSet.getString("maintenance"));
	            dog.setID((int) resultSet.getLong("userID"));
	            dogsList.add(dog);
	        }
	    } finally {
	        if (connection != null) {
	            connection.close();
	        }
	    }

	    return dogsList;
	}
	
	
	
	/**
	 * Main method
	 */
	public static void main(String[] args) throws Exception {
	    // Call methods to fetch and display all users and dogs
	    getAllUsers();
	    getAllDogs();
	}
	
	public static void getAllUsers() throws Exception {
	    List<User> users = instance.getUsers();
	    
	    if (users != null) {
	        for (User user : users) {
	        	System.out.println("-------------------------");
	            System.out.println("User ID: " + user.getID());
	            System.out.println("Name: " + user.getName());
	            System.out.println("Password: " + user.getPassword());
	            System.out.println("Email: " + user.getEmail());
	            System.out.println("-------------------------");
	        }
	    }
	}
	
	public static void getAllDogs() throws Exception {
	    List<Dogs> dogs = instance.getDogs();
	    
	    if (dogs != null) {
	        for (Dogs dog : dogs) {
	            System.out.println("Dog ID: " + dog.getID());
	            System.out.println("Name: " + dog.getName());
	            System.out.println("Age: " + dog.getAge());
	            System.out.println("Breed: " + dog.getBreed());
	            System.out.println("Color: " + dog.getColor());
	            System.out.println("Activity: " + dog.getActivity());
	            System.out.println("Maintenance: " + dog.getMaintenance());

	            String ownerName = dog.getOwnerName();
	            if (ownerName != null) {
	                System.out.println("Owner: " + ownerName);
	            } else {
	                System.out.println("Owner: Not found");
	            }
	            System.out.println("-------------------------");
	        }
	    }
	}
}

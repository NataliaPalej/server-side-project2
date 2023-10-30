import java.util.List;

public class QueryClass {

	public static void main(String[] args) {
		
		try {
			// Create an instance of UserDAO
            UserDAO userDAO = UserDAO.instance; 
            
            System.out.println("GET DOG");
            userDAO.getDog(1);
            System.out.println();
            System.out.println("-##----------------------------##-");
            System.out.println();
            
            // Retrieve users
            //List<User> usersList = userDAO.getUsers();
            //List<Dogs> dogsList = userDAO.getDogs();

            
            // Update dog
            System.out.println("\tUPDATE QUERY\t");
            try {
            	userDAO.updateDogAge(1, 3);
            	System.out.println("Dog updated successfully.");
            	userDAO.getDog(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Delete dog
            System.out.println("\n\tDELETE QUERY\t");
            try {
            	int dogID = 12;
            	System.out.println("Dog to delete:\n");
            	userDAO.getDog(dogID);
            	userDAO.deleteDog(dogID);  	
            } catch (Exception e) {
                e.printStackTrace();
            }
            

//            // Update a user
//            User updatedUser = new User();
//            updatedUser.setName("John");
//            updatedUser.setPassword("john");
//            updatedUser.setEmail("john@gmail.com");
//            userDAO.updateUser(updatedUser);

            // Delete a user
            //userDAO.deleteUser("John");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

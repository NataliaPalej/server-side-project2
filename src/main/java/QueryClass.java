import java.util.List;

public class QueryClass {

	public static void main(String[] args) throws Exception {
		
		try {
			// Create an instance of UserDAO
            UserDAO userDAO = UserDAO.instance; 
            
            System.out.println("GET DOG");
            userDAO.getDog(1);
            System.out.println();
            System.out.println("\n-##----------------------------##-");
            System.out.println();
            
            // Retrieve users
            //List<User> usersList = userDAO.getUsers();
            //List<Dogs> dogsList = userDAO.getDogs();

            
            // Update dog
            System.out.println("\tUPDATE QUERY\t");
            try {
            	userDAO.updateDogAge(1, 3);
            	userDAO.getDog(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            System.out.println("\n-##----------------------------##-");
            
            // Delete dog
            System.out.println("\n\tDELETE QUERY\t");
            try {
            	int dogID = 12;
            	userDAO.getDog(dogID);
            	userDAO.deleteDog(dogID);  	
            } catch (Exception e) {
                e.printStackTrace();
            }   
            
            System.out.println("\n-##----------------------------##-");
            
            // Insert dog
            System.out.println("\n\tINSERT QUERY\t");
            try {
            	Dogs newDog = new Dogs();
            	newDog.setName("Buddy");
            	newDog.setAge(10);
            	newDog.setBreed("Pomeralian");
            	newDog.setColor("Ginger");
            	newDog.setActivity("high");
            	newDog.setMaintenance("medium");
            	String userName = "Natalia";
            	
            	userDAO.insertDog(newDog, userName);
            } catch (Exception e) {
            	System.out.println("Couldn't insert dog.\n" + e.getMessage());
            }
        } catch (Exception e) {
        	System.out.println("Some error happened.");
            e.printStackTrace();
        }
		
		//UserDAO.getAllDogs();
	}
}

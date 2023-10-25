import java.util.ArrayList;
import java.util.List;

// ENUM is NOT a class
public enum UserDAO {
	
	// Essential as it is an entry point
	instance;
	
	List<User> usersList;
	List<Dogs> dogsList;
	
	private UserDAO() {
		usersList = new ArrayList<User>();
		dogsList = new ArrayList<Dogs>();
		
		User u1 = new User("Natalia", "natalia", "natalia1", "natalia@gmail.com");
		User u2 = new User("Kasia", "kasia", "kasia1", "kasia@gmail.com");
		User u3 = new User("Dominik", "dominik", "dominik1", "dominik@gmail.com");
		User u4 = new User("Monika", "monika", "monika1", "monika@gmail.com");
		User u5 = new User("Aska", "aska", "aska1", "aska@gmail.com");
		User u6 = new User("Lidia", "lidia", "lidia1", "lidia@gmail.com");
		
		Dogs d1 = new Dogs("Lilly", 3, "Yorkshire Terrier", "Silver-Tan", "High");
		Dogs d2 = new Dogs("Coco", 1, "Cockapoo", "Brown", "Low");
		Dogs d3 = new Dogs("Luna", 3, "Cockapoo", "Light-Brown", "Low");
		Dogs d4 = new Dogs("Gizmo", 9, "Shih Tzu", "Black-White", "Medium");
		Dogs d5 = new Dogs("Lady", 15, "Yorkshire Terrier", "Tan", "Very Low");
		Dogs d6 = new Dogs("Saba", 12, "Boxer", "Dark-Brown", "Low");
		
		// Add users to the list
		usersList.add(u1);
		usersList.add(u2);
		usersList.add(u3);
		usersList.add(u4);
		usersList.add(u5);
		usersList.add(u6);
		
		// Add dogs to the list
		dogsList.add(d1);
		dogsList.add(d2);
		dogsList.add(d3);
		dogsList.add(d4);
		dogsList.add(d5);
		dogsList.add(d6);
	}
	
	public List<User> list(){
		return this.usersList;
	}
}

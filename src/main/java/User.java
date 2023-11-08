public class User {

	private String name, password, email;
	private int id;
	
	public User (String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User() {
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}

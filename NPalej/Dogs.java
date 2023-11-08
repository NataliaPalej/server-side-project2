public class Dogs {
	
	private String age, name, breed, color, activity, maintenance, owner_email, owner_name, owner_password;
	private int id;
	
	public Dogs(String name, String age, String breed, String color, String activity, String maintenance, String owner_name, String email, String password) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.color = color;
		this.activity = activity;
		this.maintenance = maintenance;
		this.owner_email = email;
		this.owner_name = owner_name;
		this.owner_password = password;
	}
		
	public Dogs() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getOwner_email() {
		return owner_email;
	}

	public void setOwner_email(String owner_email) {
		this.owner_email = owner_email;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getOwner_password() {
		return owner_password;
	}

	public void setOwner_password(String owner_password) {
		this.owner_password = owner_password;
	}
}

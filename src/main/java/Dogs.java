public class Dogs {
	
	private String name, breed, color, activity, maintenance, ownerName;
	private int age, id;
	
	public Dogs(int id, String name, int age, String breed, String color, String activity, String maintenance) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.color = color;
		this.activity = activity;
		this.maintenance = maintenance;
	}
		
	public Dogs() {
		
	}
	
	public String getOwnerName() {
	    return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;	
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	
}

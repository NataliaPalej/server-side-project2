public class Dogs {
	
	private String name, breed, color, maintenance;
	private int age;
	
	public Dogs(String name, int age, String breed, String color, String maintenance) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.color = color;
		this.maintenance = maintenance;
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
}

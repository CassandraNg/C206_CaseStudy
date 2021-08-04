
public class Category {
	private String name;
	private boolean isAvailable;
	 

	public Category(String name) {
		super();
		this.name = name;
		this.isAvailable = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	

}

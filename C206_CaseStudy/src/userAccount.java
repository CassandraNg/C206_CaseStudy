
public class userAccount {
	
	private String name;
	private String password;
	private String role;
	private String email;
	private boolean isAvailable;
	
	
	public userAccount(String name, String role, String password,String email) {

		this.name = name;
		this.password = password;
		this.role = role;
		this.email = email;
		isAvailable = true;
		
 }

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
}
 

package dit.hua.project.basic;

import java.io.Serializable;


public class LogInEmployee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String username;
	public String password;
	
	
	public LogInEmployee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public LogInEmployee() { //default  constructor
		super();
		}

	
	@Override
	public String toString() {
		return "LogInEmployee [username=" + username + ", password=" + password + "]";
	}

	//getters and setters 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

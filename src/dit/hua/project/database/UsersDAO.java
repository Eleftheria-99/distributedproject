package dit.hua.project.database;

import java.util.ArrayList;
import java.util.List;

import dit.hua.project.entities.Users;

public interface UsersDAO {
	public List<Users>  getUsers();
	//public List<Users>  getTheLogInUser(String given_username);
	public ArrayList<Users>  getTheLogInUser(String given_username);
	public void displayUsers(List<Users> students) ;
	
	
}

package dit.hua.project.database;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dit.hua.project.entities.Users;

@Repository                   //component that declares that exists communication with db 
public class UsersDAOImpl implements UsersDAO{
	//we will read the table users which contains the username and password 
	//the results will be returned in a list 
	
	
	 // inject the session factory
    @Autowired
    private SessionFactory sessionFactory;
    

    @Override
    @Transactional                           //epeidh sxetizetai me to pare dwse sth  database
	public List<Users> getUsers() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Users> query = currentSession.createQuery("from Users", Users.class);
        
        
        // execute the query and get the results list
        List<Users> users = query.getResultList();
                        
        //return the results
        return users;           //returns ALL THE USERS

	}


	@Override
    @Transactional                           //because it has to do with the database 
	public ArrayList<Users> getTheLogInUser(String given_username) {
		//return only the user(s) that tries to log in !
		//look in the database to fin if the given username and password exists in the database
		
		 
        
        String create_search_query = "from Users u where u.username='"+ given_username+"'";
        System.out.println("query "+ create_search_query);
        //Query<Users> query =null;
        List<Users> users = new ArrayList<>();
        
        try {          
        	// get current hibernate session
            Session currentSession = sessionFactory.getCurrentSession();
            
        	 Query<Users> query = currentSession.createQuery(create_search_query, Users.class);     // create a query
        
	        // execute the query and get the results list
        	 users = query.getResultList();
        	
        }catch(Exception e) {
        	e.getStackTrace();
        	e.getMessage();
        	e.getCause();
        }
      
	        
	   //displayUsers(users);
	 
               
        ArrayList<Users> arraylist_users = new ArrayList<Users>();
                
        arraylist_users.addAll(users);   //pass whatever the List has into the arraylist!

  	   	displayUsers(arraylist_users);
  	     
        return arraylist_users;                    //return the results in arraylist!
	}


	@Override
	public void displayUsers(List<Users> students) {
		 System.out.println("display student found in database based on the username!!");
		 // display students
        for (Users users : students) {
                System.out.println(users);
        }
		
	}


}

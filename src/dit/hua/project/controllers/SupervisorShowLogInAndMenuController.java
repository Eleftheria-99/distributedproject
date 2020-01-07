package dit.hua.project.controllers;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class SupervisorShowLogInAndMenuController {
	//just made 1 controller type of component type of bean 
	String sup_username = null; 
	String sup_password = null;
	String result = null;

	@RequestMapping(value = "/supervisor-login",method = RequestMethod.GET )
	public String showSupervisorLogIn(HttpServletRequest request){
		System.out.println("ready to show: supervisor log in ");
			
				
		System.out.println("show supervisor menu ");

		//get what the user has typed for user name and password 
		sup_username = request.getParameter("username");
		sup_password = request.getParameter("password");
		
		
		return "show-supervisor-login";
	}
	
	@RequestMapping(value = "/supervisor-login/supervisor-menu" ,method = RequestMethod.GET )
	public String showSupervisorMenu(){
		System.out.println("show supervisor menu ");

		return "supervisor-show-menu";
	}

}



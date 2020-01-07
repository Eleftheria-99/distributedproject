package dit.hua.project.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeVerifyLogInAndShowMenuController {
	//username=eleftheria, password=$2y$12$t636yYy3joufiKk2E17o3uQ67Bpc/.iqjG5ya0ZpD6n3soc8sN6Kq
	

	@RequestMapping(value = "/employee-login/employee-menu" ,method = RequestMethod.POST )   //  /DistributedSystems/employee-login/
	public String showEmployeeMenu(HttpServletRequest request, 	Model model, HttpSession session, ModelMap modelMap){
		//this method transitions the user(employee) from the login page to the menu, if log in is successful 
		//this method checks if the user name and password from the user are valid , if yes , then log in is successful and the employee menu will be shown 
		String empl_username = null; 
	    String empl_password = null;
	    String result = null;
		
				
		System.out.println("show employee menu ");

		//get what the user has typed for user name and password 
		empl_username = request.getParameter("username");
		empl_password = request.getParameter("password");
		
		result = "Hello! Your username and password: "+empl_username+" "+empl_password;
        model.addAttribute("message", result);    
		
		return "employee-show-menu";
	}

	
	@RequestMapping(value = "http://localhost/DistributedSystems/employee-login/just-logged-out", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("username");
		model.addAttribute("log_out_message", "You have just logged out!");
		//return "redirect:../show-employee-login";   //show-employee-login
		return "show-employee-login";
	}


}

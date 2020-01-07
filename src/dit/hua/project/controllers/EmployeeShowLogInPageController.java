package dit.hua.project.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class EmployeeShowLogInPageController  {
	//eftiaxsa 1 controller type of  component type of bean 


	@RequestMapping(value = "/employee-login",method = RequestMethod.GET )
	public String showEmployeeLogIn(){
		System.out.println("ready to show: employee log in page");
		return "show-employee-login";
	}
	


}

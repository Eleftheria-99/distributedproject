package dit.hua.project.controllers;

import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);
		
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String showHomePage(){
		
		return "home-page";
	}
	
	@RequestMapping(value = "http://localhost/DistributedSystems/just-logged-out", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("username");
		model.addAttribute("log_out_message", "You have just logged out!");
		//return "redirect:../show-employee-login";   //show-employee-login
		return "after_log_out";
	}


}

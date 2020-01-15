package dit.hua.project.controllers;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePage_LogIn_MainMenuForAll_LogOut_Controller {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomePage_LogIn_MainMenuForAll_LogOut_Controller.class);
		
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String showHomePage(){	
		return "home-page";
	}
	//the user must click to the href: login in order to go t teh login page
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogInForAll() {
		System.out.println("ready to show: log in page");
		return "show-login-for-all";
	}

	
	@RequestMapping(value = "/login/main-menu-for-all", method = RequestMethod.POST)
	public String showMainMenuForAll() {
		System.out.println("ready to show: main menu for all users page");
		return "main-menu-for-all";
	}

////maybe if security works, we won't need it
//	@RequestMapping(value = "http://localhost/DistributedSystems/just-logged-out", method = RequestMethod.GET)
//	public String logout(HttpSession session, Model model) {
//		session.removeAttribute("username");
//		model.addAttribute("log_out_message", "You have just logged out!");
//		// return "redirect:../show-employee-login"; //show-employee-login
//		return "after-log-out";
//	}
}

package dit.hua.project.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomePage_LogIn_MainMenuForAll_LogOut_Controller {
	
	public static String currentUser = "";
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String showHomePage(){	
		System.out.println("ready to show: home page");
		return "home-page";
	}
	//the user must click to the href: login in order to go to the login page
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogInForAll() {
		System.out.println("ready to show: log in page");
		return "show-login-for-all";
	}

	
	@RequestMapping(value = "/login/main-menu-for-all", method = RequestMethod.GET)
	public String showMainMenuForAll(HttpServletRequest request, Model model, HttpSession session, ModelMap modelMap) {
		System.out.println("ready to show: main menu for all users page");
		
		String st_username = null;
		String st_password = null;
		String result = null;

		// get what the user has typed for username and password
		st_username = request.getParameter("username");
		st_password = request.getParameter("password");
		// currentUser.setUsername(st_username);
		currentUser = st_username;

		model.addAttribute("username", st_username);

		result = "Hello! Your username and password: " + st_username + " " + st_password;
		model.addAttribute("message", result);
		session.setAttribute("username", st_username);
		

		return "main-menu-for-all";
	}

	//log out   http://localhost/DistributedSystems
	@RequestMapping(value = "/just-logged-out", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("username");
		model.addAttribute("log_out_message", "You have just logged out!");
		return "redirect:/login";
	}
}

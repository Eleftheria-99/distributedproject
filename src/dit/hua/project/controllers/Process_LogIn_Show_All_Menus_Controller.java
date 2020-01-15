package dit.hua.project.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Process_LogIn_Show_All_Menus_Controller { // this is a controller type of component type of bean

	public static String currentUser = "";

	
	@RequestMapping(value = "/login/main-menu-for-all/student-login/options", method = RequestMethod.GET)
	protected String Options(HttpServletRequest request, Model model, HttpSession session, ModelMap modelMap) {

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

		return "st-options";
	}

	// <a href="/DistributedSystems/login/main-menu-for-all/employee-menu"> menu </a>for the employee.
	@RequestMapping(value = "/login/main-menu-for-all/employee-menu", method = RequestMethod.GET) // /DistributedSystems/employee-login/
	public String showEmployeeMenu(HttpServletRequest request, Model model, HttpSession session, ModelMap modelMap) {
		// this method transitions the user(employee) from the login page to the menu,
		// if log in is successful
		// this method checks if the user name and password from the user are valid , if
		// yes , then log in is successful and the employee menu will be shown

		// username=eleftheria,
		// password=$2y$12$t636yYy3joufiKk2E17o3uQ67Bpc/.iqjG5ya0ZpD6n3soc8sN6Kq
		String empl_username = null;
		String empl_password = null;
		String result = null;

		System.out.println("show employee menu ");

		// get what the user has typed for user name and password
		empl_username = request.getParameter("username");
		empl_password = request.getParameter("password");

		result = "Hello! Your username and password: " + empl_username + " " + empl_password;
		model.addAttribute("message", result);

		return "employee-show-menu";
	}

	@RequestMapping(value = "/login/main-menu-for-all/supervisor-menu", method = RequestMethod.GET)
	public String showSupervisorMenu() {
		System.out.println("show supervisor menu ");

		return "supervisor-show-menu";
	}

	

}

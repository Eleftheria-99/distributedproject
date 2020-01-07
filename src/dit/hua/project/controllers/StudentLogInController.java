package dit.hua.project.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("Student Log in controller")
public class StudentLogInController {

	public static String currentUser = "";
	
	@RequestMapping(value = "/student-login/options", method = RequestMethod.POST)
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

	@RequestMapping(value = "/st-just-logged-out", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("username");
		model.addAttribute("log_out_message", "You have just logged out!");
		// return "redirect:../show-employee-login"; //show-employee-login
		return "show-student-login";
	}

}

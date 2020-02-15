package dit.hua.project.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dit.hua.project.entities.*;
import dit.hua.project.service.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	ServiceInterface_for_student student_service;

	Users user = null;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage() {
		System.out.println("ready to show: home page");

		String json = "{\"Title\": \"This is the home-page\"}";
		return json;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogInForAll() {

		System.out.println("ready to show: log in page");

		return "This is the login-page";
	}
	
	@RequestMapping(value = "/login/main-menu-for-all", method = RequestMethod.POST)
	public String showMainMenuForAll_retrieve_username_from_client(@RequestBody Users user_username, HttpServletRequest request, Model model, HttpSession session,
			Authentication auth, @RequestHeader("Authorization") String language) {
		System.out.println("ready to show: main menu for all users page POST METHOD REST CONTROLLERS");

		System.out.println("ready to show: main menu for all users page USERNAME RETRIEVED FRoM CLIENT: "+  user_username.toString());
	if (user_username == null) 
		return "HttpStatus.NOT_FOUND";
		
	else 
		return "HttpStatus.OK";
		//	return return_username_and_department(auth); // returns object type of Users, which contains the username and
														// the department
	}
	
	

	@RequestMapping(value = "/login/main-menu-for-all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Users showMainMenuForAll(HttpServletRequest request, Model model, HttpSession session,
			Authentication auth) {
		System.out.println("ready to show: main menu for all users page");

		return return_username_and_department(auth); // returns object type of Users, which contains the username and
														// the department
	}

	// here we want to return the department
	@GetMapping(value = "/login/main-menu-for-all/showForm", produces = "application/json")
	public @ResponseBody Users getdepartment(HttpSession session, Authentication auth) {
		System.out.println("ready to show: form");

		return return_username_and_department(auth); // returns object type of Users, which contains the username and
														// the department
	}

	// the form is being saved and it will be shown on the screen
	// So we want to return the form of the student after it has been submitted
	@PostMapping(value = "/login/main-menu-for-all/showForm/StudentForm", produces = "application/json", consumes="application/json")
	public void insertForm(@RequestBody SubmittedForm_Oik form, HttpServletRequest request, Model model, HttpSession session) { 
		
		String error = "You have already submitted your form!";
		
        //here method to save object in database
		form=student_service.student_service_externalInsert(form.getUsername(), form.getFname(),form.getLname(),form.getEmail(),
				form.getPhoneNumber(),form.getPlaceOfResidence(), form.getPlaceOfStudying(), form.getDepartment(),
				form.getYearOfAttendance(),form.getFamilyStatus(),form.getSiblingsStudying(), form.getAnnualIncome(), 
				form.getUnemployedParents());
		if(form.getDepartment()== error) {
			
		}

	}
	
	@GetMapping(value = "/showForm/StudentForm/{studentusername}", produces = "application/json")
	public @ResponseBody SubmittedForm_Oik send_the_insertedForm(@PathVariable String usernname, Model model, HttpSession session) { 
		
		SubmittedForm_Oik formOik = new SubmittedForm_Oik("ele", "ele","ele","ele",
				0,"ele", "ele","ele",
				0,"ele",0, "ele", 
				0);
		//student_service.student_service_showSubmittedForm(request, model, session);
	//return form;
		return formOik;
	}
	
	
	
	
	
	
	@GetMapping(value = "/login/main-menu-for-all/change-data", produces = "application/json")
	public @ResponseBody Users ChangePersonalData(Authentication auth) {
		System.out.println("ready to show: change personal data - student rest controller");

		return return_username_and_department(auth);
	}

	@PutMapping(value = "/login/main-menu-for-all/change-data/newForm") // login/main-menu-for-all/student-menu/change-data/newForm
	protected @ResponseBody String ChangedForm(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("ready to show: changed form - student rest controller");
		// returns the changed form in string, which consists of a Json
		//return student_service.student_service_ChangedForm(request, model, session);
		return null;
	}
	
	
	
	
	
	

	@GetMapping(value = "/login/main-menu-for-all/showResults", produces = "application/json")
	protected @ResponseBody Final_Ranking_Oik SeeResults(Model model, HttpSession session) {
		System.out.println("ready to show: see results - student rest controller");
		System.out.println("ready to show: see results - student rest controller- final ranking object returned from db: "+student_service.student_service_SeeResults(model, session));
		return student_service.student_service_SeeResults(model, session);
		
	}


	
//	//log out   http://localhost/DistributedSystems
//			@RequestMapping(value = "/just-logged-out", method = RequestMethod.GET)
//			public String logout(HttpSession session, Model model) {
//				session.removeAttribute("username");
//				model.addAttribute("log_out_message", "You have just logged out!");
//				return "redirect:/login";
//			}

	protected Users return_username_and_department(Authentication auth) {
		String department = null;
		String username = "andreas";
		user = new Users();

		//auth = SecurityContextHolder.getContext().getAuthentication();
		//username = auth.getName();
		try {
			department = student_service.findDepartment(username);
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println("username: " + username + "department: " + department);

		user = new Users(username, department); // username, department
		return user;
	}

}

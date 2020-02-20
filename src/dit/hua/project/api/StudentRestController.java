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

	protected String changedForm = null;
	protected Users user = null;
	protected String username_send_from_client_from_form_login_with_post = null;

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
			Authentication auth, @RequestHeader(value = "Authorization", required=false) String credentials) {
		System.out.println("ready to show: main menu for all users page POST METHOD REST CONTROLLERS");
		System.out.println("ready to show: main menu for all users page requested header from client: "+  credentials);
		System.out.println("ready to show: main menu for all users page USERNAME RETRIEVED FRoM CLIENT: "+  user_username.toString());
	
		username_send_from_client_from_form_login_with_post = user_username.getUsername();
	if (user_username == null) 
		return "HttpStatus.NOT_FOUND";
		
	else 
		return "HttpStatus.OK";
	}
	
	

	@RequestMapping(value = "/login/main-menu-for-all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Users showMainMenuForAll(HttpServletRequest request, Model model, HttpSession session,
			Authentication auth) {
		System.out.println("ready to show: main menu for all users page");

		return return_username_and_department(auth, username_send_from_client_from_form_login_with_post,session); // returns object type of Users, which contains the username and
														// the department
	}

	// here we want to return the department
	@GetMapping(value = "/login/main-menu-for-all/showForm", produces = "application/json")
	public @ResponseBody Users getdepartment(HttpSession session, Authentication auth) {
		System.out.println("ready to show: form");

		return return_username_and_department(auth, username_send_from_client_from_form_login_with_post,session);
		// returns object type of Users, which contains the username and  the department
	}

	// the form is being saved and it will be shown on the screen
	// So we want to return the form of the student after it has been submitted
	@PostMapping(value = "/login/main-menu-for-all/showForm/StudentForm", produces = "application/json", consumes="application/json")
	public @ResponseBody String insertForm(@RequestBody SubmittedForm_Oik form) { 
		System.out.println("StudentRestController: insert form ");
		
		System.out.println("rest insert: requestbody--> "+form.toString());
		SubmittedForm_Oik newform = new SubmittedForm_Oik();
		try {
        //here method to save object in database
		newform=student_service.student_service_externalInsert(form.getUsername(), form.getFname(),form.getLname(),form.getEmail(),
				form.getPhoneNumber(),form.getPlaceOfResidence(), form.getPlaceOfStudying(), form.getDepartment(),
				form.getYearOfAttendance(),form.getFamilyStatus(),form.getSiblingsStudying(), form.getAnnualIncome(), 
				form.getUnemployedParents());
		}catch(Exception e) {
			e.getStackTrace();
		}
		String jsonForm = return_string_that_contains_json_from_object(newform);
		System.out.println("rest insert: AFTER requestbody--> "+form.toString());

		
			return jsonForm;

	}
	
	
	@GetMapping(value = "/login/main-menu-for-all/change-data", produces = "application/json")
	public @ResponseBody Users ChangePersonalData(Authentication auth,HttpSession session) {
		System.out.println("ready to show: change personal data - student rest controller");

		return return_username_and_department(auth, username_send_from_client_from_form_login_with_post,session);
	}
	
	

	@PutMapping(value = "/login/main-menu-for-all/change-data/newForm") // login/main-menu-for-all/student-menu/change-data/newForm
	protected @ResponseBody String ChangedForm(@RequestBody SubmittedForm_Oik form) {
		System.out.println("ready to show: changed form - student rest controller");
		// returns the changed form in string, which consists of a Json
		System.out.println("changed form - student rest controller: the changed data from client : "+form.toString());
		System.out.println("REST: "+form.getDepartment()+" username: "+form.getUsername());
		//save them into db !!!!!!!!   --MISSING
		changedForm = student_service.student_service_externalChangedForm(form);
		System.out.println("changed form - student rest controller:  "+changedForm);

		if (form == null) 
			return "HttpStatus.changed.data.NOT_FOUND";	
		else 
			return changedForm;
			//return "HttpStatus.changed.data.OK";
		}
		

	@GetMapping(value = "/login/main-menu-for-all/showResults", produces = "application/json")
	protected @ResponseBody Final_Ranking_Oik SeeResults(Authentication auth,Model model, HttpSession session) {
		System.out.println("ready to show: see results - student rest controller");
		return_username_and_department(auth, username_send_from_client_from_form_login_with_post,session);
			Final_Ranking_Oik rank1 = student_service.student_service_SeeResults(model, session);
			//System.out.println("AFTER---ready to show: see results - student rest controller"+rank.toString());
			String rank = "{\"error\":\"Sorry, you haven't submitted your form yet!\"}"; // MAKE IT JSON

			return rank1;

	}

	@RequestMapping(value = "/just-logged-out", method = RequestMethod.POST,  produces = "application/json", consumes="application/json")
	public String logout(@RequestBody Users user_username, HttpSession session, Model model) {
		System.out.println("ready to show: logout redirecting to login page - student rest controller");
		username_send_from_client_from_form_login_with_post = user_username.getUsername();
		
		session.removeAttribute("username"); //reomve the username from the session 
		
		if (user_username == null) 
			return "HttpStatus.LOG_OUT.NOT_FOUND";
			
		else 
			return "HttpStatus.LOG_OUT.OK";
	}

	protected Users return_username_and_department(Authentication auth, String username_from_client,HttpSession session) {  //returns object that contains the username from the user, that was sent to the server through post reqeust and the department that was found in the database
		String department = null;
		String username = username_from_client;
		user = new Users();

		//auth = SecurityContextHolder.getContext().getAuthentication();
		//username = auth.getName();
		try {
			department = student_service.findDepartment(username);
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println("username: " + username + "and found department: " + department);
		session.setAttribute("username",username);
		session.setAttribute("department",department);

		user = new Users(username, department); // username, department
		return user;
	}
	
	protected String return_string_that_contains_json_from_object(SubmittedForm_Oik form) {
		// the method creates and returns a string that conatains all the parameters
		// from the form that the user submitted
		String json="";
		json = "{\"username\": \"" + form.getUsername() + "\"," + "\"Fname\": \"" + form.getFname() + "\","
				+ "\"Lname\": \"" + form.getLname() + "\"," + "\"Email\": \"" + form.getEmail() + "\","
				+ "\"PhoneNumber\": " + form.getPhoneNumber() + "," + "\"PlaceOfResidence\": \""
				+ form.getPlaceOfResidence() + "\"," + "\"PlaceOfStudying\": \"" + form.getPlaceOfStudying() + "\","
				+ "\"Department\": \"" + form.getDepartment() + "\"," + "\"YearOfAttendance\": "
				+ form.getYearOfAttendance() + "," + "\"FamilyStatus\": \"" + form.getFamilyStatus() + "\","
				+ "\"SiblingsStudying\": " + form.getSiblingsStudying() + "," + "\"AnnualIncome\": \""
				+ form.getAnnualIncome() + "\"," + "\"UnemployedParents\": " + form.getUnemployedParents()

				+ "}";

		// try {
		// json = objectMapper.writeValueAsString(form);
		// } catch (JsonProcessingException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		return json;
	}

}

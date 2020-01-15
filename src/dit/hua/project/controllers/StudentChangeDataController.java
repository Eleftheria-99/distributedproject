package dit.hua.project.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dit.hua.project.database.Student_DAO;

@Controller
public class StudentChangeDataController {

	// inject the user DAO
	@Autowired
	private Student_DAO studentDAO;

	@RequestMapping(value = "login/main-menu-for-all/student-menu/change-data/newForm", method = RequestMethod.GET)
	protected String ChangedForm(HttpServletRequest request, Model model,HttpSession session) {

		String email = request.getParameter("email");
		int phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
		String placeOfResidence = request.getParameter("placeofliving");
		//String department = request.getParameter("Department");

		//String user = StudentLogInController.currentUser; 
		String user = (String) session.getAttribute("user");
		System.out.println("USER INSIDE CHANGE DATA"+user);
		
		String department = (String) session.getAttribute("department");

		
		// INFORMATICS
		if (department.equals("Informatics")) {
			if (studentDAO.if_form_NOT_exists_Plir(user)) {
				String notfound = "Sorry, you haven't submitted your form yet!";
				model.addAttribute("errormessage", notfound);
				return "st-form";
			} else {
				// SubmittedForm_Plir form = new SubmittedForm_Plir();
				studentDAO.change_form_plir(user, email, phoneNumber, placeOfResidence);
				
				String error = "This is your new up to date form!";
				studentDAO.returnStudentForm_Plir(user, model,error);

				return "show-submitted-form";
			}

			// GEOGRAPHY
		} else if (department.equals("Geography")) {
			if (studentDAO.if_form_NOT_exists_Geo(user)) {
				String notfound = "Sorry, you haven't submitted your form yet!";
				model.addAttribute("errormessage", notfound);
				return "st-form";
			} else {

				// SubmittedForm_Geo form = new SubmittedForm_Geo();
				studentDAO.change_form_geo(user, email, phoneNumber, placeOfResidence);
				String error = "This is your new up to date form!";
				studentDAO.returnStudentForm_Geo(user, model,error);

				return "show-submitted-form";
			}
			// NUTRITION
		} else if (department.equals("Nutrition")) {
			if (studentDAO.if_form_NOT_exists_Diat(user)) {
				String notfound = "Sorry, you haven't submitted your form yet!";
				model.addAttribute("errormessage", notfound);
				return "st-form";
			} else {
				// SubmittedForm_Diat form = new SubmittedForm_Diat();
				studentDAO.change_form_diat(user, email, phoneNumber, placeOfResidence);
				String error = "This is your new up to date form!";

				studentDAO.returnStudentForm_Diat(user, model,error);
				
				return "show-submitted-form";
			}
			// ECONOMICS
		} else if (department.equals("Economics")) {
			if (studentDAO.if_form_NOT_exists_Oik(user)) {
				System.out.println("INSIDE IF");
				String notfound = "Sorry, you haven't submitted your form yet!";
				model.addAttribute("errormessage", notfound);
				return "st-form";
			} else {
				System.out.println("INSIDE ELSE");
				// SubmittedForm_Oik form = new SubmittedForm_Oik();
				studentDAO.change_form_oik(user, email, phoneNumber, placeOfResidence);

				String error = "This is your new up to date form!";

				studentDAO.returnStudentForm_Oik(user, model,error);

				return "show-submitted-form";
			}

		}

		// model.addAttribute("currentUser",user);

		return "show-submitted-form";
	}
}

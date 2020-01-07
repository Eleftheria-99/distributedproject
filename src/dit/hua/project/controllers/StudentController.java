package dit.hua.project.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dit.hua.project.database.Student_DAO;

@Controller
public class StudentController {

	// inject the student DAO
	@Autowired
	private Student_DAO studentDAO;

	@RequestMapping(value = "/student-login", method = RequestMethod.GET)
	public String showStudentLogIn() {
		return "show-student-login";
	}

	@RequestMapping(value = "student-login/options/showForm", method = RequestMethod.GET)
	protected String fillForm() {
		return "st-form";
	}

	@RequestMapping(value = "student-login/options/showForm/StudentForm", method = RequestMethod.GET)
	protected String showSubmittedForm(HttpServletRequest request, Model model) {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		int phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
		String placeOfResidence = request.getParameter("placeofliving");
		String placeOfStudying = request.getParameter("placeofstudying");
		String department = request.getParameter("Department");
		String annualIncome = request.getParameter("FinancialIncome");
		int siblingsStudying = Integer.parseInt(request.getParameter("numofsiblingswhostudy"));
		String familyStatus = request.getParameter("FamilyStatus");
		int yearOfAttendance = Integer.parseInt(request.getParameter("yearofattendance"));
		int unemployedParents = Integer.parseInt(request.getParameter("UnemployedParents"));

		String user = StudentLogInController.currentUser;

		// insert to DB
			// INFORMATICS
		if (department.equals("Informatics")) {
			if (studentDAO.if_form_NOT_exists_Plir(user)) {

				studentDAO.insert_form_plir(user, fname, lname, email, phoneNumber, placeOfResidence, placeOfStudying,
						department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {

				studentDAO.returnStudentForm_Plir(user, model);

				return "show-submitted-form";
			}

			// GEOGRAPHY
		} else if (department.equals("Geography")) {
			if (studentDAO.if_form_NOT_exists_Geo(user)) {

				studentDAO.insert_form_geo(user, fname, lname, email, phoneNumber, placeOfResidence, placeOfStudying,
						department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {

				studentDAO.returnStudentForm_Geo(user, model);

				return "show-submitted-form";
			}
			// NUTRITION
		} else if (department.equals("Nutrition")) {
			if (studentDAO.if_form_NOT_exists_Diat(user)) {
				studentDAO.insert_form_diat(user, fname, lname, email, phoneNumber, placeOfResidence, placeOfStudying,
						department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {
				studentDAO.returnStudentForm_Diat(user, model);

				return "show-submitted-form";
			}
			// ECONOMICS
		} else if (department.equals("Economics")) {
			if (studentDAO.if_form_NOT_exists_Oik(user)) {
				studentDAO.insert_form_oik(user, fname, lname, email, phoneNumber, placeOfResidence, placeOfStudying,
						department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {
				//String error = "It seems that you have already submitted your form!";
				studentDAO.returnStudentForm_Oik(user, model);

				return "show-submitted-form";
			}
		}

		//Attributes for inserts
		// model.addAttribute("currentUser",user);
		model.addAttribute("fname", fname);
		model.addAttribute("lname", lname);
		model.addAttribute("email", email);
		model.addAttribute("phone", phoneNumber);
		model.addAttribute("pofresidence", placeOfResidence);
		model.addAttribute("pofstudying", placeOfStudying);
		model.addAttribute("dep", department);
		model.addAttribute("income", annualIncome);
		model.addAttribute("siblings", siblingsStudying);
		model.addAttribute("family", familyStatus);
		model.addAttribute("year", yearOfAttendance);
		model.addAttribute("parents", unemployedParents);

		return "show-submitted-form";
	}

	/*
	 * @RequestMapping(value="/") protected String SubmitForm(){ List<String> list =
	 * new ArrayList<String>(); return list; }
	 */
	@RequestMapping(value = "student-login/options/showResults", method = RequestMethod.GET)
	protected String SeeResults() {
		return "st-results";
	}

	@RequestMapping(value = "student-login/options/change-data", method = RequestMethod.GET)
	protected String ChangePersonalData() {
		return "st-change";
	}

}

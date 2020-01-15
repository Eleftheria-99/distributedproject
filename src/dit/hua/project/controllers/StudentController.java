package dit.hua.project.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

//	@RequestMapping(value = "/login/main-menu-for-all/student-login", method = RequestMethod.GET)
//	public String showStudentLogIn() {
//		return "show-student-login";
//	}

	@RequestMapping(value = "login/main-menu-for-all/student-menu/showForm", method = RequestMethod.GET)
	protected String fillForm() {
		
		return "st-form";
	}

	@RequestMapping(value = "login/main-menu-for-all/student-menu/showForm/StudentForm", method = RequestMethod.GET)
	protected String showSubmittedForm(HttpServletRequest request, Model model, HttpSession session) {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		int phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
		String placeOfResidence = request.getParameter("placeofliving");
		String placeOfStudying = request.getParameter("placeofstudying");
		// String department = request.getParameter("Department");
		String annualIncome = request.getParameter("FinancialIncome");
		int siblingsStudying = Integer.parseInt(request.getParameter("numofsiblingswhostudy"));
		String familyStatus = request.getParameter("FamilyStatus");
		int yearOfAttendance = Integer.parseInt(request.getParameter("yearofattendance"));
		int unemployedParents = Integer.parseInt(request.getParameter("UnemployedParents"));

		String user = (String) session.getAttribute("user");
		System.out.println("INSIDE PLAIN CONTROLLER USERNAME:   " + user);

		String department = (String) session.getAttribute("department");

		// INFORMATICS
		if (department.equals("Informatics")) {
			if (studentDAO.if_form_NOT_exists_Plir(user)) {

				studentDAO.insert_form_plir(user, fname, lname, email, phoneNumber, placeOfResidence, placeOfStudying,
						department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {
				String error = "You have already submitted your form";

				studentDAO.returnStudentForm_Plir(user, model, error);

				return "show-submitted-form";
			}

			// GEOGRAPHY
		} else if (department.equals("Geography")) {
			if (studentDAO.if_form_NOT_exists_Geo(user)) {

				studentDAO.insert_form_geo(user, fname, lname, email, phoneNumber, placeOfResidence, placeOfStudying,
						department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {
				String error = "You have already submitted your form";
				studentDAO.returnStudentForm_Geo(user, model, error);

				return "show-submitted-form";
			}
			// NUTRITION
		} else if (department.equals("Nutrition")) {
			if (studentDAO.if_form_NOT_exists_Diat(user)) {
				studentDAO.insert_form_diat(user, fname, lname, email, phoneNumber, placeOfResidence, placeOfStudying,
						department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {
				String error = "You have already submitted your form";

				studentDAO.returnStudentForm_Diat(user, model, error);

				return "show-submitted-form";
			}
			// ECONOMICS
		} else if (department.equals("Economics")) {
			if (studentDAO.if_form_NOT_exists_Oik(user)) {
				studentDAO.insert_form_oik(user, fname, lname, email, phoneNumber, placeOfResidence, placeOfStudying,
						department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {
				String error = "You have already submitted your form";
				studentDAO.returnStudentForm_Oik(user, model, error);

				return "show-submitted-form";
			}
		}

		// Attributes for inserts
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

	@RequestMapping(value = "login/main-menu-for-all/student-menu/showResults", method = RequestMethod.GET)
	protected String SeeResults(Model model,HttpSession session) {
		
		String username = (String) session.getAttribute("user");
		String dep = (String) session.getAttribute("department");
		
		if(dep.equals("Economics")) {
			studentDAO.showPoints_oik(username, model);
		}
		
		return "st-results";
	}

	@RequestMapping(value = "login/main-menu-for-all/student-menu/change-data", method = RequestMethod.GET)
	protected String ChangePersonalData() {
		return "st-change";
	}

}

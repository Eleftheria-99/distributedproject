package dit.hua.project.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import dit.hua.project.database.Student_DAO;
import dit.hua.project.entities.Final_Ranking_Diat;
import dit.hua.project.entities.Final_Ranking_Geo;
import dit.hua.project.entities.Final_Ranking_Oik;
import dit.hua.project.entities.Final_Ranking_Plir;

public class ServiceImpl_for_student implements ServiceInterface_for_student{
	
	//inject student DAO
	@Autowired
	private Student_DAO studentDAO;
	
	
	
	private String username = null;
	private String fname = null;
	private String lname = null;
	private String string_year_of_attendance = null;
	private int int_year_of_attendance = 0;
	private String string_number_of_siblings_studying = null;
	private int siblingsStudying = 0;
	private String email = null;
	private String string_phone_number = null;
	private int phoneNumber = 0;
	private String department = null;
	private String place_of_residence = null;
	private String string_number_of_unemployed_parents = null;
	private int unemployedParents = 0;


	

	@Override
	@Transactional // because it has to do with the database
	public String student_service_showSubmittedForm(HttpServletRequest request, Model model, HttpSession session) {

		fname = request.getParameter("fname");
		lname = request.getParameter("lname");
		email = request.getParameter("email");
		
		string_phone_number = request.getParameter("phoneNumber");

		if (string_phone_number == null || string_phone_number.length() == 0) {
			phoneNumber = -1; // in case of error
		} else {
			try {
				phoneNumber = Integer.parseInt(string_phone_number);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		String placeOfResidence = request.getParameter("placeofliving");
		String placeOfStudying = request.getParameter("placeofstudying");
		String annualIncome = request.getParameter("FinancialIncome");
		
		string_number_of_siblings_studying = request.getParameter("siblingsStudying");

		if (string_number_of_siblings_studying == null || string_number_of_siblings_studying.length() == 0) {
			siblingsStudying = -1; // in case of error
		} else {
			try {
				siblingsStudying = Integer.parseInt(string_number_of_siblings_studying);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		String familyStatus = request.getParameter("FamilyStatus");
		
		string_year_of_attendance = request.getParameter("yearOfAttendance");

		if (string_year_of_attendance == null || string_year_of_attendance.length() == 0) {
			int_year_of_attendance = -1; // in case of error
		} else {
			try {
				int_year_of_attendance = Integer.parseInt(string_year_of_attendance);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}		

		string_number_of_unemployed_parents = request.getParameter("unemployedParents");

		if (string_number_of_unemployed_parents == null || string_number_of_unemployed_parents.length() == 0) {
			unemployedParents = -1; // -1 means that the id does not exist or was not retrieved
		} else {
			try {
				unemployedParents = Integer.parseInt(string_number_of_unemployed_parents);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		
		String user = (String) session.getAttribute("username");
		System.out.println("INSIDE PLAIN CONTROLLER USERNAME:   " + user);

	    department = (String) session.getAttribute("department");

		// INFORMATICS
		if (department.equals("Informatics")) {
			if (studentDAO.if_form_NOT_exists_Plir(user)) {

				studentDAO.insert_form_plir(user, fname, lname, email, phoneNumber,place_of_residence, placeOfStudying,
						department, int_year_of_attendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
				session.setAttribute("email", email);
			} else {
				String error = "You have already submitted your form!";

				studentDAO.returnStudentForm_Plir(user, model, error);

				return "show-submitted-form";
			}

			// GEOGRAPHY
		} else if (department.equals("Geography")) {
			if (studentDAO.if_form_NOT_exists_Geo(user)) {

				studentDAO.insert_form_geo(user, fname, lname, email, phoneNumber, place_of_residence, placeOfStudying,
						department, int_year_of_attendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {
				String error = "You have already submitted your form!";
				studentDAO.returnStudentForm_Geo(user, model, error);

				return "show-submitted-form";
			}
			// NUTRITION
		} else if (department.equals("Nutrition")) {
			if (studentDAO.if_form_NOT_exists_Diat(user)) {
				studentDAO.insert_form_diat(user, fname, lname, email,phoneNumber, place_of_residence, placeOfStudying,
						department, int_year_of_attendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {
				String error = "You have already submitted your form!";

				studentDAO.returnStudentForm_Diat(user, model, error);

				return "show-submitted-form";
			}
			// ECONOMICS
		} else if (department.equals("Economics")) {
			if (studentDAO.if_form_NOT_exists_Oik(user)) {
				studentDAO.insert_form_oik(user, fname, lname, email, phoneNumber, place_of_residence, placeOfStudying,
						department, int_year_of_attendance, familyStatus, siblingsStudying, annualIncome, unemployedParents);
			} else {
				String error = "You have already submitted your form!";
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
		model.addAttribute("year", int_year_of_attendance);
		model.addAttribute("parents", unemployedParents);

		return "show-submitted-form";			
	}

	@Override
	@Transactional // because it has to do with the database
	public String student_service_ChangedForm(HttpServletRequest request, Model model, HttpSession session) {

		email = request.getParameter("email");
		//int phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
		
		string_phone_number = request.getParameter("phoneNumber");

		if (string_phone_number == null || string_phone_number.length() == 0) {
			phoneNumber = -1; // in case of error
		} else {
			try {
				phoneNumber = Integer.parseInt(string_phone_number);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
        String placeOfResidence = request.getParameter("placeofliving");
		
		String user = (String) session.getAttribute("username");
		System.out.println("USER INSIDE CHANGE DATA"+user);
		
		department = (String) session.getAttribute("department");

		
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
				studentDAO.change_form_diat(user, email,phoneNumber, placeOfResidence);
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
		return "show-submitted-form";
	}

	@Override
	@Transactional // because it has to do with the database
	public String student_service_SeeResults(Model model, HttpSession session) {

		username = (String) session.getAttribute("username");
		String dep = (String) session.getAttribute("department");

		if (dep.equals("Economics")) {

			seeResults_Oik(model, username, dep);

		} else if (dep.equals("Informatics")) {

			seeResults_Plir(model, username, dep);

		} else if (dep.equals("Geography")) {

			seeResults_Geo(model, username, dep);

		} else if (dep.equals("Nutrition")) {

			seeResults_Diat(model, username, dep);

		}

		return "st-results";
	}
	

	// ECONOMICS
	@Transactional // because it has to do with the database
	private int seeResults_Oik(Model model, String username, String dep) {

		fname = studentDAO.returnFname_geo(username);
		lname = studentDAO.returnLname_geo(username);

		System.out.println("This is the first name " + fname + " and last name " + lname);
		
		ArrayList<Final_Ranking_Oik> arraylist_all_final_ranking_forms = studentDAO.returnFinalRanking_oik_ALL_students_entitled();

		for (Final_Ranking_Oik users : arraylist_all_final_ranking_forms) {
			System.out.println("INSIDE FOR");
			// System.out.println(users);
			String retrieved_fname = users.getFname();
			String retrieved_lname = users.getLname();
			System.out.println("This is the retrived from database first name " + retrieved_fname + " and last name "
					+ retrieved_lname);

			if (retrieved_fname.equals(fname) && retrieved_lname.equals(lname)) {
				System.out.println("INSIDE IF");
				model.addAttribute("Points", "Point : ");
				model.addAttribute("Rank", "Rank : ");
				model.addAttribute("points", users.getPoints());
				model.addAttribute("rank", users.getId());
				model.addAttribute("size", "/40");
				return 0;
			}

		}
		model.addAttribute("notfound", "Unfortunately, it seems that you're not one of the students with free board!");
		return 0;
		}
	

	// INFORMATICS
	@Transactional // because it has to do with the database
	private int seeResults_Plir(Model model, String username, String dep) {

		fname = studentDAO.returnFname_geo(username);
		lname = studentDAO.returnLname_geo(username);

		System.out.println("This is the first name " + fname + " and last name " + lname);
		
		ArrayList<Final_Ranking_Plir> arraylist_all_final_ranking_forms = studentDAO.returnFinalRanking_plir_ALL_students_entitled();

		for (Final_Ranking_Plir users : arraylist_all_final_ranking_forms) {
			System.out.println("INSIDE FOR");
			// System.out.println(users);
			String retrieved_fname = users.getFname();
			String retrieved_lname = users.getLname();
			System.out.println("This is the retrived from database first name " + retrieved_fname + " and last name "
					+ retrieved_lname);

			if (retrieved_fname.equals(fname) && retrieved_lname.equals(lname)) {
				System.out.println("INSIDE IF");
				model.addAttribute("Points", "Point : ");
				model.addAttribute("Rank", "Rank : ");
				model.addAttribute("points", users.getPoints());
				model.addAttribute("rank", users.getId());
				model.addAttribute("size", "/40");
				return 0;
			}

		}
		model.addAttribute("notfound", "Unfortunately, it seems that you're not one of the students with free board!");
		return 0;
	}

	// GEOGRAPHY
	@Transactional // because it has to do with the database
	private int seeResults_Geo(Model model, String username, String dep) {

		fname = studentDAO.returnFname_geo(username);
		lname = studentDAO.returnLname_geo(username);

		System.out.println("This is the first name " + fname + " and last name " + lname);
		
		ArrayList<Final_Ranking_Geo> arraylist_all_final_ranking_forms = studentDAO.returnFinalRanking_geo_ALL_students_entitled();

		for (Final_Ranking_Geo users : arraylist_all_final_ranking_forms) {
			System.out.println("INSIDE FOR");
			// System.out.println(users);
			String retrieved_fname = users.getFname();
			String retrieved_lname = users.getLname();
			System.out.println("This is the retrived from database first name " + retrieved_fname + " and last name "
					+ retrieved_lname);

			if (retrieved_fname.equals(fname) && retrieved_lname.equals(lname)) {
				System.out.println("INSIDE IF");
				model.addAttribute("Points", "Point : ");
				model.addAttribute("Rank", "Rank : ");
				model.addAttribute("points", users.getPoints());
				model.addAttribute("rank", users.getId());
				model.addAttribute("size", "/40");
				return 0;
			}

		}
		model.addAttribute("notfound", "Unfortunately, it seems that you're not one of the students with free board!");
		return 0;
	}


	// NUTRITION
	@Transactional // because it has to do with the database
	private int seeResults_Diat(Model model, String username, String dep) {

		fname = studentDAO.returnFname_diat(username);
		lname = studentDAO.returnLname_diat(username);

		System.out.println("This is the first name " + fname + " and last name " + lname);

		ArrayList<Final_Ranking_Diat> arraylist_all_final_ranking_forms = studentDAO
				.returnFinalRanking_diat_ALL_students_entitled();

		for (Final_Ranking_Diat users : arraylist_all_final_ranking_forms) {
			System.out.println("INSIDE FOR");
			// System.out.println(users);
			String retrieved_fname = users.getFname();
			String retrieved_lname = users.getLname();
			System.out.println("This is the retrived from database first name " + retrieved_fname + " and last name "
					+ retrieved_lname);

			if (retrieved_fname.equals(fname) && retrieved_lname.equals(lname)) {
				System.out.println("INSIDE IF");
				model.addAttribute("Points", "Points : ");
				model.addAttribute("Rank", "Rank : ");
				model.addAttribute("points", users.getPoints());
				model.addAttribute("rank", users.getId());
				model.addAttribute("size", "/40");
				return 0;
			}

		}
		model.addAttribute("notfound", "Unfortunately, it seems that you're not one of the students with free board!");
		return 0;
	}

}

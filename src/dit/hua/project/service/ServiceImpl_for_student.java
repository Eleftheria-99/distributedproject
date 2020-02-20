package dit.hua.project.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.google.gson.Gson;

import dit.hua.project.database.Student_DAO;
import dit.hua.project.entities.*;

@Service
public class ServiceImpl_for_student implements ServiceInterface_for_student {

	// inject student DAO
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

	private String error = null;

	@Override
	@Transactional
	public String findDepartment(String username) {

		String department = studentDAO.findwhichDepartment(username);
		return department;
	}

	@Override
	@Transactional // because it has to do with the database
	public void student_service_showSubmittedForm(HttpServletRequest request, Model model, HttpSession session) {

		fname = request.getParameter("fname");
		lname = request.getParameter("lname");
		email = request.getParameter("email");

		string_phone_number = request.getParameter("phonenumber");

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

		string_number_of_siblings_studying = request.getParameter("numofsiblingswhostudy");

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

		string_year_of_attendance = request.getParameter("yearofattendance");

		if (string_year_of_attendance == null || string_year_of_attendance.length() == 0) {
			int_year_of_attendance = -1; // in case of error
		} else {
			try {
				int_year_of_attendance = Integer.parseInt(string_year_of_attendance);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		string_number_of_unemployed_parents = request.getParameter("UnemployedParents");

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
				SubmittedForm_Plir form = new SubmittedForm_Plir();
				form = studentDAO.insert_form_plir(user, fname, lname, email, phoneNumber, place_of_residence,
						placeOfStudying, department, int_year_of_attendance, familyStatus, siblingsStudying,
						annualIncome, unemployedParents);
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
			} else {
				// show error
				error = "You have already submitted your form!";
				studentDAO.returnStudentForm_Plir(user, model, error); // type void, does not return anything
			}

			// GEOGRAPHY
		} else if (department.equals("Geography")) {
			if (studentDAO.if_form_NOT_exists_Geo(user)) {
				SubmittedForm_Geo form = new SubmittedForm_Geo();
				form = studentDAO.insert_form_geo(user, fname, lname, email, phoneNumber, place_of_residence,
						placeOfStudying, department, int_year_of_attendance, familyStatus, siblingsStudying,
						annualIncome, unemployedParents);
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

			} else {
				// show error
				error = "You have already submitted your form!";
				studentDAO.returnStudentForm_Geo(user, model, error);
			}
			// NUTRITION
		} else if (department.equals("Nutrition")) {
			if (studentDAO.if_form_NOT_exists_Diat(user)) {
				SubmittedForm_Diat form = new SubmittedForm_Diat();
				form = studentDAO.insert_form_diat(user, fname, lname, email, phoneNumber, place_of_residence,
						placeOfStudying, department, int_year_of_attendance, familyStatus, siblingsStudying,
						annualIncome, unemployedParents);
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

			} else {
				// show error
				error = "You have already submitted your form!";
				studentDAO.returnStudentForm_Diat(user, model, error); // type void
			}
			// ECONOMICS
		} else if (department.equals("Economics")) {
			if (studentDAO.if_form_NOT_exists_Oik(user)) {
				SubmittedForm_Oik form = new SubmittedForm_Oik();
				form = studentDAO.insert_form_oik(user, fname, lname, email, phoneNumber, place_of_residence,
						placeOfStudying, department, int_year_of_attendance, familyStatus, siblingsStudying,
						annualIncome, unemployedParents);

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

			} else {
				// show error
				error = "You have already submitted your form!";
				studentDAO.returnStudentForm_Oik(user, model, error);
			}
		}

	}

	@Override
	@Transactional // because it has to do with the database
	public void student_service_ChangedForm(HttpServletRequest request, Model model, HttpSession session) {

		email = request.getParameter("email");

		string_phone_number = request.getParameter("phonenumber");

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
		System.out.println("USER INSIDE CHANGE DATA" + user);

		department = (String) session.getAttribute("department");

		// INFORMATICS
		if (department.equals("Informatics")) {
			if (studentDAO.if_form_NOT_exists_Plir(user)) {
				// student has not submitted a form yet
				String notfound = "Sorry, you haven't submitted your form yet!";
				model.addAttribute("errormessage", notfound);
				// return "st-form";
			} else {
				// student has submitted a form
				SubmittedForm_Plir form = new SubmittedForm_Plir();
				form = studentDAO.change_form_plir(user, email, phoneNumber, placeOfResidence);

				String error = "This is your new up to date form!";
				studentDAO.returnStudentForm_Plir(user, model, error);

				// return "show-submitted-form"; //returns the changed form
			}

			// GEOGRAPHY
		} else if (department.equals("Geography")) {
			if (studentDAO.if_form_NOT_exists_Geo(user)) {
				// student has not submitted a form yet
				String notfound = "Sorry, you haven't submitted your form yet!";
				model.addAttribute("errormessage", notfound);
				// return "st-form";
			} else {
				// student has submitted a form
				SubmittedForm_Geo form = new SubmittedForm_Geo();
				form = studentDAO.change_form_geo(user, email, phoneNumber, placeOfResidence);

				String error = "This is your new up to date form!";
				studentDAO.returnStudentForm_Geo(user, model, error);

				// return "show-submitted-form"; //returns the changed form
			}
			// NUTRITION
		} else if (department.equals("Nutrition")) {
			if (studentDAO.if_form_NOT_exists_Diat(user)) {
				// student has not submitted a form yet
				String notfound = "Sorry, you haven't submitted your form yet!";
				model.addAttribute("errormessage", notfound);
				// return "st-form";
			} else {
				// student has submitted a form
				SubmittedForm_Diat form = new SubmittedForm_Diat();
				form = studentDAO.change_form_diat(user, email, phoneNumber, placeOfResidence);

				String error = "This is your new up to date form!";
				studentDAO.returnStudentForm_Diat(user, model, error);

				// return "show-submitted-form"; //returns the changed form
			}
			// ECONOMICS
		} else if (department.equals("Economics")) {
			if (studentDAO.if_form_NOT_exists_Oik(user)) {
				// student has not submitted a form yet
				System.out.println("INSIDE IF");
				String notfound = "Sorry, you haven't submitted your form yet!";
				model.addAttribute("errormessage", notfound);
				// return "st-form";
			} else {
				// student has submitted a form
				System.out.println("INSIDE ELSE");

				SubmittedForm_Oik form = new SubmittedForm_Oik();
				studentDAO.change_form_oik(user, email, phoneNumber, placeOfResidence);

				String error = "This is your new up to date form!";
				studentDAO.returnStudentForm_Oik(user, model, error);

				// return "show-submitted-form"; //returns the changed form
			}

		}
		// return "show-submitted-form";
	}

	@Override
	@Transactional // because it has to do with the database
	public Final_Ranking_Oik student_service_SeeResults(Model model, HttpSession session) {

		username = (String) session.getAttribute("username");
		String dep = (String) session.getAttribute("department");
		Final_Ranking_Oik rank = new Final_Ranking_Oik();

		if (dep.equals("Economics")) {

			rank = seeResults_Oik(model, username, dep);

		} else if (dep.equals("Informatics")) {

			Final_Ranking_Plir rankPlir = new Final_Ranking_Plir();
			rankPlir = seeResults_Plir(model, username, dep);
			rank.setFname(rankPlir.getFname());
			rank.setId(rankPlir.getId());
			rank.setLname(rankPlir.getLname());
			rank.setPoints(rankPlir.getPoints());
		} else if (dep.equals("Geography")) {

			Final_Ranking_Geo rankGeo = new Final_Ranking_Geo();
			rankGeo = seeResults_Geo(model, username, dep);
			rank.setFname(rankGeo.getFname());
			rank.setId(rankGeo.getId());
			rank.setLname(rankGeo.getLname());
			rank.setPoints(rankGeo.getPoints());

		} else if (dep.equals("Nutrition")) {

			Final_Ranking_Diat rankDiat = new Final_Ranking_Diat();
			rankDiat = seeResults_Diat(model, username, dep);
			rank.setFname(rankDiat.getFname());
			rank.setId(rankDiat.getId());
			rank.setLname(rankDiat.getLname());
			rank.setPoints(rankDiat.getPoints());

		}

		return rank;
	}

	// ECONOMICS
	@Transactional // because it has to do with the database
	private Final_Ranking_Oik seeResults_Oik(Model model, String username, String dep) {

//		fname = studentDAO.returnFname_geo(username);
//		lname = studentDAO.returnLname_geo(username);

		//System.out.println("This is the first name " + fname + " and last name " + lname);

		ArrayList<Final_Ranking_Oik> arraylist_all_final_ranking_forms = studentDAO
				.returnFinalRanking_oik_ALL_students_entitled();

		for (Final_Ranking_Oik users : arraylist_all_final_ranking_forms) {
			System.out.println("INSIDE FOR");
			// System.out.println(users);
//			String retrieved_fname = users.getFname();
//			String retrieved_lname = users.getLname();
//			System.out.println("This is the retrieved from database first name " + retrieved_fname + " and last name "
//					+ retrieved_lname);

		//	if (retrieved_fname.equals(fname) && retrieved_lname.equals(lname)) {
			if (users.getUsername().equals(username)) {
				System.out.println("INSIDE IF");
				model.addAttribute("Points", "Point : ");
				model.addAttribute("Rank", "Rank : ");
				model.addAttribute("points", users.getPoints());
				model.addAttribute("rank", users.getId());
				model.addAttribute("size", "/40");

				Final_Ranking_Oik matched_student = new Final_Ranking_Oik(users.getId(), fname, lname,
						users.getPoints());
				return matched_student;

			}

		}

		String notfound = "Unfortunately, it seems that you're not one of the students with free board!";
		model.addAttribute("notfound", notfound);

		Final_Ranking_Oik not_found = new Final_Ranking_Oik(0, "not-found", "not-found", 0);
		return not_found;

	}

	// INFORMATICS
	@Transactional // because it has to do with the database
	private Final_Ranking_Plir seeResults_Plir(Model model, String username, String dep) {

//		fname = studentDAO.returnFname_geo(username);
//		lname = studentDAO.returnLname_geo(username);

		System.out.println("This is the first name " + fname + " and last name " + lname);

		ArrayList<Final_Ranking_Plir> arraylist_all_final_ranking_forms = studentDAO
				.returnFinalRanking_plir_ALL_students_entitled();

		for (Final_Ranking_Plir users : arraylist_all_final_ranking_forms) {
			System.out.println("INSIDE FOR");
			// System.out.println(users);
			String retrieved_fname = users.getFname();
			String retrieved_lname = users.getLname();
			System.out.println("This is the retrived from database first name " + retrieved_fname + " and last name "
					+ retrieved_lname);

			if (users.getUsername().equals(username)) {
				System.out.println("INSIDE IF");
				model.addAttribute("Points", "Point : ");
				model.addAttribute("Rank", "Rank : ");
				model.addAttribute("points", users.getPoints());
				model.addAttribute("rank", users.getId());
				model.addAttribute("size", "/40");

				Final_Ranking_Plir matched_student = new Final_Ranking_Plir(users.getId(), fname, lname,
						users.getPoints());
				return matched_student;

			}

		}
		String notfound = "Unfortunately, it seems that you're not one of the students with free board!";
		model.addAttribute("notfound", notfound);

		Final_Ranking_Plir not_found = new Final_Ranking_Plir(0, "not-found", "not-found", 0);
		return not_found;

	}

	// GEOGRAPHY
	@Transactional // because it has to do with the database
	private Final_Ranking_Geo seeResults_Geo(Model model, String username, String dep) {

//		fname = studentDAO.returnFname_geo(username);
//		lname = studentDAO.returnLname_geo(username);

		System.out.println("This is the first name " + fname + " and last name " + lname);

		ArrayList<Final_Ranking_Geo> arraylist_all_final_ranking_forms = studentDAO
				.returnFinalRanking_geo_ALL_students_entitled();

		for (Final_Ranking_Geo users : arraylist_all_final_ranking_forms) {
			System.out.println("INSIDE FOR");
			// System.out.println(users);
			String retrieved_fname = users.getFname();
			String retrieved_lname = users.getLname();
			System.out.println("This is the retrived from database first name " + retrieved_fname + " and last name "
					+ retrieved_lname);

			if (users.getUsername().equals(username)) {
				System.out.println("INSIDE IF");
				model.addAttribute("Points", "Point : ");
				model.addAttribute("Rank", "Rank : ");
				model.addAttribute("points", users.getPoints());
				model.addAttribute("rank", users.getId());
				model.addAttribute("size", "/40");
				Final_Ranking_Geo matched_student = new Final_Ranking_Geo(users.getId(), fname, lname,
						users.getPoints()); // int id, String fname, String lname, int points -> constructor for that!!
				return matched_student;

			}

		}
		String notfound = "Unfortunately, it seems that you're not one of the students with free board!";
		model.addAttribute("notfound", notfound);

		Final_Ranking_Geo not_found = new Final_Ranking_Geo(0, "not-found", "not-found", 0);
		return not_found;

	}

	// NUTRITION
	@Transactional // because it has to do with the database
	private Final_Ranking_Diat seeResults_Diat(Model model, String username, String dep) {

//		fname = studentDAO.returnFname_diat(username);
//		lname = studentDAO.returnLname_diat(username);

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

			if (users.getUsername().equals(username)) {
				System.out.println("INSIDE IF");
				model.addAttribute("Points", "Points : ");
				model.addAttribute("Rank", "Rank : ");
				model.addAttribute("points", users.getPoints());
				model.addAttribute("rank", users.getId());
				model.addAttribute("size", "/40");
				Final_Ranking_Diat matched_student = new Final_Ranking_Diat(users.getId(), fname, lname,
						users.getPoints()); // int id, String fname, String lname, int points -> constructor for that!!

				return matched_student;
			}

		}
		String notfound = "Unfortunately, it seems that you're not one of the students with free board!";
		model.addAttribute("notfound", notfound);

		Final_Ranking_Diat not_found = new Final_Ranking_Diat(0, "not-found", "not-found", 0);
		return not_found;

	}

	// methods for external/rest
	@Override
	@Transactional
	public SubmittedForm_Oik student_service_externalInsert(String user, String fname, String lname, String email,
			int phoneNumber, String place_of_residence, String placeOfStudying, String department,
			int int_year_of_attendance, String familyStatus, int siblingsStudying, String annualIncome,
			int unemployedParents) {
		System.out.println("INSIDE EXTERNAL INSERT STUDENT SERVICE");
		SubmittedForm_Oik form_oik = new SubmittedForm_Oik();
		SubmittedForm_Plir form_plir = new SubmittedForm_Plir();
		SubmittedForm_Geo form_geo = new SubmittedForm_Geo();
		SubmittedForm_Diat form_diat = new SubmittedForm_Diat();

		SubmittedForm_Oik formOik = new SubmittedForm_Oik(fname, lname, email, phoneNumber, place_of_residence,
				placeOfStudying, department, int_year_of_attendance, familyStatus, siblingsStudying, annualIncome,
				unemployedParents);
		// INFORMATICS
		if (department.equals("Informatics")) {
			if (studentDAO.if_form_NOT_exists_Plir(user)) {

				form_plir = studentDAO.insert_form_plir(user, fname, lname, email, phoneNumber, place_of_residence,
						placeOfStudying, department, int_year_of_attendance, familyStatus, siblingsStudying,
						annualIncome, unemployedParents);
			} else {
				// show error
				form_plir = studentDAO.returnStudentForm_PlirREST(user);
				
				formOik.setUsername(form_plir.getUsername());
				formOik.setFname(form_plir.getFname());
				formOik.setLname(form_plir.getLname());
				formOik.setEmail(form_plir.getEmail());
				formOik.setDepartment("exists");
				formOik.setPhoneNumber(form_plir.getPhoneNumber());
				formOik.setPlaceOfResidence(form_plir.getPlaceOfResidence());
				formOik.setPlaceOfStudying(form_plir.getPlaceOfStudying());
				formOik.setYearOfAttendance(form_plir.getYearOfAttendance());
				formOik.setFamilyStatus(form_plir.getFamilyStatus());
				formOik.setAnnualIncome(form_plir.getAnnualIncome());
				formOik.setSiblingsStudying(form_plir.getSiblingsStudying());
				formOik.setUnemployedParents(form_plir.getUnemployedParents());
			}

			// GEOGRAPHY
		} else if (department.equals("Geography")) {
			if (studentDAO.if_form_NOT_exists_Geo(user)) {

				form_geo = studentDAO.insert_form_geo(user, fname, lname, email, phoneNumber, place_of_residence,
						placeOfStudying, department, int_year_of_attendance, familyStatus, siblingsStudying,
						annualIncome, unemployedParents);

			} else {
				// show error
				form_geo = studentDAO.returnStudentForm_GeoREST(user);
				
				formOik.setUsername(form_geo.getUsername());
				formOik.setFname(form_geo.getFname());
				formOik.setLname(form_geo.getLname());
				formOik.setEmail(form_geo.getEmail());
				formOik.setDepartment("exists");
				formOik.setPhoneNumber(form_geo.getPhoneNumber());
				formOik.setPlaceOfResidence(form_geo.getPlaceOfResidence());
				formOik.setPlaceOfStudying(form_geo.getPlaceOfStudying());
				formOik.setYearOfAttendance(form_geo.getYearOfAttendance());
				formOik.setFamilyStatus(form_geo.getFamilyStatus());
				formOik.setAnnualIncome(form_geo.getAnnualIncome());
				formOik.setSiblingsStudying(form_geo.getSiblingsStudying());
				formOik.setUnemployedParents(form_geo.getUnemployedParents());
			}
			// NUTRITION
		} else if (department.equals("Nutrition")) {
			if (studentDAO.if_form_NOT_exists_Diat(user)) {
				form_diat = studentDAO.insert_form_diat(user, fname, lname, email, phoneNumber, place_of_residence,
						placeOfStudying, department, int_year_of_attendance, familyStatus, siblingsStudying,
						annualIncome, unemployedParents);
			} else {
				// show error
				form_diat = studentDAO.returnStudentForm_DiatREST(user);
				
				formOik.setUsername(form_diat.getUsername());
				formOik.setFname(form_diat.getFname());
				formOik.setLname(form_diat.getLname());
				formOik.setEmail(form_diat.getEmail());
				formOik.setDepartment("exists");
				formOik.setPhoneNumber(form_diat.getPhoneNumber());
				formOik.setPlaceOfResidence(form_diat.getPlaceOfResidence());
				formOik.setPlaceOfStudying(form_diat.getPlaceOfStudying());
				formOik.setYearOfAttendance(form_diat.getYearOfAttendance());
				formOik.setFamilyStatus(form_diat.getFamilyStatus());
				formOik.setAnnualIncome(form_diat.getAnnualIncome());
				formOik.setSiblingsStudying(form_diat.getSiblingsStudying());
				formOik.setUnemployedParents(form_diat.getUnemployedParents());
				
				
			}
			// ECONOMICS
		} else if (department.equals("Economics")) {
			if (studentDAO.if_form_NOT_exists_Oik(user)) {
				formOik = studentDAO.insert_form_oik(user, fname, lname, email, phoneNumber, place_of_residence,
						placeOfStudying, department, int_year_of_attendance, familyStatus, siblingsStudying,
						annualIncome, unemployedParents);
			} else {
				// show error
				formOik = studentDAO.returnStudentForm_OikREST(user);
				formOik.setDepartment("exists");
			}
		}
		System.out.println("form was just submitted - student service");

		return formOik;
	}

	@Override
	@Transactional
	public String student_service_externalChangedForm(SubmittedForm_Oik form) {

		department = form.getDepartment();
		String user = form.getUsername();
		email = form.getEmail();
		phoneNumber = form.getPhoneNumber();
		place_of_residence = form.getPlaceOfResidence();
		
		String jsonForm = null;

		System.out.println(
				"department,user,email,phone,place:  " + department + user + email + phoneNumber + place_of_residence);

		// String jsonForm = null;
		// INFORMATICS
		if (department.equals("Informatics")) {
			if (studentDAO.if_form_NOT_exists_Plir(user)) {
				// student has not submitted a form yet
				String notfound = "Sorry, you haven't submitted your form yet!"; // MAKE IT JSON
				 return notfound;
			} else {
				// student has submitted a form
				SubmittedForm_Plir formplir = new SubmittedForm_Plir();
				formplir = studentDAO.change_form_plir(user, email, phoneNumber, place_of_residence);

				jsonForm = "{\"username\": \"" + formplir.getUsername() + "\"," + "\"Fname\": \"" + formplir.getFname()
				+ "\"," + "\"Lname\": \"" + formplir.getLname() + "\"," + "\"Email\": \"" + formplir.getEmail()
				+ "\"," + "\"PhoneNumber\": " + formplir.getPhoneNumber() + "," + "\"PlaceOfResidence\": \""
				+ formplir.getPlaceOfResidence() + "\"," + "\"PlaceOfStudying\": \""
				+ formplir.getPlaceOfStudying() + "\"," + "\"Department\": \"" + formplir.getDepartment()
				+ "\"," + "\"YearOfAttendance\": " + formplir.getYearOfAttendance() + ","
				+ "\"FamilyStatus\": \"" + formplir.getFamilyStatus() + "\"," + "\"SiblingsStudying\": "
				+ formplir.getSiblingsStudying() + "," + "\"AnnualIncome\": \"" + formplir.getAnnualIncome()
				+ "\"," + "\"UnemployedParents\": " + formplir.getUnemployedParents() 

				+ "}";
				
			}

			// GEOGRAPHY
		} else if (department.equals("Geography")) {
			if (studentDAO.if_form_NOT_exists_Geo(user)) {
				// student has not submitted a form yet
				String notfound = "Sorry, you haven't submitted your form yet!"; // MAKE IT JSON
				 return notfound;
			} else {
				// student has submitted a form
				SubmittedForm_Geo formgeo = new SubmittedForm_Geo();
				formgeo = studentDAO.change_form_geo(user, email, phoneNumber, place_of_residence);

				jsonForm = "{\"username\": \"" + formgeo.getUsername() + "\"," + "\"Fname\": \"" + formgeo.getFname()
				+ "\"," + "\"Lname\": \"" + formgeo.getLname() + "\"," + "\"Email\": \"" + formgeo.getEmail()
				+ "\"," + "\"PhoneNumber\": " + formgeo.getPhoneNumber() + "," + "\"PlaceOfResidence\": \""
				+ formgeo.getPlaceOfResidence() + "\"," + "\"PlaceOfStudying\": \""
				+ formgeo.getPlaceOfStudying() + "\"," + "\"Department\": \"" + formgeo.getDepartment() + "\","
				+ "\"YearOfAttendance\": " + formgeo.getYearOfAttendance() + "," + "\"FamilyStatus\": \""
				+ formgeo.getFamilyStatus() + "\"," + "\"SiblingsStudying\": " + formgeo.getSiblingsStudying()
				+ "," + "\"AnnualIncome\": \"" + formgeo.getAnnualIncome() + "\"," + "\"UnemployedParents\": "
				+ formgeo.getUnemployedParents() 

				+ "}";
				
			}
			// NUTRITION
		} else if (department.equals("Nutrition")) {
			if (studentDAO.if_form_NOT_exists_Diat(user)) {

				// student has not submitted a form yet
				String notfound = "Sorry, you haven't submitted your form yet!"; // MAKE IT JSON
				 return notfound;
			} else {
				// student has submitted a form
				SubmittedForm_Diat formdiat = new SubmittedForm_Diat();
				formdiat = studentDAO.change_form_diat(user, email, phoneNumber, place_of_residence);
				
				jsonForm = "{\"username\": \"" + formdiat.getUsername() + "\"," + "\"Fname\": \"" + formdiat.getFname()
				+ "\"," + "\"Lname\": \"" + formdiat.getLname() + "\"," + "\"Email\": \"" + formdiat.getEmail()
				+ "\"," + "\"PhoneNumber\": " + formdiat.getPhoneNumber() + "," + "\"PlaceOfResidence\": \""
				+ formdiat.getPlaceOfResidence() + "\"," + "\"PlaceOfStudying\": \""
				+ formdiat.getPlaceOfStudying() + "\"," + "\"Department\": \"" + formdiat.getDepartment()
				+ "\"," + "\"YearOfAttendance\": " + formdiat.getYearOfAttendance() + ","
				+ "\"FamilyStatus\": \"" + formdiat.getFamilyStatus() + "\"," + "\"SiblingsStudying\": "
				+ formdiat.getSiblingsStudying() + "," + "\"AnnualIncome\": \"" + formdiat.getAnnualIncome()
				+ "\"," + "\"UnemployedParents\": " + formdiat.getUnemployedParents() 

				+ "}";
				
			}
			// ECONOMICS
		} else if (department.equals("Economics")) {
			if (studentDAO.if_form_NOT_exists_Oik(user)) {
				// student has not submitted a form yet
				String notfound = "Sorry, you haven't submitted your form yet!"; // MAKE IT JSON
				// return notfound;
			} else {
				// student has submitted a form

				form = studentDAO.change_form_oik(user, email, phoneNumber, place_of_residence);
				
				jsonForm = "{\"username\": \"" + form.getUsername() + "\"," + "\"Fname\": \"" + form.getFname() + "\","
						+ "\"Lname\": \"" + form.getLname() + "\"," + "\"Email\": \"" + form.getEmail() + "\","
						+ "\"PhoneNumber\": " + form.getPhoneNumber() + "," + "\"PlaceOfResidence\": \""
						+ form.getPlaceOfResidence() + "\"," + "\"PlaceOfStudying\": \"" + form.getPlaceOfStudying()
						+ "\"," + "\"Department\": \"" + form.getDepartment() + "\"," + "\"YearOfAttendance\": "
						+ form.getYearOfAttendance() + "," + "\"FamilyStatus\": \"" + form.getFamilyStatus() + "\","
						+ "\"SiblingsStudying\": " + form.getSiblingsStudying() + "," + "\"AnnualIncome\": \""
						+ form.getAnnualIncome() + "\"," + "\"UnemployedParents\": " + form.getUnemployedParents() 

						+ "}";
			}

		}
		return jsonForm;
	}
}

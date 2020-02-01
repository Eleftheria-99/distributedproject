package dit.hua.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import dit.hua.project.database.Diat_DAO;
import dit.hua.project.database.Geo_DAO;
import dit.hua.project.database.Oik_DAO;
import dit.hua.project.database.Plir_DAO;
import dit.hua.project.entities.*;

@Service
public class ServiceImpl_for_employee_and_supervisor implements ServiceInterface_for_employee_and_supervisor {
	// inject the diat DAO
	@Autowired
	private Diat_DAO diat_DAO;

	// inject the geo DAO
	@Autowired
	private Geo_DAO geo_DAO;

	// inject the oik DAO
	@Autowired
	private Oik_DAO oik_DAO;

	// inject the plir DAO
	@Autowired
	private Plir_DAO plir_DAO;
	

	// if I had more than one implemenations for 1 dao, I would need qualifier !

	private String username = null;
	private String fname = null;
	private String lname = null;
	private String string_year_of_attendance = null;
	private int int_year_of_attendance = 0;
	private String email = null;
	private String string_phone_number = null;
	private int int_phone_number = 0;
	private String department = null;
	private String place_of_residence = null;
	private String place_of_living = null;
	private String annual_family_income = null;
	private String string_number_of_siblings_studying = null;
	private String family_state = null;
	private String string_number_of_unemployed_parents = null;
	private int int_number_of_siblings_studying = 0;
	private int int_number_of_unemployed_parents = 0;

	// HomePage_LogIn_MainMenuForAll_LogOut_Controller does not need to use service
	// or dao, because it has nothing to do with the database

	// EmployeeShowTheSubmittedFormsController

	// RETRIEVING THE SUBMITTED FORMS FROM THE DATABASE
	@Override
	@Transactional // because it has to do with the database
	public void show_the_submitted_forms_diat_query(Model model) {
		List<SubmittedForm_Diat> arraylist_subforms_diat = new ArrayList<SubmittedForm_Diat>();
		try {
			arraylist_subforms_diat = diat_DAO.get_the_submitted_forms_diat(); // get all
																				// submitted
																				// forms from
																				// DAO
			model.addAttribute("arraylist_subforms", arraylist_subforms_diat); // add all forms to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	@Transactional // because it has to do with the database
	public void show_the_submitted_forms_geo_query(Model model) {
		try {
			List<SubmittedForm_Geo> arraylist_subforms_geo = geo_DAO.get_the_submitted_forms_geo(); // get all submitted
																									// forms from DAO
			model.addAttribute("arraylist_subforms", arraylist_subforms_geo); // add all forms to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	@Transactional // because it has to do with the database
	public void show_the_submitted_forms_oik_query(Model model) {
		try {
			List<SubmittedForm_Oik> arraylist_subforms_oik = oik_DAO.get_the_submitted_forms_oik(); // get all submitted
																									// forms from DAO
			model.addAttribute("arraylist_subforms", arraylist_subforms_oik); // add all forms to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	@Transactional // because it has to do with the database
	public void show_the_submitted_forms_plir_query(Model model) {
		try {
			List<SubmittedForm_Plir> arraylist_subforms_plir = plir_DAO.get_the_submitted_forms_plir(); // get all
																										// submitted
																										// forms from
																										// DAO
			model.addAttribute("arraylist_subforms", arraylist_subforms_plir); // add all forms to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// DECLINE
	@Override
	@Transactional // because it has to do with the database
	public String declineASubmittedFormDiat(HttpServletRequest request) {
		getDataFromTheForm(request);   //getting the data from the form

		// first save the submitted form into the declined table and then delete it from
		// the submitted forms table and finally find the rest submitted forms
		// points are being calculated into the method save row in accepted table
		if (department == null) {// if form is found
			JOptionPane.showMessageDialog(null, "No form was found");
		} else if (department.equals("Nutrition")) {
			diat_DAO.save_in_declinedforms_diat(fname, lname, email, int_phone_number, place_of_residence,
					place_of_living, department, int_year_of_attendance, family_state, int_number_of_siblings_studying,
					annual_family_income, int_number_of_unemployed_parents);

			diat_DAO.delete_a_row_from_subform_table(username); // query to find the submitted forms
																// in
																// database
		}
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat";
	}

	@Override
	@Transactional // because it has to do with the database
	public String declineASubmittedFormGeo(HttpServletRequest request) {
		getDataFromTheForm(request);   //getting the data from the form

		// first save the submitted form into the declined table and then delete it from
		// the submitted forms table and finally find the rest submitted forms
		// points are being calculated into the method save row in accepted table
		if (department == null) {// if form is found
			JOptionPane.showMessageDialog(null, "No form was found");
		} else if (department.equals("Geography")) {
			geo_DAO.save_in_declinedforms_geo(fname, lname, email, int_phone_number, place_of_residence,
					place_of_living, department, int_year_of_attendance, family_state, int_number_of_siblings_studying,
					annual_family_income, int_number_of_unemployed_parents);

			geo_DAO.delete_a_row_from_subform_table(username); // query to find the submitted forms
			// in
			// database

		}
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo";
	}

	@Override
	@Transactional // because it has to do with the database
	public String declineASubmittedFormOik(HttpServletRequest request) {
		getDataFromTheForm(request);   //getting the data from the form


		// first save the submitted form into the declined table and then delete it from
		// the submitted forms table and finally find the rest submitted forms
		// points are being calculated into the method save row in accepted table
		if (department == null) {// if form is found
			JOptionPane.showMessageDialog(null, "No form was found");
		} else if (department.equals("Economics")) {
			oik_DAO.save_in_declinedforms_oik(fname, lname, email, int_phone_number, place_of_residence,
					place_of_living, department, int_year_of_attendance, family_state, int_number_of_siblings_studying,
					annual_family_income, int_number_of_unemployed_parents);

			oik_DAO.delete_a_row_from_subform_table(username); // query to find the submitted forms
			// in
			// database
		} else {
			JOptionPane.showMessageDialog(null, "No suitbale department");
		}
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik";
	}

	@Override
	@Transactional // because it has to do with the database
	public String declineASubmittedFormPlir(HttpServletRequest request) {
		getDataFromTheForm(request);   //getting the data from the form
		
		// first save the submitted form into the declined table and then delete it from
		// the submitted forms table and finally find the rest submitted forms
		if (department == null) {
			JOptionPane.showMessageDialog(null, "No form was found");
		} else if (department.equals("Informatics")) {
			plir_DAO.save_in_declinedforms_plir(fname, lname, email, int_phone_number, place_of_residence,
					place_of_living, department, int_year_of_attendance, family_state, int_number_of_siblings_studying,
					annual_family_income, int_number_of_unemployed_parents);

			plir_DAO.delete_a_row_from_subform_table(username); // query to find the submitted forms
																// in
																// database
		}
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir";
	}
	
	@Override
	@Transactional // because it has to do with the database
	public String acceptASubmittedFormDiat(HttpServletRequest request) {
		getDataFromTheForm(request);   //getting the data from the form

		// points are being calculated into the method save row in accepted table
		if (department == null) {// if form is found
			JOptionPane.showMessageDialog(null, "No form was found");
		}
		if (department.equals("Nutrition")) { // first save the accepted form into the table, then delete it from
												// the
												// submitted forms table and finally find the rest submitted forms
			diat_DAO.save_a_row_in_table_acceptedforms_diatS(fname, lname, email, int_phone_number, place_of_residence,
					place_of_living, department, int_year_of_attendance, family_state, int_number_of_siblings_studying,
					annual_family_income, int_number_of_unemployed_parents);
			diat_DAO.delete_a_row_from_subform_table(username);
		}
		// redirect to this page => show again all the submitted forms that exist in the
		// database table for this department
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat";
	}

	@Override
	@Transactional // because it has to do with the database
	public String acceptASubmittedFormGeo(HttpServletRequest request) {
		getDataFromTheForm(request);   //getting the data from the form



		// points are being calculated into the method save row in accepted table
		if (department == null) {// if form is found
			JOptionPane.showMessageDialog(null, "No form was found");
		} else if (department.equals("Geography")) {
			geo_DAO.save_a_row_in_table_acceptedforms_geo(fname, lname, email, int_phone_number, place_of_residence,
					place_of_living, department, int_year_of_attendance, family_state, int_number_of_siblings_studying,
					annual_family_income, int_number_of_unemployed_parents);
			geo_DAO.delete_a_row_from_subform_table(username);
		}
		// redirect to this page => show again all the submitted forms that exist in the
		// database table for this department
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo";
	}

	@Override
	@Transactional // because it has to do with the database
	public String acceptASubmittedFormOik(HttpServletRequest request) {

		getDataFromTheForm(request);   //getting the data from the form

		// points are being calculated into the method save row in accepted table
		if (department == null) {// if form is found
			JOptionPane.showMessageDialog(null, "No form was found");
		} else if (department.equals("Economics")) {
			oik_DAO.save_a_row_in_table_acceptedforms_oik(fname, lname, email, int_phone_number, place_of_residence,
					place_of_living, department, int_year_of_attendance, family_state, int_number_of_siblings_studying,
					annual_family_income, int_number_of_unemployed_parents);
			oik_DAO.delete_a_row_from_subform_table(username);
		}

		// redirect to this page => show again all the submitted forms that exist in the
		// database table for this department
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik";

	}

	@Override
	@Transactional // because it has to do with the database
	public String acceptASubmittedFormPlir(HttpServletRequest request) {
		getDataFromTheForm(request);   //getting the data from the form

		// points are being calculated into the method save row in accepted table
		if (department == null) {// if form is found
			JOptionPane.showMessageDialog(null, "No form was found");
		} else if (department.equals("Informatics")) {
			plir_DAO.save_a_row_in_table_acceptedforms_plir(fname, lname, email, int_phone_number, place_of_residence,
					place_of_living, department, int_year_of_attendance, family_state, int_number_of_siblings_studying,
					annual_family_income, int_number_of_unemployed_parents);
			plir_DAO.delete_a_row_from_subform_table(username);
		}

		// redirect to this page => show again all the submitted forms that exist in the
		// database table for this department
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir";
	}
	
	
	//EmployeeShowTheListWithCountedPointsController
	@Override
	@Transactional // because it has to do with the database
	public String service_showTheListWithCountedpointsDiat(Model model) {
		try {
			List<AcceptedForms_Diat> arraylist_acceptedforms_diat = diat_DAO.get_the_accepted_forms_diat(); // get all submitted forms from DAO
			model.addAttribute("arraylist_accepted_forms", arraylist_acceptedforms_diat); // add all users to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "employee-show-the-list-with-counted-points";
	}

	@Override
	@Transactional // because it has to do with the database
	public String service_showTheListWithCountedpointsGeo(Model model) {
		try {
			List<AcceptedForm_Geo> arraylist_acceptedforms_geo = geo_DAO.get_the_accepted_forms_geo(); // get all submitted forms from DAO
			model.addAttribute("arraylist_accepted_forms", arraylist_acceptedforms_geo); // add all users to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "employee-show-the-list-with-counted-points";
	}

	@Override
	@Transactional // because it has to do with the database
	public String service_showTheListWithCountedpointsOik(Model model) {
		try {
			List<AcceptedForm_Oik> arraylist_acceptedforms_oik = oik_DAO.get_the_accepted_forms_oik(); // get all submitted forms from DAO
			model.addAttribute("arraylist_accepted_forms", arraylist_acceptedforms_oik); // add all users to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "employee-show-the-list-with-counted-points";
	}
	
	@Override
	@Transactional // because it has to do with the database
	public String service_showTheListWithCountedpointsPlir(Model model) {
		try {
			List<AcceptedForms_Plir> arraylist_acceptedforms_plir = plir_DAO.get_the_accepted_forms_plir(); // get all submitted forms from DAO
			model.addAttribute("arraylist_accepted_forms", arraylist_acceptedforms_plir); // add all users to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "employee-show-the-list-with-counted-points";
	}

	// SUPERVISOR
	// SupervisorMenuChoicesController

	@Override
	@Transactional // because it has to do with the database
	public String service_create_final_ranking_supervisor_dep_diat(Model model) {
		System.out.println("count limit of students entitled to free meals - dep. diat ");
		String department = "Nutrition"; // declare department

		// int number_of_students_of_the_department = 40; // retrieved from database
		int number_of_students_of_the_department = (int) diat_DAO
				.count_number_of_students_from_table_user_dep_diat(department);

		int final_number = count_limit_of_students_entitled_to_free_meals_based_on_number_of_students_per_dep(
				number_of_students_of_the_department);

		System.out.println("final limit of students entitled to free meals - dep. diat: " + final_number);
		System.out.println("running: create final ranking of students entitled to free meals ");

		ArrayList<AcceptedForms_Diat> arraylist_acceptedforms_diat = new ArrayList<>();
		try {
			arraylist_acceptedforms_diat = diat_DAO
					.get_the_accepted_forms_order_by_desc_and_until_limit_diat(final_number); // get all submitted forms
																								// from DAO order by
																								// desc
																								// and only the number
																								// of students entitled
			model.addAttribute("arraylist_from_accepted_forms_to_finalranking", arraylist_acceptedforms_diat); // add
																												// all
																												// users
																												// to
																												// the
																												// model
																												// // to
			System.out.println(arraylist_acceptedforms_diat);
		} catch (Exception e) {
			e.getStackTrace();
		}

		try {
			for (int i = 0; i < arraylist_acceptedforms_diat.size(); i++) {
				String fname = arraylist_acceptedforms_diat.get(i).getFname();
				String lname = arraylist_acceptedforms_diat.get(i).getLname();
				int points = arraylist_acceptedforms_diat.get(i).getPoints();

				Final_Ranking_Diat final_ranking = new Final_Ranking_Diat(fname, lname, points);
				diat_DAO.save_a_row_in_table_final_ranking_diat(final_ranking);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "supervisor-show-final-ranking";
	}

	@Override
	@Transactional // because it has to do with the database
	public String service_create_final_ranking_supervisor_dep_geo(Model model) {
		System.out.println("count limit of students entitled to free meals - dep. geo  ");
        String department = "Geography"; //declare department

		//int number_of_students_of_the_department = 40;  // retrieved from database
		int number_of_students_of_the_department = (int) geo_DAO.count_number_of_students_from_table_user_dep_geo(department);
		int final_number = count_limit_of_students_entitled_to_free_meals_based_on_number_of_students_per_dep(
				number_of_students_of_the_department);
		
		System.out.println("final limit of students entitled to free meals - dep. geo: " + final_number);
		System.out.println("running: create final ranking of students entitled to free meals ");
		ArrayList<AcceptedForm_Geo> arraylist_acceptedforms_geo = new ArrayList<>();
		try {
			arraylist_acceptedforms_geo = geo_DAO
					.get_the_accepted_forms_order_by_desc_and_until_limit_geo(final_number); // get all submitted forms
																								// from DAO order by asc
																								// and only the number
																								// of students entitled
																								// to
			model.addAttribute("arraylist_from_accepted_forms_to_finalranking", arraylist_acceptedforms_geo ); // add all users to the model																	// to

			System.out.println(arraylist_acceptedforms_geo);
		} catch (Exception e) {
			e.getStackTrace();
		}

		try {
			for (int i = 0; i < arraylist_acceptedforms_geo.size(); i++) {
				String fname = arraylist_acceptedforms_geo.get(i).getFname();
				String lname = arraylist_acceptedforms_geo.get(i).getLname();

				int points = arraylist_acceptedforms_geo.get(i).getPoints();

				Final_Ranking_Geo final_ranking = new Final_Ranking_Geo(fname, lname, points);

				geo_DAO.save_a_row_in_table_final_ranking_geo(final_ranking);

			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "supervisor-show-final-ranking";
	}

	@Override
	@Transactional // because it has to do with the database
	public String service_create_final_ranking_supervisor_dep_oik(Model model) {
System.out.println("count limit of students entitled to free meals - dep. oik ");
		
        String department = "Economics"; //declare department

		//int number_of_students_of_the_department = 40;  // that could be retrieved from database too
        int number_of_students_of_the_department = (int) oik_DAO.count_number_of_students_from_table_user_dep_oik(department);
        
		int final_number = count_limit_of_students_entitled_to_free_meals_based_on_number_of_students_per_dep(number_of_students_of_the_department);
				
		System.out.println("final limit of students entitled to free meals - dep. eco: " + final_number);
		System.out.println("running: create final ranking of students entitled to free meals ");

		ArrayList<AcceptedForm_Oik> arraylist_acceptedforms_oik = new ArrayList<>();
		
		try {
			arraylist_acceptedforms_oik = oik_DAO
					.get_the_accepted_forms_order_by_desc_and_until_limit_oik(final_number); // get all submitted forms
																								// from DAO order by asc
																								// and only the number
																								// of students entitled
																								// to
			model.addAttribute("arraylist_from_accepted_forms_to_finalranking", arraylist_acceptedforms_oik); // add all users to the model																	// to

			System.out.println(arraylist_acceptedforms_oik);
		} catch (Exception e) {
			e.getStackTrace();
		}
		try {

			for (int i = 0; i < arraylist_acceptedforms_oik.size(); i++) {
				String fname = arraylist_acceptedforms_oik.get(i).getFname();
				String lname = arraylist_acceptedforms_oik.get(i).getLname();

				int points = arraylist_acceptedforms_oik.get(i).getPoints();

				Final_Ranking_Oik final_ranking = new Final_Ranking_Oik(fname, lname, points);
				oik_DAO.save_a_row_in_table_final_ranking_oik(final_ranking);

			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return "supervisor-show-final-ranking";
	}

	@Override
	@Transactional // because it has to do with the database
	public String service_create_final_ranking_supervisor_dep_plir(Model model) {
System.out.println("count limit of students entitled to free meals - dep. plir  ");
		

		String department = "Geography"; //declare department
		
		//int number_of_students_of_the_department = 40;  // retrieved from database too
		int number_of_students_of_the_department = (int) plir_DAO.count_number_of_students_from_table_user_dep_plir(department);
		
		int final_number = count_limit_of_students_entitled_to_free_meals_based_on_number_of_students_per_dep(number_of_students_of_the_department);
		
		System.out.println("final limit of students entitled to free meals - dep. plir: " + final_number);
		System.out.println("running: create final ranking of students entitled to free meals ");

		ArrayList<AcceptedForms_Plir> arraylist_acceptedforms_plir = new ArrayList<>();
		try {
			arraylist_acceptedforms_plir = plir_DAO
					.get_the_accepted_forms_order_by_desc_and_until_limit_plir(final_number); // get all submitted forms
																								// from DAO order by desc
																								// and only the number
																								// of students entitled
																								// to
			model.addAttribute("arraylist_from_accepted_forms_to_finalranking", arraylist_acceptedforms_plir); // add all users to the model																	// to
			System.out.println(arraylist_acceptedforms_plir);
		} catch (Exception e) {
			e.getStackTrace();
		}
		//try {
			for (int i = 0; i < arraylist_acceptedforms_plir.size(); i++) {
				String fname = arraylist_acceptedforms_plir.get(i).getFname();
				String lname = arraylist_acceptedforms_plir.get(i).getLname();

				int points = arraylist_acceptedforms_plir.get(i).getPoints();

				Final_Ranking_Plir final_ranking = new Final_Ranking_Plir(fname, lname, points);
				System.out.println("final ranking object : "+  final_ranking);

				plir_DAO.save_a_row_in_table_final_ranking_plir( final_ranking);
			}
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
		return "supervisor-show-final-ranking";
	}

	private int count_limit_of_students_entitled_to_free_meals_based_on_number_of_students_per_dep(
			int number_of_students_of_the_department) {
		// this method counts the annual number of the students that are entitled to
		// free meals based on the annual number of the students of every department
		System.out.println("running method count limit of students entitled to free meals per department");
		int final_number_of_students_entitleed = 0;
		if (number_of_students_of_the_department == 0) {
			final_number_of_students_entitleed = -1; // shows error
		} else {
			final_number_of_students_entitleed = (int) (0.8 * number_of_students_of_the_department); // check if it
																										// works !
		}
		System.out.println(
				"limit of students entitled to free meals per department: " + final_number_of_students_entitleed);
		return final_number_of_students_entitleed;
	}
	
	private void getDataFromTheForm(HttpServletRequest request) {
		username = request.getParameter("username");
		System.out.println("The username is " + username);

		fname = request.getParameter("fname");
		System.out.println("The first name is " + fname);

		lname = request.getParameter("lname");

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

		email = request.getParameter("email");

		string_phone_number = request.getParameter("phoneNumber");

		if (string_phone_number == null || string_phone_number.length() == 0) {
			int_phone_number = -1; // in case of error
		} else {
			try {
				int_phone_number = Integer.parseInt(string_phone_number);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		department = request.getParameter("department");

		place_of_residence = request.getParameter("placeOfResidence");

		place_of_living = request.getParameter("placefStudying"); // place of studying

		annual_family_income = request.getParameter("annualIncome"); // annualIncome. financial_data

		string_number_of_siblings_studying = request.getParameter("siblingsStudying");

		if (string_number_of_siblings_studying == null || string_number_of_siblings_studying.length() == 0) {
			int_number_of_siblings_studying = -1; // in case of error
		} else {
			try {
				int_number_of_siblings_studying = Integer.parseInt(string_number_of_siblings_studying);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		family_state = request.getParameter("familyStatus");

		string_number_of_unemployed_parents = request.getParameter("unemployedParents");

		if (string_number_of_unemployed_parents == null || string_number_of_unemployed_parents.length() == 0) {
			int_number_of_unemployed_parents = -1; // -1 means that the id does not exist or was not retrieved
		} else {
			try {
				int_number_of_unemployed_parents = Integer.parseInt(string_number_of_unemployed_parents);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		System.out.println("The department is " + department);
	}
	

}

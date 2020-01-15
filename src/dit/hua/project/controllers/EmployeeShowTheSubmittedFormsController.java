package dit.hua.project.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dit.hua.project.database.*;
import dit.hua.project.entities.*;

@Controller
public class EmployeeShowTheSubmittedFormsController {

	// inject the diat DAO
	@Autowired
	private Diat_DAO diat_DAO; // interface

	// inject the geo DAO
	@Autowired
	private Geo_DAO geo_DAO;

	// inject the oik DAO
	@Autowired
	private Oik_DAO oik_DAO;

	// inject the plir DAO
	@Autowired
	private Plir_DAO plir_DAO; // interface
	// an eixa parpanw apo 2 implementations 8elw qualifier !

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat", method = RequestMethod.GET)
	public String showTheSubmittedFormsDiat(Model model) {
		show_the_submitted_forms_diat_query(model); // query to find the submitted forms in database
		return "employee-show-the-submitted-forms";
	}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo", method = RequestMethod.GET)
	public String showTheSubmittedFormsGeo(Model model) {
		show_the_submitted_forms_geo_query(model); // query to find the submitted forms in database
		return "employee-show-the-submitted-forms";
	}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik", method = RequestMethod.GET)
	public String showTheSubmittedFormsOik(Model model) {
		show_the_submitted_forms_oik_query(model); // query to find the submitted forms in database
		return "employee-show-the-submitted-forms";
	}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir", method = RequestMethod.GET)
	public String showTheSubmittedFormsPlir(Model model) {
		show_the_submitted_forms_plir_query(model);// query to find the submitted forms in database
		return "employee-show-the-submitted-forms";
	}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat/decline" , method = RequestMethod.GET)  //, "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo/decline", "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik/decline", "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir/decline"}, method = RequestMethod.GET)
	public String declineASubmittedForm(HttpServletRequest request, Model model) {

		String username = request.getParameter("Username");
		System.out.println(username);
		String fname = request.getParameter("First Name");
		System.out.println(fname);
		String lname = request.getParameter("Last Name");

		String string_year_of_attendance = request.getParameter("Year Of Attendance");
		int int_year_of_attendance = 0;
		if (string_year_of_attendance == null || string_year_of_attendance.length() == 0) {
			int_year_of_attendance = -1; // in case of error
		} else {
			try {
				int_year_of_attendance = Integer.parseInt(string_year_of_attendance);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		String email = request.getParameter("Email");

		String string_phone_number = request.getParameter("PhoneNumber");
		int int_phone_number = 0;
		if (string_phone_number == null || string_phone_number.length() == 0) {
			int_phone_number = -1; // in case of error
		} else {
			try {
				int_phone_number = Integer.parseInt(string_phone_number);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		String department = request.getParameter("Department");

		String place_of_residence = request.getParameter("Place Of Residence");
		String place_of_living = request.getParameter("Place Of Studying"); // place of studying
		String annual_family_income = request.getParameter("Annual Income"); // annualIncome. financial_data

		String string_number_of_siblings_studying = request.getParameter("Sibling's Studying");
		int int_number_of_siblings_studying = 0;
		if (string_number_of_siblings_studying == null || string_number_of_siblings_studying.length() == 0) {
			int_number_of_siblings_studying = -1; // in case of error
		} else {
			try {
				int_number_of_siblings_studying = Integer.parseInt(string_number_of_siblings_studying);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		String family_state = request.getParameter("Family Status");

		String string_number_of_unemployed_parents = request.getParameter("Unemployed Parents");
		int int_number_of_unemployed_parents = 0;
		if (string_number_of_unemployed_parents == null || string_number_of_unemployed_parents.length() == 0) {
			int_number_of_unemployed_parents = -1; // 500 means that the id does not exist or was not retrieved
		} else {
			try {
				int_number_of_unemployed_parents = Integer.parseInt(string_number_of_unemployed_parents);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		// first save the submitted form into the declined table and then delete it from
		// the submitted forms table and finally find the rest submitted forms

			if (department.equals("Nutrition")) {
				diat_DAO.save_in_declinedforms_diat(fname, lname, email, int_phone_number, place_of_residence,
						place_of_living, department, int_year_of_attendance, family_state,
						int_number_of_siblings_studying, annual_family_income, int_number_of_unemployed_parents);

				diat_DAO.delete_a_row_from_subform_table(username); // query to find the submitted forms
																					// in
																					// database
				System.out.println("quer");
				show_the_submitted_forms_diat_query(model);
				System.out.println("2");
			} else if (department.equals("Geography")) {
				geo_DAO.save_in_declinedforms_geo(fname, lname, email, int_phone_number, place_of_residence,
						place_of_living, department, int_year_of_attendance, family_state,
						int_number_of_siblings_studying, annual_family_income, int_number_of_unemployed_parents);

				geo_DAO.delete_a_row_from_subform_table(username); // query to find the submitted forms
																					// in
																					// database
				show_the_submitted_forms_geo_query(model);
			} else if (department.equals("Economics")) {
				oik_DAO.save_in_declinedforms_oik(fname, lname, email, int_phone_number, place_of_residence,
						place_of_living, department, int_year_of_attendance, family_state,
						int_number_of_siblings_studying, annual_family_income, int_number_of_unemployed_parents);

				oik_DAO.delete_a_row_from_subform_table(username); // query to find the submitted forms
																					// in
																					// database
				show_the_submitted_forms_oik_query(model);
		 	} else if (department.equals("Informatics")) {
				plir_DAO.save_in_declinedforms_plir(fname, lname, email, int_phone_number, place_of_residence,
						place_of_living, department, int_year_of_attendance, family_state,
						int_number_of_siblings_studying, annual_family_income, int_number_of_unemployed_parents);

				plir_DAO.delete_a_row_from_subform_table(username); // query to find the submitted forms
																					// in
																					// database
				show_the_submitted_forms_plir_query(model);
 		}else { JOptionPane.showMessageDialog(null, "No form was found");}
		return "redirect:/employee-show-the-submitted-forms";
	//	return  showTheSubmittedFormsDiat(model);
		 // redirect
	}

	@RequestMapping(value = {"/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat/accept", "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo/accept", "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik/accept", "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir/accept"}, method = RequestMethod.GET)
	public String AcceptASubmittedForm(HttpServletRequest request, Model model) {

		String username = request.getParameter("Username");
		String fname = request.getParameter("First Name");
		String lname = request.getParameter("Last Name");
		String string_year_of_attendance = request.getParameter("Year Of Attendance");

		int int_year_of_attendance = 0;

		if (string_year_of_attendance == null || string_year_of_attendance.length() == 0) {
			int_year_of_attendance = -1; // in case of error
		} else {
			try {
				int_year_of_attendance = Integer.parseInt(string_year_of_attendance);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		String email = request.getParameter("Email");
		String string_phone_number = request.getParameter("PhoneNumber");
		int int_phone_number = 0;

		if (string_phone_number == null || string_phone_number.length() == 0) {
			int_phone_number = -1; // in case of error
		} else {
			try {
				int_phone_number = Integer.parseInt(string_phone_number);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		String department = request.getParameter("Department");

		String place_of_residence = request.getParameter("Place Of Residence");
		String place_of_living = request.getParameter("Place Of Studying"); // place of studying
		String annual_family_income = request.getParameter("Annual Income"); // annualIncome. financial_data
		String string_number_of_siblings_studying = request.getParameter("Sibling's Studying");
		int int_number_of_siblings_studying = 0;

		if (string_number_of_siblings_studying == null || string_number_of_siblings_studying.length() == 0) {
			int_number_of_siblings_studying = -1; // in case of error
		} else {
			try {
				int_number_of_siblings_studying = Integer.parseInt(string_number_of_siblings_studying);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		String family_state = request.getParameter("Family Status");

		String string_number_of_unemployed_parents = request.getParameter("Unemployed Parents");
		int int_number_of_unemployed_parents = 0;

		if (string_number_of_unemployed_parents == null || string_number_of_unemployed_parents.length() == 0) {
			int_number_of_unemployed_parents = -1; // 500 means that the id does not exist or was not retrieved
		} else {
			try {
				int_number_of_unemployed_parents = Integer.parseInt(string_number_of_unemployed_parents);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		if (username != null) {  //if form is found

			// points are being calculated into the method save row in accepted table
			if (department.equals("Nutrition")) { // first save the accepted form into the table, then delete it from
													// the
													// submitted forms table and finally find the rest submitted forms
				diat_DAO.save_a_row_in_table_acceptedforms_diatS(fname, lname, email, int_phone_number,
						place_of_residence, place_of_living, department, int_year_of_attendance, family_state,
						int_number_of_siblings_studying, annual_family_income, int_number_of_unemployed_parents);
				diat_DAO.delete_a_row_from_subform_table(username);

				show_the_submitted_forms_diat_query(model); // query to find the submitted forms in database
			} else if (department.equals("Geography")) {
				geo_DAO.save_a_row_in_table_acceptedforms_geo(fname, lname, email, int_phone_number, place_of_residence,
						place_of_living, department, int_year_of_attendance, family_state,
						int_number_of_siblings_studying, annual_family_income, int_number_of_unemployed_parents);
				geo_DAO.delete_a_row_from_subform_table(username);

				show_the_submitted_forms_geo_query(model); // query to find the submitted forms in database
			} else if (department.equals("Economics")) {
				oik_DAO.save_a_row_in_table_acceptedforms_oik(fname, lname, email, int_phone_number, place_of_residence,
						place_of_living, department, int_year_of_attendance, family_state,
						int_number_of_siblings_studying, annual_family_income, int_number_of_unemployed_parents);
				oik_DAO.delete_a_row_from_subform_table(username);

				show_the_submitted_forms_oik_query(model);// query to find the submitted forms in database
			} else if (department.equals("Informatics")) {
				plir_DAO.save_a_row_in_table_acceptedforms_plir(fname, lname, email, int_phone_number,
						place_of_residence, place_of_living, department, int_year_of_attendance, family_state,
						int_number_of_siblings_studying, annual_family_income, int_number_of_unemployed_parents);
				plir_DAO.delete_a_row_from_subform_table(username);

				show_the_submitted_forms_plir_query(model); // query to find the submitted forms in database
			}
		}else {JOptionPane.showMessageDialog(null, "No form was found");
		}
		return "employee-show-the-submitted-forms";
	}

	protected void show_the_submitted_forms_diat_query(Model model) {
		try {
			List<SubmittedForm_Diat> arraylist_subforms_diat = diat_DAO.get_the_submitted_forms_diat(); // get all
																										// submitted
																										// forms from
																										// DAO
			model.addAttribute("arraylist_subforms", arraylist_subforms_diat); // add all forms to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	protected void show_the_submitted_forms_geo_query(Model model) {
		try {
			List<SubmittedForm_Geo> arraylist_subforms_geo = geo_DAO.get_the_submitted_forms_geo(); // get all submitted
																									// forms from DAO
			model.addAttribute("arraylist_subforms", arraylist_subforms_geo); // add all forms to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	protected void show_the_submitted_forms_oik_query(Model model) {
		try {
			List<SubmittedForm_Oik> arraylist_subforms_oik = oik_DAO.get_the_submitted_forms_oik(); // get all submitted
																									// forms from DAO
			model.addAttribute("arraylist_subforms", arraylist_subforms_oik); // add all forms to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	protected void show_the_submitted_forms_plir_query(Model model) {
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
}

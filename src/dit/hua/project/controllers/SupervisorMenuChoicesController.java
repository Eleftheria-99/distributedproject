package dit.hua.project.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dit.hua.project.database.*;
import dit.hua.project.entities.*;

@Controller
public class SupervisorMenuChoicesController {

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
	private Plir_DAO plir_DAO;

	// request accepted forms table ORDER BY DESC limited by the number of students
	// entitled to !! and put the number of students included into the number
	// that i have found in the previous method : final_number_of_students_entitleed
	// into the table of final ranking
	// alert the supervisor for success

	// I NEED TO KEEP ONLY THE FIRST E.G. 80 PERSONS AND SAVE THEM INTO FINAL
	// RANKING TABLE CHANGE QUERY !!!!!!!!!!
	
//			href="/DistributedSystems/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-diat">Count

	@RequestMapping(value = "/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-diat", method = RequestMethod.GET)
	public String create_final_ranking_supervisor_dep_diat(Model model) {
		System.out.println("count limit of students entitled to free meals - dep. diat ");

		int number_of_students_of_the_department = 40;    // that could be retrieved from database too
		int final_number = count_limit_of_students_entitled_to_free_meals_based_on_number_of_students_per_dep(
				number_of_students_of_the_department);
		System.out.println("final limit of students entitled to free meals - dep. diat: " + final_number);

		System.out.println("running: create final ranking of students entitled to free meals ");
		ArrayList<AcceptedForms_Diat> arraylist_acceptedforms_diat = new ArrayList<>();
		try {
			arraylist_acceptedforms_diat = diat_DAO
					.get_the_accepted_forms_order_by_desc_and_until_limit_diat(final_number); // get all submitted forms
																								// from DAO order by desc
																								// and only the number
																								// of students entitled
			model.addAttribute("arraylist_from_accepted_forms_to_finalranking", arraylist_acceptedforms_diat ); // add all users to the model																	// to
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

	@RequestMapping(value = "/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-geo", method = RequestMethod.GET)
	public String create_final_ranking_supervisor_dep_geo(Model model) {
		System.out.println("count limit of students entitled to free meals - dep. geo  ");

		int number_of_students_of_the_department = 40;  // that could be retrieved from database too
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

	@RequestMapping(value = "/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-eco", method = RequestMethod.GET)
	public String create_final_ranking_supervisor_dep_eco(Model model) {
		System.out.println("count limit of students entitled to free meals - dep. oik ");
		int number_of_students_of_the_department = 40;  // that could be retrieved from database too
		int final_number = count_limit_of_students_entitled_to_free_meals_based_on_number_of_students_per_dep(
				number_of_students_of_the_department);
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

	@RequestMapping(value = "/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-infor", method = RequestMethod.GET)
	public String create_final_ranking_supervisor_dep_infor(Model model) {
		System.out.println("count limit of students entitled to free meals - dep. plir  ");
		int number_of_students_of_the_department = 40;  // that could be retrieved from database too
		int final_number = count_limit_of_students_entitled_to_free_meals_based_on_number_of_students_per_dep(
				number_of_students_of_the_department);
		System.out.println("final limit of students entitled to free meals - dep. plir: " + final_number);
		System.out.println("running: create final ranking of students entitled to free meals ");

		ArrayList<AcceptedForms_Plir> arraylist_acceptedforms_plir = new ArrayList<>();
		try {
			arraylist_acceptedforms_plir = plir_DAO
					.get_the_accepted_forms_order_by_desc_and_until_limit_plir(final_number); // get all submitted forms
																								// from DAO order by asc
																								// and only the number
																								// of students entitled
																								// to
			model.addAttribute("arraylist_from_accepted_forms_to_finalranking", arraylist_acceptedforms_plir); // add all users to the model																	// to
			System.out.println(arraylist_acceptedforms_plir);
		} catch (Exception e) {
			e.getStackTrace();
		}
		try {
			for (int i = 0; i < arraylist_acceptedforms_plir.size(); i++) {
				String fname = arraylist_acceptedforms_plir.get(i).getFname();
				String lname = arraylist_acceptedforms_plir.get(i).getLname();

				int points = arraylist_acceptedforms_plir.get(i).getPoints();

				Final_Ranking_Plir final_ranking = new Final_Ranking_Plir(fname, lname, points);
				plir_DAO.save_a_row_in_table_final_ranking_plir(final_ranking);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
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

}

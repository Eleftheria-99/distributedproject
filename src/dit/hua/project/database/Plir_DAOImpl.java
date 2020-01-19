package dit.hua.project.database;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dit.hua.project.entities.AcceptedForms_Plir;
import dit.hua.project.entities.DeclinedForm_Plir;
import dit.hua.project.entities.Final_Ranking_Plir;
import dit.hua.project.entities.SubmittedForm_Plir;

@Repository // component that declares that exists communication with database
public class Plir_DAOImpl implements Plir_DAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional // because it has to do with the database
	public List<SubmittedForm_Plir> get_the_submitted_forms_plir() {
		String create_search_query = "from SubmittedForm_Plir"; // SUBMFORM_PLIR
		System.out.println("query: " + create_search_query);
		
		List<SubmittedForm_Plir> all_submittedForms_Plir = new ArrayList<>();
     
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		try {

			Query<SubmittedForm_Plir> query = currentSession.createQuery(create_search_query, SubmittedForm_Plir.class); // create
																															// a
																															// query

			// execute the query and get the results list
			all_submittedForms_Plir = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		 System.out.println("plir_dao_impl system out print ln and list.tostring:"+all_submittedForms_Plir.toString());

		 displayForms(all_submittedForms_Plir);
		return all_submittedForms_Plir; // return the results !
	}

	@Override
	public void displayForms(List<SubmittedForm_Plir> forms_list) {
		System.out.println("display forms method : display submitted forms from oiconomics found in database!");
		// display students
		for (SubmittedForm_Plir users : forms_list) {
			System.out.println(users);
		}

	}

	@Override
	@Transactional
	public SubmittedForm_Plir return_Submitted_Form_Plir(String username) {

		SubmittedForm_Plir form = new SubmittedForm_Plir();

		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = (SubmittedForm_Plir) currentSession.get(SubmittedForm_Plir.class, username);
			System.out.println("returned fname is------->" + form.getFname());

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return form;
	}

	@Override
	@Transactional // because it has to do with the database
	public void save_a_row_in_table_acceptedforms_plir(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents) {

		SubmittedForm_Plir submitted_form = new SubmittedForm_Plir(fname, lname, email, phone_number,
				place_of_residence, place_of_living, department, year_of_attendance, family_state,
				number_of_siblings_studying, annual_family_income, number_of_unemployed_parents);

		int points = -1; // in case of error
		points = calculatePoints(submitted_form);
		System.out.println(" plir dao impl point : " + points);

		AcceptedForms_Plir form = new AcceptedForms_Plir(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents, points);

		// List<SubmittedForm_Diat> all_submittedForms_Diat = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// currentSession.createQuery(save_query, AcceptedForms_Plir.class); // create a
			// query
			currentSession.save(form);

		} catch (Exception e) {
			System.out.println("ROW NOT SUBMITTED INTO ACCEPTED FORMS SUCCESSFULLY");
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		System.out.println("ROW SUBMITTED INTO ACCEPTED FORMS SUCCESSFULLY");

	}

	@Override
	@Transactional // because it has to do with the database
	public ArrayList<AcceptedForms_Plir> check_if_inserted_row_exists_plir(String given_id) {
		// to check if the inserted row exists! //String given_id_ = retrieve from db ;

		String create_search_query = "from AcceptedForms_diat a where a.id='" + given_id + "'";
		System.out.println("query " + create_search_query);

		List<AcceptedForms_Plir> list_inserted_row = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			Query<AcceptedForms_Plir> query = currentSession.createQuery(create_search_query, AcceptedForms_Plir.class); // create
																															// a
																															// query
			// execute the query and get the results list
			list_inserted_row = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		ArrayList<AcceptedForms_Plir> arraylist_inserted_row = new ArrayList<AcceptedForms_Plir>();

		arraylist_inserted_row.addAll(list_inserted_row); // pass whatever the List has into the arraylist!

		displayAcceptedForms_plir(arraylist_inserted_row);

		return arraylist_inserted_row; // return the results in arraylist!

	}

	@Override
	public void displayAcceptedForms_plir(List<AcceptedForms_Plir> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display students
		for (AcceptedForms_Plir users : forms_list) {
			System.out.println(users);
		}

	}

	@Override
	@Transactional // because it has to do with the database
	public void save_in_declinedforms_plir(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents) {

		DeclinedForm_Plir form = new DeclinedForm_Plir(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents);

		// List<SubmittedForm_Diat> all_submittedForms_Diat = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// currentSession.createQuery(save_query, DeclinedForm_Plir.class); // create a
			// query
			currentSession.save(form);

		} catch (Exception e) {
			System.out.println("ROW NOT SUBMITTED INTO DECLINED FORMS SUCCESSFULLY");
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		System.out.println("ROW SUBMITTED INTO DECLINED FORMS SUCCESSFULLY");

	}

	@Override
	@Transactional // because it has to do with the database
	public void delete_a_row_from_subform_table(String username ) {   //ERRORR NEEDS CHANGEE !!
	

		//String delete_query = "delete from SubmittedForm_Plir where SubmittedForm_Plir.username='" + username+ "'";
		//System.out.println("query: " + delete_query);

		
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			try {
			// create a query
			// Query<SubmittedForm_Diat> query =
			//currentSession.createQuery(delete_query, SubmittedForm_Plir.class).executeUpdate();
				SubmittedForm_Plir subform = return_Submitted_Form_Plir(username);
				if(subform != null) {
					currentSession.delete(subform);
				}


		} catch (Exception e) {
			System.out.println("error : delete query: Diat_DAOImpl");
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		System.out.println("form from department was just deleted ");

	}

	@Override
	@Transactional // because it has to do with the database
	public List<AcceptedForms_Plir> get_the_accepted_forms_plir() {
		// returns the table acceptedforms_plir, returns all the submitted forms from
		// the department of dietology

		String create_search_query = "from AcceptedForms_Plir order by points desc";
		System.out.println("query: " + create_search_query);

		List<AcceptedForms_Plir> all_acceptedForms_Plir = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create a query
			Query<AcceptedForms_Plir> query = currentSession.createQuery(create_search_query, AcceptedForms_Plir.class);

			// execute the query and get the results list
			all_acceptedForms_Plir = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		return all_acceptedForms_Plir; // return the results
	}

	@Override
	@Transactional // because it has to do with the database
	public ArrayList<AcceptedForms_Plir> get_the_accepted_forms_order_by_desc_and_until_limit_plir(
			int limit_of_students_entitled_to_free_meals) { // returns the table acceptedforms_diat order by asc and
															// only the students entitled to free meals

		String create_search_query = "from AcceptedForms_Plir order by points desc limit "
				+ limit_of_students_entitled_to_free_meals;
		System.out.println("query: " + create_search_query);

		List<AcceptedForms_Plir> acceptedForms_Plir = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			Query<AcceptedForms_Plir> query = currentSession.createQuery(create_search_query, AcceptedForms_Plir.class); // create
																															// a
																															// query

			// execute the query and get the results list
			acceptedForms_Plir = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		ArrayList<AcceptedForms_Plir> arraylist_all_Forms_Diat = new ArrayList<AcceptedForms_Plir>();

		arraylist_all_Forms_Diat.addAll(acceptedForms_Plir); // pass whatever the List has into the arraylist!

		displayAcceptedForms_plir(arraylist_all_Forms_Diat);

		return arraylist_all_Forms_Diat; // return the results in arraylist!

	}

	@Override
	@Transactional // because it has to do with the database
	public void save_a_row_in_table_final_ranking_plir(Final_Ranking_Plir final_ranking) {
		try { // save it
				// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// currentSession.createQuery(save_query, AcceptedForm_Geo.class); // create a
			// query
			currentSession.save(final_ranking);

		} catch (Exception e) {
			System.out.println("ROW NOT SUBMITTED INTO FINAL RANKING SUCCESSFULLY");
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		System.out.println("ROW SUBMITTED INTO FINAL RANKING SUCCESSFULLY");

	}

	@Override
	public int calculatePoints(SubmittedForm_Plir form) {
		int countpoints = 0;

		if (form.getAnnualIncome().equals("zero") && form.getUnemployedParents() == 0) {
			countpoints = 1000; // means that the student is entitled to free meals surely
		} else {
			if (form.getAnnualIncome().equals("lower than 10.000")) { // points from income
				countpoints += 100;
			} else if (form.getAnnualIncome().equals("10.000 - 15.000")) {
				countpoints += 30;

			}
			// point from siblings
			for (int i = 0; i < form.getSiblingsStudying(); i++) {
				countpoints += 20;
			}

			// points from place of studying
			if (form.getPlaceOfStudying() != form.getPlaceOfResidence()) {
				countpoints += 50;
			}
		}

		// acceptedform.setPoints(Integer.toString(countpoints));
		System.out.println("final points :" + countpoints);
		return countpoints;
	}

}

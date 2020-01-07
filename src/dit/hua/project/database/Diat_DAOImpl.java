package dit.hua.project.database;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dit.hua.project.entities.SubmittedForm_Diat;
import dit.hua.project.entities.AcceptedForms_Diat;
import dit.hua.project.entities.DeclinedForm_Diat;
import dit.hua.project.entities.Final_Ranking_Diat;

@Repository                                     // the component that declares that exists communication with database
public class Diat_DAOImpl implements Diat_DAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional // because it has to do with the database
	public List<SubmittedForm_Diat> get_the_submitted_forms_diat() {
		// returns the table submforms_diat, returns all the submitted forms from the
		// department of dietology

		String create_search_query = "from Subform_diat"; // UBMFORM_DIAT
		System.out.println("query: " + create_search_query);

		List<SubmittedForm_Diat> all_submittedForms_Diat = new ArrayList<>();

		
		try {
			System.out.println("begin try ");

			// create session
	        Session curentSession =  sessionFactory.getCurrentSession();
//			// get current hibernate session
//			Session currentSession = sessionFactory.getCurrentSession();
			System.out.println("current session done " );

			//Query<SubmittedForm_Diat> query = currentSession.createQuery(create_search_query, SubmittedForm_Diat.class); // create
			// start a transaction
			curentSession.beginTransaction();	
			System.out.println("began transaction");
// a
			// query SubmittedForm_Diat
		    all_submittedForms_Diat  = (List<SubmittedForm_Diat>) curentSession.createQuery(create_search_query).getResultList();																									// query
			System.out.println("query done " );

			// execute the query and get the results list
		//	all_submittedForms_Diat = query.getResultList();
		 // commit transaction
		    curentSession.getTransaction().commit();
			System.out.println("transaction done " );

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		} finally {
			sessionFactory.close();
        }
		displayForms(all_submittedForms_Diat);
//        ArrayList<SubmittedForm_Diat> arraylist_all_submittedForms_Diat = new ArrayList<SubmittedForm_Diat>();
//                
//        arraylist_all_submittedForms_Diat.addAll( all_submittedForms_Diat);   //pass whatever the List has into the arraylist!
//
//  	   	displayForms(arraylist_all_submittedForms_Diat);

		return all_submittedForms_Diat; // return the results !

	}

	
	public SubmittedForm_Diat return_Submitted_Form_Diat(String username) { //return 1 submitted form based on the username   
		SubmittedForm_Diat form = new SubmittedForm_Diat();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Diat.class, username);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		return form;
	
	}
	
	@Override
	@Transactional // because it has to do with the database
	public List<AcceptedForms_Diat> get_the_accepted_forms_diat() {
		// returns the table acceptedforms_diat, returns all the submitted forms from
		// the department of dietology

		String create_search_query = "from Acceptedforms_diat order by points desc"; // UBMFORM_DIAT
		System.out.println("query: " + create_search_query);

		List<AcceptedForms_Diat> all_acceptedForms_Diat = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			Query<AcceptedForms_Diat> query = currentSession.createQuery(create_search_query, AcceptedForms_Diat.class); // create
																															// a
																															// query
			// execute the query and get the results list
			all_acceptedForms_Diat = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return all_acceptedForms_Diat; // return the results !
	}

	@Override
	@Transactional // becasue it has to do with the databse database
	public void save_in_declinedforms_diat(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents) { // save form into table declined table , beacuse it did
																// not meet the criteria

		//create object
		DeclinedForm_Diat form = new DeclinedForm_Diat(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents);

		try { // save it
				// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// currentSession.createQuery(save_query, DeclinedForm_Diat.class); // create a
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
	@Transactional // because it has to do with the databse database
	public void displayForms(List<SubmittedForm_Diat> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display students
		for (SubmittedForm_Diat users : forms_list) {
			System.out.println(users);
		}

	}

	@Override
	public void save_a_row_in_table_acceptedforms_diatS(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,	int number_of_unemployed_parents) {	

		SubmittedForm_Diat submitted_form = new SubmittedForm_Diat(fname, lname, email, phone_number,
				place_of_residence, place_of_living, department, year_of_attendance, family_state,
				number_of_siblings_studying, annual_family_income, number_of_unemployed_parents);
		
		int points =-1;       //in case of error 
		points = calculatePoints(submitted_form);
		
		AcceptedForms_Diat form = new AcceptedForms_Diat(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents, points);

        // List<SubmittedForm_Diat> all_submittedForms_Diat = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// currentSession.createQuery(save_query, AcceptedForms_Diat.class); // create a
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
	public ArrayList<AcceptedForms_Diat> check_if_inserted_row_exists(String given_id) {

		// to check if the inserted row exists! //String given_id_ = retrieve from db ;

		String create_search_query = "from AcceptedForms_diat a where a.id='" + given_id + "'";
		System.out.println("query " + create_search_query);

		List<AcceptedForms_Diat> list_inserted_row = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			Query<AcceptedForms_Diat> query = currentSession.createQuery(create_search_query, AcceptedForms_Diat.class); // create
																															// a
																															// query
			// execute the query and get the results list
			list_inserted_row = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		ArrayList<AcceptedForms_Diat> arraylist_inserted_row = new ArrayList<AcceptedForms_Diat>();

		arraylist_inserted_row.addAll(list_inserted_row); // pass whatever the List has into the arraylist!

		displayAcceptedForms_Diat(arraylist_inserted_row);

		return arraylist_inserted_row; // return the results in arraylist!}

	}

	@Override
	public void displayAcceptedForms_Diat(List<AcceptedForms_Diat> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display students
		for (AcceptedForms_Diat users : forms_list) {
			System.out.println(users);
		}

	}

	@Override
	public void delete_a_row_from_subform_table(int id_of_the_submitted_form) {
		// int id_of_the_submitted_form, String table_name, String entity_class_name
		// for this class ! +id needed
//		table_name = "Subform_diat";
//		entity_class_name= "SubmittedForm_Diat";
		// entity_class_name = entity_class_name +".class";

		String delete_query = "from Subform_diat where Subform_diat.id='" + id_of_the_submitted_form + "'";
		System.out.println("query: " + delete_query);

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create a query
			// Query<SubmittedForm_Diat> query =
			currentSession.createQuery(delete_query, SubmittedForm_Diat.class).executeUpdate();

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
	public ArrayList<AcceptedForms_Diat> get_the_accepted_forms_order_by_asc_and_until_limit_diat(
			int limit_of_students_entitled_to_free_meals) {
		// returns the table acceptedforms_diat order by asc and only the students
		// entitled to free meals

		String create_search_query = "from Acceptedforms_diat order by points desc limit"+limit_of_students_entitled_to_free_meals; // ++++++
		System.out.println("query: " + create_search_query);

		List<AcceptedForms_Diat> all_acceptedForms_Diat = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			Query<AcceptedForms_Diat> query = currentSession.createQuery(create_search_query, AcceptedForms_Diat.class); // create
																															// a
																															// query

			// execute the query and get the results list
			all_acceptedForms_Diat = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		ArrayList<AcceptedForms_Diat> arraylist_all_acceptedForms_Diat = new ArrayList<AcceptedForms_Diat>();

		arraylist_all_acceptedForms_Diat.addAll(all_acceptedForms_Diat); // pass whatever the List has into the
																			// arraylist!

		return arraylist_all_acceptedForms_Diat; // return the results !
	}

	@Override
	@Transactional // because it has to do with the database
	public void save_a_row_in_table_final_ranking_diat(Final_Ranking_Diat final_ranking) {
		try { // save it
				// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// currentSession.createQuery(save_query, DeclinedForm_Diat.class); // create a
			// query
			currentSession.save(final_ranking);
		} catch (Exception e) {
			System.out.println("ROW NOT SUBMITTED INTO DECLINED FORMS SUCCESSFULLY");
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		System.out.println("ROW SUBMITTED INTO FINAL RANKING DIAT SUCCESSFULLY");
	}

	@Override
	public int calculatePoints(SubmittedForm_Diat form) {
		
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
			if (!form.getPlaceOfStudying().equals(form.getPlaceOfResidence())) {
				countpoints += 50;
			}
		}

		// acceptedform.setPoints(Integer.toString(countpoints));
		System.out.println("final points :" + countpoints);
		return countpoints;
	}
}

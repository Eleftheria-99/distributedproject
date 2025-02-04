package dit.hua.project.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dit.hua.project.entities.AcceptedForm_Geo;
import dit.hua.project.entities.DeclinedForm_Geo;
import dit.hua.project.entities.Final_Ranking_Geo;
import dit.hua.project.entities.SubmittedForm_Geo;


@Repository // component that declares that exists communication with database
public class Geo_DAOImpl implements Geo_DAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional // because it has to do with the database
	public List<SubmittedForm_Geo> get_the_submitted_forms_geo() {

		String create_search_query = "from SubmittedForm_Geo"; // SUBMFORM_GEO
		System.out.println("query: " + create_search_query);

		List<SubmittedForm_Geo> all_submittedForms_Geo = new ArrayList<>();

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			// create a query
			Query<SubmittedForm_Geo> query = currentSession.createQuery(create_search_query, SubmittedForm_Geo.class);

			// execute the query and get the results list
			all_submittedForms_Geo = query.getResultList();
			System.out.println("list without method " + all_submittedForms_Geo.toString());
			displayForms(all_submittedForms_Geo);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return all_submittedForms_Geo; // return the results!
	}

	@Override
	public void displayForms(List<SubmittedForm_Geo> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display submitted forms from students
		for (SubmittedForm_Geo theusers : forms_list) {
			System.out.println(theusers);
		}

	}

	@Override
	@Transactional
	public SubmittedForm_Geo return_Submitted_Form_Geo(String username) {
		//return the submitted that matches the given user name

		SubmittedForm_Geo form = new SubmittedForm_Geo();
		Session currentSession = sessionFactory.getCurrentSession();
		try {

			form = currentSession.get(SubmittedForm_Geo.class, username);
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		} 
		return form;
	}

	@Override
	@Transactional // because it has to do with the database
	public void save_a_row_in_table_acceptedforms_geo(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents) {

		SubmittedForm_Geo submitted_form = new SubmittedForm_Geo(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents);

		int points = -1; // in case of error
		points = calculatePoints(submitted_form);
		System.out.println("geo dao impl point : " + points);

		AcceptedForm_Geo form = new AcceptedForm_Geo(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents, points);

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		try { // save it

			// currentSession.createQuery(save_query, AcceptedForm_Geo.class);
			// create a query
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
	public ArrayList<AcceptedForm_Geo> check_if_inserted_row_exists(String given_id) {
		// to check if the inserted row exists! //String given_id_ = retrieve from db ;

		String create_search_query = "from AcceptedForm_Geo a where a.id='" + given_id + "'";
		System.out.println("query " + create_search_query);

		List<AcceptedForm_Geo> list_inserted_row = new ArrayList<>();

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			// create query
			Query<AcceptedForm_Geo> query = currentSession.createQuery(create_search_query, AcceptedForm_Geo.class);
			// execute the query and get the results list
			list_inserted_row = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		ArrayList<AcceptedForm_Geo> arraylist_inserted_row = new ArrayList<AcceptedForm_Geo>();

		arraylist_inserted_row.addAll(list_inserted_row); // pass whatever the List has into the arraylist!

		displayAcceptedForms_geo(arraylist_inserted_row);

		return arraylist_inserted_row; // return the results in arraylist!
	}

	@Override
	@Transactional // because it has to do with the database
	public void save_in_declinedforms_geo(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents) {

		DeclinedForm_Geo form = new DeclinedForm_Geo(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents);

		// List<SubmittedForm_Diat> all_submittedForms_Diat = new ArrayList<>();
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		try {

			// currentSession.createQuery(save_query, DeclinedForm_Geo.class); // create a
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
	public void displayAcceptedForms_geo(List<AcceptedForm_Geo> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display students
		for (AcceptedForm_Geo users : forms_list) {
			System.out.println(users);
		}

	}

	@Override
	@Transactional // because it has to do with the database
	public void delete_a_row_from_subform_table(String username) { // delete a row from submitted forms
																				// table based on the id

//		String delete_query = "from SubmittedForm_Geo where SubmittedForm_Geo.id='" + id_of_the_submitted_form + "'";
//		System.out.println("query: " + delete_query);

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			// create a query
			// Query<SubmittedForm_Diat> query =			currentSession.createQuery(delete_query, SubmittedForm_Geo.class).executeUpdate();

			SubmittedForm_Geo subform = return_Submitted_Form_Geo(username);
			if(subform != null) {
				currentSession.delete(subform);
			}

		} catch (Exception e) {
			System.out.println("error : delete query: Diat_DAOImpl");
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		} 

		System.out.println("form from submitted form department was just deleted ");
	}

	@Override
	@Transactional // because it has to do with the database
	public List<AcceptedForm_Geo> get_the_accepted_forms_geo() { // returns the table acceptedforms_geo

		String create_search_query = "from AcceptedForm_Geo order by points desc";
		System.out.println("query: " + create_search_query);

		List<AcceptedForm_Geo> all_acceptedForms_Geo = new ArrayList<>();

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			
			Query<AcceptedForm_Geo> query = currentSession.createQuery(create_search_query, AcceptedForm_Geo.class); // create
																														// a
																														// query

			// execute the query and get the results list
			all_acceptedForms_Geo = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return all_acceptedForms_Geo; // return the results
	}

	@Override
	@Transactional // because it has to do with the database
	public ArrayList<AcceptedForm_Geo> get_the_accepted_forms_order_by_desc_and_until_limit_geo(
			int limit_of_students_entitled_to_free_meals) { // returns the table acceptedforms_diat order by asc and
															// only the students entitled to free meals

		String create_search_query = "from AcceptedForm_Geo order by points desc";
		System.out.println("query: " + create_search_query);

		List<AcceptedForm_Geo> acceptedForms_Geo = new ArrayList<>();

		
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
		try {
				 // create query
			Query<AcceptedForm_Geo> query = currentSession.createQuery(create_search_query, AcceptedForm_Geo.class);
																										 
			 // this replaces the LIMIT in the query
			query.setMaxResults(limit_of_students_entitled_to_free_meals);

			// execute the query and get the results list
			acceptedForms_Geo = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		ArrayList<AcceptedForm_Geo> arraylist_final_Forms_Geo = new ArrayList<AcceptedForm_Geo>();

		arraylist_final_Forms_Geo.addAll(acceptedForms_Geo); // pass whatever the List has into the
																// arraylist!
		displayAcceptedForms_geo(arraylist_final_Forms_Geo);

		return arraylist_final_Forms_Geo; // return the results
	}

	@Override
	@Transactional // because it has to do with the database
	public void save_a_row_in_table_final_ranking_geo(Final_Ranking_Geo final_ranking) {

				// get current hibernate session		
			Session currentSession = sessionFactory.getCurrentSession();
			try { // save it
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
	public int calculatePoints(SubmittedForm_Geo form) {
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

	@Override
	@Transactional // because it has to do with the database
	public long count_number_of_students_from_table_user_dep_geo(String department) {
		String create_search_query = "select count(*) from Users where department='"+ department+"'"; //group by department";
		System.out.println("query: " + create_search_query);
		long number_of_students = 0;
		//String SQL_QUERY = "SELECT COUNT(*) FROM Users users";
     
//		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			// query	
		  Query query = currentSession.createQuery(create_search_query );
		    
		  for(Iterator it=query.iterate();it.hasNext();)
		  {
			  number_of_students = (Long) it.next();
		   System.out.print("Count: " + number_of_students);
		  }
		  
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		
		return number_of_students; // return the result!
	}

}

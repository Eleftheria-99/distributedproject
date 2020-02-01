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

import dit.hua.project.entities.AcceptedForm_Oik;
import dit.hua.project.entities.DeclinedForm_Oik;
import dit.hua.project.entities.Final_Ranking_Oik;
import dit.hua.project.entities.SubmittedForm_Oik;


@Repository // component that declares that exists communication with database
public class Oik_DAOImpl implements Oik_DAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SubmittedForm_Oik> get_the_submitted_forms_oik() {

		String create_search_query = "from SubmittedForm_Oik"; // SUBMFORM_OIK
		System.out.println("query: " + create_search_query);

		List<SubmittedForm_Oik> all_submittedForms_Oik = new ArrayList<>();

		try {System.out.println("before session");
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			System.out.println("session");
			
			// create a query
			Query<SubmittedForm_Oik> query = currentSession.createQuery(create_search_query, SubmittedForm_Oik.class); 
			
			// execute the query and get the results list
			all_submittedForms_Oik = query.getResultList();
			System.out.println("query result :"+ all_submittedForms_Oik.toString());																								// query

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		displayForms(all_submittedForms_Oik);
		return all_submittedForms_Oik; // return the results
	}

	@Override
	public void displayForms(List<SubmittedForm_Oik> forms_list) {
		System.out.println("display submitted forms from oiconomics found in database!");
		// display students
		for (SubmittedForm_Oik users : forms_list) {
			System.out.println(users);
		}
	}
	
	

	@Override
	public SubmittedForm_Oik return_Submitted_Form_Oik(String username) {

		SubmittedForm_Oik form = new SubmittedForm_Oik();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Oik.class, username);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		return form;
	}

	@Override
	public void save_a_row_in_table_acceptedforms_oik(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents) {

		SubmittedForm_Oik submitted_form = new SubmittedForm_Oik(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents);

		int points = -1; // in case of error
		points = calculatePoints(submitted_form);
		System.out.println("oik dao impl point : " + points);

		AcceptedForm_Oik form = new AcceptedForm_Oik(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents, points);

		// List<SubmittedForm_Diat> all_submittedForms_Diat = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// currentSession.createQuery(save_query, AcceptedForm_Oik.class); // create a
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
	public ArrayList<AcceptedForm_Oik> check_if_inserted_row_exists(String given_id) {
		// to check if the inserted row exists! //String given_id_ = retrieve from db ;

		String create_search_query = "from AcceptedForm_Oik a where a.id='" + given_id + "'";
		System.out.println("query " + create_search_query);

		List<AcceptedForm_Oik> list_inserted_row = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			Query<AcceptedForm_Oik> query = currentSession.createQuery(create_search_query, AcceptedForm_Oik.class); // create
																														// a
																														// query
			// execute the query and get the results list
			list_inserted_row = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		ArrayList<AcceptedForm_Oik> arraylist_inserted_row = new ArrayList<AcceptedForm_Oik>();

		arraylist_inserted_row.addAll(list_inserted_row); // pass whatever the List has into the arraylist!

		displayAcceptedForms_oik(arraylist_inserted_row);

		return arraylist_inserted_row; // return the results in arraylist!

	}

	@Override
	public void displayAcceptedForms_oik(List<AcceptedForm_Oik> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display students
		for (AcceptedForm_Oik users : forms_list) {
			System.out.println(users);
		}

	}

	@Override
	public void save_in_declinedforms_oik(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents) {

		DeclinedForm_Oik form = new DeclinedForm_Oik(fname, lname, email, phone_number, place_of_residence,
				place_of_living, department, year_of_attendance, family_state, number_of_siblings_studying,
				annual_family_income, number_of_unemployed_parents);

		// List<SubmittedForm_Diat> all_submittedForms_Diat = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// currentSession.createQuery(save_query, DeclinedForm_Oik.class); // create a
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
	public void delete_a_row_from_subform_table(String username) {

		//String delete_query = "from SubmittedForm_Oik where SubmittedForm_Oik.id='" + id_of_the_submitted_form + "'";
		//System.out.println("query: " + delete_query);

		
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			try {
			// create a query
			// Query<SubmittedForm_Diat> query =
			//currentSession.createQuery(delete_query, SubmittedForm_Oik.class).executeUpdate();
			SubmittedForm_Oik subform = return_Submitted_Form_Oik(username);
			
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
	public List<AcceptedForm_Oik> get_the_accepted_forms_oik() {// returns the table acceptedforms_diat

		String create_search_query = "from AcceptedForm_Oik order by points desc"; // UBMFORM_DIAT
		System.out.println("query: " + create_search_query);

		List<AcceptedForm_Oik> all_acceptedForms_Oik = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			Query<AcceptedForm_Oik> query = currentSession.createQuery(create_search_query, AcceptedForm_Oik.class); // create
																														// a
																														// query

			// execute the query and get the results list
			all_acceptedForms_Oik = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		return all_acceptedForms_Oik; // return the results in arraylist!
	}

	@Override
	public ArrayList<AcceptedForm_Oik> get_the_accepted_forms_order_by_desc_and_until_limit_oik(
			int limit_of_students_entitled_to_free_meals) { // returns the table acceptedforms_oik order by asc and only
															// the students entitled to free meals

		String create_search_query = "from AcceptedForm_Oik order by points desc ";
		System.out.println("query: " + create_search_query);

		List<AcceptedForm_Oik> acceptedForms_Oik = new ArrayList<>();

		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create a query
			Query<AcceptedForm_Oik> query = currentSession.createQuery(create_search_query, AcceptedForm_Oik.class);

			 // this replaces the LIMIT in the query
			query.setMaxResults(limit_of_students_entitled_to_free_meals);

			// execute the query and get the results list
			acceptedForms_Oik = query.getResultList();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		ArrayList<AcceptedForm_Oik> arraylist_all_final_Forms_Oik = new ArrayList<AcceptedForm_Oik>();

		arraylist_all_final_Forms_Oik.addAll(acceptedForms_Oik); // pass whatever the List has into the arraylist!

		displayAcceptedForms_oik(arraylist_all_final_Forms_Oik);

		return arraylist_all_final_Forms_Oik; // return the results in arraylist!
	}

	@Override
	public void save_a_row_in_table_final_ranking_oik(Final_Ranking_Oik final_ranking) {
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
	public int calculatePoints(SubmittedForm_Oik form) {
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

		System.out.println("final points :" + countpoints);
		return countpoints;
	}

	@Override
	@Transactional // because it has to do with the database
	public long count_number_of_students_from_table_user_dep_oik(String department) {
		String create_search_query = "select count(*) from Users where department='"+ department+"'"; //group by department"; 
		System.out.println("query: " + create_search_query);
		long number_of_students = 0;
     
		// get current hibernate session
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

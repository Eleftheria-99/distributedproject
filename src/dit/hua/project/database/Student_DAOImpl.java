package dit.hua.project.database;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import dit.hua.project.entities.Final_Ranking_Diat;
import dit.hua.project.entities.Final_Ranking_Geo;
import dit.hua.project.entities.Final_Ranking_Oik;
import dit.hua.project.entities.Final_Ranking_Plir;
import dit.hua.project.entities.SubmittedForm_Diat;
import dit.hua.project.entities.SubmittedForm_Geo;
import dit.hua.project.entities.SubmittedForm_Oik;
import dit.hua.project.entities.SubmittedForm_Plir;
import dit.hua.project.entities.Users;

@Repository
public class Student_DAOImpl implements Student_DAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	
	//find student's department
	@Override
	public String findwhichDepartment(String username) {

		Users user = new Users();
		String department = "";

		try {

			Session currentSession = sessionFactory.getCurrentSession();
			user = currentSession.get(Users.class, username);
			department = user.getDepartment();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return department;
	}
	
	//INSERT TO DB

	@Override
	public SubmittedForm_Oik insert_form_oik(String username, String fname, String lname, String email,
			int phoneNumber, String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents) {
		// inserts new form into table
		// create form
		SubmittedForm_Oik form = new SubmittedForm_Oik(fname, lname, email, phoneNumber, placeOfResidence,
				placeOfStudying, department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome,
				unemployedParents);

		// save it
		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// check if user has already made a form

			Users user = currentSession.load(Users.class, username);
			form.setUsername(user.getUsername());

			currentSession.save(form);

			// currentSession.load(SubmittedForm_Oik.class,1);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		return form;
	}

	@Override
	public SubmittedForm_Plir insert_form_plir(String username, String fname, String lname, String email,
			int phoneNumber, String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents) {
		// create form
		SubmittedForm_Plir form = new SubmittedForm_Plir(fname, lname, email, phoneNumber, placeOfResidence,
				placeOfStudying, department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome,
				unemployedParents);

		// save it
		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			Users user = currentSession.load(Users.class, username);
			form.setUsername(user.getUsername());

			currentSession.save(form);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return form;
	}

	@Override
	public SubmittedForm_Diat insert_form_diat(String username, String fname, String lname, String email,
			int phoneNumber, String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents) {

		// create form
		SubmittedForm_Diat form = new SubmittedForm_Diat(fname, lname, email, phoneNumber, placeOfResidence,
				placeOfStudying, department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome,
				unemployedParents);
		// form.setUsername(user);

		// save it
		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			Users user = currentSession.load(Users.class, username);
			form.setUsername(user.getUsername());

			currentSession.save(form);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		return form;
	}

	@Override
	public SubmittedForm_Geo insert_form_geo(String username, String fname, String lname, String email,
			int phoneNumber, String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents) {

		// create form
		SubmittedForm_Geo form = new SubmittedForm_Geo(fname, lname, email, phoneNumber, placeOfResidence,
				placeOfStudying, department, yearOfAttendance, familyStatus, siblingsStudying, annualIncome,
				unemployedParents);

		// save it
		try {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			Users user = currentSession.get(Users.class, username);
			form.setUsername(user.getUsername());

			currentSession.save(form);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		return form;
	}

	//CHANGE DATA
	
	@Override
	public SubmittedForm_Oik  change_form_oik(String username, String email, int phoneNumber, String placeOfResidence) {

		SubmittedForm_Oik form = new SubmittedForm_Oik();

		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.load(SubmittedForm_Oik.class, username);
			form.setEmail(email);
			form.setPhoneNumber(phoneNumber);
			form.setPlaceOfResidence(placeOfResidence);

			currentSession.update(form);    //save form into database

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return form;

	}

	@Override
	public SubmittedForm_Plir change_form_plir(String username, String email, int phoneNumber, String placeOfResidence) {

		SubmittedForm_Plir form = new SubmittedForm_Plir();
		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.load(SubmittedForm_Plir.class, username);
			form.setEmail(email);
			form.setPhoneNumber(phoneNumber);
			form.setPlaceOfResidence(placeOfResidence);

			currentSession.update(form);  //save form into database

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return form;

	}

	@Override
	public SubmittedForm_Diat change_form_diat(String username, String email, int phoneNumber, String placeOfResidence) {

		SubmittedForm_Diat form = new SubmittedForm_Diat();
		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Diat.class, username);
			form.setEmail(email);
			form.setPhoneNumber(phoneNumber);
			form.setPlaceOfResidence(placeOfResidence);
			
			currentSession.update(form);  //save form into database

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return form;

	}

	@Override
	public SubmittedForm_Geo change_form_geo(String username, String email, int phoneNumber, String placeOfResidence) {

		SubmittedForm_Geo form = new SubmittedForm_Geo();
		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Geo.class, username);
			form.setEmail(email);
			form.setPhoneNumber(phoneNumber);
			form.setPlaceOfResidence(placeOfResidence);
			currentSession.update(form);  //save form into database

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
	    return form;
	}
	
	//CHECK IF SUBMITTED FORM DOEN'T EXIST

	@Override
	public boolean if_form_NOT_exists_Oik(String username) {

		try {

			Session currentSession = sessionFactory.getCurrentSession();
			SubmittedForm_Oik form = currentSession.get(SubmittedForm_Oik.class, username);

			if (form.equals(null)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
			return true;
		}

	}

	@Override
	public boolean if_form_NOT_exists_Plir(String username) {

		try {

			Session currentSession = sessionFactory.getCurrentSession();
			SubmittedForm_Plir form = currentSession.get(SubmittedForm_Plir.class, username);

			if (form.equals(null)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
			return true;

		}

	}

	@Override
	public boolean if_form_NOT_exists_Diat(String username) {

		try {

			Session currentSession = sessionFactory.getCurrentSession();
			SubmittedForm_Diat form = currentSession.get(SubmittedForm_Diat.class, username);

			if (form.equals(null)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
			return true;
		}
	}

	@Override
	public boolean if_form_NOT_exists_Geo(String username) {

		try {

			Session currentSession = sessionFactory.getCurrentSession();
			SubmittedForm_Geo form = currentSession.get(SubmittedForm_Geo.class, username);

			if (form.equals(null)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
			return true;
		}
	}

	//RETURN FORM
	
	@Override
	public void returnStudentForm_Oik(String username, Model model, String error) {

		SubmittedForm_Oik form = new SubmittedForm_Oik();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Oik.class, username);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		model.addAttribute("error", error);
		model.addAttribute("fname", form.getFname());
		model.addAttribute("lname", form.getLname());
		model.addAttribute("email", form.getEmail());
		model.addAttribute("phone", form.getPhoneNumber());
		model.addAttribute("pofresidence", form.getPlaceOfResidence());
		model.addAttribute("pofstudying", form.getPlaceOfStudying());
		model.addAttribute("dep", form.getDepartment());
		model.addAttribute("income", form.getAnnualIncome());
		model.addAttribute("siblings", form.getSiblingsStudying());
		model.addAttribute("family", form.getFamilyStatus());
		model.addAttribute("year", form.getYearOfAttendance());
		model.addAttribute("parents", form.getUnemployedParents());
	}

	@Override
	public SubmittedForm_Oik returnStudentForm_OikREST(String user) {
		
		SubmittedForm_Oik form = new SubmittedForm_Oik();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Oik.class, user);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return form;
		
	}

	@Override
	public void returnStudentForm_Plir(String username, Model model, String error) {

		SubmittedForm_Plir form = new SubmittedForm_Plir();

		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = (SubmittedForm_Plir) currentSession.get(SubmittedForm_Plir.class, username);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		model.addAttribute("error", error);
		model.addAttribute("fname", form.getFname());
		model.addAttribute("lname", form.getLname());
		model.addAttribute("email", form.getEmail());
		model.addAttribute("phone", form.getPhoneNumber());
		model.addAttribute("pofresidence", form.getPlaceOfResidence());
		model.addAttribute("pofstudying", form.getPlaceOfStudying());
		model.addAttribute("dep", form.getDepartment());
		model.addAttribute("income", form.getAnnualIncome());
		model.addAttribute("siblings", form.getSiblingsStudying());
		model.addAttribute("family", form.getFamilyStatus());
		model.addAttribute("year", form.getYearOfAttendance());
		model.addAttribute("parents", form.getUnemployedParents());

	}
	
	@Override
	public SubmittedForm_Plir returnStudentForm_PlirREST(String user) {
		
		SubmittedForm_Plir form = new SubmittedForm_Plir();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Plir.class, user);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return form;
		
	}

	@Override
	public void returnStudentForm_Diat(String username, Model model, String error) {
		SubmittedForm_Diat form = new SubmittedForm_Diat();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Diat.class, username);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		model.addAttribute("error", error);
		model.addAttribute("fname", form.getFname());
		model.addAttribute("lname", form.getLname());
		model.addAttribute("email", form.getEmail());
		model.addAttribute("phone", form.getPhoneNumber());
		model.addAttribute("pofresidence", form.getPlaceOfResidence());
		model.addAttribute("pofstudying", form.getPlaceOfStudying());
		model.addAttribute("dep", form.getDepartment());
		model.addAttribute("income", form.getAnnualIncome());
		model.addAttribute("siblings", form.getSiblingsStudying());
		model.addAttribute("family", form.getFamilyStatus());
		model.addAttribute("year", form.getYearOfAttendance());
		model.addAttribute("parents", form.getUnemployedParents());
	}
	
	@Override
	public SubmittedForm_Diat returnStudentForm_DiatREST(String user) {
		
		SubmittedForm_Diat form = new SubmittedForm_Diat();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Diat.class, user);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return form;
		
	}

	@Override
	public void returnStudentForm_Geo(String username, Model model, String error) {
		SubmittedForm_Geo form = new SubmittedForm_Geo();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Geo.class, username);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

		model.addAttribute("error", error);
		model.addAttribute("fname", form.getFname());
		model.addAttribute("lname", form.getLname());
		model.addAttribute("email", form.getEmail());
		model.addAttribute("phone", form.getPhoneNumber());
		model.addAttribute("pofresidence", form.getPlaceOfResidence());
		model.addAttribute("pofstudying", form.getPlaceOfStudying());
		model.addAttribute("dep", form.getDepartment());
		model.addAttribute("income", form.getAnnualIncome());
		model.addAttribute("siblings", form.getSiblingsStudying());
		model.addAttribute("family", form.getFamilyStatus());
		model.addAttribute("year", form.getYearOfAttendance());
		model.addAttribute("parents", form.getUnemployedParents());
	}
	
	@Override
	public SubmittedForm_Geo returnStudentForm_GeoREST(String user) {
		
		SubmittedForm_Geo form = new SubmittedForm_Geo();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Geo.class, user);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return form;
		
	}

	//SEE RESULTS
	
	//ECONOMICS
	@Override
	public String returnFname_oik(String username) {

		SubmittedForm_Oik form = new SubmittedForm_Oik();
		String fname = "";
		try {

			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Oik.class, username);
			fname = form.getFname();

			System.out.println("Submitted form is :"+form);
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return fname;

	}

	@Override
	public String returnLname_oik(String username) {

		SubmittedForm_Oik form = new SubmittedForm_Oik();
		String lname = "";
		try {

			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Oik.class, username);
			lname = form.getLname();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return lname;
	}

	@Override
	public ArrayList<Final_Ranking_Oik> returnFinalRanking_oik_ALL_students_entitled() {
		String create_search_query = "from Final_Ranking_Oik"; // entity name
		System.out.println("query: " + create_search_query);

		List<Final_Ranking_Oik> all_finalranking_forms = new ArrayList<>();
		// create session
		Session curentSession = sessionFactory.getCurrentSession();
		System.out.println("current session done ");
		try {
			System.out.println("begin try ");

			// create query
			Query<Final_Ranking_Oik> query = curentSession.createQuery(create_search_query, Final_Ranking_Oik.class); // query
			System.out.println("query done");

			// execute the query and get the results list
			all_finalranking_forms = query.getResultList();
			System.out.println("getting  list");

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		
		
		ArrayList<Final_Ranking_Oik> arraylist_final_ranking = new ArrayList<Final_Ranking_Oik>();

		arraylist_final_ranking.addAll( all_finalranking_forms); // pass whatever the List has into the arraylist!

		displayFormsOik(arraylist_final_ranking ); //print in the console the list that the database returned 
		return arraylist_final_ranking; // return the results !
	}

	@Override
	public void displayFormsOik(List<Final_Ranking_Oik> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display students
		for (Final_Ranking_Oik users : forms_list) {
			System.out.println(users);
		}

		
	}
	
	
	//INFORMATICS
	@Override
	public String returnFname_plir(String username) {
		
		SubmittedForm_Plir form = new SubmittedForm_Plir();
		String fname = "";
		try {

			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Plir.class, username);
			fname = form.getFname();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return fname;
	}

	@Override
	public String returnLname_plir(String username) {
		
		SubmittedForm_Plir form = new SubmittedForm_Plir();
		String lname = "";
		try {

			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Plir.class, username);
			lname = form.getLname();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return lname;
	}
	
	@Override
	public ArrayList<Final_Ranking_Plir> returnFinalRanking_plir_ALL_students_entitled() {
		String create_search_query = "from Final_Ranking_Plir"; // entity name
		System.out.println("query: " + create_search_query);

		List<Final_Ranking_Plir> all_finalranking_forms = new ArrayList<>();
		// create session
		Session curentSession = sessionFactory.getCurrentSession();
		System.out.println("current session done ");
		try {
			System.out.println("begin try ");

			// create query
			Query<Final_Ranking_Plir> query = curentSession.createQuery(create_search_query, Final_Ranking_Plir.class); // query
			System.out.println("query done");

			// execute the query and get the results list
			all_finalranking_forms = query.getResultList();
			System.out.println("getting  list"+all_finalranking_forms);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		
		
		ArrayList<Final_Ranking_Plir> arraylist_final_ranking = new ArrayList<Final_Ranking_Plir>();

		arraylist_final_ranking.addAll( all_finalranking_forms); // pass whatever the List has into the arraylist!

		displayFormsPlir(arraylist_final_ranking ); //print in the console the list that the database returned 
		return arraylist_final_ranking; // return the results !
	}

	@Override
	public void displayFormsPlir(List<Final_Ranking_Plir> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display students
		for (Final_Ranking_Plir users : forms_list) {
			System.out.println(users);
		}

		
	}
	
	//GEOGRAPHY
	@Override
	public String returnFname_geo(String username) {

		SubmittedForm_Geo form = new SubmittedForm_Geo();
		String fname = "";
		try {

			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Geo.class, username);
			fname = form.getFname();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return fname;
	}

	@Override
	public String returnLname_geo(String username) {
		
		SubmittedForm_Geo form = new SubmittedForm_Geo();
		String lname = "";
		try {

			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Geo.class, username);
			lname = form.getLname();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return lname;
	}
	
	

	@Override
	public ArrayList<Final_Ranking_Geo> returnFinalRanking_geo_ALL_students_entitled() {
		String create_search_query = "from Final_Ranking_Geo"; // entity name
		System.out.println("query: " + create_search_query);

		List<Final_Ranking_Geo> all_finalranking_forms = new ArrayList<>();
		// create session
		Session curentSession = sessionFactory.getCurrentSession();
		System.out.println("current session done ");
		try {
			System.out.println("begin try ");

			// create query
			Query<Final_Ranking_Geo> query = curentSession.createQuery(create_search_query, Final_Ranking_Geo.class); // query
			System.out.println("query done");

			// execute the query and get the results list
			all_finalranking_forms = query.getResultList();
			System.out.println("getting  list");

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		
		
		ArrayList<Final_Ranking_Geo> arraylist_final_ranking = new ArrayList<Final_Ranking_Geo>();

		arraylist_final_ranking.addAll( all_finalranking_forms); // pass whatever the List has into the arraylist!

		displayFormsGeo(arraylist_final_ranking ); //print in the console the list that the database returned 
		return arraylist_final_ranking; // return the results !
	}

	@Override
	public void displayFormsGeo(List<Final_Ranking_Geo> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display students
		for (Final_Ranking_Geo users : forms_list) {
			System.out.println(users);
		}

		
	}
	
	//NUTRITION
	@Override
	public String returnFname_diat(String username) {
		
		SubmittedForm_Diat form = new SubmittedForm_Diat();
		String fname = "";
		try {

			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Diat.class, username);
			fname = form.getFname();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return fname;
	}

	@Override
	public String returnLname_diat(String username) {
		
		SubmittedForm_Diat form = new SubmittedForm_Diat();
		String lname = "";
		try {

			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Diat.class, username);
			lname = form.getLname();

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		return lname;
	}
		
	@Override
	public ArrayList<Final_Ranking_Diat> returnFinalRanking_diat_ALL_students_entitled() {
		String create_search_query = "from Final_Ranking_Diat"; // entity name
		System.out.println("query: " + create_search_query);

		List<Final_Ranking_Diat> all_finalranking_forms = new ArrayList<>();
		// create session
		Session curentSession = sessionFactory.getCurrentSession();
		System.out.println("current session done ");
		try {
			System.out.println("begin try ");

			// create query
			Query<Final_Ranking_Diat> query = curentSession.createQuery(create_search_query, Final_Ranking_Diat.class); // query
			System.out.println("query done");

			// execute the query and get the results list
			all_finalranking_forms = query.getResultList();
			System.out.println("getting  list");

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		
		
		ArrayList<Final_Ranking_Diat> arraylist_final_ranking = new ArrayList<Final_Ranking_Diat>();

		arraylist_final_ranking.addAll( all_finalranking_forms); // pass whatever the List has into the arraylist!

		displayFormsDiat(arraylist_final_ranking ); //print in the console the list that the database returned 
		return arraylist_final_ranking; // return the results !
	}
	
	@Override
	public void displayFormsDiat(List<Final_Ranking_Diat> forms_list) {
		System.out.println("display submitted forms from dietology found in database!");
		// display students
		for (Final_Ranking_Diat users : forms_list) {
			System.out.println(users);
		}

	}


}

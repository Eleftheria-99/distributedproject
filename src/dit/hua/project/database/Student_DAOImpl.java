package dit.hua.project.database;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import dit.hua.project.entities.AcceptedForm_Oik;
import dit.hua.project.entities.DeclinedForm_Oik;
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

	@Override
	@Transactional
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

	@Override
	@Transactional
	public ArrayList<SubmittedForm_Oik> insert_form_oik(String username, String fname, String lname, String email,
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

		return null;
	}

	@Override
	@Transactional
	public ArrayList<SubmittedForm_Plir> insert_form_plir(String username, String fname, String lname, String email,
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
		return null;
	}

	@Override
	@Transactional
	public ArrayList<SubmittedForm_Diat> insert_form_diat(String username, String fname, String lname, String email,
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

		return null;
	}

	@Override
	@Transactional
	public ArrayList<SubmittedForm_Geo> insert_form_geo(String username, String fname, String lname, String email,
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

		return null;
	}

	@Override
	@Transactional
	public void change_form_oik(String username, String email, int phoneNumber, String placeOfResidence) {

		SubmittedForm_Oik form = new SubmittedForm_Oik();

		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.load(SubmittedForm_Oik.class, username);
			form.setEmail(email);
			form.setPhoneNumber(phoneNumber);
			form.setPlaceOfResidence(placeOfResidence);

			currentSession.update(form);

			// return form;

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		// return form;

	}

	@Override
	@Transactional
	public void change_form_plir(String username, String email, int phoneNumber, String placeOfResidence) {

		SubmittedForm_Plir form = new SubmittedForm_Plir();
		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.load(SubmittedForm_Plir.class, username);
			form.setEmail(email);
			form.setPhoneNumber(phoneNumber);
			form.setPlaceOfResidence(placeOfResidence);

			currentSession.update(form);

			// return form;

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		// return form;

	}

	@Override
	@Transactional
	public void change_form_diat(String username, String email, int phoneNumber, String placeOfResidence) {

		SubmittedForm_Diat form = new SubmittedForm_Diat();
		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Diat.class, username);
			form.setEmail(email);
			form.setPhoneNumber(phoneNumber);
			form.setPlaceOfResidence(placeOfResidence);
			currentSession.update(form);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		// return form;

	}

	@Override
	@Transactional
	public void change_form_geo(String username, String email, int phoneNumber, String placeOfResidence) {

		SubmittedForm_Geo form = new SubmittedForm_Geo();
		try {
			Session currentSession = sessionFactory.getCurrentSession();

			form = currentSession.get(SubmittedForm_Geo.class, username);
			form.setEmail(email);
			form.setPhoneNumber(phoneNumber);
			form.setPlaceOfResidence(placeOfResidence);
			currentSession.update(form);

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}
		// return form;
	}

	@Override
	@Transactional
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
	@Transactional
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
	@Transactional
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
	@Transactional
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

	@Override
	@Transactional
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
	@Transactional
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
	@Transactional
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
	@Transactional
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
	@Transactional
	public void showPoints_oik(String username, Model model) {

		AcceptedForm_Oik acceptedform = new AcceptedForm_Oik();
		DeclinedForm_Oik declinedform = new DeclinedForm_Oik();
		// Final_Ranking_Oik ranking = new Final_Ranking_Oik();
		SubmittedForm_Oik form = new SubmittedForm_Oik();
		try {

			Session currentSession = sessionFactory.getCurrentSession();
			form = currentSession.get(SubmittedForm_Oik.class, username);
			String fname = form.getFname();
			// if form is declined
			for (int id = 1; id <= 40; id++) {
				declinedform = currentSession.get(DeclinedForm_Oik.class, id);
				acceptedform = currentSession.get(AcceptedForm_Oik.class, id);
				
				if (declinedform.getFname().equals(fname)) {
					model.addAttribute("declined", "Unfortunately your form was declined!");
					model.addAttribute("errormessage","");
					break;
					
				} else if (acceptedform.getFname().equals(fname)) {
					model.addAttribute("points", acceptedform.getPoints());
					model.addAttribute("errormessage","");
					//model.addAttribute("rank", id);
					break;
				}else {
					model.addAttribute("errormessage","Sorry, this is not available yet!");
					
				}
			}
			
			
		} catch (

		Exception e) {
			e.getStackTrace();
			e.getMessage();
			e.getCause();
		}

	}

}

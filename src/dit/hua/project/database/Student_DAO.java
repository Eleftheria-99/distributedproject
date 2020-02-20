package dit.hua.project.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import dit.hua.project.entities.Final_Ranking_Diat;
import dit.hua.project.entities.Final_Ranking_Geo;
import dit.hua.project.entities.Final_Ranking_Oik;
import dit.hua.project.entities.Final_Ranking_Plir;
import dit.hua.project.entities.SubmittedForm_Diat;
import dit.hua.project.entities.SubmittedForm_Geo;
import dit.hua.project.entities.SubmittedForm_Oik;
import dit.hua.project.entities.SubmittedForm_Plir;

public interface Student_DAO {

	// insert submitted form to database
	public SubmittedForm_Oik insert_form_oik(String username, String fname, String lname, String email,
			int phoneNumber, String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents);

	public SubmittedForm_Plir insert_form_plir(String username, String fname, String lname, String email,
			int phoneNumber, String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents);

	public SubmittedForm_Diat insert_form_diat(String username, String fname, String lname, String email,
			int phoneNumber, String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents);

	public SubmittedForm_Geo insert_form_geo(String username, String fname, String lname, String email,
			int phoneNumber, String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents);

	// change personal data
	public SubmittedForm_Oik change_form_oik(String username, String email, int phoneNumber, String placeOfResidence);

	public SubmittedForm_Plir change_form_plir(String username, String email, int phoneNumber, String placeOfResidence);

	public SubmittedForm_Diat change_form_diat(String username, String email, int phoneNumber, String placeOfResidence);

	public SubmittedForm_Geo change_form_geo(String username, String email, int phoneNumber, String placeOfResidence);

	// check if student hasn't submitted his form yet
	public boolean if_form_NOT_exists_Oik(String username);
	public boolean if_form_NOT_exists_Plir(String username);
	public boolean if_form_NOT_exists_Diat(String username);
	public boolean if_form_NOT_exists_Geo(String username);

	// return student's form
	public void returnStudentForm_Oik(String username, Model model, String error);
	public SubmittedForm_Oik returnStudentForm_OikREST(String user);

	public void returnStudentForm_Plir(String username, Model model, String error);
	public SubmittedForm_Plir returnStudentForm_PlirREST(String user);

	public void returnStudentForm_Diat(String username, Model model, String error);
	public SubmittedForm_Diat returnStudentForm_DiatREST(String user);

	public void returnStudentForm_Geo(String username, Model model, String error);
	public SubmittedForm_Geo returnStudentForm_GeoREST(String user);

	// find which department the logged-in student is studying
	public String findwhichDepartment(String username);

	// show points and ranking of student

		// ECONOMICS
	public String returnFname_oik(String username);
	public String returnLname_oik(String username);
	
	public ArrayList<Final_Ranking_Oik> returnFinalRanking_oik_ALL_students_entitled();
	public void displayFormsOik(List<Final_Ranking_Oik> forms_list);


		// INFORMATICS
	public String returnFname_plir(String username);
	public String returnLname_plir(String username);
	
	public ArrayList<Final_Ranking_Plir> returnFinalRanking_plir_ALL_students_entitled();
	public void displayFormsPlir(List<Final_Ranking_Plir> forms_list);


		// GEOGRAPHY
	public String returnFname_geo(String username);
	public String returnLname_geo(String username);
	
	public ArrayList<Final_Ranking_Geo> returnFinalRanking_geo_ALL_students_entitled();
	public void displayFormsGeo(List<Final_Ranking_Geo> forms_list);


		// NUTRITION
	public String returnFname_diat(String username);
	public String returnLname_diat(String username);
	
	public ArrayList<Final_Ranking_Diat> returnFinalRanking_diat_ALL_students_entitled();
	public void displayFormsDiat(List<Final_Ranking_Diat> forms_list);

}

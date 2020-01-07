package dit.hua.project.database;

import java.util.ArrayList;

import org.springframework.ui.Model;

import dit.hua.project.entities.SubmittedForm_Diat;
import dit.hua.project.entities.SubmittedForm_Geo;
import dit.hua.project.entities.SubmittedForm_Oik;
import dit.hua.project.entities.SubmittedForm_Plir;

public interface Student_DAO {

	public ArrayList<SubmittedForm_Oik>  insert_form_oik(String username,String fname, String lname, String email, int phoneNumber, String placeOfResidence,
			String placeOfStudying, String department, int yearOfAttendance, String familyStatus, int siblingsStudying,
			String annualIncome, int unemployedParents);
	public ArrayList<SubmittedForm_Plir>  insert_form_plir(String username,String fname, String lname, String email, int phoneNumber, String placeOfResidence,
			String placeOfStudying, String department, int yearOfAttendance, String familyStatus, int siblingsStudying,
			String annualIncome, int unemployedParents);
	public ArrayList<SubmittedForm_Diat>  insert_form_diat(String username,String fname, String lname, String email, int phoneNumber, String placeOfResidence,
			String placeOfStudying, String department, int yearOfAttendance, String familyStatus, int siblingsStudying,
			String annualIncome, int unemployedParents);
	public ArrayList<SubmittedForm_Geo>  insert_form_geo(String username,String fname, String lname, String email, int phoneNumber, String placeOfResidence,
			String placeOfStudying, String department, int yearOfAttendance, String familyStatus, int siblingsStudying,
			String annualIncome, int unemployedParents);
	
	public void change_form_oik(String username,String email, int phoneNumber, String placeOfResidence);
	public void change_form_plir(String username,String email, int phoneNumber, String placeOfResidence);
	public void change_form_diat(String username,String email, int phoneNumber, String placeOfResidence);
	public void change_form_geo(String username,String email, int phoneNumber, String placeOfResidence);
	
	public boolean if_form_NOT_exists_Oik(String username);
	public boolean if_form_NOT_exists_Plir(String username);
	public boolean if_form_NOT_exists_Diat(String username);
	public boolean if_form_NOT_exists_Geo(String username);
	
	public void returnStudentForm_Oik(String username,Model model);
	public void returnStudentForm_Plir(String username,Model model);
	public void returnStudentForm_Diat(String username,Model model);
	public void returnStudentForm_Geo(String username,Model model);
}



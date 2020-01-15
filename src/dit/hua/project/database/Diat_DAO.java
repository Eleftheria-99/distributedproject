package dit.hua.project.database;

import java.util.ArrayList;
import java.util.List;

import dit.hua.project.entities.AcceptedForms_Diat;
import dit.hua.project.entities.Final_Ranking_Diat;
import dit.hua.project.entities.SubmittedForm_Diat;


public interface Diat_DAO {
	
	public List<SubmittedForm_Diat>  get_the_submitted_forms_diat(); //show the submitted forms 
	public List<AcceptedForms_Diat>  get_the_accepted_forms_diat();  //show the accepted forms
	
	public ArrayList<AcceptedForms_Diat>  get_the_accepted_forms_order_by_desc_and_until_limit_diat(int limit_of_students_entitled_to_free_meals); //retrieve from the database the accepted forms and show them from the student that has the more points to the student that has the less points and show only those that are entitled to free meals  
	public void displayForms(List<SubmittedForm_Diat> forms_list) ;   //display the list in the console 
	
	public void save_a_row_in_table_acceptedforms_diatS(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents);  //save a row in one of the tables: accepted forms, points are being here also calculated
	
	public ArrayList<AcceptedForms_Diat> check_if_inserted_row_exists(String given_id);
	public void displayAcceptedForms_Diat(List<AcceptedForms_Diat> forms_list) ;  //display the list in the console 
	
	public void save_in_declinedforms_diat(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents);  //save a row in one of the tables: declined forms
	 
	public void delete_a_row_from_subform_table(String username); //delete a row from submitted forms based on the username

	public void save_a_row_in_table_final_ranking_diat(Final_Ranking_Diat final_ranking);  //save a row into the table final ranking
	
	public int calculatePoints(SubmittedForm_Diat form);    //calculate points based on the submitted form

	public SubmittedForm_Diat return_Submitted_Form_Diat(String username) ;   //return 1 submitted form based on the username

}

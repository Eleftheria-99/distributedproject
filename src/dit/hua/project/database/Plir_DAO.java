package dit.hua.project.database;

import java.util.ArrayList;
import java.util.List;

import dit.hua.project.entities.AcceptedForms_Plir;
import dit.hua.project.entities.Final_Ranking_Plir;
import dit.hua.project.entities.SubmittedForm_Plir;

public interface Plir_DAO {

	public List<SubmittedForm_Plir>  get_the_submitted_forms_plir(); //show all the submitted forms
	public List<AcceptedForms_Plir>  get_the_accepted_forms_plir();  //show the forms that have been accepted 
	public ArrayList<AcceptedForms_Plir> get_the_accepted_forms_order_by_desc_and_until_limit_plir(int limit_of_students_entitled_to_free_meals);  //retrieve from the database the accepted forms and show them from the student that has the more points to the student that has the less points and show only those that are entitled to free meals
	public void displayForms(List<SubmittedForm_Plir> forms_list) ;  //display the list in the console 
	
    public void save_a_row_in_table_acceptedforms_plir(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents);  //save a row in one of the tables: accepted forms, points are being here also calculated
	
	public ArrayList<AcceptedForms_Plir> check_if_inserted_row_exists_plir(String given_id);
	public void displayAcceptedForms_plir(List<AcceptedForms_Plir> forms_list) ;
	
	public void save_in_declinedforms_plir(String fname, String lname, String email, int phone_number,
			String place_of_residence, String place_of_living, String department, int year_of_attendance,
			String family_state, int number_of_siblings_studying, String annual_family_income,
			int number_of_unemployed_parents);   // save a form into declined forms

	public void delete_a_row_from_subform_table(String username); //delete a row from submitted forms based on the username   
	public void save_a_row_in_table_final_ranking_plir(Final_Ranking_Plir final_ranking);  //save a row into the table final ranking

	public int calculatePoints(SubmittedForm_Plir form); //calculate points based on the submitted form
 
	public SubmittedForm_Plir return_Submitted_Form_Plir(String username) ;   //return 1 submitted form based on the username
		
}

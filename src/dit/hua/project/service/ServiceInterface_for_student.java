package dit.hua.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import dit.hua.project.entities.Final_Ranking_Oik;
import dit.hua.project.entities.SubmittedForm_Oik;

public interface ServiceInterface_for_student {
	
	public String findDepartment(String username);
	// STUDENT
	// StudentController
	public void student_service_showSubmittedForm(HttpServletRequest request, Model model, HttpSession session);

	// StudentChangeDataController
	public void student_service_ChangedForm(HttpServletRequest request, Model model, HttpSession session);

	// StudentSeeResultsController
	public Final_Ranking_Oik student_service_SeeResults(Model model, HttpSession session);
	
	
	//Methods for external system and rest
	public SubmittedForm_Oik student_service_externalInsert(String user, String fname, String lname, String email,
			int phoneNumber, String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents);

	public String student_service_externalChangedForm(SubmittedForm_Oik form);

//	private String seeResults_Diat(Model model, String username, String dep)
//	private String seeResults_Geo(Model model, String username, String dep)
//	private String seeResults_Oik(Model model, String username, String dep)
//	private String seeResults_Plir(Model model, String username, String dep)
	
		
	
	
	

}

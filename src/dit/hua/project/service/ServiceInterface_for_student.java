package dit.hua.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface ServiceInterface_for_student {
	
	
	// STUDENT
	// StudentController
	public String student_service_showSubmittedForm(HttpServletRequest request, Model model, HttpSession session);

	// StudentChangeDataController
	public String student_service_ChangedForm(HttpServletRequest request, Model model, HttpSession session);

	// StudentSeeResultsController
	public String student_service_SeeResults(Model model, HttpSession session);
	
	
//	private int seeResults_Diat(Model model, String username, String dep)
//	private int seeResults_Geo(Model model, String username, String dep)
//	private int seeResults_Oik(Model model, String username, String dep)
//	private int seeResults_Plir(Model model, String username, String dep)
	
		
	
	
	

}

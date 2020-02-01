package dit.hua.project.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public interface ServiceInterface_for_employee_and_supervisor {

	// EMPLOYEE
	// EmployeeShowTheSubmittedFormsController

	// RETRIEVING THE SUBMITTED FORMS FROM THE DATABASE

	public void show_the_submitted_forms_diat_query(Model model);

	public void show_the_submitted_forms_geo_query(Model model);

	public void show_the_submitted_forms_oik_query(Model model);

	public void show_the_submitted_forms_plir_query(Model model);

	// DECLINE A FORM
	public String declineASubmittedFormDiat(HttpServletRequest request);

	public String declineASubmittedFormGeo(HttpServletRequest request);

	public String declineASubmittedFormOik(HttpServletRequest request);

	public String declineASubmittedFormPlir(HttpServletRequest request);

	// ACCEPT A FORM
	public String acceptASubmittedFormDiat(HttpServletRequest request);

	public String acceptASubmittedFormGeo(HttpServletRequest request);

	public String acceptASubmittedFormOik(HttpServletRequest request);

	public String acceptASubmittedFormPlir(HttpServletRequest request);

	// EmployeeShowTheListWithCountedPointsController
	public String service_showTheListWithCountedpointsDiat(Model model);

	public String service_showTheListWithCountedpointsGeo(Model model);

	public String service_showTheListWithCountedpointsOik(Model model);

	public String service_showTheListWithCountedpointsPlir(Model model);

	// SUPERVISOR
	// SupervisorMenuChoicesController

	public String service_create_final_ranking_supervisor_dep_diat(Model model);

	public String service_create_final_ranking_supervisor_dep_geo(Model model);

	public String service_create_final_ranking_supervisor_dep_oik(Model model);

	public String service_create_final_ranking_supervisor_dep_plir(Model model);

	// private int count_limit_of_students_entitled_to_free_meals_based_on_number_of_students_per_dep(int
	// number_of_students_of_the_department) private void getDAtaFRomForm()
	
	
	
}

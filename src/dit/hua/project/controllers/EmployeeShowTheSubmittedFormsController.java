package dit.hua.project.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dit.hua.project.service.ServiceInterface_for_employee_and_supervisor;

@Controller
public class EmployeeShowTheSubmittedFormsController {
	
	@Autowired
	private ServiceInterface_for_employee_and_supervisor service;

	//SHOW THE SUBMITTED FORMS 
	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat", method = RequestMethod.GET)
	public String showTheSubmittedFormsDiat(Model model) {
		service.show_the_submitted_forms_diat_query(model); // query to find the submitted forms in database
		return "employee-show-the-submitted-forms";
	}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo", method = RequestMethod.GET)
	public String showTheSubmittedFormsGeo(Model model) {
		service.show_the_submitted_forms_geo_query(model); // query to find the submitted forms in database
		return "employee-show-the-submitted-forms";
	}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik", method = RequestMethod.GET)
	public String showTheSubmittedFormsOik(Model model) {
		service.show_the_submitted_forms_oik_query(model); // query to find the submitted forms in database
		return "employee-show-the-submitted-forms";
	}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir", method = RequestMethod.GET)
	public String showTheSubmittedFormsPlir(Model model) {
		service.show_the_submitted_forms_plir_query(model);// query to find the submitted forms in database
		return "employee-show-the-submitted-forms";
	}

	//DECLINE
	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat/decline", method = RequestMethod.GET)
	public String declineASubmittedFormDiat(HttpServletRequest request) {
		service.declineASubmittedFormDiat(request);
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat";

	}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo/decline", method = RequestMethod.GET)
	public String declineASubmittedFormGeo(HttpServletRequest request) {
		service.declineASubmittedFormGeo(request);
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo";
}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik/decline", method = RequestMethod.GET)
	public String declineASubmittedFormOik(HttpServletRequest request) {
		service.declineASubmittedFormOik(request);
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik";

	}
	
	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir/decline" , method = RequestMethod.GET) 
	public String declineASubmittedForm(HttpServletRequest request) {
		service.declineASubmittedFormPlir(request);	
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir";

	}

	//ACCEPT
	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat/accept", method = RequestMethod.GET)
	public String AcceptASubmittedFormDiat(HttpServletRequest request) {
		service.acceptASubmittedFormDiat(request);
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-diat";

	}

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo/accept", method = RequestMethod.GET)
	public String AcceptASubmittedFormGeo(HttpServletRequest request) {
		service.acceptASubmittedFormGeo(request);
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-geo";

	}
	
	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik/accept", method = RequestMethod.GET)
	public String AcceptASubmittedFormOik(HttpServletRequest request) {
		service.acceptASubmittedFormOik(request);
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-oik";

	}


	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir/accept", method = RequestMethod.GET)
	public String AcceptASubmittedFormPlir(HttpServletRequest request) {
		service.acceptASubmittedFormPlir(request);
		return "redirect:/login/main-menu-for-all/employee-menu/employee-show-the-submitted-forms-dep-plir";


	}

	
}
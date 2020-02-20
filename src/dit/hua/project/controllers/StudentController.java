package dit.hua.project.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dit.hua.project.service.ServiceInterface_for_student;

@Controller
public class StudentController {
	@Autowired
	private ServiceInterface_for_student  student_service;

	@RequestMapping(value = "login/main-menu-for-all/student-menu/showForm", method = RequestMethod.GET)
	protected String fillForm() {
		return "st-form";
	}

	@RequestMapping(value = "login/main-menu-for-all/student-menu/showForm/StudentForm", method = RequestMethod.GET)
	protected String showSubmittedForm(HttpServletRequest request, Model model, HttpSession session) {
		//student_service.rest_service_showSubmittedForm();
		student_service.student_service_showSubmittedForm(request, model, session);
		return "show-submitted-form";	
	}

	@RequestMapping(value = "login/main-menu-for-all/student-menu/change-data", method = RequestMethod.GET)
	protected String ChangePersonalData() {
		return "st-change";
	}

	
}

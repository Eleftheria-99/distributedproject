package dit.hua.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dit.hua.project.service.ServiceInterface_for_employee_and_supervisor;

@Controller
public class SupervisorMenuChoicesController {
	@Autowired
	private ServiceInterface_for_employee_and_supervisor service;
	
	//CREATE THE FINAL RANKING FOR EVERY DEPARTMENT
	@RequestMapping(value = "/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-diat", method = RequestMethod.GET)
	public String create_final_ranking_supervisor_dep_diat(Model model) {
		 service.service_create_final_ranking_supervisor_dep_diat(model);
		 return "supervisor-show-final-ranking";
	}

	@RequestMapping(value = "/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-geo", method = RequestMethod.GET)
	public String create_final_ranking_supervisor_dep_geo(Model model) {
		 service.service_create_final_ranking_supervisor_dep_geo(model);
		 return "supervisor-show-final-ranking";
	}

	@RequestMapping(value = "/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-eco", method = RequestMethod.GET)
	public String create_final_ranking_supervisor_dep_eco(Model model) {
		 service.service_create_final_ranking_supervisor_dep_oik(model);
		 return "supervisor-show-final-ranking";
	}

	@RequestMapping(value = "/login/main-menu-for-all/supervisor-menu/supervisor-count-limit-of-students-entitled-to-free-meals-and-create-final-ranking-dep-infor", method = RequestMethod.GET)
	public String create_final_ranking_supervisor_dep_infor(Model model) {
		service.service_create_final_ranking_supervisor_dep_plir(model);
		return "supervisor-show-final-ranking";
	}

}

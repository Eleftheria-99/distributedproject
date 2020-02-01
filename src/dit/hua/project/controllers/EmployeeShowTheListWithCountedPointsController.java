package dit.hua.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dit.hua.project.service.ServiceInterface_for_employee_and_supervisor;

@Controller
public class EmployeeShowTheListWithCountedPointsController {

	@Autowired
	private ServiceInterface_for_employee_and_supervisor service;

	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-list-with-counted-points-dietology",method = RequestMethod.GET )
	public String showTheListWithCountedpointsDiet(Model model){
		 service.service_showTheListWithCountedpointsDiat(model);
		 return "employee-show-the-list-with-counted-points";
	}
	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-list-with-counted-points-geography",method = RequestMethod.GET )
	public String showTheListWithCountedpointsGeo(Model model){
		 service.service_showTheListWithCountedpointsGeo(model);
		 return "employee-show-the-list-with-counted-points";
	}
	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-list-with-counted-points-economics",method = RequestMethod.GET )
	public String showTheListWithCountedpointsEco(Model model){
		 service.service_showTheListWithCountedpointsOik(model);
		 return "employee-show-the-list-with-counted-points";
	}
	@RequestMapping(value = "/login/main-menu-for-all/employee-menu/employee-show-the-list-with-counted-points-informatics",method = RequestMethod.GET )
	public String showTheListWithCountedpointsInfor(Model model){
		 service.service_showTheListWithCountedpointsPlir(model);
		 return "employee-show-the-list-with-counted-points";
	}
	
}

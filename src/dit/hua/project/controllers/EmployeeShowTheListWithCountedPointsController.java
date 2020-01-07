package dit.hua.project.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dit.hua.project.database.*;
import dit.hua.project.entities.*;


@Controller
public class EmployeeShowTheListWithCountedPointsController {
	

	// inject the diat DAO
	@Autowired
	private Diat_DAO diat_DAO; // interface

	// inject the geo DAO
	@Autowired
	private Geo_DAO geo_DAO;

	// inject the oik DAO
	@Autowired
	private Oik_DAO oik_DAO;

	// inject the plir DAO
	@Autowired
	private Plir_DAO plir_DAO; // interface
	
	@RequestMapping(value = "/employee-login/employee-menu/employee-show-the-list-with-counted-points-dietology",method = RequestMethod.GET )
	public String showTheListWithCountedpointsDiet(Model model){
		try {
			List<AcceptedForms_Diat> arraylist_acceptedforms_diat = diat_DAO.get_the_accepted_forms_diat(); // get all submitted forms from DAO
			model.addAttribute("arraylist_accepted_forms", arraylist_acceptedforms_diat); // add all users to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "employee-show-the-list-with-counted-points";
	}
	@RequestMapping(value = "/employee-login/employee-menu/employee-show-the-list-with-counted-points-geography",method = RequestMethod.GET )
	public String showTheListWithCountedpointsGeo(Model model){
		try {
			List<AcceptedForm_Geo> arraylist_acceptedforms_geo = geo_DAO.get_the_accepted_forms_geo(); // get all submitted forms from DAO
			model.addAttribute("arraylist_accepted_forms", arraylist_acceptedforms_geo); // add all users to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "employee-show-the-list-with-counted-points";
	}
	@RequestMapping(value = "/employee-login/employee-menu/employee-show-the-list-with-counted-points-economics",method = RequestMethod.GET )
	public String showTheListWithCountedpointsEco(Model model){
		try {
			List<AcceptedForm_Oik> arraylist_acceptedforms_oik = oik_DAO.get_the_accepted_forms_oik(); // get all submitted forms from DAO
			model.addAttribute("arraylist_accepted_forms", arraylist_acceptedforms_oik); // add all users to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "employee-show-the-list-with-counted-points";
	}
	@RequestMapping(value = "/employee-login/employee-menu/employee-show-the-list-with-counted-points-informatics",method = RequestMethod.GET )
	public String showTheListWithCountedpointsInfor(Model model){
		try {
			List<AcceptedForms_Plir> arraylist_acceptedforms_plir = plir_DAO.get_the_accepted_forms_plir(); // get all submitted forms from DAO
			model.addAttribute("arraylist_accepted_forms", arraylist_acceptedforms_plir); // add all users to the model
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "employee-show-the-list-with-counted-points";
	}
	
}

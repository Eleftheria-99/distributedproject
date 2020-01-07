package dit.hua.project.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dit.hua.project.database.Student_DAO;
import dit.hua.project.entities.SubmittedForm_Diat;
import dit.hua.project.entities.SubmittedForm_Geo;
import dit.hua.project.entities.SubmittedForm_Oik;
import dit.hua.project.entities.SubmittedForm_Plir;

@Controller
public class StudentChangeDataController {

	// inject the user DAO
	@Autowired
	private Student_DAO studentDAO;

	@RequestMapping(value = "student-login/options/change-data/newForm", method = RequestMethod.GET)
	protected String ChangedForm(HttpServletRequest request, Model model) {

		String email = request.getParameter("email");
		int phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
		String placeOfResidence = request.getParameter("placeofliving");
		String department = request.getParameter("Department");

		String user = StudentLogInController.currentUser;

		if (department.equals("Informatics")) {
			SubmittedForm_Plir form = new SubmittedForm_Plir();
			form = studentDAO.change_form_plir(user, email, phoneNumber, placeOfResidence);
			//System.out.println("fname is------->"+form.getFname());

			model.addAttribute("fname", form.getFname());
			model.addAttribute("lname", form.getLname());
			model.addAttribute("email", email);
			model.addAttribute("phone", phoneNumber);
			model.addAttribute("pofresidence", placeOfResidence);
			model.addAttribute("pofstudying", form.getPlaceOfStudying());
			model.addAttribute("dep", form.getDepartment());
			model.addAttribute("income", form.getAnnualIncome());
			model.addAttribute("siblings", form.getSiblingsStudying());
			model.addAttribute("family", form.getFamilyStatus());
			model.addAttribute("year", form.getYearOfAttendance());
			model.addAttribute("parents", form.getUnemployedParents());

		} else if (department.equals("Geography")) {
			SubmittedForm_Geo form = new SubmittedForm_Geo();
			form = studentDAO.change_form_geo(user, email, phoneNumber, placeOfResidence);

			model.addAttribute("fname", form.getFname());
			model.addAttribute("lname", form.getLname());
			model.addAttribute("email", email);
			model.addAttribute("phone", phoneNumber);
			model.addAttribute("pofresidence", placeOfResidence);
			model.addAttribute("pofstudying", form.getPlaceOfStudying());
			model.addAttribute("dep", form.getDepartment());
			model.addAttribute("income", form.getAnnualIncome());
			model.addAttribute("siblings", form.getSiblingsStudying());
			model.addAttribute("family", form.getFamilyStatus());
			model.addAttribute("year", form.getYearOfAttendance());
			model.addAttribute("parents", form.getUnemployedParents());

		} else if (department.equals("Nutrition")) {
			SubmittedForm_Diat form = new SubmittedForm_Diat();
			form = studentDAO.change_form_diat(user, email, phoneNumber, placeOfResidence);

			model.addAttribute("fname", form.getFname());
			model.addAttribute("lname", form.getLname());
			model.addAttribute("email", email);
			model.addAttribute("phone", phoneNumber);
			model.addAttribute("pofresidence", placeOfResidence);
			model.addAttribute("pofstudying", form.getPlaceOfStudying());
			model.addAttribute("dep", form.getDepartment());
			model.addAttribute("income", form.getAnnualIncome());
			model.addAttribute("siblings", form.getSiblingsStudying());
			model.addAttribute("family", form.getFamilyStatus());
			model.addAttribute("year", form.getYearOfAttendance());
			model.addAttribute("parents", form.getUnemployedParents());

		} else if (department.equals("Economics")) {
			SubmittedForm_Oik form = new SubmittedForm_Oik();
			form = studentDAO.change_form_oik(user, email, phoneNumber, placeOfResidence);

			model.addAttribute("fname", form.getFname());
			model.addAttribute("lname", form.getLname());
			model.addAttribute("email", email);
			model.addAttribute("phone", phoneNumber);
			model.addAttribute("pofresidence", placeOfResidence);
			model.addAttribute("pofstudying", form.getPlaceOfStudying());
			model.addAttribute("dep", form.getDepartment());
			model.addAttribute("income", form.getAnnualIncome());
			model.addAttribute("siblings", form.getSiblingsStudying());
			model.addAttribute("family", form.getFamilyStatus());
			model.addAttribute("year", form.getYearOfAttendance());
			model.addAttribute("parents", form.getUnemployedParents());

		}

		// model.addAttribute("currentUser",user);

		return "show-submitted-form";
	}
}

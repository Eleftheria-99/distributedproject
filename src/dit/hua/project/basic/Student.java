package dit.hua.project.basic;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	protected int idS;
	protected String fname;
	protected String lname;
	protected int YearOfAttenndance;
	protected String email;
	protected String PhoneNumber;
	protected String Department;

	public int getIdS() {
		return idS;
	}

	public void setIdS(int idS) {
		this.idS = idS;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getYearOfAttenndance() {
		return YearOfAttenndance;
	}

	public void setYearOfAttenndance(int yearOfAttenndance) {
		YearOfAttenndance = yearOfAttenndance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	protected List<String> fillForm() {
		List<String> list = new ArrayList<String>();
		return list;
	}

	protected List<String> SubmitForm(){
		List<String> list = new ArrayList<String>();
		return list;
	}

	protected void SeeResults(){}

	protected void ChangePersonalData(){}

}

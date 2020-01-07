package dit.hua.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "DECLINEDFORM_DIAT")
public class DeclinedForm_Diat {
	
	@Id                       //primary key 
    @GeneratedValue(strategy=GenerationType.IDENTITY)   //autoincrement     
	@Column(name = "ID")
	protected int id;
	
	@Column(name = "FNAME")
	protected String fname;
	
	@Column(name = "LNAME")
	protected String lname;
	@Column(name = "EMAIL")
	protected String email;
	
	@Column(name = "PHONENUMBER")
	protected int phone_number;
	
	@Column(name = "PLACEOF_RESIDENCE")
	protected String place_of_residence;
	
	@Column(name = "PLACEOF_STUDYING")
	protected String place_of_living;
	
	@Column(name = "DEPARTMENT")
	protected String department;
	
	@Column(name = "YEAROFATTENDANCE")
	protected int year_of_attendance;
	
	@Column(name = "FAMILY_STATUS")
	protected String family_state;
	
	@Column(name = "NUMBER_OF_SIBLINGS_STUDYING")
	protected int number_of_siblings_studying;
	
	@Column(name = "ANNUAL_FINANCIAL_FAMILY_INCOME")    //financial data 
	protected String annual_family_income;
	
	@Column(name = "NUMBER_OF_UNEMPLOYED_PARENTS")
	protected int number_of_unemployed_parents;
	
	public DeclinedForm_Diat() {
	}

	public DeclinedForm_Diat(String fname, String lname, String email, int phone_number, String place_of_residence,
			String place_of_living, String department, int year_of_attendance, String family_state,
			int number_of_siblings_studying, String annual_family_income, int number_of_unemployed_parents) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone_number = phone_number;
		this.place_of_residence = place_of_residence;
		this.place_of_living = place_of_living;
		this.department = department;
		this.year_of_attendance = year_of_attendance;
		this.family_state = family_state;
		this.number_of_siblings_studying = number_of_siblings_studying;
		this.annual_family_income = annual_family_income;
		this.number_of_unemployed_parents = number_of_unemployed_parents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getPlace_of_residence() {
		return place_of_residence;
	}

	public void setPlace_of_residence(String place_of_residence) {
		this.place_of_residence = place_of_residence;
	}

	public String getPlace_of_living() {
		return place_of_living;
	}

	public void setPlace_of_living(String place_of_living) {
		this.place_of_living = place_of_living;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYear_of_attendance() {
		return year_of_attendance;
	}

	public void setYear_of_attendance(int year_of_attendance) {
		this.year_of_attendance = year_of_attendance;
	}

	public String getFamily_state() {
		return family_state;
	}

	public void setFamily_state(String family_state) {
		this.family_state = family_state;
	}

	public int getNumber_of_siblings_studying() {
		return number_of_siblings_studying;
	}

	public void setNumber_of_siblings_studying(int number_of_siblings_studying) {
		this.number_of_siblings_studying = number_of_siblings_studying;
	}

	public String getAnnual_family_income() {
		return annual_family_income;
	}

	public void setAnnual_family_income(String annual_family_income) {
		this.annual_family_income = annual_family_income;
	}

	public int getNumber_of_unemployed_parents() {
		return number_of_unemployed_parents;
	}

	public void setNumber_of_unemployed_parents(int number_of_unemployed_parents) {
		this.number_of_unemployed_parents = number_of_unemployed_parents;
	}

	@Override
	public String toString() {
		return "DeclinedForm_Diat [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", phone_number=" + phone_number + ", place_of_residence=" + place_of_residence + ", place_of_living="
				+ place_of_living + ", department=" + department + ", year_of_attendance=" + year_of_attendance
				+ ", family_state=" + family_state + ", number_of_siblings_studying=" + number_of_siblings_studying
				+ ", annual_family_income=" + annual_family_income + ", number_of_unemployed_parents="
				+ number_of_unemployed_parents + "]";
	}
	
	


}

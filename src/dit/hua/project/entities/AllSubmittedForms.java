package dit.hua.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALLSUBMITTEDFORMS")
public class AllSubmittedForms {

	
	@Id
	@Column(name="USERNAME")
	private String username;

	@Column(name="FNAME")
	private String Fname;

	@Column(name="LNAME")
	private String Lname;

	@Column(name="EMAIL")
	private String Email;

	@Column(name="PHONENUMBER")
	private int PhoneNumber;

	@Column(name="PLACEOF_RESIDENCE")
	private String PlaceOfResidence;

	@Column(name="PLACEOF_STUDYING")
	private String PlaceOfStudying;

	@Column(name="DEPARTMENT")
	private String Department;

	@Column(name="YEAROFATTENCANCE")
	private int YearOfAttendance;

	@Column(name="FAMILY_STATUS")
	private String FamilyStatus;

	@Column(name="NUMBER_OF_SIBLINGS_STUDYING")
	private int SiblingsStudying;

	@Column(name="ANNUAL_FINANCIAL_FAMILY_INCOME")
	private String AnnualIncome;

	@Column(name="NUMBER_OF_UNEMPLOYED_PARENTS")
	private int UnemployedParents;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getPlaceOfResidence() {
		return PlaceOfResidence;
	}

	public void setPlaceOfResidence(String placeOfResidence) {
		PlaceOfResidence = placeOfResidence;
	}

	public String getPlaceOfStudying() {
		return PlaceOfStudying;
	}

	public void setPlaceOfStudying(String placeOfStudying) {
		PlaceOfStudying = placeOfStudying;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public int getYearOfAttendance() {
		return YearOfAttendance;
	}

	public void setYearOfAttendance(int yearOfAttendance) {
		YearOfAttendance = yearOfAttendance;
	}

	public String getFamilyStatus() {
		return FamilyStatus;
	}

	public void setFamilyStatus(String familyStatus) {
		FamilyStatus = familyStatus;
	}

	public int getSiblingsStudying() {
		return SiblingsStudying;
	}

	public void setSiblingsStudying(int siblingsStudying) {
		SiblingsStudying = siblingsStudying;
	}

	public String getAnnualIncome() {
		return AnnualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		AnnualIncome = annualIncome;
	}

	public int getUnemployedParents() {
		return UnemployedParents;
	}

	public void setUnemployedParents(int unemployedParents) {
		UnemployedParents = unemployedParents;
	}

	public AllSubmittedForms() {
	}

	public AllSubmittedForms(String fname, String lname, String email, int phoneNumber,
			String placeOfResidence, String placeOfStudying, String department, int yearOfAttendance,
			String familyStatus, int siblingsStudying, String annualIncome, int unemployedParents) {
		super();
		//this.username = username;
		Fname = fname;
		Lname = lname;
		Email = email;
		PhoneNumber = phoneNumber;
		PlaceOfResidence = placeOfResidence;
		PlaceOfStudying = placeOfStudying;
		Department = department;
		YearOfAttendance = yearOfAttendance;
		FamilyStatus = familyStatus;
		SiblingsStudying = siblingsStudying;
		AnnualIncome = annualIncome;
		UnemployedParents = unemployedParents;
	}

	@Override
	public String toString() {
		return "AllSubmittedForms [username=" + username + ", Fname=" + Fname + ", Lname=" + Lname + ", Email=" + Email
				+ ", PhoneNumber=" + PhoneNumber + ", PlaceOfResidence=" + PlaceOfResidence + ", PlaceOfStudying="
				+ PlaceOfStudying + ", Department=" + Department + ", YearOfAttendance=" + YearOfAttendance
				+ ", FamilyStatus=" + FamilyStatus + ", SiblingsStudying=" + SiblingsStudying + ", AnnualIncome="
				+ AnnualIncome + ", UnemployedParents=" + UnemployedParents + "]";
	}

}

package dit.hua.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {

	@Id // this annotation shows the primary key of the table
	@Column(name = "USERNAME")
	protected String username;

	@Column(name = "PASSWORD")
	protected String password;

	@Column(name = "ENABLED")
	protected int enabled;
	
	@Column(name = "DEPARTMENT")
	protected String department;

	// TABLE:AUTHORITIES: USERNAME : FK -> TABLE:USERS:USERNAME
	// mapping: one to one //instead of manual join
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "USERNAME") // field of table: AUTHORITIES
	private Authorities authorities;

	// TABLE:SubmittedForm_Diat: USERNAME : FK -> TABLE:USERS:USERNAME
	// mapping: one to one  //instead of manual join
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "USERNAME") // field of table: SubmittedForm_Diat
	private SubmittedForm_Diat submittedForm_Diat;

	// TABEL:SubmittedForm_Geo: USERNAME : FK -> TABLE:USERS:USERNAME
	// mapping: one to one //instead of manual join
	@OneToOne(fetch=FetchType.EAGER ) //, cascade={CascadeType.DETACH}) //, cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "USERNAME") // field of table: SubmittedForm_Geo
	private SubmittedForm_Geo submittedForm_Geo;

	// TABEL:SubmittedForm_Oik: USERNAME : FK -> TABLE:USERS:USERNAME
	// mapping: one to one //instead of manual join
	@OneToOne(fetch=FetchType.EAGER) //, cascade={CascadeType.DETACH}) //, cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "USERNAME") // field of table: SubmittedForm_Oik
	private SubmittedForm_Oik submittedForm_Oik;

	// TABEL:SubmittedForm_Plir: USERNAME : FK -> TABLE:USERS:USERNAME
	// mapping: one to one //instead of manual join
	@OneToOne(fetch=FetchType.EAGER)//, cascade={CascadeType.DETACH}) //, cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "USERNAME") // field of table: SubmittedForm_Plir
	private SubmittedForm_Plir submittedForm_Plir; //SubmittedForm_Plir submittedForm_Plir;         //List<SubmittedForm_Plir> submittedForm_Plir;	
	

	public Users() { // public empty default constructor

	}

	public Users(String username, String password, int enabled, Authorities authorities) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	public Users(String username, String password, int enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public Users(String username,String department) {
		super();
		this.username = username;
		this.department=department;
	}
	
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


	
	public SubmittedForm_Plir getSubmittedForm_Plir() {
		return submittedForm_Plir;
	}

	public void setSubmittedForm_Plir(SubmittedForm_Plir submittedForm_Plir) {
		this.submittedForm_Plir = submittedForm_Plir;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", enabled=" + enabled + ", department="
				+ department + "]";
	}


}

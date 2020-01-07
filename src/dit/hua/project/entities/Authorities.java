package dit.hua.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authorities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    //for autoincrement 
	@Column(name = "ID")
	private int id;
	
	@Column(name = "AUTHORITY")
	private String authority;

//	@ManyToOne                                         //annotation for foreign key  in users.java
//	@JoinColumn(name = "USERNAME")
//	private Users username;
	
	public Authorities() {  //empty default constructor
	
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Users getUsername() {
//		return username;
//	}
//
//	public void setUsername(Users username) {
//		this.username = username;
//	}

}

	
	
	
	
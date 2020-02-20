package dit.hua.project.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "FINALRANKING_GEO")
public class Final_Ranking_Geo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@Id                       //primary key 
	@Column(name = "ID")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)   //autoincrement     
	protected int id;
	
	@Column(name = "FNAME")
	protected String fname;
	
	@Column(name = "LNAME")
	protected String lname;

	@Column(name = "POINTS")
	protected int points;
	
	@Column(name = "username")
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public Final_Ranking_Geo() {
		super();
		
	}
	public Final_Ranking_Geo(int id, String fname, String lname, int points) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.points = points;
	}


	public Final_Ranking_Geo(String fname, String lname, int points, String username) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.points = points;
		this.username = username;
	}

	public Final_Ranking_Geo(String fname, String lname, int points) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.points = points;
	}
	
	
	@Override
	public String toString() {
		return "Final_Ranking_Geo [id=" + id + ", fname=" + fname + ", lname=" + lname + ", points=" + points
				+ ", username=" + username + "]";
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}

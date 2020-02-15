package dit.hua.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FINALRANKING_OIK")
public class Final_Ranking_Oik implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id                       //primary key 
	@Column(name = "ID")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)   //autoincrement     
	private int id;
	
	@Column(name = "FNAME")
	private String fname;
	
	@Column(name = "LNAME")
	private String lname;

	@Column(name = "POINTS")
	private int points;
	
	public Final_Ranking_Oik(){
		super();
	}

	public Final_Ranking_Oik(int id, String fname, String lname, int points) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.points = points;
	}

	public Final_Ranking_Oik(String fname, String lname, int points) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.points = points;
	}
	

	@Override
	public String toString() {
		return "Final_Ranking_Oik [id=" + id + ", fname=" + fname + ", lname=" + lname + ", points=" + points + "]";
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

package dit.hua.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FINALRANKING_DIAT")
public class Final_Ranking_Plir {
	
	@Id                       //primary key 
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)   //autoincrement     
	protected String id;
	
	@Column(name = "FNAME")
	protected String fname;
	
	@Column(name = "LNAME")
	protected String lname;

	@Column(name = "POINTS")
	protected int points;
	
	Final_Ranking_Plir(){}
	public Final_Ranking_Plir(String fname, String lname, int  points) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.points = points;
	}

	@Override
	public String toString() {
		return "Final_Ranking_Plir [id=" + id + ", fname=" + fname + ", lname=" + lname + ", points=" + points + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public void setPoints(int  points) {
		this.points = points;
	}
	

}

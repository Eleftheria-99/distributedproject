package dit.hua.project.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "FINALRANKING_DIAT")
public class Final_Ranking_Diat implements Serializable{
	
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
	
	
	public Final_Ranking_Diat() {
		super();
		
	}
	public Final_Ranking_Diat(int id, String fname, String lname, int points) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.points = points;
	}

	public Final_Ranking_Diat(String fname, String lname, int points) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.points = points;
	}

	@Override
	public String toString() {
		return "Final_Ranking_Diat [id=" + id + ", fname=" + fname + ", lname=" + lname + ", points=" + points + "]";
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

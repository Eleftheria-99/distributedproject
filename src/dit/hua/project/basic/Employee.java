package dit.hua.project.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee extends User implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected int idE;
 protected String DepartmentManager;
 
   
 
 public int getIdE() {
	return idE;
}
public void setIdE(int idE) {
	this.idE = idE;
}
public String getDepartmentManager() {
	return DepartmentManager;
}
public void setDepartmentManager(String departmentManager) {
	DepartmentManager = departmentManager;
}

protected List<Student> ShowList() {
	 List<Student> list=new ArrayList<Student>();
	 return list;
 }
 protected int CountPoints() {
	 return 0;
 }
 protected boolean DeclineForm() {
	 
	 boolean decline = true;
	 
	 return decline;
 }
 protected boolean AcceptForm() {
	 boolean accept = true;
	 
	 return accept;
 }
 protected List<Student> SeeSubmittedForms(){
	 List<Student> list=new ArrayList<Student>();
	 return list;
 }
 
 protected void computeResults() { }
 
 
 
}

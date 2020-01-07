package dit.hua.project.basic;

public class Supervisor extends Employee {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int LimitOfAcceptedStudents ;
	protected int yearlyNumberOfTheStudents; 
	
	
	
	protected int ComputeLimit(int yearlyNumberOfTheStudents) { //missing return type in class diagram
//computes and returns the number of the students that can have free meals
		
		return LimitOfAcceptedStudents;
	}
}

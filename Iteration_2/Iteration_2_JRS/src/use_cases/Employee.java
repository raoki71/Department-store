// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package use_cases;

import java.util.ArrayList;
import java.util.HashMap;


public class Employee{
	private int employeeId;
	private String name;
	private String position;
	private double salary;
	private ArrayList<HashMap<String, Object>> promotionHistory;

	public Employee(int employeeId, String name, String position, double salary){
	    this.employeeId = employeeId;
	    this.name = name;
	    this.position = position;
	    this.salary = salary;
	    this.promotionHistory = new ArrayList<>();
	}

	public void promote(String newPosition, double newSalary){
	    HashMap<String, Object> record = new HashMap<>();
	    record.put("oldPosition", this.position);
	    record.put("newPosition", newPosition);
	    record.put("oldSalary", this.salary);
	    record.put("newSalary", newSalary);
	    promotionHistory.add(record);
	
	    this.position = newPosition;
	    this.salary = newSalary;
	    System.out.println(name + " promoted to " + newPosition + " with salary $" + newSalary);
	}

	public void pay(){
	    System.out.println("Paying " + name + " $" + salary);
	    }
	
	    public String getName(){ 
	    	return name; 
	    }
	    
	    public String getPosition(){
	    	return position;
	    }
	    public double getSalary(){ 
	    	return salary;
	    }
}

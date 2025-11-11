package clean_store;
public abstract class Employee {
	protected String name;
	protected double salary;
	protected String role;
	
	public Employee(String name, double salary, String role) {
		this.name = name;
		this.salary = salary;
		this.role = role;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalaryInfo() {
		return salary;
	}
	
	public String getRole() {
		return role;
	}
}

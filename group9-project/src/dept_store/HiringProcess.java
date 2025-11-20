// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package dept_store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class HiringProcess{
	private ArrayList<Employee> employees;

    public HiringProcess(){
    	employees = new ArrayList<>();
    }
    public Employee hireCandidate(Candidate c){
        if (!c.isQualified()){
            System.out.println(c.getName() + " not qualified, cannot hire.");
            return null;
        }
        int employeeId = assignEmployeeId(c.getAppliedDepartment());
        double salary = assignSalary(c.getAppliedDepartment());
        Employee emp = new Employee(employeeId, c.getName(), c.getAppliedDepartment(), salary);
        employees.add(emp);
        System.out.println(c.getName() + " hired as " + c.getAppliedDepartment() + " with ID " + employeeId);
        return emp;
    }

    private int assignEmployeeId(String dept){
        switch (dept){
            case "Boss": return employees.size(); // 0-99
            case "Manager": return 100 + employees.size();
            case "Shoes": return 200 + employees.size();
            default: return 900 + employees.size();
        }
    }

    private double assignSalary(String dept){
        switch (dept){
            case "Boss": return 70000;
            case "Manager": return 50000;
            case "Shoes": return 30000;
            default: return 25000;
        }
    }
    public ArrayList<Employee> getEmployees(){
    	return employees;
	}


}

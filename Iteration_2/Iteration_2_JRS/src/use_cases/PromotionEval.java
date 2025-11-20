// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package use_cases;

public class PromotionEval{
	 public boolean canPromote(Employee emp, boolean appliedForHigherPosition, int yearsWorked, boolean reliable){
	        if (!reliable){
	            System.out.println(emp.getName() + " is not reliable.");
	            return false;
	        }
	        if (yearsWorked < 2){
	            System.out.println(emp.getName() + " has not worked long enough.");
	            return false;
	        }
	        if (!appliedForHigherPosition){
	            System.out.println(emp.getName() + " did not apply for higher position.");
	            return false;
	        }
	        return true;
	    }

	    public void promoteEmployee(Employee emp, String newPosition, double newSalary, boolean applied, int yearsWorked, boolean reliable){
	        if (canPromote(emp, applied, yearsWorked, reliable)){
	            emp.promote(newPosition, newSalary);
	        }
	    }
}

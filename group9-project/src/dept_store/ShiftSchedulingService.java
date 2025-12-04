// Melanie Wenz
package dept_store;

import java.util.ArrayList;
import java.util.List;

public class ShiftSchedulingService {
     // Hiring Manager picks an employee and tries to assign them to a shift
    public boolean assignEmployeeToShift(Employee e, Shift shift, ShiftSchedule schedule) {
        // Make sure the employee can work the shift
        if (!e.canWorkShift(shift)) {
            return false;
        }

        // Make sure there are no conflicts
        for (Shift s : schedule.getShiftsForEmployee(e.getId())) {
            if (s.conflictsWith(shift)) {
                return false;
            }
        }

        // Assign employee to the shift
        shift.assignEmployee(e);
        return true;
    }

    // Determines which employees are eligible for a shift
    public List<Employee> getEligibleEmployees(Shift shift, List<Employee> employees, ShiftSchedule schedule) {
        List<Employee> eligible = new ArrayList<>();

        for (Employee e : employees) {
            // Check if the employee can work the shift
            if (!e.canWorkShift(shift)) continue;

            // Check conflicts
            boolean conflict = false;
            for (Shift s : schedule.getShiftsForEmployee(e.getId())) {
                if (s.conflictsWith(shift)) {
                    conflict = true;
                    break;
                }
            }

            if (!conflict) {
                eligible.add(e);
            }
        }

        return eligible;
    }

}

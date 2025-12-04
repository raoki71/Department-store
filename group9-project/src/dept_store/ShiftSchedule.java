// Melanie Wenz
package dept_store;

import java.util.ArrayList;
import java.util.List;

public class ShiftSchedule {
     private List<Shift> shifts = new ArrayList<>();

    public void addShift(Shift shift) {
        shifts.add(shift);
    }

    public List<Shift> getAllShifts() {
        return shifts;
    }

    public List<Shift> getOpenShifts() {
        List<Shift> result = new ArrayList<>();
        for (Shift s : shifts) {
            if (s.isOpen()) result.add(s);
        }
        return result;
    }

    public List<Shift> getShiftsForEmployee(int employeeId) {
        List<Shift> result = new ArrayList<>();
        for (Shift s : shifts) {
            if (employeeId == s.getAssignedEmployeeId()) {
                result.add(s);
            }
        }
        return result;
    }

   // Lists out all the shifts
   public void printSchedule() {
        for (Shift s : shifts) {
            System.out.println(s);
        }
    }
}

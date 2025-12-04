// Melanie Wenz
package dept_store;

import java.time.LocalDateTime;

public class Shift {
    private String id, department, role;
    private int assignedEmployeeId;
    private LocalDateTime startTime, endTime;

   public Shift(String id, LocalDateTime startTime, LocalDateTime endTime, String role, String department) {
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("Shift end time cannot be before start time.");
        }
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.role = role;
        this.department = department;
        this.assignedEmployeeId = -1;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public int getAssignedEmployeeId() {
        return assignedEmployeeId;
    }

   public boolean isOpen() {
        return assignedEmployeeId == -1;
   }

   public void assignEmployee(Employee e) {
        this.assignedEmployeeId = e.getId();
    }

    public boolean conflictsWith(Shift other) {
        return !(endTime.isBefore(other.startTime) || startTime.isAfter(other.endTime));
    }

    @Override
    public String toString() {
        return role + " - " + department + " from " + startTime + " to " + endTime + " -> assigned to " + assignedEmployeeId;
    }

}

package dept_store;

import java.time.*;
import java.util.*;

public class AvailabilityAndSchedulingDemo {
    public static void main(String[] args) {
        // Create employees
        Employee alice = new Employee(1, "Alice", "Cashier", 15.0);
        Employee bob = new Employee(2, "Bob", "Stock", 14.0);

        // Set availability for employees
        // Alice can work Tuesdays from 10:00 to 14:00
        alice.getAvailability().addWeeklySlot(
            new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(14, 0))
        );

        // Bob can work Tuesdays from 15:00 to 20:00
        bob.getAvailability().addWeeklySlot(
            new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(15, 0), LocalTime.of(20, 0))
        );

        List<Employee> employees = Arrays.asList(alice, bob);

        // Print out each employee's availability:
        System.out.println("Employee Availabilities:");
        for (Employee e : employees) {
            System.out.println(e.getName() + " (" + e.getPosition() + "): " + e.getAvailability());
        }
        System.out.println();



        // Create shifts that need to be filled (in this demo it is 2 shifts to be filled on a Tuesday)
        LocalDate shiftDate = LocalDate.of(2025, 12, 2); // Tuesday
        Shift shift1 = new Shift("shift1",
                LocalDateTime.of(shiftDate, LocalTime.of(10, 0)),
                LocalDateTime.of(shiftDate, LocalTime.of(14, 0)),
                "Cashier",
                "FrontEnd");

        Shift shift2 = new Shift("shift2",
                LocalDateTime.of(shiftDate, LocalTime.of(15, 0)),
                LocalDateTime.of(shiftDate, LocalTime.of(20, 0)),
                "Stock",
                "BackEnd");

        shift1.toString();
        shift2.toString();

        // Create schedule and add the shifts to it
        ShiftSchedule schedule = new ShiftSchedule();
        schedule.addShift(shift1);
        schedule.addShift(shift2);

        // Assign employees to shifts in the schedule
        ShiftSchedulingService scheduler = new ShiftSchedulingService();

        for (Shift s : schedule.getOpenShifts()) {
            List<Employee> eligible = scheduler.getEligibleEmployees(s, employees, schedule);
            System.out.println("Eligible for " + s.getId() + ": " + eligibleNames(eligible));
            if (!eligible.isEmpty()) {
                boolean assigned = scheduler.assignEmployeeToShift(eligible.get(0), s, schedule);
                System.out.println("Assigned " + (assigned ? eligible.get(0).getName() : "none") + " to " + s.getId());
            } else {
                System.out.println("No eligible employees for " + s.getId());
            }
        }

        // Print the final schedule
        System.out.println("\nSchedule:");
        for (Shift s : schedule.getAllShifts()) {
            String empName = "-";
            if (s.getAssignedEmployeeId() != -1) {
                for (Employee e : employees) {
                    if (e.getId() == s.getAssignedEmployeeId()) empName = e.getName();
                }
            }
            System.out.println(s.getRole() + " - " + s.getDepartment() +
                    " from " + s.getStartTime() + " to " + s.getEndTime() +
                    " -> assigned to " + empName);
        }
    }

    private static String eligibleNames(List<Employee> list) {
        if (list.isEmpty()) return "None";
        StringBuilder sb = new StringBuilder();
        for (Employee e : list) sb.append(e.getName()).append(" ");
        return sb.toString().trim();
    }
}
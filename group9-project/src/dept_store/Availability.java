// Melanie Wenz
package dept_store;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Availability {
    private List<TimeSlot> weeklySlots = new ArrayList<>();
    private Map<LocalDate, TimeSlot> specialDates = new HashMap<>();

    // Add a time slop of availability to the weekly slots (general availability)
    public void addWeeklySlot(TimeSlot slot) {
        weeklySlots.add(slot);
    }

    // Add special availability (A specific date/time employee is available that does not include general availability)
    public void addSpecialDate(LocalDate date, TimeSlot slot) {
        specialDates.put(date, slot);
    }

    // Checks if employee is available given the date/times
    public boolean isAvailable(LocalDateTime start, LocalDateTime end) {
        // See if there is a special time slot that includes the start date/time
        TimeSlot special = specialDates.get(start.toLocalDate());
        // See if the special time slot covers the entire range
        if (special != null) {
            return special.includes(start, end);
        }
        // If there is not special time slot covering it, check general availability
        return weeklySlots.stream().anyMatch(slot -> slot.includes(start, end));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Weekly: ").append(weeklySlots).append(", Special: {");
    
        for (Map.Entry<LocalDate, TimeSlot> entry : specialDates.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }
        if (!specialDates.isEmpty()) sb.setLength(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }

}

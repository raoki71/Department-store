// Melanie Wenz
package dept_store;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeSlot {
    private DayOfWeek day;
    private LocalTime start;
    private LocalTime end;

    public TimeSlot(DayOfWeek day, LocalTime start, LocalTime end) {
        if (end.isBefore(start)){
            throw new IllegalArgumentException("Time slot end time cannot be before start time.");
        }
        this.day = day;
        this.start = start;
        this.end = end;
    }

    // Checks if a given start/end time is within the time slot
    public boolean includes (LocalDateTime startTime, LocalDateTime endTime){
        if (!day.equals(startTime.getDayOfWeek())) return false;

    LocalTime slotStart = this.start;
    LocalTime slotEnd = this.end;
    LocalTime startLocal = startTime.toLocalTime();
    LocalTime endLocal = endTime.toLocalTime();

    return !startLocal.isBefore(slotStart) && !endLocal.isAfter(slotEnd);
    }

    @Override
    public String toString() {
        return day + " " + start + "-" + end;
    }
}

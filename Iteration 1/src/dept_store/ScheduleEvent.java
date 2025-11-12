package dept_store;

import java.sql.Time;

public interface ScheduleEvent {
	public void schedule(Weekday weekday, Time startTime, Time endTime);
	public void unschedule(Weekday weekday, Time startTime, Time endTime);
}

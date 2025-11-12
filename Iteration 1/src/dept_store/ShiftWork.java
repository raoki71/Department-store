package dept_store;
import java.sql.Time;
import java.util.Date;

public class ShiftWork implements ScheduleEvent {
	private OperatingHours operatingHours;
	private Weekday weekday;
	private Time startTime;
	private Time endTime;
	private boolean isSlotAvailable;
	
	public ShiftWork() {
		isSlotAvailable = true;
	}
	
	public void schedule(Weekday weekday, Time startTime, Time endTime) {
		this.weekday = weekday;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public void unschedule(Weekday weekday, Time startTime, Time endTime) {
		if(this.weekday==weekday && this.startTime==startTime && this.endTime==endTime ) {
			this.weekday = null;
			this.startTime = null;
			this.endTime = null;
		}
	}
	
	public void assignShift(Employee employee) {
		if(isSlotAvailable) {
			System.out.println(employee.getName() + " is assigned to the slot: " 
		+ weekday + " from " + startTime + " to " + endTime);
		}
		isSlotAvailable = false;
	}
	
	public void moveShift(Employee employee) {
		
	}
}

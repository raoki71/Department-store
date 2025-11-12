package dept_store;


import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OperatingHours {
//	private Date[] operatingDates;
	private Weekday[] weekdays;
	private Time startTime;
	private Time endTime;
	
	public OperatingHours(Time startTime, Time endTime) {
		weekdays = new Weekday [7];
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Time getStartTime() {
 		return startTime;
	}
	
	public Time getEndTime() {
		return endTime;
	}
	
	public Weekday[] getWeekdays() {
		return weekdays;
	}
	
	public void setWeekdays(Weekday weekday) {
		for(int i=0; i<7; i++) {
			if(weekdays[i]==null) {
				weekdays[i] = weekday;
				break;
			}
		}
	}
	
	public void formatSchedule() {
		System.out.println("\t\tSun\tMon\tTue\tWed\tThu\tFri\tSat\n");
		System.out.println("Start:\n");
		System.out.println("End:\n");
		for(int i=0; i<7; i++) {
			System.out.println();
		}
	}
}

enum Weekday { Sun, Mon, Tue, Wed, Thu, Fri, Sat };


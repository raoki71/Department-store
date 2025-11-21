package dept_store;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Schedule {

    private String type; // "Interview" or "Work"
    private String participant1;
    private String participant2; // optional : can be blank for work
    private String department;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    private ArrayList<Schedule> schedList;
	private Weekday weekday;
	
	public Schedule(Weekday weekday, LocalDateTime startTime, LocalDateTime endTime) {
		this.weekday = weekday;
		this.startTime = startTime;
		this.endTime = endTime;
		schedList = new ArrayList<>();
	}

	public Schedule(String type, String participant1, String participant2, String department, LocalDateTime startTime, LocalDateTime endTime) {
        this.type = type;
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.department = department;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public void displaySchedule() {
        System.out.println(type + " for " + participant1 + 
        				  (participant2.isEmpty() ? "" : " with " + participant2) + 
        				  " in " + department + " from " + startTime + " to " + endTime);
    }
    
    /**
	 * This method verifies that today is operation day or not
	 * @return true if today is open day and false if close day
	 */
	public boolean getToday() {
		Schedule sched = null;
		int i = 0;
		for(Schedule s: schedList) {
			if(s!=null) {
				sched = schedList.getFirst();
				break;
			}
		}
		return (sched!=null) ? true : false;
	}
	
	/**
	 * This method add given schedule to the list of Schedules schedList
	 * @param sched
	 */
	public void addSchedule(Schedule sched) {
		schedList.add(sched);
	}
}

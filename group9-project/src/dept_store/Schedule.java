// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package dept_store;

import java.time.LocalDateTime;

public class Schedule{

	    private String type; // "Interview" or "Work"
	    private String participant1;
	    private String participant2; // optional : can be blank for work
	    private String department;
	    private LocalDateTime startTime;
	    private LocalDateTime endTime;

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
}


package dept_store;


import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Rei Aoki
 * 
 * OpenHours is the Information Expert that knows Schedule
 */
public class OpenHours {
	// This array stores the Open weekdays of the department store
	private Weekday[] weekdays;
	private LocalTime startTime;
	private LocalTime endTime;
	
	private Store store=null;
	private LocalTime currentTime=null;
	
	/**
	 * Arbitrary constructor without any arguments
	 */
	public OpenHours() {
		this.startTime = LocalTime.of(9,0);
		this.endTime = LocalTime.of(18,0);
	}
	
	/**
	 * Constructor with specific set start and end time of the department store
	 * @param startTime
	 * @param endTime
	 */
	public OpenHours(LocalTime startTime, LocalTime endTime) {
		weekdays = new Weekday [7];
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * This method retrieves the start time of the department store
	 * @return - the Time object specified by (hour, min, sec)
	 */
	public LocalTime getStartTime() {
 		return startTime;
	}
	
	/**
	 * This method retrieves the end time of the department store
	 * @return - the Time object specified by (hour, min, sec)
	 */
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public boolean changeTime(LocalTime time) {
		this.currentTime = time;
		if(currentTime!=null)
			return false;
		return true;
	}
	/**
	 * This method adds the working dates to the data array
	 * @param weekday
	 */
	public void setWeekdays(Weekday weekday) {
		for(int i=0; i<7; i++) {
			if(weekdays[i]==null) {
				weekdays[i] = weekday;
				break;
			}
		}
	}
	
	/**
	 * This method calls a open() and close() methods from the Store instance to set the operation hours.
	 * 
	 * @param sched
	 * @return - returns true if successfully open/close the store and false if there is no associated schedule
	 */
	public boolean controlOpenHours(Schedule sched) {
		Store store = this.getStoreInstance();
		if(sched!=null) {
			if(currentTime.isBefore(getStartTime())){
				System.out.println("===============================================");
				System.out.println("Store is successfully opened: Time is " + getStartTime());
				System.out.println("-----------------------------------------------");
				System.out.println();
				return store.openStore(sched);
			} else if(currentTime.isAfter(getEndTime())) {
				System.out.println();
				System.out.println("-----------------------------------------------");
				System.out.println("Store is successfully closed: Time is " + getEndTime());
				System.out.println("===============================================");
				return store.closeStore(sched);
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Method used to instantiate the new Schedule object in the adding or changing the operation
	 * @return - return Schedule object
	 */
	private Store getStoreInstance() {
		if(store==null) 
			store = new Store();
		return store;
	}
}

enum Weekday { Sun, Mon, Tue, Wed, Thu, Fri, Sat };


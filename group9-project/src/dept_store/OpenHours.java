package dept_store;


import java.sql.Time;

/**
 * @author Rei Aoki
 * 
 * OpenHours is the Information Expert that knows Schedule
 */
public class OpenHours {
	// This array stores the Open weekdays of the department store
	private Weekday[] weekdays;
	private Time startTime;
	private Time endTime;
	
	private Store store=null;
//	public Time currentTime;
	
	/**
	 * Arbitrary constructor without any arguments
	 */
	public OpenHours() {
		this.startTime = new Time(9,0,0);
		this.endTime = new Time(18,0,0);
	}
	
	/**
	 * Constructor with specific set start and end time of the department store
	 * @param startTime
	 * @param endTime
	 */
	public OpenHours(Time startTime, Time endTime) {
		weekdays = new Weekday [7];
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * This method retrieves the start time of the department store
	 * @return - the Time object specified by (hour, min, sec)
	 */
	public Time getStartTime() {
 		return startTime;
	}
	
	/**
	 * This method retrieves the end time of the department store
	 * @return - the Time object specified by (hour, min, sec)
	 */
	public Time getEndTime() {
		return endTime;
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
		Time currentTime = new Time(8,59,0);
		Store store = this.getStoreInstance();
		if(sched!=null) {
			if(currentTime.getTime() <= store.getStartTime().getTime()) {
				System.out.println("Store is successfully opened");
				return store.openStore(sched);
			} else if(currentTime.getTime() >= store.getEndTime().getTime()) {
				System.out.println("Store is successfully closed");
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


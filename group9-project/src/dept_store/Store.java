package dept_store;

import java.sql.Time;

public class Store implements StoreInterface{
	String name;
//	Address address;
	
	/**
	 * This method retrieves Time object that contains the start time of the department store.
	 * @return - Time object set to 9am
	 */
	public Time getStartTime() {
		return new Time(9,0,0);
	}
	
	/**
	 * This method retrieves the Time object that contains the end time of the department store.
	 * @return - Time object set to 6pm
	 */
	public Time getEndTime() {
		return new Time(18,0,0);
	}
	
	/**
	 * This method effectively opens the department store using assigned sched.
	 * @param - sched
	 * @return - true if the store is successfully opened and false the sched is not available
	 */
	public boolean openStore(Schedule sched) {
		//TODO: sched	
		if(sched!=null)
			return true;
		else
			return false;
	}
	
	/**
	 * This method effectively closes the department store using assigned sched.
	 * @param - sched
	 * @return - true if the store is successfully closed and false the sched is not available
	 */
	public boolean closeStore(Schedule sched) {
		//TODO: sched
		if(sched!=null)
			return true;
		else
			return false;
	}
}

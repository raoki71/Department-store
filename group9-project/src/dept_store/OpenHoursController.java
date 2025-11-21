package dept_store;

import java.sql.Time;
import java.util.Calendar;

/**
 * @author Rei Aoki
 * 
 * 
 */
public class OpenHoursController implements OpenHoursControllerInterface {
	// Stores an instance of Schedule object necessary for controlling the Open Hours.
	private OpenHours openHours = null;
	
	
	
	/**
	 *	This method initiates the open/close store operation by more general controlling means. By checking the given
	 *	schedule it verifies the validity of the operation.
	 *
	 *	@param sched - schedule appointed
	 *	@return - return true if the operation succeeds and false otherwise
	 */
	public boolean controlOpenHours(Schedule sched) {
		return this.getOpenHoursInstance().controlOpenHours(sched);
	}
	
	private OpenHours getOpenHoursInstance() {
		if(openHours==null)
			openHours=new OpenHours();
		return openHours;
	}
}

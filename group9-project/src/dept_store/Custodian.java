package dept_store;

import java.sql.Time;
import java.util.ArrayList;

public class Custodian extends Employee {
	
	private ArrayList<String> cleaningTools;
	private ShiftWork shiftwork;

	public Custodian(int employeeId, String name, String position, double salary) {
		super(employeeId, name, position, salary);
		cleaningTools = new ArrayList<>();
		cleaningTools.add("Scrubber Machine");
		cleaningTools.add("Mop");
		cleaningTools.add("Water Bucket");
	}
	
	public void checkInShift(ShiftWork shiftWork) {
		this.shiftwork = shiftWork;
		System.out.println(name + " checks in the shift hour.");
	}
	
	public void checkOutShift(ShiftWork shiftWork) {
		this.shiftwork = null;
		System.out.println(name + " checks out the shift");
	}
	
	public String getCleaningTools() {
		String tool = "";
		int i = 0;
		while(cleaningTools!=null) {
			if(cleaningTools!=null) {
				tool = cleaningTools.get(i);
				cleaningTools.remove(i);
				break;
			}
			i++;
		}
		System.out.println(name + " gets " + tool);
		return tool;
	}
	
	public void returnCleaningTools(String tool) {
		cleaningTools.add(tool);
		System.out.println(tool + " is returned");
	}
	
	public void cleanArea(FloorMap floorMap) {
		System.out.println(name + " cleans section " + floorMap.getSection() + " at " +floorMap.getFloor());
	}
}

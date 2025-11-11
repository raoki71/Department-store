package clean_store;

import java.sql.Time;
import java.util.ArrayList;

public class Custodian extends Employee {
	
	private ArrayList<String> cleaningTools;
	private ShiftWork shiftwork;

	public Custodian(String name, double salary, String role) {
		super(name, salary, role);
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
	
//	public void accessArea(FloorMap floorMap) {
//		
//	}
	
	public void cleanArea(FloorMap floorMap) {
		System.out.println(name + " cleans section " + floorMap.getSection() + " at " +floorMap.getFloor());
	}
	
//	public static void main(String[] args) {
//		Custodian custodian = new Custodian("John", 120, "cleaner");
//		ShiftWork shiftwork = new ShiftWork();
//		Time startTime = new Time(17, 0, 0);
//		Time endTime = new Time(19, 0, 0);
//		shiftwork.schedule(Weekday.Mon, startTime, endTime);
//		shiftwork.assignShift(custodian);
//		custodian.checkInShift(shiftwork);
//		FloorMap floorMap = new FloorMap("1F", Direction.W, 38);
//		String tool = custodian.getCleaningTools();
//		custodian.cleanArea(floorMap);
//		custodian.returnCleaningTools(tool);
//		custodian.checkOutShift(shiftwork);
//		
//	}
}

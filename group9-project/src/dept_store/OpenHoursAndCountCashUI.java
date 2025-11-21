package dept_store;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OpenHoursAndCountCashUI {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalTime time = LocalTime.of(9, 0);
		LocalDateTime startTime = LocalDateTime.of(2025, 11, 20, 9, 0);
		LocalDateTime endTime = LocalDateTime.of(2025, 11, 20, 18, 0);
		Schedule sched = new Schedule(Weekday.Mon, startTime, endTime);
		sched.addSchedule(sched);
		
		OpenHoursController opController = new OpenHoursController();
		OpenHours opHours = new OpenHours();
//		opHours.currentTime = new Time(8,59,0);
		opController.controlOpenHours(sched);
		RegisterDatabase regDatabase = new RegisterDatabase();
		Cash cash = new Cash();
		cash.addAmount(1000.0, false); // Add physical type of cash
		System.out.println("Add Physical cash: $1,000");
		cash.addAmount(3000.50, true); // Add digital type of cash
		System.out.println("Add Digital cash: $8,000.40");
		try {
			regDatabase.addCash(cash, "Reg01");
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		opController.controlOpenHours(sched);
		
//		public static void main(String[] args) {
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
//	}
		
	}
}

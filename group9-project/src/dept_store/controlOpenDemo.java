package dept_store;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class controlOpenDemo {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDateTime startTime = LocalDateTime.of(2025, 11, 20, 9, 0);
		LocalDateTime endTime = LocalDateTime.of(2025, 11, 20, 18, 0);
		
		// Schedule the event; in this case the operating hours of the Department Store on Monday
		Schedule sched = new Schedule(Weekday.Mon, startTime, endTime);
		sched.addSchedule(sched);
		
		// Initialize the contoller for operating store
		OpenHoursController opController = new OpenHoursController();
		OpenHours opHours = new OpenHours();
		
		// Assume the time becomes close to 9:00am
		opController.changeTime(LocalTime.of(8, 55));
		
		// Open the store
		opController.controlOpenHours(sched);
		
		
		RegisterDatabase regDatabase = new RegisterDatabase();
		Cash cash = new Cash();
		System.out.println();
		System.out.println("---Reg01 gets amounts of cash---");
		cash.addAmount(1000.0, false); // Add physical type of cash
		cash.addAmount(3000.50, true); // Add digital type of cash
		
		System.out.println();
		System.out.println("---Reg02 gets amounts of cash---");
		Cash cash2 = new Cash();
		cash2.addAmount(500, true); // Digital
		cash2.addAmount(400.36, true); // Digital
		System.out.println();
		try {
			regDatabase.addCash(cash, "Reg01");
			regDatabase.addCash(cash2, "Reg02");
			
			regDatabase.countCash("Reg01");
			regDatabase.countCash("Reg02");
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		// Assume the time has passed
		opController.changeTime(LocalTime.of(18, 5));
		
		// Close the store
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

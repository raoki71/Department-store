// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package use_cases;

import java.time.LocalDateTime;

public class InterviewHireSim {

	public class Main {
	    public static void main(String[] args) {
	        Candidate alice = new Candidate("Alice", 25, "Shoes");
	        Candidate bob = new Candidate("Bob", 30, "Manager");

	        // Interviewing
	        InterviewProcess interviews = new InterviewProcess();
	        String[] shoesKeywords = {"sales", "customer service", "footwear"};
	        interviews.evaluateCandidateFile(alice, "alice_resume.txt", shoesKeywords);
	        interviews.conductInterview(alice, 85);

	        String[] managerKeywords = {"leadership", "management"};
	        interviews.evaluateCandidateFile(bob, "bob_resume.txt", managerKeywords);
	        interviews.conductInterview(bob, 60);

	        // Hiring
	        HiringProcess hiring = new HiringProcess();
	        Employee empAlice = hiring.hireCandidate(alice);
	        Employee empBob = hiring.hireCandidate(bob);
	        
	        // Scheduling interviews
	        Schedule interviewSchedule = new Schedule(
	            "Interview", alice.getName(), "Manager Bob", "Shoes",
	            LocalDateTime.of(2025, 11, 20, 10, 0),
	            LocalDateTime.of(2025, 11, 20, 11, 0)
	        );
	        interviewSchedule.displaySchedule();
	        // Scheduling work shift
	        Schedule shiftAlice = new Schedule(
	            "Work", empAlice.getName(), "", "Shoes",
	            LocalDateTime.of(2025, 11, 21, 9, 0),
	            LocalDateTime.of(2025, 11, 21, 17, 0)
	        );
	        shiftAlice.displaySchedule();
	        // Promotion
	        PromotionEval promo = new PromotionEval();
	        if (empAlice != null) {
	            promo.promoteEmployee(empAlice, "Senior Shoes", 35000, true, 3, true);
	        }
	        // Payroll
	        if (empAlice != null) empAlice.pay();
	    }
	}
}

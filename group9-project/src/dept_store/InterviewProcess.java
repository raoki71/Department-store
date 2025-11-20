// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package dept_store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InterviewProcess{

	public void evaluateCandidateFile(Candidate c, String filePath, String[] keywords){
        try{
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            boolean foundKeyword = false;

	        while (scanner.hasNextLine()){
	            String line = scanner.nextLine().toLowerCase();
	            for (String key : keywords) {
	                if (line.contains(key.toLowerCase())) {
	                    foundKeyword = true;
	                    break;
	                }
	            }
	            if (foundKeyword) break;
	        }
	        scanner.close();
	        if (foundKeyword){
	            System.out.println(c.getName() + " passed keyword check for " + c.getAppliedDepartment());
	            c.addInterviewScore(80); // score for passing keyword
			} 
	        else{
			    System.out.println(c.getName() + " did NOT pass keyword check");
			    c.addInterviewScore(50); // score for failing
			}
		} 
        catch (FileNotFoundException e){
		    System.out.println("File not found: " + filePath);
		}
	}

	public void conductInterview(Candidate c, int score){
	    c.addInterviewScore(score);
	    System.out.println("Interviewed " + c.getName() + " with score " + score);
	}
}

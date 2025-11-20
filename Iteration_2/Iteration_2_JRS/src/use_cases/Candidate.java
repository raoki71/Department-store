// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package use_cases;

import java.util.ArrayList;

public class Candidate{
	
	private String name;
	private int age;
	private String appliedDepartment;
	private ArrayList<Integer> interviewScores;
	private boolean qualified;

    public Candidate(String name, int age, String appliedDepartment){
        this.name = name;
        this.age = age;
        this.appliedDepartment = appliedDepartment;
        this.interviewScores = new ArrayList<>();
        this.qualified = false;
    }

    public void addInterviewScore(int score){
        interviewScores.add(score);
        evaluateQualification();
    }

    private void evaluateQualification(){
        if (interviewScores.size() >= 4){ //minimum rounds
	        int total = 0;
	        for (int s : interviewScores) total += s;
	        this.qualified = (total / interviewScores.size()) >= 70; // score threshold
        }
    }

	public boolean isQualified(){
		return qualified; 
	}
	public String getAppliedDepartment(){
		return appliedDepartment;
	}
	public String getName(){ 
		return name;
	}
}

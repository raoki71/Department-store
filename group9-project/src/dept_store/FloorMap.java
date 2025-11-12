package dept_store;

import java.util.ArrayList;

public class FloorMap {
	private ArrayList<FloorMap> floorMap;
	private String floor;
	private Direction dir;
	private int sectionCode;
	
	public FloorMap(String floor, Direction dir, int sectionCode) {
		this.floor = floor;
		this.dir = dir;
		this.sectionCode = sectionCode;
	}
	
	public String getFloor() {
		return floor;
	}
	
	public String getSection() {
		return dir.toString() + sectionCode + "";
	}
	public boolean isSectionAccessible(String floor, Direction dir, int sectionCode) {
		return true;
	}
}

// The floor plan is mainly divided into North, East, West, South sections
enum Direction {N, E, W, S};
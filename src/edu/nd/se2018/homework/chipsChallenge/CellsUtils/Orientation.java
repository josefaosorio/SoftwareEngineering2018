package edu.nd.se2018.homework.chipschallenge.CellsUtils;

public enum Orientation {
	DOWN("Down"),
	UP("Up"),
	LEFT("Left"),
	RIGHT("Right");
	
	private String str;
	
	private Orientation(String str) {
		this.str = str;
	}
	
	public String getOrientation() {
		return str;
	}
	
}

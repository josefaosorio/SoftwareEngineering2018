package edu.nd.se2018.homework.chipschallenge;

public enum State {
	PLAYING("Playing"),
	DEAD("Dead"),
	WON("Won");
	
	private String str;
	
	private State(String str) {
		this.str = str;
	}
	
	public String getString() {
		return str;
	}
}

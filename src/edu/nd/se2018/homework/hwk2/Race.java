//Josefa Osorio
package edu.nd.se2018.homework.hwk2;

import java.util.*;

public class Race {
	
	double raceLength = 10.0;
	List<Horse> race = new ArrayList<Horse>();
	boolean winner = false;
	Horse winnerHorse;
	
	public Race(){}
	
	public void enrollHorse(String name, int num, int maxSpeed, StrategyBehavior strategy) {
		//tests that the input is correct
		if (name.length()>0 && maxSpeed>0) {
			Horse horse = new Horse(name, num, maxSpeed, strategy);
			race.add(horse);
		}
	}
	
	public void start() {
		String winnerName = run();
		printWinner(winnerName);
	}
	
	public String run() {
		//while there isn't a winner
		while (!winner) {
			//update each horses distance
			for (Horse h : race) {
				h.update();
				//first winner is found but continues updating with other horses
				if (!winner && h.currDist >= raceLength) {
					winner = true;
					winnerHorse = h;
				}
			}
			
			//slows down the race
			try
			{
			    Thread.sleep(1000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			
			//finds the horse who went the farthest in that iteration
			if (winner) {
				for (Horse h : race) {
					if (!h.equals(winnerHorse) && h.currDist > winnerHorse.currDist) {
						winnerHorse = h;
					}
				}			
				return winnerHorse.name;
				//System.out.println("Winner is " + winnerHorse.name);
			}
		}
		
		return "";
	}
	
	public void printWinner(String winnerName) {
		System.out.println("Winner is " + winnerName);
	}

}

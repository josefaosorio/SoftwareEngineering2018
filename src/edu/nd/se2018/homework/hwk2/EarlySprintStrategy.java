//Josefa Osorio
package edu.nd.se2018.homework.hwk2;

public class EarlySprintStrategy implements StrategyBehavior {
	
	public EarlySprintStrategy(){}
	
	public double update(int maxSpeed, double distanceRan) {
		//divides by 100 to get distance run in one iteration
		if (distanceRan < 2.0) {
			return (distanceRan + (maxSpeed/100.0));
		}
		else {
			return (distanceRan + (maxSpeed/100.0)*0.75);
		}
	}
}

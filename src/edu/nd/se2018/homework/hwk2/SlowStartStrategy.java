//Josefa Osorio
package edu.nd.se2018.homework.hwk2;

public class SlowStartStrategy implements StrategyBehavior {
	
	public SlowStartStrategy() {}
	
	public double update(int maxSpeed, double distanceRan) {
		//divides by 100 to get distance run in one iteration
		if (distanceRan < 6.0) {
			return (distanceRan + ((maxSpeed/100.0)*0.75));
		}
		else if (distanceRan >= 6.0 && distanceRan < 9.0){
			return (distanceRan + ((maxSpeed/100.0)*0.9));
		}
		else {
			return (distanceRan + (maxSpeed/100.0));
		}
	}
}

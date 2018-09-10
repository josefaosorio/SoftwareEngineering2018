//Josefa Osorio
package edu.nd.se2018.homework.hwk2;

public class SteadyRunStrategy implements StrategyBehavior {
	
	public SteadyRunStrategy() {}

	public double update(int maxSpeed, double distanceRan) {
		//divides by 100 to get distance run in one iteration
		return (distanceRan + ((maxSpeed/100.0)*0.8));
	}
	
}

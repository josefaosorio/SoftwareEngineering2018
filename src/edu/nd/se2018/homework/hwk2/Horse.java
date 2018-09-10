//Josefa Osorio
package edu.nd.se2018.homework.hwk2;

public class Horse {
	
	String name;
	int num;
	int maxSpeed;
	StrategyBehavior strategy;
	double currDist = 0.0;
	
	public Horse() {}
	
	public Horse(String name, int num, int maxSpeed, StrategyBehavior strategy) {
		this.name = name;
		this.num = num;
		this.maxSpeed = maxSpeed;
		resetStrategy(strategy);
	}
	
	//displays how far the horse has run in that iteration
	public void update() {
		currDist = strategy.update(maxSpeed, currDist);
		System.out.println(name + " has run " + (Math.round(currDist*100.0)/100.0) + " miles.");
	}
	
	//sets or resets the strategy
	public void resetStrategy(StrategyBehavior strategy) {
		if (strategy.getClass() == SteadyRunStrategy.class) {
			this.strategy = new SteadyRunStrategy();
		}
		else if (strategy.getClass() == SlowStartStrategy.class) {
			this.strategy = new SlowStartStrategy();
		}
		else if (strategy.getClass() == EarlySprintStrategy.class){
			this.strategy = new EarlySprintStrategy();
		}
	}
}

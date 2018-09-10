//Josefa Osorio
package edu.nd.se2018.homework.hwk2;

public class Main {

	public static void main(String[] args) {
		//Test ideas #1
		Race race1 = new Race();
		race1.enrollHorse("Sam",0,22,new EarlySprintStrategy());
		race1.enrollHorse("Molly",1,24,new SlowStartStrategy());
		race1.enrollHorse("Joe",2,25,new EarlySprintStrategy());
		race1.enrollHorse("Blizzard",3,25,new SlowStartStrategy());
		race1.enrollHorse("Flicker",4,25,new SteadyRunStrategy());
		//race1.start();
		
		//Test ideas #2
		Race race2 = new Race();
		race2.enrollHorse("Sam",0,22,new EarlySprintStrategy());
		race2.enrollHorse("Molly",1,22,new EarlySprintStrategy());
		//race2.start();
		
		//Test ideas #3
		Race race3 = new Race();
		race3.enrollHorse("Sam",0,100,new EarlySprintStrategy());
		race3.enrollHorse("Molly",1,100,new SlowStartStrategy());
		race3.start();
	}

}

//Josefa Osorio
package edu.nd.se2018.homework.hwk2;
import org.junit.Test;

public class RaceTest {
	@Test
	public void test() {
		Race raceTest = new Race();
		//tests incorrect input won't be added
		raceTest.enrollHorse("", 10, 0, new EarlySprintStrategy());
		assert(raceTest.race.size() == 0);
		
		//tests that horses have been added correctly
		raceTest.enrollHorse("Sam",0,100,new EarlySprintStrategy());
		raceTest.enrollHorse("Molly",1,100,new SlowStartStrategy());
		assert(raceTest.race.size() == 2);

		//tests correct winner output
		assert(raceTest.run() == "Molly");
		
		//tests that the strategies calculate correctly based on how far in the race the horse is
		//Early Sprint (2 cases)
		EarlySprintStrategy stratTest1 = new EarlySprintStrategy();
		int maxSpeed = 20;
		double distanceRan = 0.0;
		assert(stratTest1.update(maxSpeed, distanceRan) == 0.2);
		
		distanceRan = 5.0;
		assert(stratTest1.update(maxSpeed, distanceRan) == 5.15);
		
		//Steady Run (1 case)
		SteadyRunStrategy stratTest2 = new SteadyRunStrategy();
		assert(stratTest2.update(maxSpeed, distanceRan) == 5.16);
		
		//Slow Start (3 cases)
		SlowStartStrategy stratTest3 = new SlowStartStrategy();		
		assert(stratTest3.update(maxSpeed, distanceRan) == 5.15);
		
		distanceRan = 7.5;
		assert(stratTest3.update(maxSpeed, distanceRan) == 7.68);
		
		distanceRan = 9.0;
		assert(stratTest3.update(maxSpeed, distanceRan) == 9.2);	
	}

}

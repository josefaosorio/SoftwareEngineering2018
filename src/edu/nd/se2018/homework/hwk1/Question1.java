//Josefa Osorio
//Homework 1 Question 1
package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;
import java.util.Iterator;

public class Question1 {
	
	public Question1() {}
	
	public int getSumWithoutDuplicates(int[] numbers) {
		HashSet<Integer> numsUnique = new HashSet<Integer>();
		int sum = 0;
		
		//iterates through the numbers input and removes duplicates by adding to HashSet
		for (int i=0; i<numbers.length; i++) {
			numsUnique.add(numbers[i]);
		}
		
		//finds sum by using iterator to iterate through nums HashSet
		Iterator<Integer> it = numsUnique.iterator();
		while(it.hasNext()) {
			//gets Integer value from iterator then turns to an int
			sum += it.next().intValue(); 
		}
		
		return sum;
	}

}

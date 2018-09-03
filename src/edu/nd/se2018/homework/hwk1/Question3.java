//Josefa Osorio
//Homework 1 Question 3
package edu.nd.se2018.homework.hwk1;

import edu.nd.se2018.SumNumbers;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	int indexNum = 0;
    	int indexMirror = 0;
    	
    	//keeps track of the max length of mirrored numbers
    	for (int mirrLen=numbers.length; mirrLen>=0; mirrLen--) {
    		//numsStart starts at front of the array and is the left side of the mirroring
    		for (int numsStart=0; numsStart<numbers.length; numsStart++) {
    			//mirrStart starts at the right side and is the right side of the mirroring
    			for (int mirrStart=numbers.length-1; mirrStart>=mirrLen-1; mirrStart--) {
    				indexNum = numsStart;
    				indexMirror = mirrStart;
    				//if both indexNum and indexMirror and inside the array and the values equal each other then move both indexes
    				while (indexNum < numbers.length && indexMirror >= 0 && numbers[indexNum] == numbers[indexMirror]) {
    					indexNum++;
    					indexMirror--;
    				}
    				
    				//if the mirroring when complete is equal to the max length of mirrored nums then return mirrLen
    				if (indexNum-numsStart == mirrLen)
    					return mirrLen;
    			}
    		}
    	}
		return 0;	
	}
    
}
//Josefa Osorio
//Homework 1 Question 2
package edu.nd.se2018.homework.hwk1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		HashMap<String, Integer> map = new HashMap<>();
		String[] stopwordsArr = stopwords.split(" ");
		
		//gets every word in the input by splitting at spaces
		for (String word : input.split(" " )) {
			//checks if the word is not in the stopwords
			if (!Arrays.asList(stopwordsArr).contains(word)) {
				//if the map already contains the word, increment the num times it appears (value)
				if (map.containsKey(word))
					map.put(word, map.get(word)+1);
				//otherwise set the value of that word to 1
				else
					map.put(word, 1);
			}
		}
		

		//gets the maximum value in the map
		int maxValue=(Collections.max(map.values()));
		
		int numTimesMaxAppeared = 0;
		String keyAtMaxVal = "";
		//iterates through the hashmap
		for (Entry<String, Integer> entry : map.entrySet()) {
			//if the maxValue is found increment how many times it's found and get the Key for that Value
			if (entry.getValue()==maxValue) {
				numTimesMaxAppeared++;
				keyAtMaxVal = entry.getKey();
			}
		}
		
		//if there's only one key with the max value, return that key
		if (numTimesMaxAppeared==1) {
			return keyAtMaxVal;
		}
		
		//otherwise return null
		return null;
		
	}
	
}

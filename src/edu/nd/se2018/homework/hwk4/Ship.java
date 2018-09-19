//Josefa Osorio
package edu.nd.se2018.homework.hwk4;

import java.awt.Point;
import java.util.Random;
import java.util.Observable;

public class Ship extends Observable{
	Point currentLocation;
	OceanMap oceanMap;
	Random rand;
	int[][] islandMap;
	int dimensions;
	
	//gets random location for pirate ship and sets variables
	public Ship(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		islandMap = oceanMap.getMap();
		this.dimensions = oceanMap.dimensions;
		
		rand = new Random();
		int randX = rand.nextInt(dimensions);
		int randY = rand.nextInt(dimensions);
		//checks if location is filled
		while(islandMap[randX][randY] != 0) {
			randX = rand.nextInt(dimensions);
			randY = rand.nextInt(dimensions);
		}
		
		currentLocation = new Point(randX, randY);
		islandMap[randX][randY] = 2;
	}
	
	//returns the ships location
	public Point getShipLocation() {
		return currentLocation;
	}
	
	//increments x variable by one if space open and notifies observers
	public void goEast() {
		int oldX = currentLocation.x;
		int newX = currentLocation.x+1;
		int y = currentLocation.y;
		if(newX < dimensions && islandMap[newX][y] == 0) {
			currentLocation.move(newX, y);
			islandMap[oldX][y] = 0;
			islandMap[newX][y] = 2;
			
			setChanged();
			notifyObservers();
		}
		
		
	}
	
	//decrements x variable by one if space open and notifies observers
	public void goWest() {
		int oldX = currentLocation.x;
		int newX = currentLocation.x-1;
		int y = currentLocation.y;
		if(newX >= 0 && islandMap[newX][y] == 0) {
			currentLocation.move(newX, y);
			islandMap[oldX][y] = 0;
			islandMap[newX][y] = 2;
			
			setChanged();
			notifyObservers();
		}
	}

	//increments y variable by one if space open and notifies observers
	public void goNorth() {
		int x = currentLocation.x;
		int newY = currentLocation.y-1;
		int oldY = currentLocation.y;
		if(newY >= 0 && islandMap[x][newY] == 0) {
			currentLocation.move(x, newY);
			islandMap[x][oldY] = 0;
			islandMap[x][newY] = 2;
		
			setChanged();
			notifyObservers();
		}
	}

	//decrements y variable by one if space open and notifies observers
	public void goSouth() {
		int x = currentLocation.x;
		int newY = currentLocation.y+1;
		int oldY = currentLocation.y;
		if(newY < dimensions && islandMap[x][newY] == 0) {
			currentLocation.move(x, newY);
			islandMap[x][oldY] = 0;
			islandMap[x][newY] = 2;
			
			setChanged();
			notifyObservers();
		}
	}
	
}

//Josefa Osorio
package edu.nd.se2018.homework.hwk4;

import java.awt.Point;
import java.util.Random;
import java.util.Observer;
import java.util.Observable;

public class PirateShip implements Observer{
	Point pirateShipLocation;
	Point shipLocation;
	OceanMap oceanMap;
	int[][] islandMap;
	int dimensions;
	
	//gets random location for pirate ship and sets variables
	public PirateShip(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		islandMap = oceanMap.getMap();
		this.dimensions = oceanMap.dimensions;
		
		Random rand = new Random();
		int randX = rand.nextInt(dimensions);
		int randY = rand.nextInt(dimensions);
		//checks if location is filled
		while(islandMap[randX][randY] != 0) {
			randX = rand.nextInt(dimensions);
			randY = rand.nextInt(dimensions);
		}
		
		pirateShipLocation = new Point(randX, randY);
		islandMap[randX][randY] = 2;
	}
	
	//returns the ships location
	public Point getShipLocation() {
		return pirateShipLocation;
	}
	
	//moves the pirate ship closer to the columbus ship
	public void movePirateShip() {
		int oldX = pirateShipLocation.x;
		int oldY = pirateShipLocation.y;
		int newX = oldX;
		int newY = oldY;
		int tempX, tempY;
		
		//compares to ship location to move closer to it
		if (oldX - shipLocation.x < 0) {
			tempX = pirateShipLocation.x+1;
			if(tempX < dimensions && islandMap[tempX][oldY] == 0)
				newX = tempX;
		}
		else {
			tempX = pirateShipLocation.x-1;
			if(tempX >= 0 && islandMap[tempX][oldY] == 0)
				newX = tempX;
		}
		
		if (oldY - shipLocation.y < 0) {
			tempY = pirateShipLocation.y+1;
			if(tempY < dimensions && islandMap[newX][tempY] == 0)
				newY = tempY;
		}
		else {
			tempY = pirateShipLocation.y-1;
			if(tempY >= 0 && islandMap[newX][tempY] == 0)
				newY = tempY;
		}
		
		//sets pirate location and changes classification of grid
		pirateShipLocation.move(newX, newY);
		islandMap[newX][newY] = 2;
		islandMap[oldX][oldY] = 0;
	}
	
	//updates the location of the pirate every time that the columbus ship moves
	@Override
	public void update(Observable s, Object arg1) {
		if(s instanceof Ship) {
			shipLocation = ((Ship)s).getShipLocation();
			movePirateShip();
		}
	}

}

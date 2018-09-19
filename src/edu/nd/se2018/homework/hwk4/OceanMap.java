//Josefa Osorio
package edu.nd.se2018.homework.hwk4;

import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import java.awt.Point;
import java.util.Random;

public class OceanMap {
	int[][] oceanGrid; //0 - water, 1 - island, 2 - ship
	int dimensions = 15;
	int islandCount;
	Image islandImage;
	ImageView islandImageView;
	Image waveImage;
	ImageView waveImageView;
	
	//initializes variables input
	public OceanMap(int dimensions, int islandCount) {
		this.dimensions = dimensions;
		oceanGrid = new int[dimensions][dimensions];
		this.islandCount = islandCount;
	}
	
	//draws the grid on the map and fills with water
	public void drawMap(ObservableList<Node> root, int scale) {
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = 0;
			}
		}
		
		//adds islands to map
		placeIslands(root, scale);
		
	}
	
	public int[][] getMap(){
		return oceanGrid;
	}
	
	//returns ship location if Ship object
	public Point getShipLocation(Ship ship) {
		return ship.getShipLocation();
	}
	
	//returns ship location if PirateShip object
	public Point getShipLocation(PirateShip ship) {
		return ship.getShipLocation();
	}
	
	//adds islands to the grid
	public void placeIslands(ObservableList<Node> root, int scale) {
		Random rand = new Random();
		int countIslandsAdded = 0;
		
		//adds ships until at islandCount (input variable when OceanMap object initialized
		while(countIslandsAdded < islandCount) {
			int randX = rand.nextInt(dimensions);
			int randY = rand.nextInt(dimensions);
			while(oceanGrid[randX][randY] != 0) {
				randX = rand.nextInt(dimensions);
				randY = rand.nextInt(dimensions);
			}
			
			// adds island image instead of green rectangle
			islandImage = new Image("images//island.png", 50, 50, true, true);
			islandImageView = new ImageView(islandImage);
			islandImageView.setX(randX * scale);
			islandImageView.setY(randY * scale);
			root.add(islandImageView);
		
			oceanGrid[randX][randY] = 1;
			countIslandsAdded++;
		}
	}
}

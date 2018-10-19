//Josefa Osorio
package edu.nd.se2018.homework.chipschallenge;

import edu.nd.se2018.homework.chipschallenge.CellsUtils.CellBehavior;


public class Grid {
	private static Grid grid;
	private CellBehavior cellGrid[][];
	private int dimensions = 25;
	private int totalChips = 0;
	private int chipsCollected = 0;

	private Grid() {
		cellGrid = new CellBehavior[dimensions][dimensions];
	}
		
	public static Grid getGrid() {
		if (grid == null)
			grid = new Grid();
		
		return grid;
	}
	
	public int getSize() {
		return dimensions;
	}
	
	public void setCell(CellBehavior cell) {
		cellGrid[cell.getX()][cell.getY()] = cell;
	}
	
	public CellBehavior getCell(int i, int j) {
		return cellGrid[i][j];
	}
	
	// increments number of chips added to game
	public void addToTotalChips() {
		totalChips++;
	}
	
	// increments number of chips player has collected
	public void addToChipsCollected() {
		chipsCollected++;
	}
	
	// checks if all of the chips have been collected
	public boolean getIfAllChipsCollected() {
		return (totalChips == chipsCollected);
	}
	
	// used for scoreboard
	public int getChipsLeft() {
		return (totalChips - chipsCollected);
	}
	
	// checks if the cell has been set
	public boolean cellSet(final int i, final int j) {
		return (getCell(i, j) != null);
	}
	
	//resets grid
	public void clear() {
		grid = new Grid();
	}

}



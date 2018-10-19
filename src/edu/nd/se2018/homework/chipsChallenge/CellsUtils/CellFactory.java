package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.Grid;

public class CellFactory {
	public void addCell(Grid grid, CellType type, Point p) {
		switch(type) {
			case CHIPITEM:
				grid.setCell(new ChipItem(p));
				break;
			case BUG:
				grid.setCell(new Bug(p));
				break;
			case WALLTILE:
				grid.setCell(new WallTile(p));
				break;
			case PORTAL:
				grid.setCell(new Portal(p));
				break;
			case PORTALGATE:
				grid.setCell(new PortalGate(p));
				break;
			case BLANKTILE:
				grid.setCell(new BlankTile(p));
				break;
			default:
				break;
		}
	}
	
	public void addCell(Grid grid, CellType type, Point p, String color) {
		switch(type) {
			case KEY:
				grid.setCell(new Key(p, color));
				break;
			case KEYWALL:
				grid.setCell(new KeyWall(p, color));
				break;
			default:
				break;
		}
	}
}

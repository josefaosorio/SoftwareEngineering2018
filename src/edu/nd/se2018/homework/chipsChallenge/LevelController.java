package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.CellsUtils.*;
import javafx.scene.layout.AnchorPane;

public class LevelController {
	private Grid grid;
	private AnchorPane root;
	private CellFactory cellFactory;
	private int dim;
	
	public LevelController(AnchorPane root) {
		this.root = root;
		
		grid = Grid.getGrid();
		cellFactory = new CellFactory();
		dim = grid.getSize();
	}
	
	public Grid getLevelGrid(int level) {
		grid.clear();
		grid = Grid.getGrid();
		
		if (level == 1)
			return drawLevelOne();
		else
			return drawLevelTwo();
	}
	
	private Grid drawLevelOne() {
		
		//left and right outer square walls
		for (int i = 0; i < dim; i++) {
			cellFactory.addCell(grid, CellType.WALLTILE, new Point(0, i));
			cellFactory.addCell(grid, CellType.WALLTILE, new Point(dim-1, i));
		}
		
		// top outer square wall
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(1, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(2, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(3, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(4, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(5, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(6, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(7, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(9, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(10, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(11, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(12, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(13, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(14, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(15, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(17, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(18, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(19, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(20, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(21, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(22, 0));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(23, 0));
		
		// bottom outer square wall
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(1, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(2, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(3, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(4, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(5, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(6, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(7, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(9, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(10, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(11, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(12, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(13, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(14, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(15, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(17, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(18, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(19, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(20, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(21, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(22, 24));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(23, 24));
		
		// key boundary wall tiles
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(1, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(2, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(3, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(4, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(5, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(6, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(7, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(9, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(10, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(11, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(12, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(13, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(14, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(15, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(17, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(18, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(19, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(20, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(21, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(22, 6));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(23, 6));
		
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(1, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(2, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(3, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(4, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(5, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(6, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(7, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(9, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(10, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(14, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(15, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(17, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(18, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(19, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(20, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(21, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(22, 18));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(23, 18));
		
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 1));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 2));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 3));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 4));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 5));
		
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 1));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 2));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 3));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 4));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 5));
		
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 23));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 22));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 21));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 20));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(8, 19));
		
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 23));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 22));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 21));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 20));
		cellFactory.addCell(grid, CellType.WALLTILE, new Point(16, 19));
		
		// key walls 
		cellFactory.addCell(grid, CellType.KEYWALL, new Point(4, 6), "blue");
		cellFactory.addCell(grid, CellType.KEYWALL, new Point(20, 6), "red");
		cellFactory.addCell(grid, CellType.KEYWALL, new Point(4, 18), "yellow");
		cellFactory.addCell(grid, CellType.KEYWALL, new Point(20, 18), "green");
		
		// keys
		cellFactory.addCell(grid, CellType.KEY, new Point(12, 12), "blue");
		cellFactory.addCell(grid, CellType.KEY, new Point(3, 3), "red");
		cellFactory.addCell(grid, CellType.KEY, new Point(19, 3), "yellow");
		cellFactory.addCell(grid, CellType.KEY, new Point(3, 21), "green");
		
		//chip items
		cellFactory.addCell(grid, CellType.CHIPITEM, new Point(5, 3));
		cellFactory.addCell(grid, CellType.CHIPITEM, new Point(21, 3));
		cellFactory.addCell(grid, CellType.CHIPITEM, new Point(5, 21));
		cellFactory.addCell(grid, CellType.CHIPITEM, new Point(20, 21));
		
		// portal and portal gate
		cellFactory.addCell(grid, CellType.PORTALGATE, new Point(12, 6));
		cellFactory.addCell(grid, CellType.PORTAL, new Point(12, 3));
		
		
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				//add empty cells where they haven't already been set
				if(!grid.cellSet(i, j)) {
					cellFactory.addCell(grid, CellType.BLANKTILE, new Point(i, j));
				}
				root.getChildren().add(grid.getCell(i, j).getImageView());
			}
		}
		
		Player player = Player.getInstance(new Point(13, 13));
		grid.setCell(player.getChipCell());
		root.getChildren().add(player.getImageView());
	
		return grid;
		
	}
	
	private Grid drawLevelTwo() {
		//pound symbol framework blocks
		for (int i = 0; i < dim; i++) {
			cellFactory.addCell(grid, CellType.WALLTILE, new Point(5, i));
			cellFactory.addCell(grid, CellType.WALLTILE, new Point(19, i));
			cellFactory.addCell(grid, CellType.WALLTILE, new Point(i, 5));
			cellFactory.addCell(grid, CellType.WALLTILE, new Point(i, 19));
		}
		
		
		//Key walls
		cellFactory.addCell(grid, CellType.KEYWALL, new Point(5, 12), "green");
		cellFactory.addCell(grid, CellType.KEYWALL, new Point(12, 5), "blue");
		cellFactory.addCell(grid, CellType.KEYWALL, new Point(19, 12), "yellow");
		cellFactory.addCell(grid, CellType.KEYWALL, new Point(22, 19), "red");
		
		//Keys
		cellFactory.addCell(grid, CellType.KEY, new Point(2, 8), "blue");
		cellFactory.addCell(grid, CellType.KEY, new Point(8, 2), "yellow");
		cellFactory.addCell(grid, CellType.KEY, new Point(22, 8), "red");
		cellFactory.addCell(grid, CellType.KEY, new Point(2, 21), "green");
		
		// Blank tiles
		cellFactory.addCell(grid, CellType.BLANKTILE, new Point(5, 22));
		cellFactory.addCell(grid, CellType.BLANKTILE, new Point(12, 19));
		
		//Chip items
		cellFactory.addCell(grid, CellType.CHIPITEM, new Point(2, 16));
		cellFactory.addCell(grid, CellType.CHIPITEM, new Point(2, 23));
		cellFactory.addCell(grid, CellType.CHIPITEM, new Point(12, 2));
		cellFactory.addCell(grid, CellType.CHIPITEM, new Point(22, 22));
		
		// portal and portal gate
		cellFactory.addCell(grid, CellType.PORTALGATE, new Point(22, 5));
		cellFactory.addCell(grid, CellType.PORTAL, new Point(22, 2));
		
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				//add empty cells where they haven't already been set
				if(!grid.cellSet(i, j)) {
					cellFactory.addCell(grid, CellType.BLANKTILE, new Point(i, j));
				}
				root.getChildren().add(grid.getCell(i, j).getImageView());
			}
		}
		
		// adds player
		Player player = Player.getInstance(new Point(12, 22));
		grid.setCell(player.getChipCell());
		root.getChildren().add(player.getImageView());
		
		// adds bug
		Enemy enemy = Enemy.getInstance(new Point(12, 12), 2);
		grid.setCell(enemy.getBug());
		root.getChildren().add(enemy.getImageView());
		
		return grid;
	}
}

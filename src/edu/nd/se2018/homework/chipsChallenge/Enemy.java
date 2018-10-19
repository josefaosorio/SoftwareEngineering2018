package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;
import edu.nd.se2018.homework.chipschallenge.CellsUtils.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class Enemy {
	private static Enemy enemy;
	private Point position;
	private Grid grid;
	private int level;
	private Bug bug;
	private boolean canMove = false;
	private boolean dirMoving; //false = up, true = down;
	
	public Enemy(Point position, int level) {
		this.position = position;
		this.level = level;
		bug = new Bug(position);
		dirMoving = false;
	}
	
	public static Enemy getInstance() {
		return enemy;
	}
	
	public static Enemy getInstance(Point p, int level) {
		enemy = new Enemy(p, level);
		return enemy;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public ImageView getImageView() {
		return bug.getImageView();
	}
	
	public Bug getBug() {
		return bug;
	}
	
	public boolean canMove() {
		if(level == 2)
			return true;
		return false;
	}
	
	public void move(AnchorPane root) {
		grid = grid.getGrid();
		
		// remove player and image where player used to be and add blank tile
		root.getChildren().remove(enemy.getImageView());
		root.getChildren().remove(grid.getCell(position.x, position.y).getImageView());
		grid.setCell(new BlankTile(position));
		root.getChildren().add(grid.getCell(position.x, position.y).getImageView());
		
		position = getPosition(level);
		
		//update player location and image
		grid.setCell(new Bug(position));
		root.getChildren().add(grid.getCell(position.x, position.y).getImageView());
	}
	
	public Point getPosition(int level) {
		switch (level) {
			case 2:
				if(position.y - 1 < 7 || position.y + 1 > 17 || !grid.getCell(position.x, position.y - 1).canEnter() || !grid.getCell(position.x, position.y + 1).canEnter())
					dirMoving = !dirMoving;
				
				if(!dirMoving && position.y - 1 >= 7 && grid.getCell(position.x, position.y - 1).canEnter())
					return new Point(position.x, position.y - 1);
				else if(dirMoving && position.y + 1 <= 17 && grid.getCell(position.x, position.y + 1).canEnter())
					return new Point(position.x, position.y + 1);
			default:
				return position;
		}
	}
}

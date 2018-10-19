package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;
import java.util.ArrayList;
import edu.nd.se2018.homework.chipschallenge.CellsUtils.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class Player {
	private static int dimensions = 25;
	private static Player player;
	private Point position;
	private ArrayList<String> keys;
	private State state;
	private Chip chipCell;
	private Grid grid;
	private boolean canMove;
	
	public Player(Point position) {
		this.position = position;
		keys = new ArrayList<>();
		state = State.PLAYING;
		chipCell = new Chip(position, Orientation.DOWN, state);
	}
	
	public static Player getInstance() {
		return player;
	}
	
	public static Player getInstance(Point p) {
		player = new Player(p);
		return player;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public ImageView getImageView() {
		return chipCell.getImageView();
	}
	
	public Chip getChipCell() {
		return chipCell;
	}
	
	public State getState() {
		return state;
	}
	
	public void move(AnchorPane root, KeyEvent event) {
		grid = grid.getGrid();
		
		// remove player and image where player used to be and add blank tile
		root.getChildren().remove(player.getImageView());
		root.getChildren().remove(grid.getCell(position.x, position.y).getImageView());
		grid.setCell(new BlankTile(position));
		root.getChildren().add(grid.getCell(position.x, position.y).getImageView());
		
		Orientation orientation = Orientation.DOWN;
		
		switch(event.getCode()) {
			case UP:
				position = getPosition("up");
				orientation = Orientation.UP;
				break;
			case DOWN:
				position = getPosition("down");
				orientation = Orientation.DOWN;
				break;
			case LEFT:
				position = getPosition("left");
				orientation = Orientation.LEFT;
				break;
			case RIGHT:
				position = getPosition("right");
				orientation = Orientation.RIGHT;
				break;
			default:
				break;
		}
		
		changeState();
		
		//update player location and image
		grid.setCell(new Chip(position, orientation, state));
		root.getChildren().add(grid.getCell(position.x, position.y).getImageView());
	}
	
	public Point getPosition(String dir) {
		switch(dir.toUpperCase()) {
			case "UP":
				if (position.y-1 >= 0 && grid.getCell(position.x, position.y - 1).canEnter()) {
					return new Point(position.x, position.y - 1);
				}
				else {
					return position;
				}
			case "DOWN":
				if (position.y+1 < dimensions && grid.getCell(position.x, position.y + 1).canEnter()) {
					return new Point(position.x, position.y + 1);
				}
				else {
					return position;
				}
			case "LEFT":
				if (position.x -1 >= 0 && grid.getCell(position.x - 1, position.y).canEnter()) {
					return new Point(position.x - 1, position.y);
				}
				else {
					return position;
				}
			case "RIGHT":
				if (position.x+1 < dimensions && grid.getCell(position.x + 1, position.y).canEnter()) {
					return new Point(position.x + 1, position.y);
				}
				else {
					return position;
				}
			default:
				return position;
		}
	}
	
	//adds a key to the list of keys 
	public void takeKey(String keyColor) {
		keys.add(keyColor.toUpperCase());
	}
	
	//usea key for a door if it's available
	public boolean useKey(String keyColor) {
		if (hasKey(keyColor)) {
			keys.remove(keyColor);
			return true;
		}
		else
			return false;
	}
	
	//checks if the player has collected that key
	public boolean hasKey(String keyColor) {
		return keys.contains(keyColor.toUpperCase());
	}
	
	//returns if player can move
	public boolean canMove() {
		return canMove;
	}
	
	// Changes the cells state based on whether the cell it hits is a bug or portal or nothing
	private void changeState() {
		CellBehavior cell = Grid.getGrid().getCell(position.x, position.y);
		
		if(cell.isBug())
			state = State.DEAD;
		else if(cell.hasWon())
			state = State.WON;
		else
			state = State.PLAYING;
	}
}

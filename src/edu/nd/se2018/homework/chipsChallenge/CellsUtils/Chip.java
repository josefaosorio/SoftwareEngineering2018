package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.IVController;
import edu.nd.se2018.homework.chipschallenge.State;
import javafx.scene.image.ImageView;

public class Chip implements CellBehavior{
	private ImageView tileIV;
	private Point position;
	String path;
	
	public Chip(Point position, Orientation orientation, State state) {
		this.position = position;
		
		path = getPath(state, orientation);
		tileIV = new IVController(path, position).getTileIV();
	}
	
	@Override
	public ImageView getImageView() {
		return tileIV;
	}
	
	@Override
	public int getX() {
		return position.x;
	}
	
	@Override
	public int getY() {
		return position.y;
	}
	
	//gets the path of pictures based on the state and where the player was moving
	public String getPath(State state, Orientation orientation) {
		switch (state) {
			case PLAYING:
				switch (orientation) {
					case DOWN:
						return "textures//chipDown.png";
					case UP:
						return "textures//chipUp.png";
					case LEFT:
						return "textures//chipLeft.png";
					case RIGHT:
						return "textures//chipRight.png";
				}
			case DEAD:
				return "textures//chipDown.png";
			case WON:
				return "textures//chipDown.png";
			}
		
		return "";
	}
	
	@Override
	public boolean canEnter() {
		return true;
	}
	
	@Override
	public boolean isBug() {
		return false;
	}
	
	@Override
	public boolean hasWon() {
		return false;
	}
}

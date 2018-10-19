package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.IVController;
import edu.nd.se2018.homework.chipschallenge.Player;
import javafx.scene.image.ImageView;

public class Key implements CellBehavior {
	private ImageView tileIV;
	private Point position;
	private String path;
	private String color;
	
	public Key(Point position, String color) {
		this.position = position;
		this.color = color;
		path = getPath(color);
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
	
	public String getPath(String color) {
		switch (color.toUpperCase()) {
			case "BLUE":
				return "textures//blueKey.png";
			case "RED":
				return "textures//redKey.png";
			case "GREEN":
				return "textures//greenKey.png";
			case "YELLOW":
				return "textures//yellowKey.png";
			default:
				return "";
		}
	}
	
	@Override
	public boolean canEnter() {
		Player.getInstance().takeKey(color);
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

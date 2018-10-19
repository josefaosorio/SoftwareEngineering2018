package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import edu.nd.se2018.homework.chipschallenge.IVController;

import java.awt.*;
import javafx.scene.image.ImageView;

public class WallTile implements CellBehavior {
	private ImageView tileIV;
	private Point position;
	
	public WallTile(Point position) {
		this.position = position;
		tileIV = new IVController("textures//WallTile.png", position).getTileIV();
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
	
	@Override
	public boolean canEnter() {
		return false;
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

package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.IVController;
import javafx.scene.image.ImageView;

public class Portal implements CellBehavior {
	private ImageView tileIV;
	private Point position;
	
	public Portal(Point position) {
		this.position = position;
		tileIV = new IVController("textures//portal.png", position).getTileIV();
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
		return true;
	}
	
	@Override
	public boolean isBug() {
		return false;
	}
	
	@Override
	public boolean hasWon() {
		return true;
	}
}

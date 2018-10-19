package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.IVController;
import javafx.scene.image.ImageView;

public class Bug implements CellBehavior {
	private ImageView tileIV;
	private Point position;
	
	public Bug(Point position) {
		this.position = position;
		tileIV = new IVController("textures//bugUp.png", position).getTileIV();
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
		return true;
	}
	
	@Override
	public boolean hasWon() {
		return false;
	}
}

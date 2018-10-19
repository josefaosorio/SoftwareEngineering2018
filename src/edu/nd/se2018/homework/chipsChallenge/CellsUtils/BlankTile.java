package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import edu.nd.se2018.homework.chipschallenge.IVController;
import java.awt.*;
import javafx.scene.image.ImageView;


public class BlankTile implements CellBehavior {
	private ImageView tileIV;
	private Point position;
	
	public BlankTile(Point position) {
		this.position = position;
		tileIV = new IVController("textures//BlankTile.png", position).getTileIV();
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
		return false;
	}
	
}

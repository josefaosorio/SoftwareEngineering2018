package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.Grid;
import edu.nd.se2018.homework.chipschallenge.IVController;
import javafx.scene.image.ImageView;

public class ChipItem implements CellBehavior {
	private ImageView tileIV;
	private Point position;
	
	public ChipItem(Point position) {
		this.position = position;
		tileIV = new IVController("textures//chipItem.png", position).getTileIV();
		Grid.getGrid().addToTotalChips();
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
		Grid.getGrid().addToChipsCollected();
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

package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.Grid;
import edu.nd.se2018.homework.chipschallenge.IVController;
import javafx.scene.image.ImageView;

public class PortalGate implements CellBehavior {
	private ImageView tileIV;
	private Point position;
	
	public PortalGate(Point position) {
		this.position = position;
		tileIV = new IVController("textures//portalGate.png", position).getTileIV();
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
		if(Grid.getGrid().getIfAllChipsCollected()) {
			return true;
		}
		else {
			return false;
		}
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

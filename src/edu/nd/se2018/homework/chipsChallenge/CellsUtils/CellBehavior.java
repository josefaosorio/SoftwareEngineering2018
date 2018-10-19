package edu.nd.se2018.homework.chipschallenge.CellsUtils;

import javafx.scene.image.ImageView;

public interface CellBehavior {
	ImageView getImageView();
	int getX();
	int getY();
	boolean canEnter();
	boolean isBug();
	boolean hasWon();
}

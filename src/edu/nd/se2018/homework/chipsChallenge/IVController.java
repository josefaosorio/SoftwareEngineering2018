package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IVController {
	private static int imageSize = 25;
	private static int scalingFactor = 25;
	Image tileImage;
	ImageView tileImageView;
	
	public IVController(String path, Point p) {
		tileImage = new Image(path, imageSize, imageSize, false, true);
		tileImageView = new ImageView(tileImage);
		
		tileImageView.setX(p.x * scalingFactor);
		tileImageView.setY(p.y * scalingFactor);
	}
	
	public ImageView getTileIV() {
		return tileImageView;
	}
	
}

//Josefa Osorio
package edu.nd.se2018.homework.hwk4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import java.awt.Button;


public class OceanExplorer extends Application{
	int[][] islandMap;
	final int dimensions = 10;
	final int islandCount = 10;
	final int scalingFactor = 50;
	Image shipImage;
	Image pirateShipImage1;
	Image pirateShipImage2;
	ImageView shipImageView;
	ImageView pirateShipImageView1;
	ImageView pirateShipImageView2;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	PirateShip pirateShip1;
	PirateShip pirateShip2;
	AnchorPane root;
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		oceanMap = new OceanMap(dimensions, islandCount);
		islandMap = oceanMap.getMap();

		root = new AnchorPane();
		
		scene = new Scene(root, 500, 500);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Josefa's Island");
		oceanMap.drawMap(root.getChildren(), scalingFactor);
		
		ship = new Ship(oceanMap);
		pirateShip1 = new PirateShip(oceanMap);
		pirateShip2 = new PirateShip(oceanMap);
		ship.addObserver(pirateShip1);
		ship.addObserver(pirateShip2);
		
		loadImages();
		
		oceanStage.show();
		startSailing();
	}
	
	public void loadImages() {
		//add the Columbus ship to the ImageView
		shipImage = new Image("images//ColumbusShip.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oceanMap.getShipLocation(ship).x * scalingFactor);
		shipImageView.setY(oceanMap.getShipLocation(ship).y * scalingFactor);
		root.getChildren().add(shipImageView);
		
		//add pirate ships to the pirateShipImageView
		pirateShipImage1 = new Image("images//pirateship.gif", 50, 50, true, true);
		pirateShipImageView1 = new ImageView(pirateShipImage1);
		pirateShipImageView1.setX(oceanMap.getShipLocation(pirateShip1).x * scalingFactor);
		pirateShipImageView1.setY(oceanMap.getShipLocation(pirateShip1).y * scalingFactor);
		root.getChildren().add(pirateShipImageView1);
		
		pirateShipImage2 = new Image("images//pirateship.gif", 50, 50, true, true);
		pirateShipImageView2 = new ImageView(pirateShipImage2);
		pirateShipImageView2.setX(oceanMap.getShipLocation(pirateShip2).x * scalingFactor);
		pirateShipImageView2.setY(oceanMap.getShipLocation(pirateShip2).y * scalingFactor);
		root.getChildren().add(pirateShipImageView2);
			
	}
	
	//handles event when key is pressed and moves and updates Ship and Pirate Ship
	public void startSailing() {		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				}
				
				//updates views with new location of ships
				shipImageView.setX(ship.getShipLocation().x * scalingFactor);
				shipImageView.setY(ship.getShipLocation().y * scalingFactor);
				pirateShipImageView1.setX(pirateShip1.getShipLocation().x * scalingFactor);
				pirateShipImageView1.setY(pirateShip1.getShipLocation().y * scalingFactor);
				pirateShipImageView2.setX(pirateShip2.getShipLocation().x * scalingFactor);
				pirateShipImageView2.setY(pirateShip2.getShipLocation().y * scalingFactor);
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

package edu.nd.se2018.homework.hwk5.model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author Josefa
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private boolean moveWest; //if false, moves West to East. if true, moves East to West
	String name;
	
	public Train(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		img = new Image("images//Train.PNG",120,trainLength,false,false);
		this.name = "Train 1";
		this.moveWest = true;
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public Train(int x, int y, int trainImg){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		if(trainImg == 1)
			img = new Image("images//Train.PNG",120,trainLength,false,false);
		else {
			img = new Image("images//Train2.png",120,trainLength,false,false);
			this.name = "Train 2";
		}
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		if(moveWest) {
			currentX-=2;
		}
		else {
			currentX+=2;
		}
		
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	
	public boolean offScreen(){
		if (currentX < -200 || currentX > 1550)
			return true;
		else
			return false;				
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
	
	public void setDirection(String direction) {
		switch (direction.toLowerCase()) {
		case "west": this.moveWest = true;
		case "east": this.moveWest = false;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public boolean movingWest() {
		return moveWest;
	}
}
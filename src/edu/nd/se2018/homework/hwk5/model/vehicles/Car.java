package edu.nd.se2018.homework.hwk5.model.vehicles;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk5.model.infrastructure.gate.CrossingGate;
import edu.nd.se2018.homework.hwk5.view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 * @author Josefa
 *
 */
public class Car extends Observable implements IVehicle, Observer{
	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	private double leadCarY = -1;  // Current Y position of car directly in front of this one
	private double leadCarX = -1; // Current X position of car directly in front of this one
	private double speed = 0.5;
	private boolean turnWest = false;
	private boolean turned = false;
		
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		boolean canMove = true; 
		
		// First case.  Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 430 && getVehicleY() > 390)
			canMove = false;
		
		// Second case. Car is too close too other car.
		if (leadCarY != -1 && leadCarX != -1 && getDistanceToLeadCar() < 50 && getHorizDistanceToLeadCar() < 50)
			canMove = false;
		
		if (canMove){
			//checks if the car can turn west and if its within the bounds of the road
			if(turnWest && getVehicleY() < 850 && getVehicleY() > 785 && getVehicleX() <= 800 && getVehicleX() > 390) {
				//moves horizontally left
				currentX -= speed;
				ivCar.setX(currentX);
				turned = true;
			}
			else {
				//moves vertically down
				currentY+=speed;
				ivCar.setY(currentY);
			}
		}
		
		
		
		setChanged();
		notifyObservers();
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public boolean offScreen(){
		if (currentY > 1020)
			return true;
		else
			return false;			
	}
		
	public void reset(){
		currentY = originalY;
	}
	
	public double getDistanceToLeadCar(){
		return Math.abs(leadCarY-getVehicleY());
	}
	
	public double getHorizDistanceToLeadCar(){
		return Math.abs(leadCarX-getVehicleX());
	}
	
	public void removeLeadCar(){
		leadCarY = -1;
		leadCarX = -1;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			leadCarY = (((Car)o).getVehicleY());
			leadCarX = (((Car)o).getVehicleX()); //gets horizontal distance of lead car
			if (leadCarY > 1020) {
				leadCarY = -1;
				leadCarX = -1; //resets if out of screen
			}
		}
			
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getTrafficCommand()=="STOP")			
				gateDown = true;
			else
				gateDown = false;
					
		}				
	}
	
	//sets that the car turns onto the eastwest road
	public void setTurnWest() {
		this.turnWest = true;
	}
	
	//check if the car has turned
	public boolean getIfTurned() {
		return turned;
	}
}

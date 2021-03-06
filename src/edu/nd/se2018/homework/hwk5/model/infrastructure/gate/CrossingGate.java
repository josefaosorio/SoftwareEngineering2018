package edu.nd.se2018.homework.hwk5.model.infrastructure.gate;

import java.util.Observable;
import java.util.Observer;
import edu.nd.se2018.homework.hwk5.model.vehicles.Train;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Context class for Crossing Gate
 * @author Josefa
 *
 */
public class CrossingGate extends Observable implements Observer{
	
	// Crossing Gate location and its trigger & exit points
	private int anchorX;
	private int anchorY;
	private int movingX;
	private int movingY;
	private int leftPoint;
	private int rightPoint;
	private double currTrain1pos;
	private double currTrain2pos;

	private IGateState gateClosed;
	private IGateState gateOpen;
	private IGateState gateClosing;
	private IGateState gateOpening;
	private IGateState currentGateState;
	private Line line; 
	private Pane root;
	
	String gateName;
	
	public CrossingGate(){}
	
	public CrossingGate(int xPosition, int yPosition, String crossingGate){		
		anchorX = xPosition;
		anchorY = yPosition;
		movingX = anchorX;
		movingY = anchorY-60;
		rightPoint = anchorX+250;
		leftPoint = anchorX-250;
		
		// Gate elements
		line = new Line(anchorX, anchorY,movingX,movingY);
		line.setStroke(Color.RED);
	    line.setStrokeWidth(10);
		
		// Gate States
		gateClosed = new GateClosed(this);
		gateOpen = new GateOpen(this);
		gateOpening = new GateOpening(this);
		gateClosing = new GateClosing(this);
		currentGateState = gateOpen;
		gateName = crossingGate;
	}
	
	public Line getGateLine(){
		return line;
	}
	
	public void operateGate(){
		currentGateState.operate();
	}
	
	public void close(){
		if (movingY<anchorY){		
		    movingX+=1;
		    movingY+=1;
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		} else {
			currentGateState.gateFinishedClosing();
		}
	}
	
	public void open(){
		if (movingX>anchorX){
			movingX-=1;
			movingY-=1;
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		}  else {
			currentGateState.gateFinishedOpening();
		}
	}
	
	// State getters and setters
	public IGateState getGateClosedState(){
		return gateClosed;
	}
	public IGateState getGateOpenState(){
		return gateOpen;
	}
	public IGateState getGateClosingState(){
		return gateClosing;
	}
	public IGateState getGateOpeningState(){
		return gateOpening;
	}
	
	public void setGateState(IGateState newState){
		currentGateState = newState;
		setChanged();
		notifyObservers();
	}
	
	public String getTrafficCommand(){
		return currentGateState.getTrafficAction();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Train){
			Train train = (Train)o;
			
			//gets perspective trains locations
			if (train.movingWest())
				currTrain1pos = train.getVehicleX();
			else
				currTrain2pos = train.getVehicleX();
			
			//checks if trains are within the range of the distance of the gates
			if (currTrain1pos > leftPoint && currTrain1pos < rightPoint)
				currentGateState.approachStation();
			
			if (currTrain2pos > leftPoint && currTrain2pos < rightPoint)
				currentGateState.approachStation();
			
			//notify that the train has left the station if outside of the range
			if (currTrain1pos < leftPoint || currTrain1pos > rightPoint) {
				if (currTrain2pos < leftPoint || currTrain2pos > rightPoint)
					currentGateState.leaveStation();
			}
			
		}
	}
}

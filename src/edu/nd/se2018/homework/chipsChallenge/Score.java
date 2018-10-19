package edu.nd.se2018.homework.chipschallenge;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.canvas.Canvas;

public class Score {
	private static int win_width = 850;
	private static int win_length = 625; 
	private GraphicsContext gc;
	private Canvas canvas;
	private AnchorPane root;
	private int fontSize = 15;
	private int x = 635;
	private int y = 300;
	
	public Score() {
		canvas = new Canvas(win_width, win_length);
	}
	
	public void isDead(AnchorPane root) {
		updateText(root, "You died! Game Over.");
	}
	
	//adds new text to window
	private void updateText(AnchorPane root, String text) {
		if(root.getChildren().contains(canvas)) {
			root.getChildren().remove(canvas);
		}
		
		canvas = new Canvas(win_width, win_length);
		gc = canvas.getGraphicsContext2D();
		// from project document
		gc.setStroke(Color.DARKGRAY);
		gc.setFont(Font.font("Arial", FontWeight.BOLD, fontSize));
		gc.fillText(text, x, y);
		root.getChildren().add(canvas);
	}
	
	public void nextLevel(AnchorPane root, int level) {
		String newText = "You've beat Level " + level + "!\nLevel " + level+1 + " coming up.";
		updateText(root, newText);
	}
	
	public void wonGame(AnchorPane root) {
		updateText(root, "You've beat the game!\nCongrats!");
	}

	public void update(AnchorPane root, int level) {
		int chipsLeft = Grid.getGrid().getChipsLeft();
		String newText = "Level: " + level + "\nChips Left: " + chipsLeft;
		updateText(root, newText);
	}
}

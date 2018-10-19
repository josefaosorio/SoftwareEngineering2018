package edu.nd.se2018.homework.chipschallenge;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Game extends Application{
	public static int win_width = 850;
	public static int win_length = 625;
	private AnchorPane root;
	private Scene scene;
	private Grid grid;
	private int level = 1;
	private Player player;
	private State state;
	private Score scorekeeper;
	private Enemy enemy;

	@Override
	public void start(Stage stage) throws Exception{
		root = new AnchorPane();
		scene = new Scene(root, win_width, win_length);
		stage.setTitle("Chip's Challenge");
		stage.setScene(scene);
		stage.show();
		
		reset();
		startGame(stage);
	}
	
	private void reset() {
		root.getChildren().clear();
		grid = new LevelController(root).getLevelGrid(level);
		state = State.PLAYING;
		player = Player.getInstance();
		enemy = Enemy.getInstance();
		scorekeeper = new Score();
		scorekeeper.update(root, level);
	}
	
	//starts the game
	private void startGame(Stage stage) {
		//checks key presses from user
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ESCAPE) {
					stage.close();
					return;
				}
				
				if(state == State.DEAD || state == State.WON) {
					return;
				}
				
				player.move(root, event);
				state = player.getState();
				
				if(state == State.DEAD)
					scorekeeper.isDead(root);
				else if(state == State.WON) {
					if(level == 1) {
						scorekeeper.nextLevel(root, level);
						level++;
						reset();
					}
					else {
						scorekeeper.wonGame(root);
					}
				}
				else {
					scorekeeper.update(root, level);
				}
			}
		});
		
		// Used to delay the bugs movements when they exist
		new AnimationTimer(){
			private long lastUpdate = 0 ;
			@Override
			public void handle(long now) {
				//if the time between the last movement was more than 350 milliseconds, move bug
				if (now - lastUpdate >= 350_000_000) {
					if(enemy.getInstance() != null && enemy.canMove()) {
						enemy.move(root);
					}
					lastUpdate = now ;
                }
			}
		}.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

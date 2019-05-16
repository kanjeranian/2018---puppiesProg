package screens;


import constant.SoundEff;
import gameManager.LogicLoop;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import main.Main;

public class MainMenuScreen extends Scene {
	
//	private boolean inMainMenu;
	
	Canvas cv;
	
	public MainMenuScreen() {
		super(new StackPane(),1200, 900);
//		inMainMenu = true;
		cv = new Canvas(1200,900);
		GraphicsContext gc = cv.getGraphicsContext2D();
		gc.setFill(Color.rgb(147, 44, 44));
		gc.fillRect(0, 0, 1200, 900);
		Button startGame = new Button("CLICK TO PLAY");
		startGame.setPadding(new Insets(40));
		startGame.setFont(Font.font(50));
		startGame.setStyle("-fx-background-color: #282A38; ");
		startGame.setStyle("-fx-background-radius: 5em; ");
		
		startGame.setOnAction(e -> {
//			inMainMenu = false;
			Main.getStage().setScene(Main.getGameScreen().getGameScene());
			LogicLoop.isInGame(true);
		});
		
		getStackPane().getChildren().addAll(cv, startGame);
		
		MediaPlayer sound = new MediaPlayer(new Media(SoundEff.SOUND_GAME.getSource()));
		sound.setOnEndOfMedia(()->{
			sound.seek(Duration.ZERO);
		});
//		AudioClip sound = SoundEff.SOUND_GAME;
		sound.play();
		
		
	}
	
	private StackPane getStackPane() {
		return (StackPane) getRoot();
	}
	
	
}

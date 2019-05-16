package screens;


import gameManager.LogicLoop;
import gameManager.Score;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import main.Main;
import sharedObject.AllObj;

public class GameOverScreen extends Scene {
	
	private Canvas cv;
	private Timeline timeline;
	
	public GameOverScreen() {
		super(new StackPane(),1200, 900);
		cv = new Canvas(1200,900);
		GraphicsContext gc = cv.getGraphicsContext2D();
		Button reStart = new Button("RESTART");
		reStart.setPadding(new Insets(40));
		reStart.setFont(Font.font(50));
		reStart.setStyle("-fx-background-color: #282A38; ");
		reStart.setStyle("-fx-background-radius: 5em; ");
		String score = ""+Score.getScore();
		reStart.setOnAction(e -> {
				AllObj.resetScore();
				Main.getStage().setScene(Main.getMainMenuScreen());
				LogicLoop.isInGame(false);
			});
		
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(1./60), e -> {
					gc.setFill(Color.rgb(147, 44, 44));
					gc.fillRect(0, 0, 1200, 900);
					gc.setFill(Color.WHITE);
					gc.setFont(Font.font(34));
					gc.fillText("SCORE : " + Score.getScore(),507,580);
				}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		getStackPane().getChildren().addAll(cv, reStart);
//		Scene scene = new Scene(Scene)
		
	}
	
	private StackPane getStackPane() {
		return (StackPane) getRoot();
	}
	
	
}

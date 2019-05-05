package logic;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import others.GameScreen;

public class LogicLoop {
	private static LogicLoop instance = new LogicLoop();
	
	private Timeline timeline;
	
	private  LogicLoop() {
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(1./60), e -> {
					//ไปคิดเอาเองว่าแต่ละ loop ทำไรดี ;__;
					
				}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	

	
	
	
	
}

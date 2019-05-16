package gameManager;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import sharedObject.AllObj;


public class KeyPress {
	
    private Scene scene;
	private boolean goUp1, goRight1, goLeft1, attacking1;
	private boolean goUp2, goRight2, goLeft2, attacking2;
	
	public KeyPress(Scene scene) {
		this.scene = scene;
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                
                    case UP:  	goUp1		= true;	break;
                    case LEFT:  goLeft1  	= true; break;
                    case RIGHT: goRight1   	= true; break;
                    case ENTER: attacking1 	= true; break;
          
                    case W:  	goUp2		= true;	break;
                    case A:  	goLeft2  	= true; break;
                    case D: 	goRight2   	= true; break;
                    case SPACE: attacking2 	= true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                
                    case UP:    goUp1 		= false; break;
                    case LEFT:  goLeft1  	= false; break;
                    case RIGHT: goRight1  	= false; break;
                    case ENTER: attacking1 	= false; break;
                    
                    case W:  	goUp2		= false; break;
                    case A:  	goLeft2  	= false; break;
                    case D: 	goRight2   	= false; break;
                    case SPACE: attacking2 	= false; break;
                }
            }
        });
	}
	
	public void setKeyStatus() {
		AllObj.ALL.setKeyStatus(goUp1,goLeft1,goRight1,attacking1,goUp2,goLeft2,goRight2,attacking2);
	}	
	
}

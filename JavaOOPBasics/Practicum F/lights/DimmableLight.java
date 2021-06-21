package lights;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DimmableLight extends Light{
    private int switchcounter = 0;

    public DimmableLight(){
        super();
    }

    @Override
    public void switchLight() {
        // TODO Auto-generated method stub
        if(switchcounter == 1){
            currentBright = 0;
            switchcounter = 2;
        }else if(switchcounter == 2){
            currentBright = 50;
            switchcounter = 3;
        }else if(switchcounter == 3){
            currentBright = 100;
            switchcounter = 1;
        }
    }
}

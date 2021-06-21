package lights;

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

public class BasicLight extends Light{
    
    public BasicLight(){
        super();
    }

    @Override
    public void switchLight() {
        // TODO Auto-generated mSethod stub
        if(currentBright == 100){
            this.currentBright = 0;
        }else{
            this.currentBright = 100;
        }
    }
}

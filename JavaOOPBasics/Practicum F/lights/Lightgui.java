package lights;

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

public class Lightgui extends Application{
    int LightMax;
    int LightMin;
    int switchC = 0;

        @Override
        public void start(Stage stage) throws IOException{
            HBox box = new HBox();
    
            Label label = new Label("EH");
            label.setTextFill(Color.BLACK);
            label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            label.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    
            Button button = new Button("Switch");
            button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button.setOnAction((e) -> {
                if(switchC % 3 == 0){
                    label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                    switchC++;
                }else if(switchC % 2 == 0){
                    label.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
                    switchC++;
                }else{
                    label.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
                    switchC++;
                }
            });
    
            box.getChildren().addAll(label,button);
            Scene s = new Scene(box);
            stage.setScene(s);
            stage.setTitle("Title");
            stage.show();
    
        }
        public static void main(String[] args) {
            launch(args);
        }
}

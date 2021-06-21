package activities;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NameTag extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        Label label = new Label("HELLO MY NAME IS");
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setFont(new Font("Impact",24));
        label.setTextFill(Color.BLUE);
        label.setAlignment(Pos.CENTER);

        Label name = new Label("Your Name");
        name.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        name.setFont(new Font("Impact",24));
        name.setTextFill(Color.RED);
        name.setAlignment(Pos.CENTER);

        box.getChildren().addAll(label,name);
        label.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED, new CornerRadii(40),BorderStroke.THICK)));

        VBox box2 = new VBox();

        TextField field = new TextField();
        field.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        field.setPromptText("Enter your name");

        Button button = new Button("Update name Tag");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Updater updater = new Updater(field,name);
        button.setOnAction(updater);

        Button clear = new Button("Clear");
        clear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        clear.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent args0){
                name.setText(" ");
            }
        });

        box2.getChildren().addAll(box,field,button);

        Scene s = new Scene(box2);
        stage.setScene(s);
        stage.setTitle("Title");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

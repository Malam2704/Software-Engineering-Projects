package activities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BorderPaneActivity extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Label one = makeLabel("Ay","Times New Roman",32,0,Color.RED,Color.BLACK);
        Label two = makeLabel("Ay","Times New Roman",32,0,Color.RED,Color.GREEN);

        BorderPane pane = new BorderPane();
        pane.setCenter(one);
        pane.setBottom(two);
        
        Scene s = new Scene(pane);
        stage.setScene(s);
        stage.setTitle("Border Pane Example");
        stage.show();
    }

    private static Label makeLabel(String text, String font, int fontSize, int padding, Color textColor, Color background){
        Label label = new Label(text);
        label.setFont(new Font(font,fontSize));
        label.setTextFill(textColor);
        label.setPadding(new Insets(padding));
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(background,CornerRadii.EMPTY, Insets.EMPTY)));
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

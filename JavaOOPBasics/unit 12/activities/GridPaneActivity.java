package activities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GridPaneActivity extends Application{

    @Override
    public void start(Stage stage)throws Exception {
        GridPane pane = new GridPane();

        Label result = makeLabel("123.456");
        result.setAlignment(Pos.CENTER_RIGHT);
        result.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.add(result, 0, 0, 4, 1);

        pane.add(makeLabel("AC"), 0, 1, 2, 1);
        pane.add(makeLabel("%"), 2, 1);
        pane.add(makeLabel("/"), 3, 1);

        pane.add(makeLabel("7"), 0, 2);
        pane.add(makeLabel("8"), 1, 2);
        pane.add(makeLabel("9"), 2, 2);
        pane.add(makeLabel("x"), 3, 2);

        pane.add(makeLabel("4"), 0, 3);
        pane.add(makeLabel("5"), 1, 3);
        pane.add(makeLabel("6"), 2, 3);
        pane.add(makeLabel("-"), 3, 3);

        pane.add(makeLabel("1"), 0, 4);
        pane.add(makeLabel("2"), 1, 4);
        pane.add(makeLabel("3"), 2, 4);
        pane.add(makeLabel("+"), 3, 4);

        pane.add(makeLabel("0"), 0, 5, 2, 1);
        pane.add(makeLabel("."), 2, 5);
        pane.add(makeLabel("="), 3, 5);

        Scene s = new Scene(pane);
        stage.setScene(s);
        stage.setTitle("Title");
        stage.show();
    }

    private static Label makeLabel(String text){
        Label label = new Label(text);
        label.setFont(new Font("Arial",64));
        label.setTextFill(Color.BLACK);
        label.setPadding(new Insets(1));
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,CornerRadii.EMPTY, new Insets(1))));
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

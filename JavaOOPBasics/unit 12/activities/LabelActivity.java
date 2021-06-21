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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelActivity extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Here we go");
        label.setFont(new Font("Trebuchet",48));
        label.setTextFill(Color.RED);
        label.setPadding(new Insets(20));
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.PURPLE,CornerRadii.EMPTY, Insets.EMPTY)));

        Label label2 = new Label("Here we go");
        label2.setFont(new Font("Trebuchet",48));
        label2.setTextFill(Color.ORANGE);
        label2.setPadding(new Insets(0));
        label2.setAlignment(Pos.CENTER);
        label2.setBackground(new Background(new BackgroundFill(Color.PURPLE,CornerRadii.EMPTY, Insets.EMPTY)));

        Label label3 = new Label("Here we go");
        label3.setFont(new Font("Trebuchet",48));
        label3.setTextFill(Color.BLUE);
        label3.setPadding(new Insets(40));
        label3.setAlignment(Pos.CENTER);
        label3.setBackground(new Background(new BackgroundFill(Color.PURPLE,CornerRadii.EMPTY, Insets.EMPTY)));

        label.setMaxHeight(Double.MAX_VALUE);
        label2.setMaxHeight(Double.MAX_VALUE);
        label3.setMaxHeight(Double.MAX_VALUE);
        label.setMaxWidth(Double.MAX_VALUE);
        label2.setMaxWidth(Double.MAX_VALUE);
        label3.setMaxWidth(Double.MAX_VALUE);

        label.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED, new CornerRadii(40),BorderStroke.THICK)));

        VBox box = new VBox();
        box.getChildren().add(label);
        box.getChildren().add(label2);
        box.getChildren().add(label3);
        Label label4 = makeLabel("This is a new label","Helvetica",32,0,Color.RED,Color.BLACK);
        label4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        box.getChildren().add(label4);

        Scene s = new Scene(box);
        stage.setScene(s);
        stage.setTitle("Title");
        stage.show();
    }

    private static Label makeLabel(String text, String font, int fontSize, int padding, Color textColor, Color background){
        Label label = new Label(text);
        label.setFont(new Font(font,fontSize));
        label.setTextFill(textColor);
        label.setPadding(new Insets(padding));
        label.setBackground(new Background(new BackgroundFill(background,CornerRadii.EMPTY, Insets.EMPTY)));
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

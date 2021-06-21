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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StackPaneActivity extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();

        // Always use absolute path starting form the repository
        pane.getChildren().addAll(
            new ImageView("file:media/images/emojis/headblue.jpg"),
            new ImageView("file:media/images/emojis/eyesbrown.jpg"),
            new ImageView("file:media/images/emojis/browsbasic.jpg"),
            new ImageView("file:media/images/emojis/mouthbasic.jpg"),
            new ImageView("file:media/images/emojis/noseblue.jpg"));

        stage.setTitle("Image Viewer");
        stage.setScene(new Scene(pane));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

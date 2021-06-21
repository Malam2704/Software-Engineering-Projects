package activities;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Pacman extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        VBox box = new VBox();

        box.getChildren().addAll(
            makeButton("Start","media/sounds/start.wav"), 
            makeButton("Chomp","media/sounds/chomp.wav"), 
            makeButton("End","media/sounds/end.wav"), 
            makeButton("Eat","media/sounds/eat.wav"));

        stage.setTitle("Pacman sound");
        stage.setScene(new Scene(box));
        stage.show();
    }
    
    private static Button makeButton(String text, String path){
        Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        String uri = new File(path).toURI().toString();
        Media media = new Media(uri);
        MediaPlayer player = new MediaPlayer(media);
        player.setOnEndOfMedia(() -> player.stop());

        button.setOnAction((e) -> {
            System.out.println(player.getStatus());
            player.play();
        });

        return button;
    }
    public static void main(String[] args) {
        launch(args);
    }
}

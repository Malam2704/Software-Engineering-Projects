package assignmenttwo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class MPlayer extends Application{
    private Song currentSong;

    @Override
    public void start(Stage stage) throws Exception {
        // Our iamges that will be used in the imageview
        Image blankImage = new Image("file:images/blank.png");
        Image beethovenImage = new Image("file:images/beethoven.png");
        Image mozartImage = new Image("file:images/mozart.png");
        Image bachImage = new Image("file:images/bach.png");
        Image AIW = new Image("file:images/aiw.jpg");
        Image countingStars = new Image("file:images/countingStars.png");
        Image goodLifeImage = new Image("file:images/Good_life_cov_low_res.jpg");
        ImageView view = new ImageView(blankImage);
        
        // Our description label, modded to look better
        Label label = new Label();
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, new CornerRadii(40),BorderStroke.THICK)));
        label.setFont(new Font("Impact",24));
        label.setPadding(new Insets(20));
        label.setTextFill(Color.BLUE);
        label.setAlignment(Pos.CENTER);
        
        // List of songs with a test song made
        Song song = new Song("music/test.wav","this is a test song","file:images/blank.png");
        this.currentSong = song;
        Song MA = new Song("music/amIWrong.mp3","I don't know, some Nostalgic Childhood Song","file:images/aiw.jpg");
        Song Brandenburg = new Song("music/Brandenburg Concerto no. 1 in F major, BWV. 1046 - I. Allegro.mp3","I don't know, some Brandenburg thing made by an old guy","file:images/bach.png");
        Song March = new Song("music/March in D major, K. 215.mp3","I don't know, some March in D minor thing made by an old guy","file:images/beethoven.png");
        Song Piano = new Song("music/countingStars.mp3","I don't know, some Piano Sonata thing made by an old guy","file:images/countingStars.png");
        Song goodLife = new Song("music/goodLife.mp3","I don't know, some Kanye West Song","file:images/Good_life_cov_low_res.jpg");
        

        //---------------------------------------------------
        // These are the song buttons, the user picks and the song will be chosen

        // This follows for all the buttons. A button is made with a string name 
        // for each song with automatic size, and when pressed it stops playing the song before.
        // It calls itself as the current song variable, changes the description label to
        // it's description, stars palying and sets the imageview to it's image.
        Button buttonAdagio = new Button("Nico & Vinz - Am I Wrong");
        buttonAdagio.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonAdagio.setOnAction((e) -> {
            currentSong.stop();
            // song.play();
            label.setText(song.getDescription());
            currentSong = MA;
            MA.play();
            view.setImage(AIW);
        });
        Button buttonBrandenburg = new Button("Brandenburg Concerto no. 1 in F major, BWV. 1046 - I. Allegro.mp3");
        buttonBrandenburg.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonBrandenburg.setOnAction((e) -> {
            currentSong.stop();
            currentSong = Brandenburg;
            label.setText(currentSong.getDescription());
            Brandenburg.play();
            view.setImage(beethovenImage);
        });
        Button buttonMarch = new Button("March in D major, K. 215.mp3");
        buttonMarch.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonMarch.setOnAction((e) -> {
            currentSong.stop();
            currentSong = March;
            label.setText(currentSong.getDescription());
            March.play();
            view.setImage(bachImage);
        });
        Button buttonPiano = new Button("One Republic - Counting Stars");
        buttonPiano.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonPiano.setOnAction((e) -> {
            currentSong.stop();
            currentSong = Piano;
            label.setText(currentSong.getDescription());
            Piano.play();
            view.setImage(countingStars);
        });
        Button buttongoodLife = new Button("Good Life by Kanye West ft. T-Pain");
        buttongoodLife.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttongoodLife.setOnAction((e) -> {
            currentSong.stop();
            currentSong = goodLife;
            label.setText(currentSong.getDescription());
            goodLife.play();
            view.setImage(goodLifeImage);
        });
        //+++++++++++++++++++++++++++++++++++++++++++++++++++
        
        
        //---------------------------------------------------
        // These are the 5 media controls, play, pause stop, 
        // forward, reverse
        // Each button has a stirng showing what it is, and
        // when each button is pressed the respective action for the currentSong
        // is done, like stopping orpausing.
        Button pauseButton = new Button("||");
        pauseButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        pauseButton.setOnAction((e) ->{
            currentSong.togglePause();
        });

        Button forwardButton = new Button(">>");
        forwardButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        forwardButton.setOnAction((e) ->{
            currentSong.forward();
        });

        Button previousButton = new Button("<<");
        previousButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        previousButton.setOnAction((e) ->{
            currentSong.rewind();
        });

        Button playButton = new Button("play");
        playButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        playButton.setOnAction((e) ->{
            currentSong.play();
        });

        Button stopButton = new Button("stop");
        stopButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        stopButton.setOnAction((e) ->{
            currentSong.stop();
        });

        // The border for each media button
        pauseButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED, new CornerRadii(40),BorderStroke.THICK)));
        forwardButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED, new CornerRadii(40),BorderStroke.THICK)));
        previousButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED, new CornerRadii(40),BorderStroke.THICK)));
        playButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED, new CornerRadii(40),BorderStroke.THICK)));
        stopButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED, new CornerRadii(40),BorderStroke.THICK)));

        // An Hbox which puts all the buttons on a line.
        HBox buttonLayout = new HBox();
        buttonLayout.getChildren().addAll(previousButton,playButton,pauseButton,stopButton,forwardButton);
        buttonLayout.setAlignment(Pos.CENTER);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++

        // Vbox is all the vertical parts in the right hand, the buttons, text description
        // and the button layout
        VBox vBox = new VBox();
        vBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);    
        vBox.getChildren().addAll(buttonAdagio,buttonBrandenburg,buttonMarch,buttonPiano,buttongoodLife,label,buttonLayout);
        
        // This is the whole player, a horizontal box of our iamge, and vbox.
        HBox outer = new HBox();
        outer.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        outer.setMaxHeight(Double.MAX_VALUE);
        outer.getChildren().addAll(view,vBox);
        
        stage.setTitle("Pacman sound");
        stage.setScene(new Scene(outer));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package assignmenttwo;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class Song{
    private final String path;
    private final String description;
    private final Image image;
    private final MediaPlayer player;

    public Song(String path, String description, String imgPath){
        this.path = path;
        this.description = description;
        this.image = new Image(imgPath);

        String uri = new File(path).toURI().toString();
        Media media = new Media(uri);
        this.player = new MediaPlayer(media);
        player.setOnEndOfMedia(() -> player.stop());
    }

    public String getDescription() {
        return description;
    }public Image getImage() {
        return image;
    }

    public void play(){
        player.play();
    }
    public void stop(){
        player.stop();
    }
    public void rewind(){
	    Duration c = player.getCurrentTime();
        Duration s = c.add(new Duration(-10000));
        player.seek(s);
    }
    public void forward(){
        Duration c = player.getCurrentTime();
        Duration s = c.add(new Duration(10000));
        player.seek(s);
    }
    public void togglePause(){
        if(player.getStatus() == Status.PLAYING){
            player.pause();
        }else if(player.getStatus() == Status.PAUSED){
            player.play();
        }
    }



}

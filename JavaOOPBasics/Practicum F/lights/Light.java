package lights;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

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

public abstract class Light{
    protected int currentBright;
    private Set<Light> observers = new TreeSet<>();

    public Light(){
        this.currentBright = 0;    
    }

    public int getOnOff(){
        return currentBright;
    }

    public void register(Light l){
        observers.add(l);
    };
    public void deregister(Light l){
        observers.remove(l);
    };
    public abstract void switchLight();
}

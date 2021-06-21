package activities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Updater implements EventHandler<ActionEvent>{
    private final TextField field;
    private final Label label;

    public Updater(TextField field, Label label){
        this.field = field;
        this.label = label;
    }

    @Override public void handle(ActionEvent event) {
        System.out.println(event);
        // grab the text from a text field
        String text = field.getText();

        // slap it in a label
        label.setText(text);
    }
}

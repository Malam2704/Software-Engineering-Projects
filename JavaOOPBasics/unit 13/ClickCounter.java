import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClickCounter extends Application{
    private int counter = 0;

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        Label label = new Label("Number of Clicks");
        Label count = new Label("0");
        count.setAlignment(Pos.CENTER);
        count.setFont(new Font("Courier New", 124));
        count.setPadding(new Insets(20));
        count.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button button = new Button("Add a click");
        
        button.setOnAction((e) -> {
            counter++;
            count.setText(Integer.toString(counter));
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(label,count,button);

        stage.setTitle("Counting Clicks");
        stage.setScene(new Scene(vbox));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

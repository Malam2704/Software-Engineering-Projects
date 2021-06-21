// Mohammed Alam assignment 12.3,
// It works, but for some reason isn't displaying the blank image properly.
// I tried countless features and things, but they all seem to not show the image.
package connectfour.view;

import connectfour.model.ConnectFour;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import connectfour.model.*;

public class ConnectFourGUI extends Application{
    private static final Image BLANK = new Image("file:media/images/blank.png");
    private static final Image BLACK = new Image("file:media/images/blackpiece.png");
    private static final Image WHITE = new Image("file:media/images/whitepiece.png");
    private static final Image SQUARE = new Image("file:media/images/newsquare.png");

    // Fields that are supposed to be for the game, and current number
    // of circles within each column
    private ConnectFour game;
    private int col1moves = 0;
    private int col2moves = 0;
    private int col3moves = 0;
    private int col4moves = 0;
    private int col5moves = 0;
    private int col0moves = 0;

    @Override
    public void start(Stage stage) throws Exception {
        // Label to show status for the game
        Label gameStatus = new Label();
        gameStatus.setText("Currently Playing");
        Label currentTurn = new Label();
        
        // New game is made
        game = new ConnectFour();

        // A board where esach circle is amde for the connect four rows and circles
        // alogn with a broder to show where it is.
        GridPane board = new GridPane();
        for(int col = 0; col<ConnectFour.COLS; col++) {
            for(int row = 0; row<ConnectFour.ROWS; row++) {
                Button circle = makeConnectFourCircle(row,col);
                circle.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, new CornerRadii(40),BorderStroke.THICK)));
                board.add(circle, row, col);
            }
        }

        // An hobx ffor all the buttons to choose a column to make a move on
        HBox columnBox = new HBox();
        columnBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        // Each button follows the same format, padding size, and the action
        // is using the current mvoe num field to change the specific row
        // based on the button and numbe rof moves, it works and you can check on the command
        // line.
        Button col0Button = new Button("Column 0");
        col0Button.setPadding(new Insets(10));
        col0Button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col0Button.setOnAction((e) -> {
            // Image image = BLANK;
            // ImageView pieceView = new ImageView(image);
            try{
                game.move(0);
                Checker sq = game.getChecker(col0moves,0);
                gameStatus.setText(sq + " is currently at play.");
                col1moves++;
                System.out.println(">>" + sq);
            }catch(ConnectFourException e1){
                System.out.println(e1.getMessage());
            }
            
            // Checker piece = game.getCurrentPlayer();
            // Image newImage = BLANK;
            // if(piece == Checker.BLACK){
            //     newImage = BLACK;
            // }else{
            //     newImage = WHITE;
            // }
            // pieceView.setImage(newImage);
        });
        Button col1Button = new Button("Column 1");
        col1Button.setPadding(new Insets(10));
        col1Button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col1Button.setOnAction((e) -> {
            try{
                game.move(1);
                Checker sq = game.getCurrentPlayer();
                gameStatus.setText(sq + " is currently at play.");
                col1moves++;
                System.out.println(">>" + sq);
            }catch(ConnectFourException e1){
                System.out.println(e1.getMessage());
            }
        });
        Button col2Button = new Button("Column 2");
        col2Button.setPadding(new Insets(10));
        col2Button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col2Button.setOnAction((e) -> {
            try{
                game.move(2);
                Checker sq = game.getCurrentPlayer();
                gameStatus.setText(sq + " is currently at play.");
                System.out.println(">>" + sq);
            }catch(ConnectFourException e1){
                System.out.println(e1.getMessage());
            }
        });
        Button col3Button = new Button("Column 3");
        col3Button.setPadding(new Insets(10));
        col3Button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col3Button.setOnAction((e) -> {
            try{
                game.move(3);
                Checker sq = game.getCurrentPlayer();
                gameStatus.setText(sq + " is currently at play.");
                System.out.println(">>" + sq);
            }catch(ConnectFourException e1){
                System.out.println(e1.getMessage());
            }
        });
        Button col4Button = new Button("Column 4");
        col4Button.setPadding(new Insets(10));
        col4Button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col4Button.setOnAction((e) -> {
            try{
                game.move(4);
                Checker sq = game.getCurrentPlayer();
                gameStatus.setText(sq + " is currently at play.");
                System.out.println(">>" + sq);
            }catch(ConnectFourException e1){
                System.out.println(e1.getMessage());
            }
        });
        Button col5Button = new Button("Column 5");
        col5Button.setPadding(new Insets(10));
        col5Button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        col5Button.setOnAction((e) -> {
            try{
                game.move(5);
                Checker sq = game.getCurrentPlayer();
                gameStatus.setText(sq + " is currently at play.");
                System.out.println(">>" + sq);
            }catch(ConnectFourException e1){
                System.out.println(e1.getMessage());
            }
        });
        columnBox.getChildren().addAll(col0Button,col1Button,col2Button,col3Button,col4Button,col5Button);
        
        // Vbox to display label, column boxes and board.
        VBox displayVBox = new VBox();
        displayVBox.getChildren().addAll(gameStatus,currentTurn,columnBox,board);
        stage.setTitle("ConnectFour!");
        stage.setScene(new Scene(displayVBox));
        stage.show();
    }

    // This is supposed to make the grid for the connectfour boxes so eh.
    private Button makeConnectFourCircle(int row, int column) {
        // Initialy is supposed to be a blank field where each button 
        // changes the circle to blank, but there's also a feature where you can click and the image changes.
        Image image = BLANK;
        ImageView pieceView = new ImageView(image);
        
        Button button = new Button("", pieceView); //pass graphic in here
        button.setPadding(new Insets(0));

        button.setBackground(new Background(new BackgroundImage(
            SQUARE,
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER, 
            BackgroundSize.DEFAULT
        )));

        // add a Checker observer to the Checker that changes the image.
        // on the imageview (using setiMAGE IAMGE WHEREVE THE DWUARE CHANGES)
        game.register((sq) -> {
            Checker piece = game.getCurrentPlayer();
            Image newImage = BLANK;
            // if(piece == Checker.BLACK){
            //     newImage = BLACK;
            // }else{
            //     newImage = WHITE;
            // }
            pieceView.setImage(newImage);
        });

        // When button, orcircle is pressed cna simulate color changing, was supposed ot be 
        // used by the column buttons in the starts.
        button.setOnAction((e) -> {
            Checker sq = game.getChecker(row,column);
            try{
                game.move(column);
                System.out.println(">>" + sq);
            }catch(ConnectFourException e1){
                System.out.println(e1.getMessage());
            }
            
            Checker piece = game.getCurrentPlayer();
            Image newImage = BLANK;
            if(piece == Checker.BLACK){
                newImage = BLACK;
            }else{
                newImage = WHITE;
            }
            pieceView.setImage(newImage);
        });

        button.setPrefSize(72, 72);

        return button;
    }

    // public void changeCircleColor(int row, int col, Checker checker){

    // }

    // private Button makeColButton(int col){
    //     // add a Checker observer to the Checker that changes the image.
    //     // on the imageview (using setiMAGE IAMGE WHEREVE THE DWUARE CHANGES)
    //     game.register((sq) -> {
    //         Checker piece = game.getCurrentPlayer();
    //         Image newImage = BLANK;
    //         if(piece == Checker.BLACK){
    //             newImage = BLACK;
    //         }else{
    //             newImage = WHITE;
    //         }
    //         pieceView.setImage(newImage);
    //     });

    //     button.setOnAction((e) -> {
    //         Checker sq = game.getChecker(row,column);
    //         System.out.println(">>" + sq);
    //         try{
    //             game.move(column);
    //             System.out.println(">>" + sq);
    //         }catch(ConnectFourException e1){
    //             System.out.println(e1.getMessage());
    //         }
    //     });
    // }

    public static void main(String[] args) {
        launch(args);
    }
}

package reversi.view;

import javafx.application.Application;
import javafx.geometry.Insets;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import reversi.model.Color;
import reversi.model.Reversi;
import reversi.model.ReversiException;
import reversi.model.Square;
import reversi.model.SquareObserver;

public class ReversiGUI extends Application{
    private static final Image BLANK = new Image("file:media/images/blank.png");
    private static final Image WHITE = new Image("file:media/images/whitepiece.png");
    private static final Image SQUARE = new Image("file:media/images/square.png");
    private static final Image BLACK = new Image("file:media/images/blackpiece.png");

    private Label status;
    private Reversi game;


    @Override
    public void start(Stage stage) throws Exception {
        game = new Reversi();

        GridPane board = new GridPane();
        for(int col = 0; col<Reversi.COLS; col++) {
            for(int row = 0; row<Reversi.ROWS; row++) {
                Button button = makeReversiButton(row,col);
                board.add(button, row, col);
            }
        }
        
        stage.setTitle("Reversi!");
        stage.setScene(new Scene(board));
        stage.show();
    }

    private Button makeReversiButton(int row, int column) {
        Square square = game.getSquare(row, column);
        Image image = BLANK;
        if(square.getOccupyingColor() == Color.BLACK){
            image = BLACK;
        }else if(square.getOccupyingColor() == Color.WHITE){
            image = WHITE;
        }
        ImageView pieceView = new ImageView(image);

        // add a square observer to the square that changes the image.
        // on the imageview (using setiMAGE IAMGE WHEREVE THE DWUARE CHANGES)
        square.register((sq) -> {
            Color piece = square.getOccupyingColor();
            Image newImage = BLANK;
            if(piece == Color.BLACK){
                newImage = BLACK;
            }else{
                newImage = WHITE;
            }
            pieceView.setImage(newImage);
        });
        
        Button button = new Button("", pieceView); //pass graphic in here
        button.setPadding(new Insets(0));

        button.setBackground(new Background(new BackgroundImage(
            SQUARE,
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER, 
            BackgroundSize.DEFAULT
        )));

        button.setPrefSize(72, 72);
        
        button.setOnAction((e) -> {
            Square sq = game.getSquare(row,column);
            System.out.println(">>" + sq);
            try{
                game.move(row,column);
                System.out.println(">>" + sq);
            }catch(ReversiException e1){
                System.out.println(e1.getMessage());
            }
        });

        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

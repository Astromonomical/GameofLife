import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;

public class GameScreen extends Application {

    /**
     * Draw a square at the given coordinates
     * @param x X Coordinate
     * @param y Y Coordinate
     * @return A Rectangle object shaped like a square
     */
    private static Rectangle drawSquare(int x, int y) {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(20);
        rectangle.setWidth(20);
        rectangle.setLayoutX(x);
        rectangle.setLayoutY(y);

        return rectangle;
    }

    public static void main(String[] args) {
        GameScreen.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        // Create game table
        Board gameBoard = new Board();

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(900, 600);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        // Add gridpane to a group
        Group grid = new Group(gridPane);

        // Initialise scene
        Scene scene = new Scene(grid);
        scene.setFill(Color.LIGHTBLUE);

        // Initialise window
        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // Processing code (Carried out 60 times a second)
                System.out.println("Hello World");
                gameBoard.update();
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {

                }
                // Draw squares
                for (int y = 0 ; y < 30 ; y++) {

                    for (int x = 0 ; x < 45 ; x++) {
                        if (gameBoard.getBoard()[x][y].getState()) {
                            grid.getChildren().add(drawSquare(x * 20, y * 20));
                        }

                    }
                }
            }
        }.start();
    }
}

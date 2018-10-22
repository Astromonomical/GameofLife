import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Sets up the board array to use
 */
public class Board {
    private Cell[][] board;

    // Array dimensions
    private final int COLUMNS = 180;
    private final int ROWS = 120;
    private final int SIZE = 5;

    private Boolean inBounds(int x, int y) {
        if ( (x < 0) || (y < 0)) {
            return false;
        }
        if ( (x >= COLUMNS) || y >= ROWS) {
            return false;
        }
        return true;
    }

    private int checkAround(int x, int y) {
        int neighbours = 0;

        // Find all surrounding cells
        for( int colNum = x - 1 ; colNum <= x + 1 ; colNum++) {

            for( int rowNum = y - 1 ; rowNum <= y + 1 ; rowNum++) {

                // Check for centre cell
                if( !((colNum == x) && (rowNum == y)) ) {

                    // Avoid indexoutofbounds error
                    if( inBounds(colNum, rowNum)) {

                        // Check if cell is alive
                        if (board[colNum][rowNum].getState()) {
                            neighbours++;
                        }
                    }
                }
            }
        }
        return neighbours;
    }

    public Board() {
        board = new Cell[COLUMNS][ROWS];
        // Tracker variables for inputting coordinates to cells
        int xTrack = 0;
        int yTrack = 0;

        // Fill board
        for (int y = 0 ; y < ROWS ; y ++) {
            yTrack += SIZE;
            xTrack = 0;

            for (int x = 0 ; x < COLUMNS ; x ++) {
                board[x][y] = new Cell(false, xTrack, yTrack);
                xTrack += SIZE;
            }
        }

        board[10][10].setState(true);
        board[12][10].setState(true);
        board[12][11].setState(true);
        board[14][12].setState(true);
        board[14][13].setState(true);
        board[14][14].setState(true);
        board[16][15].setState(true);
        board[16][14].setState(true);
        board[17][14].setState(true);
        board[16][13].setState(true);


    }

    /**
     * Loops through board and checks against rules
     */
    public void update() {
        int neighbours = 0;

        // Select Cell
        for (int y = 0 ; y < ROWS ; y++) {

            for (int x = 0 ; x < COLUMNS ; x++) {
                // Get neighbour count
                neighbours = checkAround(x, y);

                // Underpopulation
                if (neighbours < 2) {
                    board[x][y].setState(false);
                }

                // Overpopulation
                if (neighbours > 3) {
                    board[x][y].setState(false);
                }

                // Reproduction
                if (neighbours == 3) {
                    board[x][y].setState(true);
                }
            }
        }
    }

    /**
     * Draw a square at the given coordinates
     * @param x X Coordinate
     * @param y Y Coordinate
     * @return A Rectangle object shaped like a square
     */
    private static Rectangle drawSquare(int x, int y, Color colour) {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(5);
        rectangle.setWidth(5);
        rectangle.setLayoutX(x);
        rectangle.setLayoutY(y);
        rectangle.setFill(colour);

        return rectangle;
    }

    public void fillSquares(Group grid) {

        for (int y = 0 ; y < ROWS ; y++) {

            for (int x = 0 ; x < COLUMNS ; x++) {
                if (board[x][y].getState()) {
                    grid.getChildren().add(drawSquare(x * SIZE, y * SIZE, Color.BLACK));
                } else {
                    grid.getChildren().add(drawSquare(x * SIZE, y * SIZE, Color.LIGHTBLUE));
                }

            }
        }
    }

    /**
     * Returns the board to the user for now (Temp Method)
     * @return Board
     */
    public Cell[][] getBoard() {
        return board;
    }

    /**
     * Returns the no. of columns in the board
     * @return Columns
     */
    public int getColumns() { return COLUMNS; }

    /**
     * Returns the no. of rows in the board
     * @return Rows
     */
    public int getRows() { return ROWS; }
}

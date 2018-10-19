/**
 * Sets up the board array to use
 */
public class Board {
    private Cell[][] board;
    private final int COLUMNS = 45;
    private final int ROWS = 30;

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
        board = new Cell[45][30];

        // Fill board
        for (int y = 0 ; y < 30 ; y ++) {

            for (int x = 0 ; x < 45 ; x ++) {
                board[x][y] = new Cell(false);
            }
        }
    }

    /**
     * Loops through board and checks against rules
     */
    public void update() {
        int neighbours = 0;

        // Select Cell
        for (int y = 0 ; y < 30 ; y++) {

            for (int x = 0 ; x < 45 ; x++) {
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
     * Returns the board to the user for now (Temp Method)
     * @return
     */
    public Cell[][] getBoard() {
        return board;
    }
}

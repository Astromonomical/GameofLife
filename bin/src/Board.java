/**
 * Sets up the board array to use
 */
public class Board {
    private Cell[][] board;

    private Boolean

    private int checkAround(int x, int y) {

        // Find all surrounding cells
        for( int colNum = x - 1 ; colNum <= x + 1 ; colNum++) {

            for( int rowNum = y - 1 ; rowNum <= y + 1 ; rowNum++) {

                // Check for centre cell
                if( !((colNum == x) && (rowNum == y)) ) {

                    // Avoid indexoutofbounds error
                    

                }

            }

        }
    }

    public Board() {
        board = new Cell[45][30];
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
                board[x][y]

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

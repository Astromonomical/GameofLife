public class Cell {
    private Boolean state;
    private int xCoord;
    private int yCoord;

    public Cell(Boolean state, int xCoord, int yCoord) {
        this.state = state;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
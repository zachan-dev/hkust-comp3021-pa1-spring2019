package pa1;


/**
 * An immutable class that represents a cell in the grid map
 */
// TODO DONE
public class Cell {
    private final int x;
    private final int y;

    /**
     * Initializes x and y coordinates
     *
     * @param x
     * @param y
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieve x coordinate
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Retrieve x coordinate
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Overrides Object Class equals method to define specific coordinates equal Cells
     *
     * @param obj
     * @return if obj is a Cell with the same x and y coordinates, return true, else return false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) return x == ((Cell) obj).x && y == ((Cell) obj).y;
        else return false;
    }
}

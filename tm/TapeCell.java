package tm;

/**
 * Description: TapeCell is one spot on the tape.
 * @author arjrao91219
 */
public class TapeCell {

    char symbol;

    TapeCell left;

    TapeCell right;

    /**
     * Constructor for TapeCell.
     * @param symbol is the symbol in the cell
     */
    public TapeCell(char symbol) {
        this.symbol = symbol;
        left = null;
        right = null;
    }

    /**
     * @return the symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Changes the symbol.
     * @param symbol is the new symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the left cell
     */
    public TapeCell getLeft() {
        return left;
    }

    /**
     * Sets the left cell.
     * @param left is the left cell
     */
    public void setLeft(TapeCell left) {
        this.left = left;
    }

    /**
     * @return the right cell
     */
    public TapeCell getRight() {
        return right;
    }

    /**
     * Sets the right cell.
     * @param right is the right cell
     */
    public void setRight(TapeCell right) {
        this.right = right;
    }
}

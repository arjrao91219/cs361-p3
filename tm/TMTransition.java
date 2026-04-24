package tm;

/**
 * Description: TMTransition stores where to go, what to write, and which way to move.
 * @author arjrao91219
 */
public class TMTransition {

    final int nextState;

    final char writeSymbol;

    final char moveDirection;

    /**
     * Constructor for TMTransition.
     * @param nextState is the next state
     * @param writeSymbol is the symbol to write
     * @param moveDirection is the direction to move
     */
    public TMTransition(int nextState, char writeSymbol, char moveDirection) {
        this.nextState = nextState;
        this.writeSymbol = writeSymbol;
        this.moveDirection = moveDirection;
    }

    /**
     * @return next state
     */
    public int getNextState() {
        return nextState;
    }

    /**
     * @return symbol to write
     */
    public char getWriteSymbol() {
        return writeSymbol;
    }

    /**
     * @return direction to move
     */
    public char getMoveDirection() {
        return moveDirection;
    }
}

package tm;

/**
 * Description: Tape class, which keeps track of the symbols and head position.
 * @author arjrao91219
 */
public class Tape {

    private TapeCell head;

    private TapeCell leftEnd;

    private TapeCell rightEnd;

    /**
     * Tape constructor. It starts with the input on the tape, or one blank if empty.
     * @param input is the input string for the TM
     */
    public Tape(String input) {
        if (input == null || input.length() == 0) {
            head = new TapeCell('0');
            leftEnd = head;
            rightEnd = head;
        } else {
            for (int i = 0; i < input.length(); i++) {
                addRight(input.charAt(i));
            }
            head = leftEnd;
        }
    }

    /**
     * @return the symbol where the head currently is
     */
    public char read() {
        return head.symbol;
    }

    /**
     * Changes the current cell's symbol.
     * @param symbol is the symbol to put on the tape
     */
    public void write(char symbol) {
        head.symbol = symbol;
    }

    /**
     * Moves the tape head left or right, adding a blank if needed.
     * @param direction is either L or R
     */
    public void move(char direction) {
        if (direction == 'L') {
            if (head.getLeft() == null) {
                TapeCell newCell = new TapeCell('0');
                newCell.right = head;
                head.left = newCell;
                leftEnd = newCell;
            }
            head = head.left;
        } else if (direction == 'R') {
            if (head.right == null) {
                TapeCell newCell = new TapeCell('0');
                newCell.left = head;
                head.right = newCell;
                rightEnd = newCell;
            }
            head = head.right;
        }
    }

    /**
     * Writes and moves based on a transition.
     * @param transition is the transition to use
     */
    public void applyTransition(TMTransition transition) {
        head.symbol = transition.writeSymbol;

        if (transition.moveDirection == 'L') {
            if (head.left == null) {
                TapeCell newCell = new TapeCell('0');
                newCell.right = head;
                head.left = newCell;
                leftEnd = newCell;
            }
            head = head.left;
        } else {
            if (head.right == null) {
                TapeCell newCell = new TapeCell('0');
                newCell.left = head;
                head.right = newCell;
                rightEnd = newCell;
            }
            head = head.right;
        }
    }

    /**
     * @return the visited part of the tape as a string
     */
    public String getContents() {
        StringBuilder sb = new StringBuilder();

        TapeCell current = leftEnd;
        while (current != null) {
            sb.append(current.symbol);
            current = current.right;
        }

        return sb.toString();
    }

    /**
     * Adds a cell to the right for setting up the tape.
     * @param symbol is the symbol for the new cell
     */
    private void addRight(char symbol) {
        TapeCell newCell = new TapeCell(symbol);

        if (leftEnd == null) {
            leftEnd = newCell;
            rightEnd = newCell;
        } else {
            rightEnd.right = newCell;
            newCell.left = rightEnd;
            rightEnd = newCell;
        }
    }
}

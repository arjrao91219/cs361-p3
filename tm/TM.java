package tm;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: TM class stores the states and runs the machine.
 * @author arjrao91219
 */
public class TM {

    private final int numStates;

    private final int numSymbols;

    private final Map<Integer, TMState> states;

    private final TMTransition[][] transitionTable;

    /**
     * Constructor for the TM.
     * @param numStates is the number of states
     * @param numSymbols is the number of input symbols
     */
    public TM(int numStates, int numSymbols) {
        this.numStates = numStates;
        this.numSymbols = numSymbols;
        states = new HashMap<>();
        transitionTable = new TMTransition[numStates][numSymbols + 1];

        for (int i = 0; i < numStates; i++) {
            states.put(i, new TMState(i));
        }
    }

    /**
     * Adds a transition to one state.
     * @param fromState is the state the transition starts at
     * @param readSymbol is the symbol being read
     * @param transition is the transition to add
     */
    public void addTransition(int fromState, char readSymbol, TMTransition transition) {
        states.get(fromState).setTransition(readSymbol, transition);
        transitionTable[fromState][readSymbol - '0'] = transition;
    }

    /**
     * Runs the TM on the input.
     * @param input is the input string
     * @return the final tape contents
     */
    public String run(String input) {
        Tape tape = new Tape(input);
        int currentState = 0;
        int haltingState = numStates - 1;

        while (currentState != haltingState) {
            TMTransition transition = transitionTable[currentState][tape.read() - '0'];

            tape.applyTransition(transition);
            currentState = transition.nextState;
        }

        return tape.getContents();
    }

    /**
     * @return number of symbols
     */
    public int getNumSymbols() {
        return numSymbols;
    }
}

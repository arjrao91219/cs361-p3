package tm;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: TMState class has a name and its transitions.
 * @author arjrao91219 & wreisig
 */
public class TMState {

    private final int name;

    private final Map<Character, TMTransition> transitions;

    /**
     * Constructor for TMState.
     * @param name is the state label
     */
    public TMState(int name) {
        this.name = name;
        transitions = new HashMap<>();
    }

    /**
     * @return the state's name
     */
    public int getName() {
        return name;
    }

    /**
     * Sets a transition for this state.
     * @param symbol is the symbol being read
     * @param transition is the transition to store
     */
    public void setTransition(char symbol, TMTransition transition) {
        transitions.put(symbol, transition);
    }

    /**
     * @param symbol is the symbol being read
     * @return the transition for the symbol
     */
    public TMTransition getTransition(char symbol) {
        return transitions.get(symbol);
    }
}

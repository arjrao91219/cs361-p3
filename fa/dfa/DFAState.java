package fa.dfa;

import java.util.Map;
import java.util.HashMap;

import fa.State;

/**
 * DFAState class has several useful functions for setting and returning state info (transitions, finality, etc.)
 * @author arjrao91219
 */
public class DFAState extends State{

    private boolean isFinal;

    private final Map<Character, DFAState> transitions;

    /**
     * DFAState constructor that takes in a state name as a string
     * @param name
     */
    public DFAState(String name) {
		super(name);
		isFinal = false;
		transitions = new HashMap<>();
	}

    /**
     * @return isFinal boolean, which shows finality of a state
     */
    public boolean isFinal() {
        return isFinal;
    }

    /**
     * Allows for the finality of a state to be set to true or false
     * @param isFinal which will determine whether a state's finality is set to true or false
     */
    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    /**
     * 
     * @return transitions, which is a map of a state's transitions
     */
    public Map<Character, DFAState> getTransitions() {
        return transitions;
    }

    /**
     * @param symb
     * @return transitions of a specific symbol
     */
    public DFAState getTransition(char symb) {
		return transitions.get(symb);
	}

    /**
     * Modify a state's transitions
     * @param symb
     * @param to
     */
	public void setTransition(char symb, DFAState to) {
		transitions.put(symb, to);
	}
    
}

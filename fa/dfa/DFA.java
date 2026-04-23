package fa.dfa;

import fa.State;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * Description: DFA class 
 * @author wreisig and arjrao91219
 */
public class DFA implements DFAInterface {


	private final Set<Character> sigma;

	private final Set<DFAState> states;

	private final Map<String, DFAState> statesByName;

	private final Map<DFAState, Map<Character, DFAState>> delta;

	private DFAState startState;


    /**
     * constructor for DFAs. Each DFA has hashmaps and hashsets of data. 
     * Sigma is the alphabet of characters in the state, states are the states themselves,
     * statesByName stores states and their name (a string)
     * delta is a representation of a transition table, and startState is the initial state
     */
    public DFA() {
		sigma = new LinkedHashSet<>();
		states = new LinkedHashSet<>();
		statesByName = new LinkedHashMap<>();
		delta = new LinkedHashMap<>();
		startState = null;
	}

    @Override
    public boolean addState(String name) {

        // checking if state name is already being used
        if (statesByName.containsKey(name)) {
            return false;
        }

        // creating new state of given name, adding it to set of states, adding name and state to map of states
        DFAState newState = new DFAState(name);
        states.add(newState);
        statesByName.put(name, newState);
        return true;

    }

    @Override
    public boolean setFinal(String name) {
        
        // return value is based on success, so check if we actually find the state
        if (statesByName.containsKey(name)) {
            // set the given state to be final and return true
            DFAState stateToSetFinal = statesByName.get(name);
            stateToSetFinal.setFinal(true);
            return true;
        }
        
        return false;
    }

    @Override
    public boolean setStart(String name) {
         // Pretty similar logic to setFinal, except we can only have one start state, which is initialized above,
         // so just set startState to the given state (based on its name)
        if (statesByName.containsKey(name)) {
            // set the given state to be start and return true
            startState = statesByName.get(name);
            return true;
        }
        
        // return false if state with the given name can't be found
        return false;
    }

    @Override
    public void addSigma(char symbol) {
        sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        if (startState == null) return false;
		if (s == null) return false;

		// "e" is an empty string 
		if (s.equals("e")) {
			return startState.isFinal();
		}

		DFAState current = startState;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!sigma.contains(c)) return false;

			DFAState next = current.getTransition(c);
			if (next == null) return false;

			current = next;
		}
		return current.isFinal();
    }

    @Override
    public Set<Character> getSigma() {
        return sigma;
    }

    @Override
    public State getState(String name) {
        return statesByName.get(name);
    }

    @Override
    public boolean isFinal(String name) {
        DFAState state = statesByName.get(name);
        return state != null && state.isFinal();
    }

    @Override
    public boolean isStart(String name) {
        DFAState state = statesByName.get(name);
        return state != null && state == startState;
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        if (!sigma.contains(onSymb)) return false;

		DFAState from = statesByName.get(fromState);
		DFAState to = statesByName.get(toState);
		if (from == null || to == null) return false;

		from.setTransition(onSymb, to);
		return true;
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        DFA newDFA = new DFA();
        // have to copy everything over from old DFA to the clone

        // populate the new alphabet
        for (char symb : sigma) {
            newDFA.addSigma(symb);
        }

        // populate the states set. have to call getName to pass in a state to addState
        // Also, since we're looping through all the states, should set each final state to final in the new DFA
        for (DFAState state : states) {
            newDFA.addState(state.getName());
            if (state.isFinal()) {
                newDFA.setFinal(state.getName());
            }
        }

        // start state
        newDFA.setStart(startState.getName());

        // now I can copy transitions. loop through every state
        for (DFAState stateSender : states) {
            // and then for every state, loop through each symbol in the alphabet
            for (char symb : sigma) {
                // We're checking every single transition
                DFAState stateReceiver = stateSender.getTransition(symb);

                char tempSymb = symb;

                // Check if the symbol we're on matches either of the specified symbols to swap
                if (symb == symb1) {
                    tempSymb = symb2;
                } else if (symb == symb2) {
                    tempSymb = symb1;
                }
                newDFA.addTransition(stateSender.getName(), stateReceiver.getName(), tempSymb);
            }
        }

        return newDFA;
    }

    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// Q
		sb.append("Q = { ");
		for (DFAState st : states) {
			sb.append(st.getName()).append(" ");
		}
		sb.append("}\n");
		// Sigma
		sb.append("Sigma = { ");
		for (char c : sigma) {
			sb.append(c).append(" ");
		}
		sb.append("}\n");
		// delta
		sb.append("delta =\n");
		sb.append("\t");
		for (char c : sigma) {
			sb.append("\t").append(c);
		}
		sb.append("\n");
		for (DFAState from : states) {
			sb.append(from.getName());
			for (char c : sigma) {
				sb.append("\t");
				DFAState to = from.getTransition(c);
				if (to != null) sb.append(to.getName());
			}
			sb.append("\n");
		}
		// q0
		sb.append("q0 = ");
		if (startState != null) sb.append(startState.getName());
		sb.append("\n");
		// F
		sb.append("F = { ");
		for (DFAState st : states) {
			if (st.isFinal()) sb.append(st.getName()).append(" ");
		}
		sb.append("}");

		return sb.toString();
	}

}

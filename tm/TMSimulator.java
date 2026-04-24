package tm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Description: Main class that reads the file and runs the TM.
 * @author arjrao91219
 */
public class TMSimulator {

    /**
     * Main method.
     * @param args command line arguments, where args[0] is the input file
     * @throws IOException if there is a problem reading the file
     */
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(args[0]));

        int numStates = Integer.parseInt(lines.get(0).trim());
        int numSymbols = Integer.parseInt(lines.get(1).trim());
        TM tm = new TM(numStates, numSymbols);

        int lineIndex = 2;
        int tapeAlphabetSize = numSymbols + 1;

        for (int state = 0; state < numStates - 1; state++) {
            for (int symbol = 0; symbol < tapeAlphabetSize; symbol++) {
                String[] parts = lines.get(lineIndex).trim().split(",");
                int nextState = Integer.parseInt(parts[0]);
                char writeSymbol = parts[1].charAt(0);
                char moveDirection = parts[2].charAt(0);

                tm.addTransition(state, Character.forDigit(symbol, 10),
                    new TMTransition(nextState, writeSymbol, moveDirection));
                lineIndex++;
            }
        }

        String input = "";
        if (lineIndex < lines.size()) {
            input = lines.get(lineIndex).trim();
        }

        System.out.println(tm.run(input));
    }
}

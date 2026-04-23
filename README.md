****************
* Project 1
* Class: CS 361
* 18th-Feb-2026
* Ahmad Rao & Will Reisig
****************

OVERVIEW: This program implements a deterministic finitie automaton in Java. It also supports adding states, transitions, testing whether a string is accepted, swapping two input symbols to produce a new DFA, and printing the DFA in the required format.

INCLUDED FILES:

State.java - Base state class used by the DFA states

FAInterface.java - Interface that defines the common FA operations

DFAInterface.java - Interface that defines DFA specific operations 

DFAState.java - Concrete DFA state that stores whether it is final and the outgoing transitions

DFA.java - The DFA implementation that manages the states, alphabet, transitions, acceptance, swapping, and formatting

DFATest.java - JUnit tests used to verify the program works as intended


COMPILING AND RUNNING:

To compile program on onyx: javac -cp .:/usr/share/java/junit.jar ./test/dfa/DFATest.java

To run DFATest: java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/hamcrest.jar
org.junit.runner.JUnitCore test.dfa.

PROGRAM DESIGN AND IMPORTANT CONCEPTS: 

So the important concept here is that in this program the DFA stores the alphabet and the states in insertion order so that the printing matches the order states and the symbols were added. Then Each state stores a map from the input symbols to the next state which represents the DFA transition function. The accepts method, goes through the DFA from the start state by following the transitions for each character and then returns whether the final state is accepting. The swap method builds a deep copy of the DFA and then swaps two transition labels while keeping the same set of states, start state, and final states.

Testing:

We tested the program using the command line for Junit tests. We also added more tests to cover more possible test cases to ensure our DFA worked properly. We checked the missing transitions, missing start state, invalid character and etc. 

Discussion: 

The main issue we had in this project was mainly implementing the DFA to print in the way we wanted it to. The toString was also a little complicated as well. Another challenge for us was implementing the swap in a way where a correct deep copy instead of modifying the original data in the DFA. Although overall it was a very interesting experience as it was quite fun to make a DFA in java.



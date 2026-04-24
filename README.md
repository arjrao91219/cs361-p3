****************
* Project 3
* Class: CS 361
* 24th-Apr-2026
* Ahmad Rao & Will Reisig
****************

OVERVIEW: This program implements an efficient Turing Machine simulator, which contains a tape that's infinite in both directions. 

INCLUDED FILES:

TMState.java - Base state class used for TMs, each state has a name and transitions

TMTransition.java - Contains next state, symbol to write, direction to move.

TMSimulator.java - Takes command line arguments and actually runs the TM.

TM.java - Stores states.

TapeCell.java - File for each individual spot on the tape.

Tape.java - Tracks symbols on the tape, and the head of the tape.

TMTest.java - JUnit tests used to verify the program works as intended


COMPILING AND RUNNING:

To compile program on onyx: javac -cp .:/usr/share/java/junit.jar ./test/TMTest.java

To run TMTest: java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/hamcrest.jar
org.junit.runner.JUnitCore test.TMTest.

PROGRAM DESIGN AND IMPORTANT CONCEPTS: 

So the Turing Machine has a tape, and that tape has individual tape cells. These cells can be navigated in either direction infinitely. When navigating through states, symbols will be written to the tape, which can override already existing symbols. 

Testing:

We tested the program using the command line for Junit tests. We also added more tests to cover more possible test cases to ensure our TM worked properly.

Discussion: 

The difficult part here was making this program with zero starting code and the tape logic is unlike anything in NFA or DFA logic, so this project required a different way of thinking to implement it. 



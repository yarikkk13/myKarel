package com.shpp.p2p.cs.dnapruishkin.assignment1;

import com.shpp.karel.KarelTheRobot;

/** Condition: Karl's task is to go around obstacles to pick up a beeper (newspaper) and return to the starting position.
 * Result: KAREL  walked around the obstacles, picked up the beeper (newspaper) and returned to the starting position.*/
public class Assignment1Part1 extends KarelTheRobot {

    /** Condition: The first method describes the movement of the robot Karel to a given point, the second of the
     * selection of the beeper, and the third movement of Karel to the starting position.
     * Result: The conditions of the task are met beeper lifted Karel in the starting position*/
    public void run() throws Exception {
        goToBeeper();
        // Karel raises the beeper (newspaper).
        pickBeeper();
        returnToStartingPosition();
    }

    /** Condition: Turning to the right Karel moves to Bieber (newspaper)
     * Result: Karel got to the beeper*/
    private void goToBeeper() throws Exception {
        turnRight();
        move();
        turnLeft();
        forwardMovement();
    }

    /** Condition: Karel with a beeper (newspaper) returns to the starting position. Leaning against the wall,
     * turn to the right and return to its original position.
     * Result: Karel returned to starting position.*/
    private void returnToStartingPosition() throws Exception {
        turnLeft();
        turnLeft();
        forwardMovement();
        turnRight();
        move();
        turnRight();
    }

    /**
     * Condition: turn right combination
     */
    public void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    /**
     * Condition: Karel moves forward while there is no beeper
     */
    public void forwardMovement() throws Exception {
        int fourSteps =4;
        for (int i = 0; i <fourSteps; i++) {
            move();
        }
    }
}




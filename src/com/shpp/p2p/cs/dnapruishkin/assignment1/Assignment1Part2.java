package com.shpp.p2p.cs.dnapruishkin.assignment1;

import com.shpp.karel.KarelTheRobot;

/**
 * Karel needs to build the missing bricks in the columns, regardless of their number
 */
public class Assignment1Part2 extends KarelTheRobot {

    /** Condition: The task of these methods is to fill the empty space on the lines that are located after 4
     * cells with beepers.
     * Result: Created a method for setting beepers in empty cells, for moving to other fields and checking for
     * the end of the field */
    public void run() throws Exception {
        loopingAllMethod();
        installationBeepers();
        forwardMovement();
    }


    /** Condition: a method that runs the method of moving Karel and setting beeps to empty cells in
     *  a circle until true.
     *  Result: Karel installed beepers and went to the border of the map */
    private void loopingAllMethod() throws Exception {
        while (frontIsClear()) {
            installationBeepers();
            forwardMovement();
        }
    }

    /** Condition: Karel goes south and installs a beeper into empty cells
     * Result: beepers set to empty cells */
    private void installationBeepers() throws Exception {
        //check if the world is in one cell
        if(frontIsBlocked()&&leftIsBlocked()  ){
            putBeeper();
        }
        turnLeft();
        //placing beepers in empty cages
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
                move();
            } else if (beepersPresent()) {
                move();
            }
            if (noBeepersPresent()) {
                putBeeper();
            }
        }
        // turn 180 degrees
        turnLeft();
        turnLeft();
    }

    /**  Condition: Karel goes from the beginning of the column to the edge of the map. Approaching the edge of
     * the map, turns to the left and makes a check for emptiness
     * Result: Karel is on a new line and is ready to build a new column else columns no more. */
    private void forwardMovement() throws Exception {
        while (frontIsClear()) {
            move();
        }
        turnLeft();
        //field end check
        if (frontIsClear()) {
            nextLocation();
        }
    }

    /**  Condition: If the columns are located on the 1st or 5th or 9th row, then the distance between them is 4 cells
     * Result: Karel makes 4 moves in the cells  */
    private void nextLocation() throws Exception {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }
}




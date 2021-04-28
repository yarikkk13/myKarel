package com.shpp.p2p.cs.dnapruishkin.assignment1;

import com.shpp.karel.KarelTheRobot;

/**
 * Karel staggered beepers.
 */
public class Assignment1Part4 extends KarelTheRobot {

    /**
     * Condition: The task of these methods is to check the boundaries of various maps and arrange
     * the beepers in a double row
     * Result: Beepers are staggered by Karel.
     */
    public void run() throws Exception {
        checkOneCell();
        combiningAllFunctions();
    }

    /**
     * Condition: The cycle, under the given conditions, runs in a circle the methods that arrange
     * the beepers in a checkerboard pattern
     * Result: Karel arranged beepers
     */
    private void combiningAllFunctions() throws Exception {
        while (frontIsClear() && noBeepersPresent()) {
            // check for different cards
            oneLineCard();
            //placement of beepers on two lines
            beeperPlacement();
            // check for beeper in the last cell
            checkingTheLastCell();
            // moving to the next level
            moveNextLevel();
        }
    }

    /**
     * Condition: If the world consists of one cell.
     * Result: Put a beeper
     */
    private void checkOneCell() throws Exception {
        if (frontIsBlocked() && leftIsBlocked()) {
            putBeeper();
        }
    }

    /**
     * Condition: World check 1 * 8
     * Result:  Put a beeper
     */
    private void oneLineCard() throws Exception {
        while (leftIsBlocked() && frontIsClear()) {
            putBeeper();
            move();
            if (frontIsClear()) {
                move();
            }
        }
    }

    /**
     * Condition: Karel moves to a new level of placement of audio signals If there are free levels
     * Result: If there is a level, sound signals are set or the end of the task
     */
    private void  moveNextLevel() throws Exception {
        // return to start
        while (frontIsClear()) {
            move();
        }
        // turn north and check for a new level
        if (frontIsBlocked()) {
            turnRight();
            if (frontIsClear()) {
                move();
                if (frontIsClear()) {
                    move();
                    turnRight();
                }
            }
        }
    }

    /**
     * Condition: Checking for the presence of a beeper in the last cell of an even level
     * Result: The beeper will be installed if it is not there
     */
    private void checkingTheLastCell() throws Exception {
        if (noBeepersPresent()) {
            turnBack();
            move();
            if (noBeepersPresent()) {
                turnBack();
                move();
                putBeeper();
                turnBack();
            }
        }
    }

    /**
     * Condition: Staggered beeper arrangement on two levels
     * Result: The chessboard is built
     */
    private void beeperPlacement() throws Exception {
        //setting the beeper at an even level
        if (frontIsClear() && noBeepersPresent()) {
            putBeeper();
            move();
            turnLeft();
            //transition to an odd level setting a beeper
            if (frontIsClear()) {
                move();
                turnBack();
                putBeeper();
            }
            //transition to even level
            if (frontIsClear()) {
                move();
                turnLeft();
                if (frontIsClear()) {
                    move();
                }
            }
            //recursion
            beeperPlacement();
        }
    }

    /** Condition: turn right combination*/
    public void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    /** Condition: turn back combination*/
    public void turnBack() throws Exception {
        for (int i = 0; i < 2; i++) {
            turnLeft();
        }
    }
}

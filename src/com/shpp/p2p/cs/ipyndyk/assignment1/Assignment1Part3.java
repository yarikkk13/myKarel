package com.shpp.p2p.cs.ipyndyk.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {
    /*
    Karel checks whether the world consists of 1 row and 1 column
    Karel fills the first line with beepers until it reaches the middle a
    Karel go to the second line
    Karel  puts a beeper in the middle of the second line and rotates 180 degrees
    Karel returns to the first line and cleans it of beepers
    Karel returns to the second line and finds the beeper and picks it up
    Karel goes to the first line and puts the beeper

     */
    public void run() throws Exception {
        if (!frontIsClear()) {
            putBeeper();
        } else {


        putBeeperFirstRow();
        moveSecondRow();
        putBeeper();
        turnAround();
        comeBackFirstRowAndClearFirstRow();
        comeBackSecondRowForBeeperAndPick();
        comeBackFirstRowAndPutBeeper();
    }

    }

    public void putBeeperFirstRow() throws Exception {
        putBeeper();
        while (frontIsClear()) {
            move();
        }
        putBeeper();
        turnAround();
        move();

        while (noBeepersPresent()) {
            if (noBeepersPresent()) {
                putBeeper();
                move();
                while (noBeepersPresent()) {
                    move();
                }
                turnAround();
                move();
                putBeeper();
                move();

            }
        }
    }

    /*
    Karel go to the second line
     */
    public void moveSecondRow() throws Exception {
        if (facingWest()) {
            turnAround();
            move();
            turnLeft();
            move();

        } else {
            turnLeft();
            move();
        }

    }

    /*
     * Karel returns to the right
     */
    public void turnright() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /*
    Karel rotates 180 degrees
    */

    public void turnAround() throws Exception {
        turnLeft();
        turnLeft();

    }

    /*
     *   Karel returns to the first row
     *  goes to the beginning
     *  raises all the beepers on the first row
     */
    public void comeBackFirstRowAndClearFirstRow() throws Exception {
        move();
        turnLeft();
        while (frontIsClear()) {
            move();
        }
        pickBeeper();
        turnAround();
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                move();
                while (beepersPresent()) {

                    pickBeeper();
                }
            } else {
                pickBeeper();
            }
        }
        {
        }
    }

    /*
     Karel returns behind the beeper on the second line and raises it
     */
    public void comeBackSecondRowForBeeperAndPick() throws Exception {
        turnright();
        move();
        turnright();
        while (noBeepersPresent()) {
            move();
        }
        pickBeeper();

    }

    /*
    Karel returns to the first line and puts the beeper
     */
    public void comeBackFirstRowAndPutBeeper() throws Exception {
        turnright();
        move();
        putBeeper();
    }
}









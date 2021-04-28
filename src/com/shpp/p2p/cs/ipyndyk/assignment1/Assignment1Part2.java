
package com.shpp.p2p.cs.ipyndyk.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {
    /*
    Karel will mark with beepers on the first line 1,5,9 ... columns
    Karel checks the world is not 1 width,if yes, let us call 1 cell by beeper and
     we build a column with bireps

    if the width is greater than 1, we start the loop: Karel turn left,
    Karel builds a column, rotates 180 degrees, comes back
    Karel turn left
    Karel goes through 4 steps (if it is empty in front)
    Karel builds the last column

     */
    public void run() throws Exception {
        KarelBuildsFirstRow();
        if (!frontIsClear()) {
            turnLeft();
            putBeeper();
            if (frontIsClear()) {
                while (frontIsClear()) {
                    if (frontIsClear()) {

                        move();
                        putBeeper();
                    } else {
                        putBeeper();
                    }
                }


            }
        } else {
            while (frontIsClear()) {
                turnLeft();
                buildingWall();
                turnAround();
                comeBack();
                turnLeft();
                takeFourSteps();

            }
            checkLastColumn();
        }
    }

    /*
     * Karelian builds the first column
     */
    public void buildingWall() throws Exception {
        while (frontIsClear()) {
            if (beepersPresent()) {
                move();
            } else {
                putBeeper();
                move();
            }
        }
        if (noBeepersPresent()) {
            putBeeper();
        }
    }


    /*
     * Karel returns to the starting position
     */
    public void comeBack() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

    /*
     * Karel rotates 180 degrees
     */
    public void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /*
    Karel takes four steps forward if possible

     */
    public void takeFourSteps() throws Exception {
        if (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                if (frontIsClear()) {
                    move();
                    if (frontIsClear()) {
                        move();


                    }
                }
            }
        }
    }

    /*
    check if you need to fill in the last column
    if the last column satisfies the condition, we build pebbles on it
     */
    public void checkLastColumn() throws Exception {
        turnLeft();
        if (beepersPresent()) {
            while (frontIsClear()) {
                move();
                if (noBeepersPresent()) {
                    putBeeper();
                }
            }
        }
    }

    /*
    Karel passes the first line, on 1,5,9 ... to a column puts a beeper
    And comes back
     */
    public void KarelBuildsFirstRow() throws Exception {
        while (frontIsClear())
            if (frontIsClear()) {
                move();
                if (frontIsClear()) {
                    move();
                    if (frontIsClear()) {
                        move();
                        if (frontIsClear()) {
                            move();
                            if (noBeepersPresent()) {

                                putBeeper();
                            }
                        }
                    }
                }


            }
        turnAround();
        comeBack();
        turnAround();

    }
}







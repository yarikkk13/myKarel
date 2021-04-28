package com.shpp.p2p.cs.aplakhtiev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {


    public void run() throws Exception {
        while (frontIsClear()) {
            makeRowStones();
            returnToStartRow();
            moveToNextRow();
        }
        makeRowStones();
    }

    //walk forward until there is no wall in front of you
    private void walkToWall() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

    //turn around = turn left twice
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    //create a row of stones
    private void makeRowStones() throws Exception {
        turnLeft();
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            move();
        }
        if (noBeepersPresent()) {
            putBeeper();
        }
    }

    //back to the beginning of the row
    private void returnToStartRow() throws Exception {
        turnAround();
        walkToWall();
        turnLeft();
    }

    //move to the next row
    private void moveToNextRow() throws Exception {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }
}


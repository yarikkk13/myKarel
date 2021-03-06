package com.shpp.p2p.cs.ymahas.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {
    public void run() throws Exception {
        stonemason();
    }


    // in this action we put beepers on our column, except the last on
    private void putBeepersInColumn() throws Exception {
        if (frontIsClear()) {
            while (frontIsClear()) {
                if (noBeepersPresent()) {
                    putBeeper();
                }
                move();
            }
        } else if (frontIsBlocked()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            turnAround();
        }

    }

    // i called it miner move because in this action Karel checks if it safe to move on
    private void minerMove() throws Exception {
        if (frontIsClear()) {
            move();
            turnLeft();
        }
    }

    // in this action we rotate our Karel on 180 degrees
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    //    in this action we put beepers for two times, and because of it the last beeper becomes
    //    first and we have complete column
    private void putBeepersAndGoBack() throws Exception {
        putBeepersInColumn();
        turnAround();
        putBeepersInColumn();
    }

    // in this action if the next column exist, we go to it
    private void goToAnotherColumn() throws Exception {
        if (leftIsClear()) {
            turnLeft();
            move();
            move();
            move();
            minerMove();
        }
    }

    // this is action in which we unite all previous actions and because of what we can build columns
    private void stonemason() throws Exception {
        turnLeft();
        while (frontIsClear() || rightIsClear()) {
            putBeepersAndGoBack();
            goToAnotherColumn();
        }
    }
}
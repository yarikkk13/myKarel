package com.shpp.p2p.cs.ymahas.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part5 extends KarelTheRobot {
    public void run() throws Exception {
        putBeepersLikeAChessMaster();
    }

    // in this action we put beepers on odd rows(first,third,fifth etc)
    private void seedingTheOddRow() throws Exception {
        while (frontIsClear()) {
            putBeeper();
            minerMove();
            minerMove();
        }
    }

    // in this action we put beepers on even rows (second, fourth etc)
    private void seedingTheEvenRow() throws Exception {
        while (frontIsClear()) {
            minerMove();
            putBeeper();
            minerMove();
        }
    }

    // i called it miner move because in this action Karel checks if it safe to move on
    private void minerMove() throws Exception {
        if (frontIsClear()) {
            move();
        }
    }

    // in this action we rotate Karel for 180 degrees
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    // in this action Karel moves back to the position in which he started in this row
    private void goingBack() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

    // in this action Karel is rotating for 90 degrees right
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    // in this action when Karel finished row goes to the next start point
    private void goingToTheNextRow() throws Exception {
        turnAround();
        goingBack();
        turnRight();
        move();
        turnRight();
    }

    // my Karel have a bug that in the row with odd length he doesn't put the last beeper,
    // so in this action i check it, and if it is true i put down these beepers
    private void checkingTheLastRow() throws Exception {
        if (noBeepersPresent() && rightIsClear()) {
            turnRight();
            move();
            if (noBeepersPresent()) {
                goingBack();
                turnAround();
                seedingTheOddRow();
                turnAround();
                move();
                if (noBeepersPresent()) {
                    turnAround();
                    move();
                    putBeeper();
                }
            }
        }
    }

    // the last bug can be if there is only one cell or there is only one row with odd length
    // so in this action i check it, and if it needs i put those beepers
    private void lastCheck() throws Exception {
        if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked() && noBeepersPresent()) {
            turnAround();
            if (frontIsClear()) {
                move();
                if (noBeepersPresent()) {
                    turnAround();
                    move();
                    putBeeper();
                }
            } else putBeeper();
        }
    }

    private void putBeepersLikeAChessMaster() throws Exception {
        while (leftIsClear()) {
            seedingTheOddRow();
            goingToTheNextRow();
            seedingTheEvenRow();
            if (leftIsClear()) {
                goingToTheNextRow();
            }
        }
        // for this checking i didn't make its own method because it rather simple
        // if the world has odd quantity of rows(or only one for example)
        // i should check it, and if its true i put beepers on it
        if (leftIsBlocked() && noBeepersPresent()) {
            seedingTheOddRow();
        }
        checkingTheLastRow();
        lastCheck();
    }
}

package com.shpp.p2p.cs.ymahas.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {
    public void run() throws Exception {
        putLikeAChessMaster();
    }


    private void seedingTheOddRow() throws Exception {
        while (frontIsClear()) {
            putBeeper();
            minerMove();
            minerMove();
        }
    }

    private void seedingTheEvenRow() throws Exception {
        while (frontIsClear()) {
            minerMove();
            putBeeper();
            minerMove();
        }
    }

    private void minerMove() throws Exception {
        if (frontIsClear()) {
            move();
        }
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    private void goingBack() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    private void putLikeAChessMaster() throws Exception {
        while (leftIsClear()) {
            seedingTheOddRow();
            turnAround();
            goingBack();
            turnRight();
            move();
            turnRight();
            seedingTheEvenRow();
            if (leftIsClear()) {
                turnAround();
                goingBack();
                turnRight();
                move();
                turnRight();
            }
        }
        if (leftIsBlocked()&&noBeepersPresent()){
            seedingTheOddRow();
        }
    }


}

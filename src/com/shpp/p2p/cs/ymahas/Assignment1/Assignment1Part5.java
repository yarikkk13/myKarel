package com.shpp.p2p.cs.ymahas.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part5 extends KarelTheRobot {
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
            goingToTheNextRow();
            seedingTheEvenRow();
            if (leftIsClear()) {
                goingToTheNextRow();
            }
        }
        if (leftIsBlocked() && noBeepersPresent()) {
            seedingTheOddRow();
        }
        checkingTheLastRow();
        lastCheck();
    }

    private void goingToTheNextRow()throws Exception {
        turnAround();
        goingBack();
        turnRight();
        move();
        turnRight();
    }

    private void lastCheck()throws Exception {
        if (frontIsBlocked()&&rightIsBlocked()&&leftIsBlocked()&&noBeepersPresent()){
            turnAround();
            if (frontIsClear()){
                move();
                if (noBeepersPresent()){
                    turnAround();
                    move();putBeeper();
                }
            }else putBeeper();
        }
    }

    private void checkingTheLastRow() throws Exception {
        if (noBeepersPresent()&&rightIsClear()) {
            turnRight();
            move();
            if (noBeepersPresent()) {
                goingBack();
                turnAround();
                seedingTheOddRow();
                turnAround();
                move();
                if(noBeepersPresent()){
                    turnAround();
                    move();
                    putBeeper();
                }
            }

        }
    }



}

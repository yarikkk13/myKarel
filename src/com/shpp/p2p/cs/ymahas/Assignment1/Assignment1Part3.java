package com.shpp.p2p.cs.ymahas.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {

    public void run() throws Exception {
        findTheMidAndPutBeeper();
    }

    // in this action we rotate our Karel on 180 degrees
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    //in this action we put beepers on the whole length of south row
    private void putBeepers() throws Exception {
        putBeeper();
        while (frontIsClear()) {
            move();
            putBeeper();
        }
    }

    // in this action we are going the borders of our row and picking up that beepers
    private void pickingUpAtBorders() throws Exception {
        while (frontIsClear()) {
            move();
        }
        pickBeeper();
        turnAround();
        while (frontIsClear()) {
            move();
        }
        pickBeeper();
        turnAround();
        move();
    }

    //in this action we are going from one to another edges and picking up beepers,
    //and because of that we are moving to the center, and the last beeper will be central
    private void pickingTheBeepersAtEdges() throws Exception {
        while (beepersPresent()) {
            move();
        }
        turnAround();
        move();
        pickBeeper();
    }

    // as you know from previous comment we pick up the last beeper from the center, and stop near the middle of row
    // now we must return to the middle and put the beeper
    private void theLastMove() throws Exception {
        turnAround();
        if (frontIsClear()) {
            move();
        }
        putBeeper();
    }

    // in this action we do what i describe on previous comments, and then Karel puts beeper in mid
    private void findTheMidAndPutBeeper() throws Exception {
        //that i made to check if the world consists of one cell
        if (frontIsBlocked()) {
            putBeeper();
        } else {
            putBeepers();
            turnAround();
            pickingUpAtBorders();
            while (beepersPresent()) {
                pickingTheBeepersAtEdges();
                move();
            }
            theLastMove();
        }
    }
}

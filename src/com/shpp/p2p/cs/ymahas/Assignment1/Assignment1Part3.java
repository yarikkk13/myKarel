package com.shpp.p2p.cs.ymahas.Assignment1;

import com.shpp.karel.KarelTheRobot;


//public class Assignment1Part3 extends KarelTheRobot {
//    int i = 0;
//
//    public void run() throws Exception {
//        findTheMidAndPutBeeper();
//    }
//
//    // in this action we rotate our Karel on 180 degrees
//    private void turnAround() throws Exception {
//        turnLeft();
//        turnLeft();
//    }
//    //in this action we explore the length of south row
//    private void counter() throws Exception {
//        while (frontIsClear()) {
//            move();
//            i++;
//        }
//    }
//    // in this action we go the mid of the south row
//    private void goToMid() throws Exception {
//        for (int j = 0; j < i / 2; j++) {
//            move();
//        }
//    }
//    // in this action we do what i describe on previous comments, and then Karel puts beeper in mid
//    private void findTheMidAndPutBeeper() throws Exception {
//        counter();
//        turnAround();
//        goToMid();
//        putBeeper();
//    }
//}


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

    // in this action we go the mid of the south row
    private void pickingUp() throws Exception {
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

    private void findingKriini() throws Exception {
        while (beepersPresent()) {
            move();
        }
        turnAround();
        move();
        pickBeeper();
    }

    private void theLastMove() throws Exception {
        turnAround();
        if (frontIsClear()) {
            move();
        }
        putBeeper();
    }


    // in this action we do what i describe on previous comments, and then Karel puts beeper in mid
    private void findTheMidAndPutBeeper() throws Exception {
        if (frontIsBlocked()) {
            putBeeper();
        } else {
            putBeepers();
            turnAround();
            pickingUp();
            while (beepersPresent()) {
                findingKriini();
                move();
            }
            theLastMove();
        }
    }
}

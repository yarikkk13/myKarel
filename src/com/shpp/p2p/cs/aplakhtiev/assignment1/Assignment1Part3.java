package com.shpp.p2p.cs.aplakhtiev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {


    public void run() throws Exception {
        //start();
        //
        moveToTheSideAndPutBeeprInLastPosition();
        turnAround();
        moveToTheSideAndPutBeeprInLastPosition();
        turnAround();
        //just go to the end
        if (frontIsClear()) {
            move();
        }
        //main algorithm
        mainPart();
    }

    private void mainPart() throws Exception {

        while (!beepersPresent()) {
            if (frontIsClear()) {
                move();
            }
        }
        // wa are standing on beeper
        //turn around and step back
        turnAround();
        if (frontIsClear()) {
            move();
        }
        //put new beeper
        turnAround();
        if (noBeepersPresent()) {
            putBeeper();
        }

        turnAround();
        if (frontIsClear()) {
            move();
        }

        if (beepersPresent()) {
            //if we are there, that`s mean that
            //previous cell was the last clean cell(middle)
            //and now we should remove all beepers from one side
            pickBeeper();
            clean();
            turnAround();
            // go to center and step over hom
            goToCenter();
            // remove all beepers
            clean();
        } else {
            mainPart();
        }
    }

    private void goToCenter() throws Exception {
        while (noBeepersPresent()) {
            move();
        }
    }

    private void clean() throws Exception {
        //remove all beepers from 1 side
        while (frontIsClear()) {
            move();
            if (beepersPresent()) {
                pickBeeper();
            }
        }

    }

    private void moveToTheSideAndPutBeeprInLastPosition() throws Exception {
        while (frontIsClear()) {
            move();
        }
        putBeeper();
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

}


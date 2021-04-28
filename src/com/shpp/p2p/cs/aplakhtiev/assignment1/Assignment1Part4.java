package com.shpp.p2p.cs.aplakhtiev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {


    public void run() throws Exception {
        if (!frontIsClear()) {
            turnLeft();
        }
        makeColumnAndTurnToNorth();
        while (frontIsClear()) {
            makeSecondColumn();
            makeFirstColumn();
        }
    }

    //create the first row (not paired) when Karel walks east
    private void makeFirstColumn() throws Exception {
        if (frontIsClear()) {
            if (beepersPresent()) {
                move();
                faceToEast();
                move();
                makeColumnAndTurnToNorth();
            } else {
                move();
                faceToEast();
                makeColumnAndTurnToNorth();
            }
        }
    }


    //create a second row (paired) when Karel walks west
    private void makeSecondColumn() throws Exception {
        if (frontIsClear()) {
            if (beepersPresent()) {
                move();
                faceToWest();
                move();
                makeColumnAndTurnToNorth();

            } else {
                move();
                faceToWest();
                makeColumnAndTurnToNorth();
            }
        }
    }

    //turn Karel's face north
    private void faceToNorth() throws Exception {
        while (notFacingNorth()) {
            turnLeft();
        }
    }

    //turn Karel's face west
    private void faceToWest() throws Exception {
        while (notFacingWest()) {
            turnLeft();
        }
    }

    //turn Karel's face east
    private void faceToEast() throws Exception {
        while (notFacingEast()) {
            turnLeft();
        }
    }

    //create a column and turn north at the end
    private void makeColumnAndTurnToNorth() throws Exception {
        putBeeper();
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
        faceToNorth();
    }
}


package com.shpp.p2p.cs.aplakhtiev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {

    //only three methods in a method run
    public void run() throws Exception {
        moveToTheNewspaper();
        //pick up a newspaper
        pickBeeper();
        moveToTheStartingPoint();
    }

    //method for moving Karel to the newspaper
    private void moveToTheNewspaper() throws Exception {
        //change of row
        turnRight();
        move();
        turnLeft();
        //move to the newspaper
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

    //method for moving Karel to the starting point after pick up a newspaper
    private void moveToTheStartingPoint() throws Exception {
        //turn around
        turnLeft();
        turnLeft();
        //move to the wall
        while (frontIsClear()) {
            move();
        }
        //change of row to start position
        turnRight();
        move();
        turnRight();
    }

    //three turns to the left = 1 turn to the right
    private void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }
}
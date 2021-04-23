package com.shpp.p2p.cs.ymahas.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {
    public void run() throws Exception {
        goToTheNewspaper();
        pickBeeperAndTurnAround();
        returnToTheStart();
    }
// in this action we are going to newspaper
    private void goToTheNewspaper() throws Exception {
        turnRight();
        move();
        turnLeft();
        move();
        move();
        move();
        move();
    }
// we are heading 90 degrees of the start position
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }
// in this action we pick the beeper and heading the way we came out
    private void pickBeeperAndTurnAround() throws Exception {
        pickBeeper();
        turnLeft();
        turnLeft();
    }
// in this action we go the point of start
    private void returnToTheStart() throws Exception {
        move();
        move();
        move();
        move();
        turnRight();
        move();
        turnRight();
    }
}


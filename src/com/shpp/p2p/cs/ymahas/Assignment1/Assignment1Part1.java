package com.shpp.p2p.cs.ymahas.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {
    public void run() throws Exception {
        goToTheNewspaper();
        pickBeeperAndTurnAround();
        returnToTheStart();
    }

    private void goToTheNewspaper() throws Exception {
        turnRight();
        move();
        turnLeft();
        move();
        move();
        move();
        move();
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    private void pickBeeperAndTurnAround() throws Exception {
        pickBeeper();
        turnLeft();
        turnLeft();
    }

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


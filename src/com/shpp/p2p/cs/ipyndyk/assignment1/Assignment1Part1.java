package com.shpp.p2p.cs.ipyndyk.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {
    public void run() throws Exception {
        goTonewspape();
        pickBeeper();
        comeBack();
    }

    /**
     * Karel is located in the northwest corner
     * Karel approaches the newspaper
     */
    public void goTonewspape() throws Exception {
        while (frontIsClear()) {
            move();
        }
        ;
        turnright();
        while (leftIsBlocked()) {
            move();
        }
        turnLeft();
        move();
        move();
    }

    public void turnright() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Karel returns to the starting position
     */
    public void comeBack() throws Exception {
        turnAround();
        move();
        move();
        turnright();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
        while (frontIsClear())
            move();
    }

    /**
     * Karel rotates 180 degrees
     */
    public void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}

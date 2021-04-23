package com.shpp.p2p.cs.ymahas;

import com.shpp.karel.KarelTheRobot;

public class video1 extends KarelTheRobot {
    public void run() throws Exception {
        for (int i = 0; i < 8; i++) {
            if (frontIsClear()) {
                move();
                move();
            } else {
                walkAround();
            }
            move();
        }
    }

    private void walkAround() throws Exception {
        walkHoldingWallOnRight();
        move();
        move();
        walkHoldingWallOnLeft();
    }

    private void walkHoldingWallOnLeft() throws Exception {
        turnRight();
        walkToWall();
        turnLeft();
    }

    private void walkHoldingWallOnRight() throws Exception {
        turnLeft();
        while (rightIsBlocked()) {
            move();
        }
        turnRight();
    }

    private void walkToWall() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }


    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
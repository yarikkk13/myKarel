package com.shpp.ymahas.cs;

import com.shpp.karel.KarelTheRobot;

public class MyKarel extends KarelTheRobot {

    public void run() throws Exception {
        for (int i = 0; i < 6; i++) {
            turnLeft();
            moveAroundRightWallUp();
            turnRight();
            jump();
            turnRight();
            move();
            moveAroundRightWallDown();
            turnLeft();
            moveAroundRightWallDown();
        }

    }

    private void moveAroundRightWallUp() throws Exception {
        while (rightIsBlocked() ) {
            move();
        }
    }
    private void moveAroundRightWallDown() throws Exception {
        while (rightIsBlocked() && !frontIsBlocked() ) {
            move();
        }
    }
    private void jump() throws Exception {
        move();
        move();
    }
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}




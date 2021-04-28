package com.shpp.p2p.cs.aplakhtiev.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3Ext extends KarelTheRobot {


    public void run() throws Exception {
        walkToWall();
    }


    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    private void walkToWall() throws Exception {
        for (int i = 0; ; i++) {
            if (frontIsBlocked()) {
                turnAround();
                for (int j = 1; j < i; j += 2)
                    move();
                putBeeper();
                if (i % 2 == 1 && i != 0) {
                    move();
                    putBeeper();
                }
                break;
            }
            move();
        }
    }
}


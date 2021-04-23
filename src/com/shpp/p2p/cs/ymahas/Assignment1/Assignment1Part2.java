package com.shpp.p2p.cs.ymahas.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {
    public void run() throws Exception {
        if (frontIsClear()) {
            move();
        } else {
            turnLeft();
        }
    }
}
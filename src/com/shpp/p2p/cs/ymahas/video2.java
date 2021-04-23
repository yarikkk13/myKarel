package com.shpp.p2p.cs.ymahas;

import com.shpp.karel.KarelTheRobot;

public class video2 extends KarelTheRobot {
    public void run() throws Exception {
    cleanCell();
    }

    private void cleanCell() throws Exception {
        if (beepersPresent()) {
            pickBeeper();
        }
    }

}
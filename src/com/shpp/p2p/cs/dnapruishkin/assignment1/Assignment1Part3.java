package com.shpp.p2p.cs.dnapruishkin.assignment1;

import com.shpp.karel.KarelTheRobot;

/**
 * Karel needs to build a brick in the center.
 */
public class Assignment1Part3 extends KarelTheRobot {

    /**
     * Condition: These methods help to find the middle of the map using recursion, regardless of its size.
     * Result:Karel uses the recursion method to place beepers all over the map. After placing
     * all beepers on the south side, place an additional one and collect all beepers. One beeper remains in the center
     */
    public void run() throws Exception {
        // place beepers on all empty cells
        recursionForSettingBeepers();
        // no matter which way the Karel is looking, he turns to face south
        turnSouth();
        //  moving forward
        moveStraight();
        // put the center beeper and go to the start
        installationCentralBeacon();
        // collects extra beepers
        beeperCleaning();

    }

    /** Condition: Spiral all beepers except the beacon
     * Result: All beepers are assembled in a spiral. Only the central beeper remains on the field. */
    private void beeperCleaning() throws Exception {
        // while there is no obstacle, go ahead and remove the beepers
        if (frontIsClear() && beepersPresent()) {
            pickBeeper();
            move();
            // obstacle turn to the left
            if (frontIsBlocked() && beepersPresent()) {
                turnLeft();
            }
            // if there are no beepers, turn around and go up to the next level
            if (noBeepersPresent()) {
                turnBack();
                move();
                turnRight();
                move();
            }
            // the method calls itself (recursion) itself until we collect all the beepers
            beeperCleaning();
        }
    }

    /** Condition: Installation of a beacon (beeper) in the center of the map
     * Result: having installed another beacon (beeper) in the cage, which will mark the center,
     * Karel returns to its original position, and ready to collect additional beeps.  */
    private void installationCentralBeacon() throws Exception {
        // set the second beeper to mark the middle
        putBeeper();
        if (beepersPresent()) {
            turnRight();
            // go back to the original and turn to the east
            while (frontIsClear()) {
                move();
            }
            turnBack();
        }
    }


    /**  Condition: Until there is no barrier move Straight  */
    private void moveStraight() throws Exception {
        if (frontIsClear()) {
            move();
            // recursion
            moveStraight();
        }
    }

    /**
     * Condition: Whichever side of the world the Karel did not look, he should turn to face south and
     * go to the edge of the map
     * Result: Karel turned south and walked to the edge of the map
     */
    private void turnSouth() throws Exception {
        if (facingEast()) {
            turnRight();
        }
        if (facingWest()) {
            turnLeft();
        }
        if (facingNorth()) {
            turnBack();
        }
        moveStraight();
    }

    /**
     * Condition: Karel goes in a spiral and puts beepers until there are no obstacles and beepers
     * Result: Karel filled all free cells with beepers
     */
    private void recursionForSettingBeepers() throws Exception {
        // while there is no obstacle, go ahead and set beepers
        if (frontIsClear() && noBeepersPresent()) {
            putBeeper();
            move();
            // obstacle turn to the left
            if (frontIsBlocked() && noBeepersPresent()) {
                turnLeft();
            }
            // if there is a beeper turns around and go up to the next level
            if (beepersPresent()) {
                turnBack();
                move();
                turnRight();
                move();
            }
            // the method calls itself (recursion) itself until all beepers are placed
            recursionForSettingBeepers();
        }
    }

    /**
     * Condition: turn right combination
     */
    public void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    /**
     * Condition: turn back combination
     */
    public void turnBack() throws Exception {
        for (int i = 0; i < 2; i++) {
            turnLeft();
        }
    }
}



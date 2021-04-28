package com.shpp.p2p.cs.ipyndyk.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {
    /*Karel will check if there is a world ahead
     if not, he will put a beeper and turn to the left
    If there is a field in front, he will build the first row, come back
     will build the first column, come back,
    Will check every column until the end of the world.
    Then it will fill the last column

     */
    public void run() throws Exception {
        if (!frontIsClear()) {
            putBeeper();
            turnLeft();
            if (frontIsClear()) {

                fillFirstColumb();


            }
        } else {
            fillFirstRow();
            comeBack();
            turnright();
            if (frontIsClear()) {


                fillFirstColumb();
                comeBack();
                turnLeft();
                move();
                FillNextColums();
                putBeeperLastColumb();

            }
        }
    }

    /*building the first line

     */
    public void fillFirstRow() throws Exception {
        if (!frontIsClear()) {
            putBeeper();
        } else {
            putBeeper();
            while (frontIsClear()) {
                move();
                frontIsClearMovePutBeeper();
            }

        }
    }

    /*
    building the first column
     */
    public void fillFirstColumb() throws Exception {


        if (frontIsClear()) {

            while (frontIsClear()) {
                move();
                frontIsClearMovePutBeeper();
            }

        }
    }

    /*
    right turn
     */
    public void turnright() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /*
    return back
     */
    public void comeBack() throws Exception {
        turAround();
        while (frontIsClear()) {
            move();
        }

    }

    /*
    turn 180 degrees
     */
    public void turAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /*
    building the next columns, while there is a clear field, up to the last column
     */
    public void FillNextColums() throws Exception {
        while (frontIsClear()) {
            turnLeft();
            if ((beepersPresent()) && (frontIsClear())) {

                while (frontIsClear()) {
                    frontIsClearMove();
                    frontIsClearMovePutBeeper();
                }
                comeBack();
                turnLeft();
                move();
            } else {
                if ((frontIsClear()) && (noBeepersPresent())) {

                    while (frontIsClear()) {
                        if (frontIsClear()) {
                            move();
                            putBeeper();
                            frontIsClearMove();
                        }
                    }
                    comeBack();
                    turnLeft();
                    move();
                }
            }


        }
    }

    /*
    building the last column
    checking with every step if there is a world ahead
     */
    public void putBeeperLastColumb() throws Exception {
        turnLeft();
        if (frontIsClear()) {
            while (frontIsClear()) {
                if (frontIsClear()) {
                    if (beepersPresent()) {
                        move();
                        frontIsClearMovePutBeeper();
                    } else {
                        if (noBeepersPresent()) {
                            frontIsClearMovePutBeeper();

                        }
                    }
                }
            }
        }

    }

    /*
    if clean ahead, step
     */
    public void frontIsClearMove() throws Exception {
        if (frontIsClear()) {
            move();
        }

    }

    /*
if clean ahead, step, put beeper
     */
    public void frontIsClearMovePutBeeper() throws Exception {
        if (frontIsClear()) {
            move();
            putBeeper();
        }
    }
}





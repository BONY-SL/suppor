package org.suppor.p4_group_8_repo.application.suppor.model;

import javafx.scene.image.Image;

public class WetTurtle extends Actor {
    Image t1;
    Image t2;
    Image t3;
    Image t4;
    int speed;
    boolean sunk = false;

    @Override
    public void act(long now) {

        if (now / 900000000 % 4 == 0) {
            setImage(t2); // Replaced 'turtle2' with 't2'
            sunk = false;
        } else if (now / 900000000 % 4 == 1) {
            setImage(t1); // Replaced 'turtle1' with 't1'
            sunk = false;
        } else if (now / 900000000 % 4 == 2) {
            setImage(t3); // Replaced 'turtle3' with 't3'
            sunk = false;
        } else if (now / 900000000 % 4 == 3) {
            setImage(t4); // Replaced 'turtle4' with 't4'
            sunk = true;
        }

        move(speed, 0);
        if (getX() > 600 && speed > 0) setX(-200);
        if (getX() < -75 && speed < 0) setX(600);
    }

    public WetTurtle(int xpos, int ypos, int s, int w, int h) {
        t1 = new Image("/images/TurtleAnimation/TurtleAnimation1.png", w, h, true, true);
        t2 = new Image("/images/TurtleAnimation/TurtleAnimation2Wet.png", w, h, true, true);
        t3 = new Image("/images/TurtleAnimation/TurtleAnimation3Wet.png", w, h, true, true);
        t4 = new Image("/images/TurtleAnimation/TurtleAnimation4Wet.png", w, h, true, true);
        setX(xpos);
        setY(ypos);
        speed = s;
        setImage(t2); // Set initial image to 't2'
    }

    public boolean isSunk() {
        return sunk;
    }
}

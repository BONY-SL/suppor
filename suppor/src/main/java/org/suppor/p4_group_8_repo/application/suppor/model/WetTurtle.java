package org.suppor.p4_group_8_repo.application.suppor.model;

import javafx.scene.image.Image;
import org.suppor.p4_group_8_repo.application.suppor.controller.Updatable;

public class WetTurtle extends Actor implements Updatable {
    private final Image[] images = new Image[4];
    private final int speed;
    private boolean sunk = false;

    @Override
    public void act(long now) {
        updateTurtleFrame(now);
        move(speed, 0);
        handleWrapAround();
    }

    // Constructor to initialize the WetTurtle object
    public WetTurtle(int xpos, int ypos, int s, int width, int height) {
        images[0] = new Image("/images/TurtleAnimation/TurtleAnimation1.png", width, height, true, true);
        images[1] = new Image("/images/TurtleAnimation/TurtleAnimation2Wet.png", width, height, true, true);
        images[2] = new Image("/images/TurtleAnimation/TurtleAnimation3Wet.png", width, height, true, true);
        images[3] = new Image("/images/TurtleAnimation/TurtleAnimation4Wet.png", width, height, true, true);

        setX(xpos);
        setY(ypos);
        speed = s;
        setImage(images[1]);  // Start with the second frame (Wet Turtle)
    }
    @Override
    public void update() {
        handleWrapAround(); // Ensure wrap-around is handled every frame
    }


    private void updateTurtleFrame(long now) {
        if (now / 900000000 % 4 == 0) {
            setImage(images[0]);
            sunk = false;
        } else if (now / 900000000 % 4 == 1) {
            setImage(images[1]);
            sunk = false;
        } else if (now / 900000000 % 4 == 2) {
            setImage(images[2]);
            sunk = false;
        } else if (now / 900000000 % 4 == 3) {
            setImage(images[3]);
            sunk = false;
        }
    }

    private void handleWrapAround() {
        if (getX() > 600) { // If the WetTurtle moves off the right edge
            setX(-130); // Reset to the left side (assuming 130 is the width of the turtle)
        } else if (getX() < -130) { // If the WetTurtle moves off the left edge
            setX(600); // Reset to the right side
        }
    }
}

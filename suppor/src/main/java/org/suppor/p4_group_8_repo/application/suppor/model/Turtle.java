package org.suppor.p4_group_8_repo.application.suppor.model;

import javafx.scene.image.Image;
import org.suppor.p4_group_8_repo.application.suppor.controller.Updatable;

public class Turtle extends Actor implements Updatable {
    private final Image turtle1;
    private final Image turtle2;
    private final Image turtle3;
    private final int speed;

    @Override
    public void act(long now) {
        if (now / 900000000 % 3 == 0) {
            setImage(turtle2);
        } else if (now / 900000000 % 3 == 1) {
            setImage(turtle1);
        } else if (now / 900000000 % 3 == 2) {
            setImage(turtle3);
        }

        move(speed, 0);
        handleWrapAround();
    }

    public Turtle(int xpos, int ypos, int s, int w, int h) {
        try {
            turtle1 = new Image("/images/TurtleAnimation/TurtleAnimation1.png", w, h, true, true);
            turtle2 = new Image("/images/TurtleAnimation/TurtleAnimation2.png", w, h, true, true);
            turtle3 = new Image("/images/TurtleAnimation/TurtleAnimation3.png", w, h, true, true);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Turtle images", e);
        }
        setX(xpos);
        setY(ypos);
        speed = s;
        setImage(turtle2);
    }

    @Override
    public void update() {

        handleWrapAround(); // Ensure wrap-around is handled every frame
    }


    private void handleWrapAround() {
        if (getX() > 600) { // If the turtle moves off the right edge
            setX(-130); // Reset to the left side (assuming 130 is the width of the turtle)
        } else if (getX() < -130) { // If the turtle moves off the left edge
            setX(600); // Reset to the right side
        }
    }
}

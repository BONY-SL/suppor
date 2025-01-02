package org.suppor.p4_group_8_repo.application.suppor.model;

import javafx.scene.image.Image;
import org.suppor.p4_group_8_repo.application.suppor.controller.Updatable;

public class Log extends Actor implements Updatable {

    private final double speed;

    @Override
    public void act(long now) {
        move(speed, 0);
        if (getX() > 600 && speed > 0) {
            setX(-180);
        }
        if (getX() < -getWidth() && speed < 0) {
            setX(600);
        }
    }

    public Log(String imageLink, int size, int xpos, int ypos, double s) {
        try {
            Image logImage = new Image(imageLink, size, size, true, true);
            if (logImage.isError()) {
                throw new IllegalArgumentException("Failed to load image: " + imageLink);
            }
            setImage(logImage);
        } catch (Exception e) {
            System.err.println("Error loading log image: " + e.getMessage());
        }
        setX(xpos);
        setY(ypos);
        speed = s;
    }

    protected boolean getLeft() {
        return speed < 0;
    }

    @Override
    public void update() {

        // Wrap-around logic for turtles
        if (getX() > 550) {
            setX(-getWidth()); // Wrap around to the left
        } else if (getX() + getWidth() < 0) {
            setX(550); // Wrap around to the right
        }
    }

}

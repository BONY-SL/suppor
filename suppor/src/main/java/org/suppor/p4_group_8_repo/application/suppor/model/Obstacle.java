package org.suppor.p4_group_8_repo.application.suppor.model;

import javafx.scene.image.Image;
import org.suppor.p4_group_8_repo.application.suppor.controller.Updatable;

public class Obstacle extends Actor implements Updatable {
    private final int speed;
    @Override
    public void act(long now) {
        move(speed , 0);
        if (getX() > 600 && speed>0)
            setX(-200);
        if (getX() < -50 && speed<0)
            setX(600);
    }


    public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
        setImage(new Image(imageLink, w,h, true, true));
        setX(xpos);
        setY(ypos);
        speed = s;
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
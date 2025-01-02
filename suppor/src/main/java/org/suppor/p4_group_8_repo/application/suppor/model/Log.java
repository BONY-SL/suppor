package org.suppor.p4_group_8_repo.application.suppor.model;

import javafx.scene.image.Image;

public class Log extends Actor {

    private final double speed;
    @Override
    public void act(long now) {
        move(speed , 0);
        if (getX()>600 && speed>0)
            setX(-180);
        if (getX()<-300 && speed<0)
            setX(700);
    }

    public Log(String imageLink, int size, int xpos, int ypos, double s) {
        setImage(new Image(imageLink, size,size, true, true));
        setX(xpos);
        setY(ypos);
        speed = s;

    }
    protected boolean getLeft() {
        return speed < 0;
    }
}
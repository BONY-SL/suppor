package org.suppor.p4_group_8_repo.application.suppor.controller;

import javafx.scene.image.Image;
import org.suppor.p4_group_8_repo.application.suppor.model.Actor;

public class EndController extends Actor {
    boolean activated = false;
    @Override
    public void act(long now) {
        // TODO Auto-generated method st
    }

    public EndController(int x, int y) {
        setX(x);
        setY(y);
        setImage(new Image("/images/log/End.png", 60, 60, true, true));
    }

    public void setEnd() {
        setImage(new Image("/images/frogger/FrogEnd.png", 70, 70, true, true));
        activated = true;
    }

    public boolean isActivated() {
        return activated;
    }


}
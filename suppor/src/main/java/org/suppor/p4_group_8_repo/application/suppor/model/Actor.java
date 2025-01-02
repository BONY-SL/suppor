package org.suppor.p4_group_8_repo.application.suppor.model;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class Actor extends ImageView {

    public void move(double dx, double dy) {
        setX(getX() - dx);
        setY(getY() - dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    public abstract void act(long now);
}

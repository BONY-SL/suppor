package org.suppor.p4_group_8_repo.application.suppor.model;
import org.suppor.p4_group_8_repo.application.suppor.controller.AnimalController;

public class Animal extends Actor {
    private final AnimalController controller;

    public Animal(String imageLink) {
        super();
        controller = new AnimalController(this, imageLink);
    }

    @Override
    public void act(long now) {
        controller.update(now);
    }

    public boolean getStop() {
        return controller.getStop();
    }

    public int getPoints() {
        return controller.getPoints();
    }

    public boolean changeScore() {
        return controller.changeScore();
    }

    public boolean detectCollision(Obstacle obstacle) {

        //return false;
        return getBoundsInParent().intersects(obstacle.getBoundsInParent());
    }



}

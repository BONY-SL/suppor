package org.suppor.p4_group_8_repo.application.suppor.controller;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import org.suppor.p4_group_8_repo.application.suppor.model.Animal;
import org.suppor.p4_group_8_repo.application.suppor.model.Obstacle;

public class AnimalController {
    private final Animal animal;
    private final Image imgW1, imgA1, imgS1, imgD1;
    private final Image imgW2, imgA2, imgS2, imgD2;

    private final double movement = 13.3333333 * 2;
    private final double movementX = 10.666666 * 2;
    private final int imgSize = 40;
    private int points = 0;
    private int end = 0;
    private double w = 800;
    private int carD = 0;

    private boolean second = false;
    private boolean noMove = false;
    private boolean carDeath = false;
    private boolean waterDeath = false;
    private boolean changeScore = false;

    public AnimalController(Animal animal, String imageLink) {
        this.animal = animal;
        animal.setImage(new Image(imageLink, imgSize, imgSize, true, true));
        animal.setX(300);
        animal.setY(679.8 + movement);

        imgW1 = new Image("/images/frogger/froggerUp.png", imgSize, imgSize, true, true);
        imgA1 = new Image("/images/frogger/froggerLeft.png", imgSize, imgSize, true, true);
        imgS1 = new Image("/images/frogger/froggerDown.png", imgSize, imgSize, true, true);
        imgD1 = new Image("/images/frogger/froggerRight.png", imgSize, imgSize, true, true);
        imgW2 = new Image("/images/frogger/froggerUpJump.png", imgSize, imgSize, true, true);
        imgA2 = new Image("/images/frogger/froggerLeftJump.png", imgSize, imgSize, true, true);
        imgS2 = new Image("/images/frogger/froggerDownJump.png", imgSize, imgSize, true, true);
        imgD2 = new Image("/images/frogger/froggerRightJump.png", imgSize, imgSize, true, true);

        setupKeyHandlers();
    }

    private void setupKeyHandlers() {
        animal.setOnKeyPressed(event -> {
            if (noMove) return;
            KeyCode code = event.getCode();
            if (second) handleKeyPressedSecond(code);
            else handleKeyPressedFirst(code);
        });

        animal.setOnKeyReleased(event -> {
            if (noMove) return;
            handleKeyReleased(event.getCode());
        });
    }

    public void update(long now) {
        handleBoundaryConditions();
        handleCarDeathAnimation(now);
        handleWaterDeathAnimation(now);
        checkCollisions();
    }

    private void handleKeyPressedFirst(KeyCode code) {
        switch (code) {
            case W -> {
                animal.move(0, movement);
                animal.setImage(imgW2);
                second = true;
            }
            case A -> {
                animal.move(movementX, 0);
                animal.setImage(imgA2);
                second = true;
            }
            case S -> {
                animal.move(0, -movement);
                animal.setImage(imgS2);
                second = true;
            }
            case D -> {
                animal.move(-movementX, 0);
                animal.setImage(imgD2);
                second = true;
            }
        }
    }

    private void handleKeyPressedSecond(KeyCode code) {
        switch (code) {
            case W -> {
                animal.move(0, movement);
                animal.setImage(imgW1);
                second = false;
            }
            case A -> {
                animal.move(movementX, 0);
                animal.setImage(imgA1);
                second = false;
            }
            case S -> {
                animal.move(0, -movement);
                animal.setImage(imgS1);
                second = false;
            }
            case D -> {
                animal.move(-movementX, 0);
                animal.setImage(imgD1);
                second = false;
            }
        }
    }

    private void handleKeyReleased(KeyCode code) {
        switch (code) {
            case W -> {
                if (animal.getY() < w) {
                    changeScore = true;
                    w = animal.getY();
                    points += 10;
                }
                animal.setImage(imgW1);
            }
            case A -> animal.setImage(imgA1);
            case S -> animal.setImage(imgS1);
            case D -> animal.setImage(imgD1);
        }
    }

    private void handleBoundaryConditions() {
        if (animal.getY() < 0 || animal.getY() > 734) resetPosition();
        if (animal.getX() < 0) animal.move(movement * 2, 0);
        if (animal.getX() > 600) animal.move(-movement * 2, 0);
    }

    private void handleCarDeathAnimation(long now) {
        if (!carDeath) return;
        noMove = true;
        if (now % 11 == 0) carD++;
        switch (carD) {
            case 1 -> animal.setImage(new Image("/images/car/cardeath1.png", imgSize, imgSize, true, true));
            case 2 -> animal.setImage(new Image("/images/car/cardeath2.png", imgSize, imgSize, true, true));
            case 3 -> animal.setImage(new Image("/images/car/cardeath3.png", imgSize, imgSize, true, true));
            case 4 -> {
                resetPosition();
                carDeath = false;
                carD = 0;
                animal.setImage(imgW1);
                noMove = false;
                if (points > 50) {
                    points -= 50;
                    changeScore = true;
                }
            }
        }
    }

    private void handleWaterDeathAnimation(long now) {
        if (!waterDeath) return;
        noMove = true;
        if (now % 11 == 0) carD++;
        switch (carD) {
            case 1 -> animal.setImage(new Image("/images/waterdeath/waterdeath1.png", imgSize, imgSize, true, true));
            case 2 -> animal.setImage(new Image("/images/waterdeath/waterdeath2.png", imgSize, imgSize, true, true));
            case 3 -> animal.setImage(new Image("/images/waterdeath/waterdeath3.png", imgSize, imgSize, true, true));
            case 4 -> animal.setImage(new Image("/images/waterdeath/waterdeath4.png", imgSize, imgSize, true, true));
            case 5 -> {
                resetPosition();
                waterDeath = false;
                carD = 0;
                animal.setImage(imgW1);
                noMove = false;
                if (points > 50) {
                    points -= 50;
                    changeScore = true;
                }
            }
        }
    }

    private void checkCollisions() {
        if (!animal.getIntersectingObjects(Obstacle.class).isEmpty()) carDeath = true;
        // Similar checks for logs, turtles, and other objects
    }

    private void resetPosition() {
        animal.setX(300);
        animal.setY(679.8 + movement);
    }

    public boolean getStop() {
        return end == 5;
    }

    public int getPoints() {
        return points;
    }

    public boolean changeScore() {
        if (changeScore) {
            changeScore = false;
            return true;
        }
        return false;
    }
}



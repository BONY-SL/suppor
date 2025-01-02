package com.lagocp.gameEngine.sprite;

public class Frog extends Sprite {

    public Frog(double x, double y, double vX, double vY, double width, double height) {
        super(x, y, vX, vY, width, height);
    }

    @Override
    public void render() {
        // Render the frog (placeholder for actual rendering logic, e.g. on a canvas)
        System.out.println("Rendering Frog at: (" + getX() + ", " + getY() + ")");
    }

    @Override
    public void update() {
        super.update();
        // Additional frog behavior (like checking for collisions or boundaries)
    }

    public void moveUp() {
        // Move the frog up
        this.setY(this.getY() - 10);  // Example movement
    }

    public void moveDown() {
        // Move the frog down
        this.setY(this.getY() + 10);
    }

    public void moveLeft() {
        // Move the frog left
        this.setX(this.getX() - 10);
    }

    public void moveRight() {
        // Move the frog right
        this.setX(this.getX() + 10);
    }
}

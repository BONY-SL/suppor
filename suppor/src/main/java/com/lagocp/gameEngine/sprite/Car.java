package com.lagocp.gameEngine.sprite;

public class Car extends Sprite {

    public Car(double x, double y, double vX, double vY, double width, double height) {
        super(x, y, vX, vY, width, height);
    }

    @Override
    public void render() {
        // Render the car (placeholder for actual rendering logic, e.g., on a canvas)
        System.out.println("Rendering Car at: (" + getX() + ", " + getY() + ")");
    }

    @Override
    public void update() {
        super.update();
        // Additional behavior for a car (like wrapping around screen if it goes off)
    }
}


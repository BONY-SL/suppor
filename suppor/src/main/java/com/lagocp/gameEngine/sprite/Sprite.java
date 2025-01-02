package com.lagocp.gameEngine.sprite;

public abstract class Sprite {

    private double x, y;
    private double vX, vY;
    private double width, height;

    public Sprite(double x, double y, double vX, double vY, double width, double height) {
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.width = width;
        this.height = height;
    }

    // Getter methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getvX() {
        return vX;
    }

    public double getvY() {
        return vY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getCenterX() {
        return x + width / 2;
    }

    public double getCenterY() {
        return y + height / 2;
    }

    public double getHalfWidth() {
        return width / 2;
    }

    public double getHalfHeight() {
        return height / 2;
    }

    // Setter methods for x and y
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Update position based on velocity
    public void update() {
        this.x += vX;
        this.y += vY;
    }

    // Abstract render method for subclasses to implement
    public abstract void render();
}

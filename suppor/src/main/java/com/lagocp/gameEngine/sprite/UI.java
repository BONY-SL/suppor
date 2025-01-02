package com.lagocp.gameEngine.sprite;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;

public abstract class UI {

    private Canvas canvas;

    public UI(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public abstract void create();

    public abstract void placeCanvas(Group root);

    public abstract void updateUI(Sprite... sprites);

    public abstract void initStats();
}

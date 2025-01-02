package org.suppor.p4_group_8_repo.application.suppor;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import org.suppor.p4_group_8_repo.application.suppor.model.*;
import org.suppor.p4_group_8_repo.application.suppor.view.BackgroundImage;
import org.suppor.p4_group_8_repo.application.suppor.view.Digit;

public class MainController {

    AnimationTimer timer;
    MyStage background;
    Animal animal;

    public Scene initializeScene() {
        background = new MyStage();
        Scene scene = new Scene(background, 550, 750);

        // Add game elements to the background
        setupGameObjects();
        return scene;
    }

    private void setupGameObjects() {

        // Set up background and other game elements
        BackgroundImage froggerback = new BackgroundImage("/images/log/iKogsKW.png");
        background.add(froggerback);

        // Set up logs and turtles
        background.add(new Log("/images/log/log3.png", 150, 0, 166, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 220, 166, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 440, 166, 0.75));
        background.add(new Log("/images/log/logs.png", 300, 0, 276, -2));
        background.add(new Log("/images/log/logs.png", 300, 400, 276, -2));
        background.add(new Log("/images/log/log3.png", 150, 50, 329, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 270, 329, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 490, 329, 0.75));


        background.add(new Turtle(600, 217, -1, 130, 130));
        background.add(new WetTurtle(400, 217, -1, 130, 130));
        background.add(new WetTurtle(200, 217, -1, 130, 130));

        // Set up the end zones
        background.add(new End(13, 96));
        background.add(new End(130, 96));
        background.add(new End(130 + 130 - 13, 96));
        background.add(new End(130 + 130 - 13 + 130 - 13 + 1, 96));
        background.add(new End(130 + 130 - 13 + 130 - 13 + 130 - 13 + 3, 96));

        // Set up animal
        animal = new Animal("/images/frogger/froggerUp.png");
        background.add(animal);

        //Corrected constructor calls for Obstacle
        background.add(new Obstacle("/images/truck/truck1Right.png", 0, 649, 1, 120, 120));
        background.add(new Obstacle("/images/truck/truck1Right.png", 300, 649, 1, 120, 120));
        background.add(new Obstacle("/images/truck/truck1Right.png", 600, 649, 1, 120, 120));
        background.add(new Obstacle("/images/truck/truck1Right.png", 720, 649, 1, 120, 120));
        background.add(new Obstacle("/images/car/car1Left.png", 100, 597, -1, 50, 50));
        background.add(new Obstacle("/images/car/car1Left.png", 250, 597, -1, 50, 50));
        background.add(new Obstacle("/images/car/car1Left.png", 400, 597, -1, 50, 50));
        background.add(new Obstacle("/images/car/car1Left.png", 550, 597, -1, 50, 50));
        background.add(new Obstacle("/images/truck/truck2Right.png", 0, 540, 1, 200, 200));
        background.add(new Obstacle("/images/truck/truck2Right.png", 500, 540, 1, 200, 200));
        background.add(new Obstacle("/images/car/car1Left.png", 500, 490, -5, 50, 50));
        background.add(new Digit(0, 30, 510, 25));


        // Set up other game elements
        background.add(new Digit(0, 30, 510, 25));
        background.start();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.println("STOPP:");
                    background.stopMusic();
                    stopGame();
                    showGameOverAlert();
                }
                // Update all objects on the background
                background.updateAllObjects();
            }
        };
    }


    public void startGame() {
        background.playMusic();
        createTimer();
        timer.start();
    }

    public void stopGame() {
        timer.stop();
        background.stopMusic();
        background.stop();
    }

    private void showGameOverAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("You Have Won The Game!");
        alert.setHeaderText("Your High Score: " + animal.getPoints() + "!");
        alert.setContentText("Highest Possible Score: 800");
        alert.show();
    }

    public void setNumber(int n) {
        int shift = 0;

        // Clear previous digits (remove old Digit objects)
        background.clearDigits();

        // Create new digits for the updated score
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            background.add(new Digit(d, 30, 510 - shift, 25));
            shift += 30;
        }

        // If the score is 0, show a 0 digit
        if (n == 0) {
            background.add(new Digit(0, 30, 510, 25));
        }
    }

}

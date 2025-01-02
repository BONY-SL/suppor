package org.suppor.p4_group_8_repo.application.suppor;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.suppor.p4_group_8_repo.application.suppor.model.*;
import org.suppor.p4_group_8_repo.application.suppor.view.BackgroundImage;
import org.suppor.p4_group_8_repo.application.suppor.view.Digit;

public class Main extends Application {
    AnimationTimer timer;
    MyStage background;
    Animal animal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        background = new MyStage();
        Scene scene  = new Scene(background,600,800);

        // Corrected constructor calls for Obstacle
        Obstacle obstacle = new Obstacle("/images/truck/truck1Right.png", 25, 25, 3, 120, 120);
        Obstacle obstacle1 = new Obstacle("/images/truck/truck2Right.png", 100, 100, 2, 120, 120);
        Obstacle obstacle2 = new Obstacle("/images/truck/truck1Right.png", 0, 150, 1, 120, 120);

        //ckgroundImage froggerback = new BackgroundImage("/images/log/smiiling-big-eyed-green-frog-clipart-6926.jpg");

        //background.add(froggerback);

        // Corrected constructor calls for Log
        background.add(new Log("/images/log/log3.png", 150, 0, 166, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 220, 166, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 440, 166, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 0, 166, 0.75));
        background.add(new Log("/images/log/logs.png", 300, 0, 276, -2));
        background.add(new Log("/images/log/logs.png", 300, 400, 276, -2));
        background.add(new Log("/images/log/logs.png", 300, 800, 276, -2));
        background.add(new Log("/images/log/log3.png", 150, 50, 329, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 270, 329, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 490, 329, 0.75));
        background.add(new Log("/images/log/log3.png", 150, 570, 329, 0.75));

        background.add(new Turtle(500, 376, -1, 130, 130));
        background.add(new Turtle(300, 376, -1, 130, 130));
        background.add(new WetTurtle(700, 376, -1, 130, 130));
        background.add(new WetTurtle(600, 217, -1, 130, 130));
        background.add(new WetTurtle(400, 217, -1, 130, 130));
        background.add(new WetTurtle(200, 217, -1, 130, 130));
        background.add(new Log("/images/log/log2.png", 200, 100, 1, 0.75));
        background.add(new Log("/images/log/log2.png", 0, 100, 1, 0.75));
        background.add(new Log("/images/log/log2.png", 100, 120, -1, 0.75));
        background.add(new Log("/images/log/log2.png", 200, 120, -1, 0.75));
        background.add(new Log("/images/log/log2.png", 100, 140, 1, 0.75));
        background.add(new Log("/images/log/log2.png", 200, 140, 1, 0.75));
        background.add(new Log("/images/log/log2.png", 100, 160, -1, 0.75));
        background.add(new Log("/images/log/log2.png", 300, 160, -1, 0.75));
        background.add(new Log("/images/log/log2.png", 100, 180, 1, 0.75));
        background.add(new Log("/images/log/log2.png", 200, 180, 1, 0.75));
        background.add(new Log("/images/log/log2.png", 100, 200, -1, 0.75));
        background.add(new Log("/images/log/log2.png", 200, 200, -1, 0.75));
        background.add(new Log("/images/log/log2.png", 100, 220, 1, 0.75));
        background.add(new Log("/images/log/log2.png", 200, 220, 1, 0.75));
        background.add(new Log("/images/log/log2.png", 400, 220, 1, 0.75));

        // Corrected constructor calls for End
        background.add(new End(13,96));
        background.add(new End(141,96));
        background.add(new End(141 + 141-13,96));
        background.add(new End(141 + 141-13+141-13+1,96));
        background.add(new End(141 + 141-13+141-13+141-13+3,96));

        animal = new Animal("/images/frogger/froggerUp.png");
        background.add(animal);

        // Corrected constructor calls for Obstacle
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

        background.add(new Digit(0, 30, 360, 25));
        background.add(obstacle);
        background.add(obstacle1);
        background.add(obstacle2);
        background.start();
        primaryStage.setScene(scene);
        primaryStage.show();
        start();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }

    public void start() {
        background.playMusic();
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        int shift = 0;
        while (n < 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 360 - shift, 25));
            shift += 30;
        }
    }
}

package org.suppor.p4_group_8_repo.application.suppor.controller;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.suppor.p4_group_8_repo.application.suppor.model.World;
import org.suppor.p4_group_8_repo.application.suppor.view.Digit;

import java.util.Objects;

public class MyStageController extends World {

    private MediaPlayer mediaPlayer;

    private final Pane rootPane = new Pane();

    public Pane getRootPane() {
        return rootPane;
    }// Initialize rootPane

    @Override
    public void act(long now) {
        // Logic for game updates can be placed here if needed
    }

    public MyStageController() {
        // Constructor
    }

    public void playMusic() {
        try {
            String musicFile = Objects.requireNonNull(getClass().getResource("/mp3/Snake_Charmer.mp3")).toExternalForm();
            Media sound = new Media(musicFile);
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        } catch (NullPointerException e) {
            System.err.println("Media file not found: /mp3/Snake_Charmer.mp3");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error playing music: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
    public void updateAllObjects() {
        for (Node node : this.getChildren()) {
            if (node instanceof Updatable) { // Ensure your objects implement an `Updatable` interface
                ((Updatable) node).update();
            }
        }
    }

    public void clearDigits() {
        getChildren().removeIf(node -> node instanceof Digit);
    }

    public void setNumber(int n) {
        int shift = 0;

        // Clear previous digits (remove old Digit objects)
        clearDigits();

        // Create new digits for the updated score
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            this.getChildren().add(new Digit(d, 30, 510 - shift, 25));
            shift += 30;
        }

        // If the score is 0, show a 0 digit
        if (this.getChildren().stream().noneMatch(node -> node instanceof Digit)) {
            this.getChildren().add(new Digit(0, 30, 510, 25));
        }
    }



}

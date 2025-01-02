package org.suppor.p4_group_8_repo.application.suppor.model;

import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.suppor.p4_group_8_repo.application.suppor.controller.Updatable;
import org.suppor.p4_group_8_repo.application.suppor.view.Digit;

import java.util.Objects;

public class MyStage extends World {

    private MediaPlayer mediaPlayer;

    @Override
    public void act(long now) {
        // Logic for game updates can be placed here if needed
    }

    public MyStage() {
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
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error playing music: " + e.getMessage());
            e.printStackTrace();
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


}

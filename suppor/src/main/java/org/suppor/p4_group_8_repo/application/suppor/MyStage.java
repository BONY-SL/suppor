package org.suppor.p4_group_8_repo.application.suppor;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.suppor.p4_group_8_repo.application.suppor.model.World;

public class MyStage extends World {

    private MediaPlayer mediaPlayer;

    @Override
    public void act(long now) {
        // Your acting logic here
    }

    // Constructor
    public MyStage() {
        // No mediaPlayer.play() here. Initialize the mediaPlayer later
    }

    // This method initializes and plays music
    public void playMusic() {
        try {
            // Use getResource to load the file from the resources directory
            String musicFile = getClass().getResource("/mp3/Snake_Charmer.mp3").toExternalForm();

            // Create Media and MediaPlayer
            Media sound = new Media(musicFile);
            mediaPlayer = new MediaPlayer(sound);

            // Set media player to play indefinitely
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            // Play the music
            mediaPlayer.play();

            // Set the media player to loop when it ends
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        } catch (NullPointerException e) {
            System.out.println("Error: Media file not found in the resources directory.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: Unable to play the media file.");
            e.printStackTrace();
        }
    }

    // Method to stop music
    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}

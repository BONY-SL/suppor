package org.suppor.p4_group_8_repo.application.suppor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.suppor.p4_group_8_repo.application.suppor.controller.MainController;

public class Main extends Application {

    MainController mainController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainController = new MainController();
        Scene scene = mainController.initializeScene();

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        mainController.startGame();
    }
}
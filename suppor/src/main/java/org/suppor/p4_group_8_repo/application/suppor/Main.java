package org.suppor.p4_group_8_repo.application.suppor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    MainController mainController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainController = new MainController();
        Scene scene = mainController.initializeScene();

        primaryStage.setScene(scene);
        primaryStage.show();
        mainController.startGame();
    }
}
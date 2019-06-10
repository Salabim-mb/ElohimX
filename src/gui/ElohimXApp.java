package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ElohimXApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        ViewCommunicator communicator = new ViewCommunicator();

        Parent root = FXMLLoader.load(getClass().getResource("resources/MainMenu.fxml"));
        primaryStage.setTitle("ElohimX");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(event -> MainMenuController.closeProgram());
        primaryStage.show();


    }

}
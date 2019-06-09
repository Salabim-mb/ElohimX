package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {


    @FXML
    private StackPane stackPane;

    @FXML
    private Button exitButton, openGameOfLife, openWireWorld;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    public static void closeProgram(){

        Platform.exit();
        System.exit(0);


    }

    public void exitButtonClicked(){

        closeProgram();

    }

    public void openWireWorld(ActionEvent e) throws IOException {

        WWCellViewController root = new WWCellViewController();

        Stage window = (Stage)((Node) e.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
        window.show();



    }

    public void openGameOfLife(ActionEvent e)  throws IOException {

        Parent newParent = FXMLLoader.load(getClass().getResource("resources/GameOfLifeWindow.fxml"));

        Scene newScene = new Scene(newParent);

        Stage window = (Stage)((Node) e.getSource()).getScene().getWindow();
        window.setScene(newScene);
        //window.setResizable(false);
        window.show();

    }



}

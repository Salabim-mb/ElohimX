package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static utils.SpinnerUtilities.initializeSpinner;


public class WWToolbarController implements Initializable {

    @FXML
    private Pane mainPane;

    @FXML
    private Button showButton;
    @FXML
    private StackPane toolbar;
    @FXML
    private Spinner<Integer> genNumSpinner, widthSpinner, heightSpinner;


    public void goBack(ActionEvent e) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource("resources/MainMenu.fxml"));

        Scene newScene = new Scene(newParent);

        Stage window = (Stage)((Node) e.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.setResizable(false);
        window.show();

    }

    public void hideToolbar(){
        toolbar.setVisible(false);
        showButton.setVisible(true);

    }

    public void showToolbar() {
        showButton.setVisible(false);
        toolbar.setVisible(true);


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initializeSpinner(heightSpinner);
        initializeSpinner(widthSpinner);
        initializeSpinner(genNumSpinner);




    }









}

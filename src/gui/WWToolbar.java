package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;


import static utils.SpinnerUtilities.initializeSpinner;


public class WWToolbar extends StackPane {


    @FXML
    private Spinner<Integer> genNumSpinner, widthSpinner, heightSpinner;



    public WWToolbar(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/WWToolbar.fxml"));


        loader.setRoot(this);
        loader.setController(this);

        try{
            loader.load();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        initializeSpinner(heightSpinner);
        initializeSpinner(widthSpinner);
        initializeSpinner(genNumSpinner);



    }


    @FXML
    public void goBack(ActionEvent e) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource("resources/MainMenu.fxml"));

        Scene newScene = new Scene(newParent);

        Stage window = (Stage)((Node) e.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.setResizable(false);
        window.show();

    }

    @FXML
    public void hideToolbar(){
        setVisible(false);

    }












}

package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class WireWorldController implements Initializable {

    @FXML
    private Pane mainPane;

    @FXML
    private Button showButton;
    @FXML
    private StackPane toolbar, cellView;
    @FXML
    private Spinner<Integer> genNumSpinner, widthSpinner, heightSpinner;



    public void setNumberOfGenerations(){}
    public void setBoardDimensions(){}
    public void loadWithFileExplorer(){}
    public void saveWithFileExplorer(){}

    public void showPatternsWindow(ActionEvent e) throws IOException {}

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

    public static boolean isInteger(String s){

        if(s.isEmpty()) return false;

        for(int i = 0; i < s.length(); i++){
            if(Character.digit(s.charAt(i), 10) < 0) return false;
        }
        return true;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initializeSpinner(heightSpinner);
        initializeSpinner(widthSpinner);
        initializeSpinner(genNumSpinner);



    }


    private void initializeSpinner(Spinner spinner){

        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 200, 10);

        spinner.setValueFactory(factory);
        spinner.setEditable(true);

        factory.setConverter(new toIntConverter());
        spinner.getEditor().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String text = spinner.getEditor().getText();
                if (isInteger(text)) {

                    StringConverter<Integer> converter = spinner.getValueFactory().getConverter();
                    Integer value = converter.fromString(text);

                    spinner.getValueFactory().setValue(value);
                } else {
                    spinner.getValueFactory().setValue(1);
                    spinner.getValueFactory().setValue(10);
                }

            }
        });

    }



    private class toIntConverter extends StringConverter<Integer>{

        @Override
        public String toString(Integer object) {
            return object + "";
        }

        @Override
        public Integer fromString(String string) {
            return Integer.parseInt(string);
        }



    }



}

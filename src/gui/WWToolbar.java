package gui;


import core.Generation;
import core.WireWorld;
import gui.resources.guiUtilities.ViewCommunicator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.TxtReader;
import utils.TxtWriter;

import java.awt.*;
import java.io.File;
import java.io.IOException;


import static gui.resources.guiUtilities.SpinnerUtilities.initializeSpinner;


public class WWToolbar extends StackPane {

    private Desktop desktop;
    private FileChooser fileExplorer;
    private WireWorld wireWorld;


    @FXML
    ToggleButton endlessModeSwitch;

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

        initializeSpinner(genNumSpinner);
        initializeSpinner(widthSpinner);
        initializeSpinner(heightSpinner);

        genNumSpinner.getValueFactory().valueProperty().addListener((observable, oldValue, newValue) -> {
            ViewCommunicator.getWWController().setGenNumber(newValue);
        });
        widthSpinner.getValueFactory().valueProperty().addListener((observable, oldValue, newValue) -> {
            ViewCommunicator.getWWController().setBoardWidth(newValue);
            ViewCommunicator.getWWController().resizeBoard();
        });
        heightSpinner.getValueFactory().valueProperty().addListener((observable, oldValue, newValue) -> {
            ViewCommunicator.getWWController().setBoardHeight(newValue);
            ViewCommunicator.getWWController().resizeBoard();
        });
        endlessModeSwitch.selectedProperty().addListener((observable, oldValue, newValue) -> {
            ViewCommunicator.getWWController().setEndlessMode(newValue);
        });

        desktop = Desktop.getDesktop();
        fileExplorer = new FileChooser();
        fileExplorer.setTitle("Choose a txt file...");
        fileExplorer.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileExplorer.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt", "*.txt"));

        wireWorld = WireWorld.getInstance();
        ViewCommunicator.setToolbarController(this);
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

    @FXML
    public void showHelpWindow(){

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("resources/HelpWindow.fxml"));
        } catch (IOException e){
            throw new RuntimeException (e);
        }


        Stage window = new Stage();
        window.setTitle("Help");
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);

        window.setScene(new Scene(root));

        window.show();

    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException e) {

        }
    }


    @FXML
    public void loadFile(ActionEvent e){

        Stage window = (Stage)((Node) e.getSource()).getScene().getWindow();
        Generation genZero = null;
        File file = fileExplorer.showOpenDialog(window);
        if (file != null) {
            openFile(file);
            try {
                genZero = TxtReader.readWW(file);
                wireWorld.initializeWW(genZero);
            } catch (IOException ex){
                throw new RuntimeException(ex);
            }
        }

    }

    @FXML
    public void saveFile(ActionEvent e){

        Stage window = (Stage)((Node) e.getSource()).getScene().getWindow();
        File file = fileExplorer.showSaveDialog(window);
        if (file != null) {
            try {
                int currentGen = ViewCommunicator.getWWController().getCurrentGen();
                TxtWriter.writeWW(file.getPath(), wireWorld.getGenerations().get(currentGen));
            } catch (IOException ex){
                throw new RuntimeException(ex);
            }
        }

    }




}

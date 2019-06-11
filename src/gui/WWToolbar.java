package gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;


import static utils.SpinnerUtilities.initializeSpinner;


public class WWToolbar extends StackPane {

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

}

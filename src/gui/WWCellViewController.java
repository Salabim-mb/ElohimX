package gui;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class WWCellViewController extends Pane {

    private int genNumber;
    private int boardWidth;
    private int boardHeight;
    private boolean endlessMode;

    @FXML
    Canvas cellCanvas;

    @FXML
    private Button showButton;

    @FXML
    private WWToolbar toolbar;

    public WWCellViewController(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/WireWorldWindow.fxml"));

        loader.setRoot(this);
        loader.setController(this);

        try{
            loader.load();
        } catch (IOException e){
            throw new RuntimeException();
        }

        setGenNumber(10);
        setBoardHeight(10);
        setBoardWidth(10);
        setEndlessMode(false);
        ViewCommunicator.setWWController(this);
    }



    @FXML
    public void showToolbar() {
        //showButton.setVisible(false);
        toolbar.setVisible(true);


    }


    public void setGenNumber(int genNumber) {
        this.genNumber = genNumber;
    }



    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }


    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }


    public void setEndlessMode(boolean endlessMode) {
        this.endlessMode = endlessMode;
    }


    public int getGenNumber(){

        return genNumber;

    }

}

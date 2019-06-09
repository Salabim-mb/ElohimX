package gui;

import gui.resources.Cell;
import gui.resources.CellBoard;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;


public class WWCellViewController extends Pane{

    private int genNumber;
    private int boardWidth;
    private int boardHeight;
    private boolean endlessMode;

    CellBoard board;



    @FXML
    Label genNum;

    @FXML
    private Button showButton;

    @FXML
    private WWToolbar toolbar;

    @FXML
    private StackPane cellSP;




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


        board = new CellBoard(10, 10);
        cellSP.setAlignment(Pos.CENTER);
        cellSP.getChildren().add(board);

        //initializeCells(10, 10, 0);

        ViewCommunicator.setWWController(this);



    }

    /*
    public void initializeCells(int width, int height, int state){

        cells = new Cell[width*height];

        for(int i = 0; i < cells.length; i++){

            cells[i] = new Cell(20, 20, 0);
            cells[i].setTranslateX(20*(i % width));
            cells[i].setTranslateY(20*(i / height));

            cellWindow.getChildren().add(cells[i]);


        }

    }
*/



    @FXML
    public void showToolbar() {
        //showButton.setVisible(false);
        toolbar.setVisible(true);


    }


    public int getGenNumber() {
        return genNumber;
    }

    public void setGenNumber(int genNumber) {
        this.genNumber = genNumber;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public boolean isEndlessMode() {
        return endlessMode;
    }

    public void setEndlessMode(boolean endlessMode) {
        this.endlessMode = endlessMode;
    }
}

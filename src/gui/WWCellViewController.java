package gui;

import core.WWStates;
import core.WireWorld;
import core.WireWorldCell;
import gui.resources.CellBoard;
import gui.resources.RecCell;
import gui.resources.guiUtilities.ScrollFunctions;
import gui.resources.guiUtilities.ViewCommunicator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import java.io.IOException;



public class WWCellViewController extends Pane{

    public static final double CELL_VIEW_HEIGHT = 420.0;
    public static final double CELL_VIEW_WIDTH = 650.0;

    private WireWorld wireWorld;
    private ScrollFunctions scrollConfig;
    private int genNumber;
    private int boardWidth;
    private int boardHeight;
    private boolean endlessMode;

    private StringProperty currentGenProperty;
    private WireWorldCell[][] genZero;
    private int currentGen;

    CellBoard board;
    RecCell[][] recCells;
    Group   boardWrapper;

    @FXML
    Label genNumLabel;

    @FXML
    Label genIndex;

    @FXML
    private Button showButton;

    @FXML
    private WWToolbar toolbar;

    @FXML
    private ScrollPane cellWindow;

    @FXML
    private Button clearButton;


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
        currentGen = 0;
        initializeGenZero();

        currentGenProperty = new SimpleStringProperty("0");
        genIndex.textProperty().bind(currentGenProperty);

        genNumLabel.setFont(Font.font(13.5));

        board = new CellBoard(10, 10);
        recCells = board.getCells();
        boardWrapper = new Group(board);

        board.initializeRecCells(genZero, boardHeight, boardWidth);
        scrollConfig = new ScrollFunctions(board, boardWrapper, cellWindow);

        //setStyle("-fx-background-color: indigo");
        wireWorld = WireWorld.getInstance();
        ViewCommunicator.setWWController(this);

    }


    public void  resizeBoard(){

        boardWrapper.getChildren().remove(board);
        board = new CellBoard(boardHeight, boardWidth);
        scrollConfig.setTarget(board);
        scrollConfig.setScaleValue(0.9);
        scrollConfig.updateScale();
        boardWrapper.getChildren().add(board);
        initializeGenZero();
        recCells = board.getCells();
        board.initializeRecCells(genZero, boardHeight, boardWidth);

    }

    @FXML
    public void clearBoard(){
        resizeBoard();
    }

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

    public int getCurrentGen() {
        return currentGen;
    }


    private void initializeGenZero(){

        genZero = new WireWorldCell[boardHeight][boardWidth];

        for (int i=0; i<boardHeight; i++){
            for(int j=0; j<boardWidth; j++){
                genZero[i][j] = new WireWorldCell(WWStates.EMPTY);
            }
        }
    }



}

package gui;


import gui.resources.CellBoard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


import java.io.IOException;


public class WWCellViewController extends Pane{

    public static final double CELL_VIEW_HEIGHT = 420.0;
    public static final double CELL_VIEW_WIDTH = 650.0;

    private int genNumber;
    private int boardWidth;
    private int boardHeight;
    private boolean endlessMode;

    CellBoard board;
    Group   boardWrapper;


    @FXML
    Label genNum;

    @FXML
    private Button showButton;

    @FXML
    private WWToolbar toolbar;

    @FXML
    private StackPane cellWindow;

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

        /*
        setStyle("-fx-background-color: silver;");
        cellSP.setStyle("-fx-background-color: white;");
        genNum.setTextFill(Color.WHITE);    */

        board = new CellBoard(10, 10);
        boardWrapper = new Group(board);

        cellWindow.getChildren().add(boardWrapper);
        StackPane.setAlignment(boardWrapper, Pos.CENTER);


        ViewCommunicator.setWWController(this);



    }


    public void  resizeBoard(){

        boardWrapper.getChildren().remove(board);
        board = new CellBoard(boardWidth, boardHeight);
        boardWrapper.getChildren().add(board);

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
}

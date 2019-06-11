package gui;


import gui.resources.CellBoard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


import java.io.IOException;


public class WWCellViewController extends Pane{

    public static final double CELL_VIEW_HEIGHT = 420.0;
    public static final double CELL_VIEW_WIDTH = 650.0;

    private double scaleValue = 1.0;
    private double zoomIntensity = 0.02;
    private Node target;
    private Node zoomNode;

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

        board = new CellBoard(10, 10);
        boardWrapper = new Group(board);

        target = board;
        zoomNode = boardWrapper;

        cellWindow.setContent(returnOuterNode(zoomNode));
        cellWindow.setPannable(true);
        cellWindow.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        cellWindow.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        cellWindow.setFitToHeight(true);
        cellWindow.setFitToWidth(true);
        updateScale();

        ViewCommunicator.setWWController(this);

    }


    public void  resizeBoard(){

        boardWrapper.getChildren().remove(board);
        board = new CellBoard(boardWidth, boardHeight);
        target = board;
        boardWrapper.getChildren().add(board);

    }

    @FXML
    public void showToolbar() {
        //showButton.setVisible(false);
        toolbar.setVisible(true);


    }

    private Node returnCenteredNode(Node node){

        VBox box = new VBox(node);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    private Node returnOuterNode(Node node){

        Node outerNode = returnCenteredNode(node);

        outerNode.setOnScroll(e -> {

            if(e.isControlDown()){
                e.consume();
                onScroll(e.getTextDeltaY(), new Point2D(e.getX(), e.getY()));
            }
        });

        return outerNode;
    }

    private void updateScale() {
        target.setScaleX(scaleValue);
        target.setScaleY(scaleValue);
    }

    private void onScroll(double wheelDelta, Point2D mousePoint) {
        double zoomFactor = Math.exp(wheelDelta * zoomIntensity);

        Bounds innerBounds = zoomNode.getLayoutBounds();
        Bounds viewportBounds = cellWindow.getViewportBounds();

        double valX = cellWindow.getHvalue() * (innerBounds.getWidth() - viewportBounds.getWidth());
        double valY = cellWindow.getVvalue() * (innerBounds.getHeight() - viewportBounds.getHeight());

        scaleValue = scaleValue * zoomFactor;
        updateScale();
        cellWindow.layout();

        Point2D posInZoomTarget = target.parentToLocal(zoomNode.parentToLocal(mousePoint));

        Point2D adjustment = target.getLocalToParentTransform().deltaTransform(posInZoomTarget.multiply(zoomFactor - 1));

        Bounds updatedInnerBounds = zoomNode.getBoundsInLocal();
        cellWindow.setHvalue((valX + adjustment.getX()) / (updatedInnerBounds.getWidth() - viewportBounds.getWidth()));
        cellWindow.setVvalue((valY + adjustment.getY()) / (updatedInnerBounds.getHeight() - viewportBounds.getHeight()));
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

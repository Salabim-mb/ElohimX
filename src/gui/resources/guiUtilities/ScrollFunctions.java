package gui.resources.guiUtilities;


import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ScrollFunctions {

    private static double scaleValue = 0.9;
    private static double zoomIntensity = 0.02;

    private static Node target;
    private static Node zoomNode;
    private static ScrollPane cellWindow;


    public ScrollFunctions(Node target, Node zoomNode, ScrollPane cellWindow){

        this.target = target;
        this.zoomNode = zoomNode;

        cellWindow.setContent(returnOuterNode(zoomNode));
        cellWindow.setPannable(true);
        cellWindow.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        cellWindow.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        cellWindow.setFitToHeight(true);
        cellWindow.setFitToWidth(true);
        updateScale();

        this.cellWindow = cellWindow;

    }


    private static Node returnCenteredNode(Node node){

        VBox box = new VBox(node);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    private static Node returnOuterNode(Node node){

        Node outerNode = returnCenteredNode(node);

        outerNode.setOnScroll(e -> {

            //if(e.isControlDown()){
            e.consume();
            onScroll(e.getTextDeltaY(), new Point2D(e.getX(), e.getY()));
            //}
        });

        return outerNode;
    }


    private static void onScroll(double wheelDelta, Point2D mousePoint) {
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


    public static void updateScale() {
        target.setScaleX(scaleValue);
        target.setScaleY(scaleValue);
    }


    public static double getScaleValue() {
        return scaleValue;
    }

    public static void setScaleValue(double scaleValue) {
        ScrollFunctions.scaleValue = scaleValue;
    }

    public static double getZoomIntensity() {
        return zoomIntensity;
    }

    public static void setZoomIntensity(double zoomIntensity) {
        ScrollFunctions.zoomIntensity = zoomIntensity;
    }

    public static Node getTarget() {
        return target;
    }

    public static void setTarget(Node target) {
        ScrollFunctions.target = target;
    }

    public static Node getZoomNode() {
        return zoomNode;
    }

    public static void setZoomNode(Node zoomNode) {
        ScrollFunctions.zoomNode = zoomNode;
    }

    public static Node getCellWindow() {
        return cellWindow;
    }

    public static void setCellWindow(ScrollPane cellWindow) {
        cellWindow = cellWindow;
    }
}

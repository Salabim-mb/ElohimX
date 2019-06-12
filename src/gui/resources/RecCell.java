package gui.resources;

import core.WWStates;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RecCell extends Rectangle {

    private static Color[] states = {Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW};
    private double stroke;

    public RecCell(double dim, int index){

        super(dim, dim);
        setStroke(Color.BLACK);
        stroke = 0.015*dim;
        setStrokeWidth(stroke);
        setState(index);
        setEffect(null);

        setOnMouseEntered(e-> {
            setStrokeWidth(stroke*1.5);
            setStroke(Color.ORANGE);
        });

        setOnMouseExited(e-> {
            setStrokeWidth(stroke);
            setStroke(Color.BLACK);
        });

    }



    public void setState(int i){
        try {
            setFill(states[i]);
        }catch (IndexOutOfBoundsException e){

        }

    }

    public void changeState(){

        for(int i=0; i < states.length; i++) {
            if ((getState() == states[i]) && i!=3){
                setState(i+1);
                break;
            }
            if ((getState() == states[i]) && i==3){
                setState(0);
                break;
            }
        }
    }


    public Color getState(){
        return (Color) getFill();
    }

    public WWStates getWWState() {

        if (getFill() == Color.BLACK)
            return WWStates.EMPTY;

        if (getFill() == Color.BLUE)
            return WWStates.ELECTRON_HEAD;

        if (getFill() == Color.RED)
            return WWStates.ELECTRON_TAIL;

        if (getFill() == Color.YELLOW)
            return WWStates.CONDUCTOR;

        return null;
    }
}

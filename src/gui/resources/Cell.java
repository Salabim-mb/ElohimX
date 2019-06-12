package gui.resources;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

    private static Color[] states = {Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW};
    //public static Color borderColor = Color.BLACK;


    public Cell(double dim, int index){

        super(dim, dim);
        setStroke(Color.WHITE);
        setStrokeWidth(0.015*dim);
        setState(index);

        setOnMouseClicked(e-> {
            changeState();
       });

        setOnMouseEntered(e-> {
            setStroke(Color.ORANGE);
        });

        setOnMouseExited(e-> {
            setStroke(Color.WHITE);
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

}

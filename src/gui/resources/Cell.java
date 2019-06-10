package gui.resources;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

    private static Color[] states = {Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW};


    public Cell(double height, double width, int i){

        super(width, height);
        setStroke(Color.GRAY);
        setState(i);

        setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent e){

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
       });

    }

    public void setState(int i){
        try {
            setFill(states[i]);
        }catch (IndexOutOfBoundsException e){

        }

    }

    public Color getState(){
        return (Color) getFill();
    }

}

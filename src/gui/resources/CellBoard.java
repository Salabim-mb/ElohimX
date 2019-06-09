package gui.resources;

import javafx.scene.layout.Pane;


public class CellBoard extends Pane {

    private Cell[] cells;

    public CellBoard(int width, int height){


        setWidth(20*width);
        setHeight(20*height);
        //double dim = width > height ? (650.0/width) : (420.0/height);
        cells = new Cell[width*height];

        for(int i = 0; i < cells.length; i++){

            cells[i] = new Cell(20, 20, 0);
            cells[i].setTranslateX(20*(i % width));
            cells[i].setTranslateY(20*(i / height));

            getChildren().add(cells[i]);


        }


    }


    public void setCells(Cell[] cells){
        this.cells = cells;
    }

    public Cell[] getCells(){
        return cells;
    }
}

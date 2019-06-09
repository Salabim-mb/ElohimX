package gui.resources;

import javafx.scene.layout.Pane;


public class CellBoard extends Pane {

    private Cell[] cells;

    public CellBoard(int width, int height){


        setWidth(650.0);
        setHeight(420.0);
        double dim = width > height ? (650.0/width) : (420.0/height);
        cells = new Cell[width*height];

        for(int i = 0; i < cells.length; i++){

            cells[i] = new Cell(20, 20, 0);
            cells[i].setTranslateX(dim*(i % width));
            cells[i].setTranslateY(dim*(i / height));

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

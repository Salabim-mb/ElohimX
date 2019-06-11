package gui.resources;


import javafx.scene.layout.Pane;

import static gui.WWCellViewController.CELL_VIEW_HEIGHT;
import static gui.WWCellViewController.CELL_VIEW_WIDTH;


public class CellBoard extends Pane {



    private Cell[][] cells;


    public CellBoard(int widthInCells, int heightInCells){


        double divisorW = CELL_VIEW_WIDTH/widthInCells;
        double divisorH = CELL_VIEW_HEIGHT/heightInCells;


        double dim = (divisorW*heightInCells > CELL_VIEW_HEIGHT) ?
            (divisorH) : (divisorW);

        cells = new Cell[widthInCells][heightInCells];

        setWidth(dim*widthInCells);
        setHeight(dim*heightInCells);

        for(int i = 0; i < widthInCells; i++)
            for(int j =0; j < heightInCells; j++){
            cells[i][j] = new Cell(dim, dim, 0);
            cells[i][j].setTranslateX(dim*i);
            cells[i][j].setTranslateY(dim*j);

            getChildren().add(cells[i][j]);
        }


    }


    public void setCells(Cell[][] cells){
        this.cells = cells;
    }

    public Cell[][] getCells(){
        return cells;
    }


}

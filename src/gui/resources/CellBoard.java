package gui.resources;

import gui.WWCellViewController;
import javafx.scene.layout.Pane;


public class CellBoard extends Pane {

    private Cell[][] cells;

    public CellBoard(int widthInCells, int heightInCells){

        double dim = (widthInCells > heightInCells && widthInCells > 15) ?
            (WWCellViewController.CELL_VIEW_WIDTH/widthInCells) : (WWCellViewController.CELL_VIEW_HEIGHT/heightInCells);

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

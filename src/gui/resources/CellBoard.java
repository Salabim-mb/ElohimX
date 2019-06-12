package gui.resources;


import core.*;
import javafx.scene.layout.Pane;

import static gui.WWCellViewController.CELL_VIEW_HEIGHT;
import static gui.WWCellViewController.CELL_VIEW_WIDTH;


public class CellBoard extends Pane {



    private RecCell[][] cells;

    public CellBoard(int widthInCells, int heightInCells){

        double divisorW = CELL_VIEW_WIDTH/widthInCells;
        double divisorH = CELL_VIEW_HEIGHT/heightInCells;


        double dim = (divisorW*heightInCells > CELL_VIEW_HEIGHT) ?
            (divisorH) : (divisorW);
       

        cells = new RecCell[widthInCells][heightInCells];

        setWidth(dim*widthInCells);
        setHeight(dim*heightInCells);

        for(int i = 0; i < widthInCells; i++)
            for(int j =0; j < heightInCells; j++){
            cells[i][j] = new RecCell(dim,0);
            cells[i][j].setTranslateX(dim*i);
            cells[i][j].setTranslateY(dim*j);

            getChildren().add(cells[i][j]);
        }


    }

    public void initializeRecCells(WireWorldCell[][] genZero, int boardHeight, int boardWidth){

        for(int i=0; i<boardHeight; i++)
            for(int j=0; j<boardWidth; j++)
            {
                RecCell cell = cells[i][j];
                WireWorldCell genZeroCell = genZero[i][j];
                cell.setOnMouseClicked(e-> {

                    cell.changeState();
                    switch (cell.getWWState()){
                        case EMPTY:
                            genZeroCell.setWWState(WWStates.EMPTY);
                            break;
                        case ELECTRON_HEAD:
                            genZeroCell.setWWState(WWStates.ELECTRON_HEAD);
                            break;
                        case ELECTRON_TAIL:
                            genZeroCell.setWWState(WWStates.ELECTRON_TAIL);
                            break;
                        case CONDUCTOR:
                            genZeroCell.setWWState(WWStates.CONDUCTOR);
                            break;
                    }
                });

            }

    }

    public void setCells(RecCell[][] cells){
        this.cells = cells;
    }

    public RecCell[][] getCells(){
        return cells;
    }


}

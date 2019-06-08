package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observer;

public class Generation{
    private int genNumber;
    private Cell[][] cells;
    ArrayList<Observer> observers;


    public Generation (int genNumber, Cell[][] cells){
        this.genNumber = genNumber;
        this.cells = cells;
    }

    public  Cell[][] getCells() {
        return cells;
    }

    public int getRows() {
        return cells.length;
    }

    public int getColumns() {
        return cells[0].length;
    }

    public void setGOLState(GOLStates gol) {
        GameOfLifeCell.setGOLState(gol);
    }

   /* public int[][] getNumericGOLCells() {
        int[][] temp = null;
        Arrays.stream(cells).flatMap(Arrays::stream).forEach(cell -> temp[Cell.getposX()][Cell.getposY()] = GameOfLifeCell.getNumericState());
        return temp;
    }

    public int[][] getNumericWWCells() {
        int[][] temp = null;
        Arrays.stream(cells).flatMap(Arrays::stream).forEach(cell -> temp[Cell.getposX()][Cell.getposY()] = WireWorldCell.getNumericState());
        return temp;
    }


*/
}

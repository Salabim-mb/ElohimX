package core;

import core.GameOfLifeCell;
import core.WireWorldCell;

public class Cell {
    private int posX;
    private int posY;

    public Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getposX() {
        return posX;
    }

    public int getposY() {
        return posY;
    }

   /*
    public WWStates currWWState() {
        return WireWorldCell.getWWState();
    }

    public GOLStates currGOLState() {
        return GameOfLifeCell.getGOLState();
    }

    public void setWWState(WWStates ww) {
        WWStates state = ww;
    }

    public void setGOLState (GOLStates gol) {
        GOLStates state = gol;
    }

    @Override
    public int hashCode() {
        int result = posX;
        result = 31* result + posY;
        return result;
    }

    @Override
    public boolean equals (Object sth) {
        Cell cell = (Cell) sth;
        if (this.getposX() == cell.getposX() && this.getposY() == cell.getposY())
            return true;
        else
            return false;
    }


*/
}

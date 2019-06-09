package core;

import static core.WWStates.*;
import core.Cell;

public class GameOfLifeCell {

    private GOLStates state;

    GameOfLifeCell(Cell posX, Cell posY, GOLStates state) {}

    public GameOfLifeCell() {
        state = GOLStates.DEAD;
    }

    public GOLStates getGOLState() {
        return state;
    }

    public void setGOLState(GOLStates gol) {
        state = gol;
    }

    /*public static int getNumericState() {
        switch (GameOfLifeCell.state) {
            case DEAD: return 0;
            case ALIVE: return 1;
            default: return -1;
        }
    }*/
}
package core;

import core.GOLStates;

public class GameOfLifeCell extends Cell{

    private GOLStates state;

    public GameOfLifeCell(int posX, int posY, GOLStates state) {
        super(posX, posY);
    }

    /*
    public GameOfLifeCell() {
        state = GOLStates.DEAD;
    }
    */

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
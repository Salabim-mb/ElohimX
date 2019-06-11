package core;


public class GameOfLifeCell extends Cell{

    private GOLStates state;

    public GameOfLifeCell() {
        state = GOLStates.DEAD;
    }


    public GOLStates getGOLState() {
        return state;
    }

    public void setGOLState(GOLStates gol) {
        state = gol;
    }

}
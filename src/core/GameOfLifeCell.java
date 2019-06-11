package core;


public class GameOfLifeCell extends Cell{

    private GOLStates state;

    public GameOfLifeCell(GOLStates state) {
        this.state = state;
    }


    public GOLStates getGOLState() {
        return state;
    }

    public void setGOLState(GOLStates gol) {
        state = gol;
    }

}
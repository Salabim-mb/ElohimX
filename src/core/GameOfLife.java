package core;

import java.util.ArrayList;

public class GameOfLife {

    private static GameOfLife instance;
    private ArrayList<Generation> generations;

    private GameOfLife(){}

    public static GameOfLife getInstance(){
        if(instance == null)
            instance = new GameOfLife();
        return instance;
    }

    private int countGOLNeighbours(GameOfLifeCell[][] hood) {
        int cellCounter = 0;
        for(GameOfLifeCell[] row : hood)
            for (GameOfLifeCell cell : row)
                if (cell.getGOLState() == GOLStates.ALIVE)
                    cellCounter++;
        if (hood[1][1].getGOLState() == GOLStates.ALIVE)
            cellCounter--;
        return cellCounter;
    }

    public void runGameOfLife(){
        if(!generations.isEmpty()){
            Generation lastGen = generations.get(generations.size() - 1);
            GameOfLifeCell[][] lastGenBoard = (GameOfLifeCell[][]) lastGen.getCells();
            int height = lastGen.getRows();
            int width = lastGen.getColumns();

            GameOfLifeCell[][] nextGenBoard = new GameOfLifeCell[height][width];
            int cellCounter = 0;
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    GameOfLifeCell[][] hood = new GameOfLifeCell[3][3];
                    for (int k=0; k<3; k++)
                        for (int l=0; l<3; l++)
                            hood[k][l] = lastGenBoard[i-1+k][j-1+l];
                    cellCounter = countGOLNeighbours(hood);

                    if (lastGenBoard[i][j].getGOLState() == GOLStates.ALIVE) {
                        if (cellCounter > 1 && cellCounter < 4)
                            nextGenBoard[i][j].setGOLState(GOLStates.ALIVE);
                        else nextGenBoard[i][j].setGOLState(GOLStates.DEAD);;
                    }
                    else {
                        if (cellCounter == 3)
                            nextGenBoard[i][j].setGOLState(GOLStates.ALIVE);
                        else nextGenBoard[i][j].setGOLState(GOLStates.DEAD);
                    }
                }
            }

            Generation nextGen = new Generation(generations.size(), nextGenBoard);

            generations.add(nextGen);

        }
    }
}

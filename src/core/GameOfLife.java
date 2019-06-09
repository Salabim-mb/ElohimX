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

    private int countGOLNeighbours(Cell[][] hood) {
        int cellCounter = 0;
        for(Cell[] row : hood)
            for (Cell cell : row)
                if (cell.currGOLState() == GOLStates.ALIVE)
                    cellCounter++;
        if (hood[1][1].currGOLState() == GOLStates.ALIVE)
            cellCounter--;
        return cellCounter;
    }

    public void runGameOfLife(){
        if(!generations.isEmpty()){
            Generation lastGen = generations.get(generations.size() - 1);
            Cell[][] lastGenBoard = lastGen.getCells();
            int height = lastGen.getRows();
            int width = lastGen.getColumns();

            Cell[][] nextGenBoard = new Cell[height][width];
            int cellCounter = 0;
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    Cell[][] hood = new Cell[3][3];
                    for (int k=0; k<3; k++)
                        for (int l=0; l<3; l++)
                            hood[k][l] = lastGenBoard[i-1+k][j-1+l];
                    cellCounter = countGOLNeighbours(hood);

                    if (lastGenBoard[i][j].currGOLState() == GOLStates.ALIVE) {
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

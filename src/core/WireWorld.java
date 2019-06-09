package core;

import java.util.ArrayList;
import core.Cell;

public class WireWorld {

    private static WireWorld instance;
    private ArrayList<Generation> generations;

    private WireWorld(){
        //zero = new Generation(0, wwCell);
    }

    public static WireWorld getInstance(){
        if(instance == null)
            instance = new WireWorld();
        return instance;
    }

    private boolean isConductor(WireWorldCell cell) {
        if (cell.getWWState() == WWStates.CONDUCTOR)
            return true;
        return false;
    }

    public void runWireWorld() {
        if(!generations.isEmpty()){
            Generation lastGen = generations.get(generations.size() - 1);
            WireWorldCell[][] lastGenBoard = (WireWorldCell[][]) lastGen.getCells();
            int height = lastGen.getRows();
            int width = lastGen.getColumns();
            WireWorldCell[][] nextGenBoard = new WireWorldCell[height][width];
            int cellCounter = 0;
            for (int r=0; r<height; r++) {
                for (int c = 0; c < width; c++) {
                    if (lastGenBoard[r][c].getWWState() == WWStates.ELECTRON_HEAD)
                        nextGenBoard[r][c].setWWState(WWStates.ELECTRON_TAIL);
                    else if (lastGenBoard[r][c].getWWState() == WWStates.ELECTRON_TAIL)
                        nextGenBoard[r][c].setWWState(WWStates.CONDUCTOR);
                    else if (isConductor(lastGenBoard[r][c])) {
                        int electronHeadCounter = 0;
                        WireWorldCell[][] hood = new WireWorldCell[3][3];
                        for (int k = 0; k<3; k++)
                            for (int l=0; l<3; l++)
                                hood[k][l] = lastGenBoard[r-1+k][c-1+l];
                        for (WireWorldCell[] row : hood)
                            for (WireWorldCell cell : row)
                                if (cell.getWWState() == WWStates.ELECTRON_HEAD)
                                    electronHeadCounter++;

                        if (electronHeadCounter == 1 || electronHeadCounter == 2)
                            nextGenBoard[r][c].setWWState(WWStates.ELECTRON_HEAD);
                    }

                }
            }
            Generation nextGen = new Generation(generations.size(), nextGenBoard);

            generations.add(nextGen);

        }
    }

}

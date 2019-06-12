package core;

import java.util.ArrayList;
import java.util.List;

import static core.WWStates.CONDUCTOR;
import static core.WWStates.ELECTRON_HEAD;


public class WireWorld {

    private static WireWorld instance;
    private List<Generation> generations;

    private WireWorld(){
        generations = new ArrayList<>();
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

    public void initializeWW(Generation genZero){

        if (!getGenerations().isEmpty())
            getGenerations().clear();

        getGenerations().add(genZero);

    }

    private WireWorldCell[][] surroundCells(WireWorldCell[][] wwCells) {

        //Create and initialize matrix with dims+2
        int height = getGenerations().get(getGenerations().size()-1).getRows();
        int width = getGenerations().get(getGenerations().size()-1).getColumns();
        WireWorldCell[][] wardedCells = new WireWorldCell[height+2][width+2];
        for (int i=0; i<5; i++) {
            wardedCells[i] = new WireWorldCell[height+2];
            for (int j=0; j<width+2; j++) {
                wardedCells[i][j] = new WireWorldCell(WWStates.EMPTY);
            }
        }

        //Fill the matrix
        for (int i=0; i<height; i++)
            for (int j = 0; j < width; j++)
                wardedCells[i+1][j+1] = wwCells[i][j];

        return wardedCells;
    }


    public void runWireWorld() {
        if(!getGenerations().isEmpty()){
            Generation lastGen = getGenerations().get(getGenerations().size() - 1);
            WireWorldCell[][] lastGenBoard = (WireWorldCell[][]) lastGen.getCells();
            lastGenBoard = surroundCells(lastGenBoard);
            int height = lastGen.getRows();
            int width = lastGen.getColumns();

            //initialize nextGenBoard
            WireWorldCell[][] nextGenBoard = new WireWorldCell[height][width];
            for (int r=0; r<height; r++) {
                nextGenBoard[r] = new WireWorldCell[width];
                for (int c = 0; c < width; c++) {

                    //default is empty, then may overwrite with other states
                    nextGenBoard[r][c] = new WireWorldCell(WWStates.EMPTY);
                    if (lastGenBoard[r+1][c+1].getWWState() == ELECTRON_HEAD)
                        nextGenBoard[r][c].setWWState(WWStates.ELECTRON_TAIL);
                    else if (lastGenBoard[r+1][c+1].getWWState() == WWStates.ELECTRON_TAIL)
                        nextGenBoard[r][c].setWWState(WWStates.CONDUCTOR);
                    else if (isConductor(lastGenBoard[r+1][c+1])) {
                        int electronHeadCounter = 0;

                        //initialize neighbouring matrix
                        WireWorldCell[][] hood = new WireWorldCell[3][3];
                        for (int i=0; i<3; i++) {
                            hood[i] = new WireWorldCell[3];
                            for (int j=0; j<3; j++)
                                hood[i][j] = new WireWorldCell(lastGenBoard[r+1][c+1].getWWState());
                        }

                        //ward(?) and count heads
                        //hood = surroundCells(hood);
                        for (int i=0; i<3;i++)
                            for (int j=0; j<3; j++)
                                if (hood[i][j].getWWState() == ELECTRON_HEAD)
                                    electronHeadCounter++;

                        if (electronHeadCounter == 1 || electronHeadCounter == 2)
                            nextGenBoard[r][c].setWWState(ELECTRON_HEAD);
                        else
                            nextGenBoard[r][c].setWWState(CONDUCTOR);
                    }

                }
            }
            Generation nextGen = new Generation(lastGen.getGenNumber()+1, nextGenBoard);

            getGenerations().add(nextGen);

        }
    }

    public List<Generation> getGenerations() {
        return generations;
    }
}

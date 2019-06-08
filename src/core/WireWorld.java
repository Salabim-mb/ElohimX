package core;

import java.util.ArrayList;

public class WireWorld {

    private static WireWorld instance;
    private ArrayList<Generation> generations;

    private WireWorld(Generation zero, WireWorldCell wwCell){
        zero = new Generation(0, wwCell)
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
            Cell[][] lastGenBoard = lastGen.getWWCells();
            int height = lastGen.getRows();
            int width = lastGen.getColumns();

            Cell[][] nextGenBoard = new Cell[height][width];
            int cellCounter = 0;
            for (int r=0; r<height; r++) {
                for (int c = 0; c < width; c++) {
                    if

                }
            }
            Generation nextGen = new Generation(generations.size(), nextGenBoard);

            generations.add(nextGen);

        }
    }

}

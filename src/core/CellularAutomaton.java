package core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import core.WireWorld;
import core.GameOfLife;
import core.Generation;

public class CellularAutomaton extends Generation{

    private static WireWorld instanceWW;
    private static GameOfLife instanceGOL;
    private ArrayList<Generation> generations;

    public CellularAutomaton(int genNumber, Cell[][] cells) {
        super(genNumber, cells);
    }

    public ArrayList<Generation> getGenerations() {
        return generations;
    }

    public void initializeGenerations(Generation genZero){
        generations = new ArrayList<>();
        generations.add(genZero);
    }

    public void clearGenerations(){
        generations.clear();
    }

    public void runAutomaton() {
        
    }
}

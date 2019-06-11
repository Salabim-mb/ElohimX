package tests;

import core.Generation;
import core.WWStates;
import core.WireWorld;
import java.util.List;

import core.WireWorldCell;
import org.junit.jupiter.api.Test;

public class WireWorldTest {
    private List<Generation> generations;
    private WireWorld ww = new WireWorld();
    //private WireWorldTest wwTest = new WireWorldTest();
    private WireWorldCell[][] wwCells = new WireWorldCell[1][1];
    private Generation zeroGen = new Generation(0, wwCells);
    private String str = "";

    public Generation getGen() {
        return zeroGen;
    }

    public void setGenerations(List<Generation> generations) {
        this.generations = generations;
    }

    private WireWorldCell tmp(Generation gen) {
        WireWorldCell[][] x;
        x = (WireWorldCell[][]) gen.getCells();
        return x[0][0];
    }

    @Test
    public void shouldCreateNewGen() {
        //generations.add(zeroGen);
        wwCells[0][0] = new WireWorldCell(WWStates.ELECTRON_HEAD);
        zeroGen.setCells(wwCells);
        ww.initializeWW(zeroGen);
        ww.runWireWorld();
        System.out.println(str.toString());
    }

    @Override
    public String toString(){
        return "Loaded matrix: " + wwCells[0][0].stateToString(wwCells[0][0])
                + "\n WireWorlded Matrix: " + tmp(generations.get(1)).stateToString(tmp(generations.get(1)));
    }

}

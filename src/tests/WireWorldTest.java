package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import core.Generation;
import core.WWStates;
import core.WireWorld;

import core.WireWorldCell;
import org.junit.jupiter.api.Test;

public class WireWorldTest {

    private int width = 3;
    private int height = 3;
    private WireWorld ww = WireWorld.getInstance();
    private WireWorldCell[][] wwCells = new WireWorldCell[height][width];
    private Generation zeroGen = new Generation(0, wwCells);
    //private String str = "";


    private WireWorldCell tmp(Generation gen) {
        WireWorldCell[][] x;
        x = (WireWorldCell[][]) gen.getCells();
        return x[0][0];
    }

    @Test
    public void shouldCreateNewGen() {
        for (WireWorldCell[] row : wwCells) {
            row = new WireWorldCell[width];
            for (WireWorldCell cell : row)
                cell = new WireWorldCell(WWStates.EMPTY);
        }
        //generations.add(zeroGen);
        wwCells[0][0] = new WireWorldCell(WWStates.ELECTRON_HEAD);
        wwCells[0][1] = new WireWorldCell(WWStates.EMPTY);
        wwCells[0][2] = new WireWorldCell(WWStates.CONDUCTOR);
        wwCells[1][0] = new WireWorldCell(WWStates.CONDUCTOR);
        wwCells[1][1] = new WireWorldCell(WWStates.CONDUCTOR);
        wwCells[1][2] = new WireWorldCell(WWStates.EMPTY);
        wwCells[2][0] = new WireWorldCell(WWStates.ELECTRON_TAIL);
        wwCells[2][1] = new WireWorldCell(WWStates.ELECTRON_HEAD);
        wwCells[2][2] = new WireWorldCell(WWStates.EMPTY);
        zeroGen.setCells(wwCells);
        ww.initializeWW(zeroGen);
        ww.runWireWorld();
        WireWorldCell cell0 = (WireWorldCell)ww.getGenerations().get(1).getCells()[0][0];
        assertEquals("ELECTRON_TAIL", cell0.stateToString(), "You've created an abomination 00");
        WireWorldCell cell1 = (WireWorldCell)ww.getGenerations().get(1).getCells()[0][1];
        assertEquals("EMPTY", cell1.stateToString(), "You've created an abomination 01");
        WireWorldCell cell2 = (WireWorldCell)ww.getGenerations().get(1).getCells()[0][2];
        assertEquals("CONDUCTOR", cell2.stateToString(), "You've created an abomination 02");
        WireWorldCell cell3 = (WireWorldCell)ww.getGenerations().get(1).getCells()[1][0];
        assertEquals("CONDUCTOR", cell3.stateToString(), "You've created an abomination 10");
        WireWorldCell cell4 = (WireWorldCell)ww.getGenerations().get(1).getCells()[1][1];
        assertEquals("CONDUCTOR", cell4.stateToString(), "You've created an abomination 11");
        WireWorldCell cell5 = (WireWorldCell)ww.getGenerations().get(1).getCells()[1][2];
        assertEquals("EMPTY", cell5.stateToString(), "You've created an abomination 12");
        WireWorldCell cell6 = (WireWorldCell)ww.getGenerations().get(1).getCells()[2][0];
        assertEquals("CONDUCTOR", cell6.stateToString(), "You've created an abomination 20");
        WireWorldCell cell7 = (WireWorldCell)ww.getGenerations().get(1).getCells()[2][1];
        assertEquals("ELECTRON_TAIL", cell7.stateToString(), "You've created an abomination 21");
        WireWorldCell cell8 = (WireWorldCell)ww.getGenerations().get(1).getCells()[2][2];
        assertEquals("EMPTY", cell8.stateToString(), "You've created an abomination 22");
    }

}

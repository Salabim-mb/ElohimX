package tests;


import core.*;
import utils.TxtWriter;
import java.io.*;
import org.junit.jupiter.api.Test;

public class TxtWriterTest {
    private TxtWriter test = new TxtWriter();

    @Test
    public void shouldCreateWWFile() throws IOException {
        String filename = "WWresult.txt";
        WireWorldCell[][] cells = new WireWorldCell[1][1];

        Generation lastGen = new Generation(0, cells);
        WireWorldCell[][] wwcells = new WireWorldCell[1][1];
        wwcells[0][0] = new WireWorldCell(WWStates.ELECTRON_TAIL);
        lastGen.setCells(wwcells);
        test.writeWW(filename, lastGen);
    }

    @Test
    public void shouldCreateGOLFile() throws IOException {
        String filename = "GOLresult.txt";
        GameOfLifeCell[][] cells = new GameOfLifeCell[1][1];

        Generation lastGen = new Generation(0, cells);
        GameOfLifeCell[][] golcells = new GameOfLifeCell[1][1];
        golcells[0][0] = new GameOfLifeCell(GOLStates.DEAD);
        lastGen.setCells(golcells);
        test.writeGOL(filename, lastGen);
    }
}

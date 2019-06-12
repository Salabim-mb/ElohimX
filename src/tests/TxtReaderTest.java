package tests;

import core.*;
import utils.TxtReader;
import java.io.*;
import org.junit.jupiter.api.Test;


public class TxtReaderTest {
    private TxtReader test = new TxtReader();
    private File fileww = new File("testww.txt");
    private File filegol = new File("testgol.txt");

    @Test
    public void shouldReturnWWGrid() throws IOException {
        WireWorldCell[][] cells = new WireWorldCell[1][1];
        cells[0][0] = new WireWorldCell(WWStates.EMPTY);
        Generation zero = new Generation(0, cells);

        test.readWW(fileww);
        //assertEquals(WWStates.ELECTRON_HEAD, zero.getCells(), "ww nierówne, powinno być 2");
    }

    @Test
    public void shouldReturnGOLGrid() throws IOException {
        GameOfLifeCell[][] cells = new GameOfLifeCell[1][1];
        cells[0][0] = new GameOfLifeCell(GOLStates.DEAD);
        Generation zero = new Generation(0, cells);

        test.readGOL(filegol);
        //assertEquals(GOLStates.ALIVE, zero.getCells(), "gol nierówne, powinno być 1");
    }

}

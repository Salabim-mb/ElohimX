package utils;

import java.io.*;

import core.WireWorldCell;
import core.GameOfLifeCell;
import core.Generation;
import core.WWStates;
import core.GOLStates;

public class TxtWriter {
    private TxtWriter instance;

    private TxtWriter() { }

    public TxtWriter getInstance() {
        if (instance == null)
            instance = new TxtWriter();
        return instance;
    }

    private String mayAddDotTxt(String name) {
        if (!name.endsWith(".txt"))
            name += ".txt";
        return name;
    }

    public void writeWW (String filename, Generation lastGen) throws IOException {
        String textBufferWW = null;
        int rows = lastGen.getRows();
        int columns = lastGen.getColumns();
        WireWorldCell[][] wwCells = (WireWorldCell[][]) lastGen.getCells();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (wwCells[i][j].getWWState() == WWStates.EMPTY) {
                    textBufferWW += "0";
                    continue;
                } else if (wwCells[i][j].getWWState() == WWStates.CONDUCTOR) {
                    textBufferWW += "1";
                    continue;
                } else if (wwCells[i][j].getWWState() == WWStates.ELECTRON_HEAD) {
                    textBufferWW += "2";
                    continue;
                } else if (wwCells[i][j].getWWState() == WWStates.ELECTRON_TAIL) {
                    textBufferWW += "3";
                    continue;
                }
            }
            textBufferWW += "\n";
        }

        String filePath = "/" + mayAddDotTxt(filename);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(textBufferWW);
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    public void writeGOL (String filename, Generation lastGen) throws IOException {
        String textBufferGOL = null;
        int rows = lastGen.getRows();
        int columns = lastGen.getColumns();
        GameOfLifeCell[][] golCells = (GameOfLifeCell[][]) lastGen.getCells();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (golCells[i][j].getGOLState() == GOLStates.DEAD) {
                    textBufferGOL += "0";
                    continue;
                } else if (golCells[i][j].getGOLState() == GOLStates.ALIVE) {
                    textBufferGOL += "1";
                    continue;
                }
            }
            textBufferGOL += "\n";
        }

        String filePath = "/" + mayAddDotTxt(filename);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(textBufferGOL);
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}

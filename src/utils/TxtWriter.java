package utils;

import java.io.*;

import core.Cell;
import core.Generation;
import core.WWStates;
import core.GOLStates;

public class TxtWriter {
    private static TxtWriter instance;

    private TxtWriter() { }

    public static TxtWriter getInstance() {
        if (instance == null)
            instance = new TxtWriter();
        return instance;
    }

    private String mayAddDotTxt(String name) {
        if (!name.endsWith(".txt"))
            name += ".txt";
        return name;
    }

    public void writeWW (String filename) throws IOException {
        String textBufferWW = null;
        int rows = Generation.getRows();
        int columns = Generation.getColumns();
        Cell[][] wwCells = Generation.getCells();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (wwCells[i][j].currWWState() == WWStates.EMPTY) {
                    textBufferWW += "0";
                    continue;
                } else if (wwCells[i][j].currWWState() == WWStates.CONDUCTOR) {
                    textBufferWW += "1";
                    continue;
                } else if (wwCells[i][j].currWWState() == WWStates.ELECTRON_HEAD) {
                    textBufferWW += "2";
                    continue;
                } else if (wwCells[i][j].currWWState() == WWStates.ELECTRON_TAIL) {
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

    public void writeGOL (String filename) throws IOException {
        String textBufferGOL = null;
        int rows = Generation.getRows();
        int columns = Generation.getColumns();
        Cell[][] golCells = Generation.getCells();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (golCells[i][j].currGOLState() == GOLStates.DEAD) {
                    textBufferGOL += "0";
                    continue;
                } else if (golCells[i][j].currGOLState() == GOLStates.ALIVE) {
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

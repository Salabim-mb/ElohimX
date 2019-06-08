package utils;

import java.io.*;

import core.Generation;
import core.WWStates;
import core.WireWorld;
import core.WireWorldCell;
import core.Cell;

public class TxtWriter {
    private static TxtWriter instance;

    private TxtWriter() { }

    public static TxtWriter getInstance() {
        if (instance == null)
            instance = new TxtWriter();
        return instance;
    }

    public void writeWW (String filename) throws IOException {
        String textBufferWW = null;
        int rows = Generation.getRows();
        int columns = Generation.getColumns();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                WireWorldCell cell = ;
                Cell[][] wwCells = Generation.getCells();
                if (wwCells[i][j].get == WWStates.EMPTY) {
                    textBufferWW += "0";
                    continue;
                } else if (wwCells[i][j] == WWStates.CONDUCTOR) {
                    textBufferWW += "1";
                    continue;
                } else if (wwCells[i][j] == WWStates.ELECTRON_HEAD) {
                    textBufferWW += "2";
                    continue;
                } else if (wwCells[i][j] == WWStates.ELECTRON_TAIL) {
                    textBufferWW += "3";
                    continue;
                }
            }
            textBufferWW += "\n";
        }
        ObjectOutputStream outputStream = null;
        try {

            outputStream = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("./" + filename)));
            outputStream.writeObject(textBufferWW);
        } finally {
            if(outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }

    }

    public void writeGOL (String filename) throws IOException {
        String textBufferGOL = null;
        int rows = Generation.getRows();
        int columns = Generation.getColumns();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                WireWorldCell cell = ;
                int[][] numericGOLCells = Generation.getNumericWWCells();
                if (numericGOLCells[i][j] == 0) {
                    textBufferGOL += "0";
                    continue;
                } else if (numericGOLCells[i][j] == 1) {
                    textBufferGOL += "1";
                    continue;
                }
            }
            textBufferGOL += "\n";
        }
        ObjectOutputStream outputStream = null;
        try {

            outputStream = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("./" + filename)));
            outputStream.writeObject(textBufferGOL);
        } finally {
            if(outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }

    }
}

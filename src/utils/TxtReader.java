package utils;

import java.io.*;

import core.*;

public class TxtReader {

    private TxtReader instance;

    public TxtReader() { }

    public TxtReader getInstance() {
        if (instance == null)
            instance = new TxtReader();
        return instance;
    }

    private int getFileLineNumber(File srcFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(srcFile));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }

    private int getFileLineLength (File srcFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(srcFile));
        int width = 0;
        String str = reader.readLine();
        reader.close();
        return str.length();
    }

    private WireWorldCell[][] strToWWCellArray(String str, int height, int width) {
        WireWorldCell[][] cells = new WireWorldCell[height][width];
        int i=0, r=0, c=0;
        while (i < str.length()) {
            while (str.charAt(i) != '\n' && str.charAt(i) != '\0') {
                switch (str.charAt(i)) {
                    case '0':
                        cells[r][c].setWWState(WWStates.EMPTY);
                    case '1':
                        cells[r][c].setWWState(WWStates.CONDUCTOR);
                    case '2':
                        cells[r][c].setWWState(WWStates.ELECTRON_HEAD);
                    case '3':
                        cells[r][c].setWWState(WWStates.ELECTRON_TAIL);
                    default:
                }
                i++;
                c++;
            }
            c=0;
            r++;
        }
        return cells;
    }

    private GameOfLifeCell[][] strToGOLCellArray(String str, int height, int width) {
        GameOfLifeCell[][] cells = new GameOfLifeCell[height][width];
        int i=0, r=0, c=0;
        while (i < str.length()) {
            while (str.charAt(i) != '\n' && str.charAt(i) != '\0') {
                switch (str.charAt(i)) {
                    case '0':
                        cells[r][c].setGOLState(GOLStates.DEAD);
                    case '1':
                        cells[r][c].setGOLState(GOLStates.ALIVE);
                    default:
                }
                i++;
                c++;
            }
            c=0;
            r++;
        }
        return cells;
    }

    public void readWW (File srcFile) throws IOException {
        BufferedReader readBufferWW = null;
        String str = "";
        try {
            int height = getFileLineNumber(srcFile);
            int width = getFileLineLength(srcFile);
            readBufferWW = new BufferedReader(new FileReader(srcFile));
            int w=0;
            while(w < height) {
                str += readBufferWW.readLine() + "\n";
                w++;
            }
            WireWorldCell[][] grid = strToWWCellArray(str, height, width);
            Generation zero = new Generation (0, grid);
        }
        finally {
            if (readBufferWW != null) {
                readBufferWW.close();
            }
        }

    }

    public void readGOL (File srcFile) throws IOException {
        BufferedReader readBufferGOL = null;
        String str = "";
        try {
            int height = getFileLineNumber(srcFile);
            int width = getFileLineLength(srcFile);
            readBufferGOL = new BufferedReader(new FileReader(srcFile));
            int g=0;
            while(g< height){
                str += readBufferGOL.readLine() + "\n";
                g++;
            }
            GameOfLifeCell[][] grid = strToGOLCellArray(str, height, width);
            Generation zero = new Generation (0, grid);
        }
        finally {
            if (readBufferGOL != null) {
                readBufferGOL.close();
            }
        }

    }

}

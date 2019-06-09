package core;

import core.WWStates;

public class WireWorldCell extends Cell{

    private WWStates state;

    public WireWorldCell(int posX, int posY, WWStates state) {
        super(posX, posY);
    }

    /*public WireWorldCell() {
        state = WWStates.EMPTY;
    }*/

    public WWStates getWWState() {
        return state;
    }

    public void setWWState(WWStates ww) {
        state = ww;
    }

    /*public static int getNumericState() {
        switch (WireWorldCell.state) {
            case EMPTY: return 0;
            case CONDUCTOR: return 1;
            case ELECTRON_HEAD: return 2;
            case ELECTRON_TAIL: return 3;
            default: return -1;
        }
    }*/
}

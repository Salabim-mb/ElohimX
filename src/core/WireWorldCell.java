package core;

public class WireWorldCell {

    private static  WWStates state;

    WireWorldCell(Cell posX, Cell posY, WWStates state) {}

    public WireWorldCell() {
        this.state = WWStates.EMPTY;
    }

    public WWStates getWWState() {
        return this.state;
    }

    public static void setWWState(WWStates ww) {
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

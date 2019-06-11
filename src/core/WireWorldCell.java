package core;


public class WireWorldCell extends Cell{

    private WWStates state;

    public WireWorldCell(WWStates state) {
        this.state = state;
    }



    public WWStates getWWState() {
        return state;
    }

    public void setWWState(WWStates ww) {
        state = ww;
    }

    public String stateToString(WireWorldCell cell) {

        switch(cell.getWWState()) {
            case EMPTY: return "EMPTY";
            case CONDUCTOR: return "CONDUCTOR";
            case ELECTRON_HEAD: return "ELECTRON_HEAD";
            case ELECTRON_TAIL: return "ELECTRON_TAIL";
            default: return "WRONG";
        }
    }

}

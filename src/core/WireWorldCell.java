package core;


public class WireWorldCell extends Cell{

    private WWStates state;

    public WireWorldCell(WWStates state) {
        state = WWStates.EMPTY;
    }



    public WWStates getWWState() {
        return state;
    }

    public void setWWState(WWStates ww) {
        state = ww;
    }

}

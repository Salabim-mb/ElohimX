package core;

public class Generation{
    private int genNumber;
    private Cell[][] cells;
    //ArrayList<Observer> observers;


    public Generation (int genNumber, Cell[][] cells){
        this.genNumber = genNumber;
        this.setCells(cells);
    }

    public Generation (int genNumber, WireWorldCell[][] cells){
        this.genNumber = genNumber;
        this.setCells(cells);
    }

    public Cell[][] getCells() {
        return cells;
    }


    public int getRows() {
        return cells.length;
    }

    public int getColumns() {
        return cells[0].length;
    }


    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getGenNumber() {
        return genNumber;
    }
}

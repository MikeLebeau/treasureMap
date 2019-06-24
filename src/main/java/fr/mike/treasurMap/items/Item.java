package fr.mike.treasurMap.items;

public abstract class Item {

    int col;
    int line;

    public Item(int col, int line) {
        this.col = col;
        this.line = line;
    }

    public abstract boolean isTraversable();

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
}

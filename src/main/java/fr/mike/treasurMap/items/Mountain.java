package fr.mike.treasurMap.items;

public class Mountain extends Item {

    public Mountain(int col, int line) {
        super(col, line);
    }

    public boolean isTraversable() {
        return false;
    }
}

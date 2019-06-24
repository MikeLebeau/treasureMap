package fr.mike.treasurMap.items;

public class Treasur extends Item {

    private int treasurNb;

    public Treasur(int col, int line, int treasurNb) {
        super(col, line);
        this.treasurNb = treasurNb;
    }

    public int getTreasurNb() {
        return treasurNb;
    }

    public void setTreasurNb(int treasurNb) {
        this.treasurNb = treasurNb;
    }

    public void collected(){
        System.out.println("Collected");
        treasurNb--;
    }

    public boolean isTraversable() {
        return true;
    }
}

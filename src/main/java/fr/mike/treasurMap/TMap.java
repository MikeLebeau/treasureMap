package fr.mike.treasurMap;

import fr.mike.treasurMap.items.Item;

import java.util.ArrayList;
import java.util.List;

public class TMap {

    private int colNb;
    private int lineNb;

    private List<Item> items;

    public TMap(int colNb, int lineNb) {
        this.colNb = colNb;
        this.lineNb = lineNb;
        this.items = new ArrayList<Item>();
    }

    public TMap(int colNb, int lineNb, List<Item> items) {
        this.colNb = colNb;
        this.lineNb = lineNb;
        this.items = items;
    }

    public int getColNb() {
        return colNb;
    }

    public void setColNb(int colNb) {
        this.colNb = colNb;
    }

    public int getLineNb() {
        return lineNb;
    }

    public void setLineNb(int lineNb) {
        this.lineNb = lineNb;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() { // TODO Print map
        String res = "";

        for (int i = 0; i < lineNb; i++) {
            for (int j = 0; j < colNb; j++) {
                Item item = getItem(j, i);
                res += (item != null)? item.getClass().getSimpleName().charAt(0) : ".";
                res += " | " ;
            }
            res += "\n";
        }

        return res;
    }


    public Item getItem(int col, int line){
        for (Item item : items) {
            if(item.getCol() == col && item.getLine() == line){
                return item;
            }
        }

        return null;
    }
}

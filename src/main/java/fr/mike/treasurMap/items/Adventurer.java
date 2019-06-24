package fr.mike.treasurMap.items;

import fr.mike.treasurMap.Orientation;
import fr.mike.treasurMap.Sequence;
import fr.mike.treasurMap.TMap;

public class Adventurer extends Item {

    private String name;
    private Orientation orientation;
    private Sequence sequence;
    private TMap map;
    private int nbTreasur;

    public Adventurer(int col, int line, String name, Orientation orientation, Sequence sequence, TMap map, int nbTreasur) {
        super(col, line);
        this.name = name;
        this.orientation = orientation;
        this.sequence = sequence;
        this.map = map;
        this.nbTreasur = nbTreasur;
    }

    public Adventurer(int col, int line, String name, Orientation orientation, String sequence, TMap map, int nbTreasur) {
        super(col, line);
        this.name = name;
        this.orientation = orientation;
        this.sequence = new Sequence(sequence);
        this.map = map;
        this.nbTreasur = nbTreasur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTraversable() {
        return false;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    public TMap getMap() {
        return map;
    }

    public void setMap(TMap map) {
        this.map = map;
    }

    public int getNbTreasur() {
        return nbTreasur;
    }

    public void setNbTreasur(int nbTreasur) {
        this.nbTreasur = nbTreasur;
    }

    // Return final state
    public String exploreTheWorld(){

        for (char c : sequence.getActions().toCharArray()) {
            switch (c) {
                case 'A':
                    move();
                    break;
                case 'D':
                    // Issue with Java % (-1%4 return -1)
                    // Soluce: https://stackoverflow.com/questions/5385024/mod-in-java-produces-negative-numbers
                    int next = (((orientation.ordinal() + 1)%Orientation.values().length)+Orientation.values().length)%Orientation.values().length;
                    orientation = Orientation.values()[next];
                    break;
                case 'G':
                    next = (((orientation.ordinal() - 1)%Orientation.values().length)+Orientation.values().length)%Orientation.values().length;
                    orientation = Orientation.values()[next];
                    break;
            }
            System.out.println("MAP:");
            System.out.println(map);
        }

        return "";
    }

    private void move(){
        switch (orientation) {
            case NORTH:
                int next = ((line-1)%map.getLineNb()+map.getLineNb())%map.getLineNb();
                if(checkNextCase(col, next)){
                    line = next;
                }
                break;
            case SOUTH:
                next = ((line+1)%map.getLineNb()+map.getLineNb())%map.getLineNb();
                if(checkNextCase(col, next)){
                    line = next;
                }
                break;
            case EAST:
                next = ((col+1)%map.getColNb()+map.getColNb())%map.getColNb();
                if(checkNextCase(next, line)){
                    col = next;
                }
                break;
            case WEST:
                next = ((col-1)%map.getColNb()+map.getColNb())%map.getColNb();
                if(checkNextCase(next, line)){
                    col = next;
                }
                break;
        }
    }

    private boolean checkNextCase(int col, int line){
        Item nextItem = map.getItem(col, line);

        System.out.println("Actual Lara: (" + this.line + ", " + this.col + ")");
        System.out.println("Next Lara: (" + line + ", " + col + ")");

        if(nextItem != null){
            if(!nextItem.isTraversable()){
                return false;
            }

            if(nextItem.getClass().getSimpleName().equals("Treasur")){
                nbTreasur++;
                ((Treasur)nextItem).collected();
            }
        }


        return true;
    }
}

package fr.mike.treasurMapTest;

import fr.mike.treasurMap.Orientation;
import fr.mike.treasurMap.TMap;
import fr.mike.treasurMap.items.Adventurer;
import fr.mike.treasurMap.items.Mountain;
import fr.mike.treasurMap.items.Treasur;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AdventureTest {

    TMap map;

    @Before
    public void initialize(){
        map = new TMap(3, 4);

        map.addItem(new Mountain(1, 0));
        map.addItem(new Mountain(2, 1));
        map.addItem(new Treasur(0, 3, 2));
        map.addItem(new Treasur(1, 3, 3));

    }

    @Test
    public void allowedMove(){

        Adventurer lara = new Adventurer(1, 1, "Lara", Orientation.SOUTH, "AADADAGGA", map, 0);
        map.addItem(lara);

        lara.exploreTheWorld();

        Assert.assertEquals("Col check", 0, lara.getCol());
        Assert.assertEquals("Line check",3, lara.getLine());
        Assert.assertEquals("Orientation check",Orientation.SOUTH, lara.getOrientation());
        Assert.assertEquals("nbTreasur check",3, lara.getNbTreasur());
    }

    @Test
    public void blockedMove(){

        Adventurer lara = new Adventurer(1, 1, "Lara", Orientation.SOUTH, "AADADAGGA", map, 0);
        map.addItem(lara);

        map.addItem(new Mountain(0, 1));
        map.addItem(new Mountain(1, 2));

        lara.exploreTheWorld();

        Assert.assertEquals("Col check", 1, lara.getCol());
        Assert.assertEquals("Line check",1, lara.getLine());
    }

    @Test
    public void collectTreasur(){

        Adventurer lara = new Adventurer(1, 1, "Lara", Orientation.SOUTH, "DAAAA", map, 0);
        map.addItem(lara);

        Treasur treasurTest = new Treasur(0, 1, 3);
        map.addItem(treasurTest);

        lara.exploreTheWorld();

        Assert.assertEquals("Lara Col check", 0, lara.getCol());
        Assert.assertEquals("Lara Line check",1, lara.getLine());
        Assert.assertEquals("Treasur nbTreasur check",2, treasurTest.getTreasurNb());
        Assert.assertEquals("Lara nbTreasur check",1, lara.getNbTreasur());
    }

    @Test
    public void rotation(){

        Adventurer lara = new Adventurer(1, 1, "Lara", Orientation.SOUTH, "DDGG", map, 0);
        map.addItem(lara);

        lara.exploreTheWorld();

        Assert.assertEquals("Lara Col check", 1, lara.getCol());
        Assert.assertEquals("Lara Line check",1, lara.getLine());
        Assert.assertEquals("Orientation check",Orientation.SOUTH, lara.getOrientation());
    }

}

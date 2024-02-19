package edu.wctc;

public class LootableRoom extends Room {
    public LootableRoom(String name) {
        super(name);
        setLootable(true);
    }

    @Override
    public String getDescription() {
        return "This is a well lit welcoming room. There is a pile of bones with a jacket still remaining on it leaned against a wall that looks to have something in the front pocket.";
    }

}

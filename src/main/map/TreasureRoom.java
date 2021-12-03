

public class TreasureRoom extends Room {
    private Lootable treasure;
    private Goblin goblin;

    public TreasureRoom(Goblin g, Lootable tr) {
        super(g);
        treasure = tr;
        goblin = g;
    }

    @Override
    public String toString() {
        return "Treasure " + super.toString();
    }

    public Lootable getTreasure() {
        return treasure;
    }

    public Goblin getMonster() {
        return goblin;
    }

    @Override
    public RoomController getController() {
        return new TreasureRoomController();
    }
}

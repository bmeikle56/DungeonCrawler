

public class MinionRoom extends Room {
    private Minion minion;

    public MinionRoom(Minion min) {
        super(min);
        minion = min;
    }

    @Override
    public String toString() {
        return "Monster " + super.toString();
    }

    public Minion getMonster() {
        return minion;
    }

    @Override
    public RoomController getController() {
        return new MinionRoomController();
    }
}

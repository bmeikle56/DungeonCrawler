

public class EmptyRoom extends Room {

    public EmptyRoom() {
        super(null);
    }

    @Override
    public String toString() {
        return "Empty " + super.toString();
    }

    public Minion getMonster() {
        return null;
    }

    @Override
    public RoomController getController() {
        return new EmptyRoomController();
    }
}

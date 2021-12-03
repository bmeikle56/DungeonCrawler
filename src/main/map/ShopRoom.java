

public class ShopRoom extends Room {
    private Serpent serpent;

    public ShopRoom(Serpent s) {
        super(s);
        serpent = s;
    }

    @Override
    public String toString() {
        return "Shop " + super.toString();
    }

    public Serpent getMonster() {
        return serpent;
    }

    @Override
    public RoomController getController() {
        return new ShopRoomController();
    }
}

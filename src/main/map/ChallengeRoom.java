public class ChallengeRoom extends Room {
    private Barbarian b1;
    private Barbarian b2;
    private Barbarian b3;

    public ChallengeRoom(Barbarian b1, Barbarian b2, Barbarian b3) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
    }

    @Override
    public Monster getMonster() {
        return null;
    }

    public Barbarian getB1() {
        return b1;
    }

    public Barbarian getB2() {
        return b2;
    }

    public Barbarian getB3() {
        return b3;
    }

    @Override
    public String toString() {
        return "Challenge " + super.toString();
    }

    @Override
    public RoomController getController() {
        return new ChallengeRoomController();
    }
}

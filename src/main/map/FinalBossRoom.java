

public class FinalBossRoom extends Room {
    private FinalBoss finalBoss;

    public FinalBossRoom(FinalBoss fb) {
        super(fb);
        finalBoss = fb;
    }

    @Override
    public String toString() {
        return "Final Boss " + super.toString();
    }

    public FinalBoss getMonster() {
        return finalBoss;
    }

    @Override
    public RoomController getController() {
        return new FinalBossRoomController();
    }
}

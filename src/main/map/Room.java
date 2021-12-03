

public abstract class Room {
    private Monster monster;

    public Room() {
        monster = null;
    }

    public Room(Monster mon) {
        monster = mon;
    }

    /**
     * Returns room as a string
     * @return "Room"
     */
    public String toString() {
        return "Room";
    }

    /**
     * Returns monster
     * @return the monster
     */
    public abstract Monster getMonster();

    public abstract RoomController getController();

}

public interface Lootable extends Descriptable {
    boolean isLooted();

    void loot();

    String getName();
}


public class Treasure implements Lootable {
    private final double value;
    private boolean isLooted;
    private String affect;

    public Treasure(double val) {
        value = val;
    }

    @Override
    public boolean isLooted() {
        return isLooted;
    }

    @Override
    public void loot() {
        isLooted = true;
        Player.setCoins(Player.getCoins() + value);
        affect = "You found " + (int) value
                + " coins in the Treasure and you now have " + (int) Player.getCoins() + " coins";
        System.out.println(affect);
    }

    @Override
    public String getName() {
        return "Treasure";
    }

    @Override
    public String toString() {
        return "Treasure";
    }

    @Override
    public String getDescription() {
        return affect;
    }

    public double amount() {
        return value;
    }
}

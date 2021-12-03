public class Weapon implements Tradeable, Lootable {

    private String name;
    private double strength;
    private double price;
    private boolean isLooted;
    private String affect;

    public Weapon(String na) {
        isLooted = false;
        name = na;
        strength = 0;
        if ("Axe".equals(name)) {
            // player begins with
            strength = 0.04;
        } else if ("Sword".equals(name)) {
            // player begins with
            strength = 0.05;
        } else if ("Stick".equals(name)) {
            // player begins with
            strength = 0.02;
        } else if ("Spoon".equals(name)) {
            // found in shop
            strength = 0.06;
            price = 150;
        } else if ("Crossbow".equals(name)) {
            // dropped as loot
            strength = 0.08;
        } else if ("Dagger".equals(name)) {
            // found in shop
            strength = 0.09;
            price = 700;
        } else if ("Mace".equals(name)) {
            // found in shop
            strength = 0.11;
            price = 850;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double ns) {
        strength = ns;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double p) {
        price = p;
    }

    @Override
    public boolean isLooted() {
        return isLooted;
    }

    @Override
    public void loot() {
        isLooted = true;
        Inventory.add(this);
        affect = "You found a " + name;
        System.out.println(affect);
    }

    @Override
    public String getDescription() {
        return affect;
    }
}

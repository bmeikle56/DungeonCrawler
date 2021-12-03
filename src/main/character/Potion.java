
public class Potion implements Lootable, Tradeable {
    private final String hpOrDPS;
    private final String addOrHurt;
    private final double value;
    private String affect;
    private boolean isLooted;
    private double price;
    private String name;

    public Potion(String type1, String type2, double val) {
        hpOrDPS = type1;
        addOrHurt = type2;
        value = val;
        if (hpOrDPS.equals("Health")) {
            name = "Health Potion";
            price = 300;
        } else if (hpOrDPS.equals("Strength")) {
            name = "Strength Potion";
            price = 300;
        }
    }


    @Override
    public boolean isLooted() {
        return isLooted;
    }

    @Override
    public void loot() {
        isLooted = true;
        if (hpOrDPS.equals("Health")) {
            if (addOrHurt.equals("Add")) {
                affect = "You found a Potion that heals you to full health!";
            } else {
                affect = "You found a Potion that hurts you!";
            }
        } else if (hpOrDPS.equals("Strength")) {
            if (addOrHurt.equals("Add")) {
                affect = "You found a Potion that increases your strength by 10%!";
            } else {
                affect = "You found a Potion that weakens you!";
            }
        }
        Inventory.add(this);
        System.out.println(affect);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getType() {
        return hpOrDPS;
    }

    @Override
    public void setPrice(double p) {
        price = p;
    }

    @Override
    public String toString() {
        return hpOrDPS + " Potion";
    }

    @Override
    public String getDescription() {
        return affect;
    }
}

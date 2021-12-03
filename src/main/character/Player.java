import java.math.BigDecimal;
import java.math.RoundingMode;

public class Player {
    private static Weapon weapon;
    private static String difficulty;
    private static String name;
    private static double health;
    private static double coins;
    private static boolean isDead;
    private static double strength;
    private static boolean hasSelectedWeapon;
    private static int selectedWeaponIndex = -1;

    private Player() {

    }

    public static boolean hasSelectedWeapon() {
        return hasSelectedWeapon;
    }

    public static void setSelectedWeaponIndex(int i) {
        selectedWeaponIndex = i;
    }

    public static int selectedWeaponIndex() {
        return selectedWeaponIndex;
    }

    /**
     * Determines whether the user entered a valid or invalid name
     * and if not, returns false
     * @param name the name the user entered
     * @return true if valid name and false if invalid
     */
    public static boolean nameIsValid(String name) {
        if (name.length() == 0) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != (' ')) {
                return true;
            }
        }
        return false;
    }

    /**
     * Accessor method for getting the weapon
     * @return the String value of the weapon
     */
    public static Weapon getWeapon() {
        return weapon;
    }

    /**
     * Setter method for setting the weapon
     * @param w the new weapon for the player
     */
    public static void setWeapon(Weapon w) {
        weapon = w;
        if (w != null) {
            hasSelectedWeapon = true;
            strength = w.getStrength();

        } else {
            hasSelectedWeapon = false;
            strength = 0;
        }
    }

    /**
     * Accessor method for coins
     * @return coins as an int value
     */
    public static double getCoins() {
        return coins;
    }

    /**
     * Accessor method for player difficulty
     * @return difficulty as a String
     */
    public static String getDifficulty() {
        return difficulty;
    }

    /**
     * Accessor method for player name
     * @return name as a String
     */
    public static String getName() {
        return name;
    }

    /**
     * Accessor method for player health
     * @return player health as an int
     */
    public static double getHealth() {
        return health;
    }

    public static void setHealth(double h) {
        health = h;
        if (health <= 0) {
            die();
        } else if (health >= 1) {
            // can't go above 1.0 HP
            health = 1;
        }
    }
    /**
     * Setter method for the coins
     * @param c the new value of the player's coins
     */
    public static void setCoins(double c) {
        coins = c;
    }

    /**
     * Sets the player name
     * @param s new name
     */
    public static void setName(String s) {
        name = s;
    }

    /**
     * Sets difficulty
     * @param s the selected difficulty
     */
    public static void setDifficulty(String s) {
        difficulty = s;
    }

    /**
     * Get strength
     * @return strength
     */
    public static double getStrength() {
        return strength;
    }

    /**
     * Set strength
     * @param s strength
     */
    public static void setStrength(double s) {
        strength = s;
    }

    /**
     * Returns whether play is alive or not
     * @return whether player is alive or not
     */
    public static boolean isDead() {
        return isDead;
    }

    /**
     * Kills player
     */
    public static void die() {
        isDead = true;
    }

    public static void revive() {
        isDead = false;
    }

    /**
     * Attack a monster
     * @param monster a monster
     */
    public static void attack(Monster monster) {
        if (Player.getWeapon() == null) {
            throw new NoWeaponException("You haven't selected a weapon to fight");
        }
        monster.setHealth(monster.getHealth() - getStrength());
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}



public abstract class Monster {
    private static int killed;
    private double health;
    private double strength;
    private boolean isDead;

    public Monster(double h, double s) {
        setHealth(h);
        setStrength(s);
    }

    /**
     * Returns if Monster is dead.
     * @return isDead
     */
    public boolean isDead() {
        return isDead;
    }

    /**
     * Return health
     *
     * @return health
     */
    public double getHealth() {
        return health;
    }

    /**
     * Return strength
     *
     * @return strength
     */
    public double getStrength() {
        return strength;
    }

    /**
     * Return killed
     *
     * @return killed
     */
    public static int getKilled() {
        return killed;
    }

    public static void resetKilled() {
        killed = 0;
    }

    /**
     * Set health
     *
     * @param h new health
     */
    public void setHealth(double h) {
        health = h;
        if (health <= 0) {
            die();
            health = 0;
        }
    }

    /**
     * Monster attacks player
     */
    public void attack() {
        Player.setHealth(Player.getHealth() - getStrength());
        double health = Player.round(Player.getHealth(), 2);
        if (health < 0) {
            health = 0;
        }
        System.out.println("You got attacked! Your health is: "
                + health + "\n");
    }

    /**
     * Monster dies
     */
    public void die() {
        isDead = true;
        killed++;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}

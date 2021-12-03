public class Dungeon {

    private static Room[][] dungeon;
    private static int row;
    private static int col;
    private static int fbrow;
    private static int fbcol;
    private static int shopCounter;
    private static int counter;
    private static String prevButton;
    private static final int MIDDLE_ROW = 6;
    private static final int MIDDLE_COL = 6;
    private static final int MAX_CHALLENGE_ROOMS = 3;
    private static int[][] shopArray = new int[10][2];
    private static int saCount = 0;
    private static int totalCoinsCollected = 0;
    private static int aChallengeRoomRow;
    private static int aChallengeRoomCol;


    public Dungeon() {
        dungeon = new Room[13][13];
    }

    /**
     * Creates a new randomized dungeon
     */
    public void createDungeon() {
        reset();
        row = 6;
        col = 6;
        shopCounter = 0;

        dungeon[MIDDLE_ROW][MIDDLE_COL] = new EmptyRoom();
        setFinalBossRoom();
        addChallengeRooms();

        for (int r = 0; r < 13; r++) {
            for (int c = 0; c < 13; c++) {
                if (dungeon[r][c] == null) {
                    dungeon[r][c] = createRoom();
                    if (dungeon[r][c] instanceof ShopRoom) {
                        shopArray[saCount][0] = r;
                        shopArray[saCount][1] = c;
                        saCount++;
                    }
                }
            }
        }
    }

    private void addChallengeRooms() {
        int count = 0;
        while (count < MAX_CHALLENGE_ROOMS) {
            int row = (int) (Math.random() * 13); // 0-12
            int col = (int) (Math.random() * 13); // 0-12

            if (dungeon[row][col] == null) {
                dungeon[row][col] = new ChallengeRoom(createBarbarian(),
                    createBarbarian(), createBarbarian());
                count++;
                aChallengeRoomRow = row;
                aChallengeRoomCol = col;
            }
        }
    }



    public static int getAChallengeRoomRow() {
        return aChallengeRoomRow;
    }

    public static int getAChallengeRoomCol() {
        return aChallengeRoomCol;
    }

    private Barbarian createBarbarian() {
        double rAddHP = (Math.random() * 0.05); // extra HP
        double rAddDPS = (Math.random() * 0.005); // extra damage
        double health;
        double strength;
        if (diffIs("Easy")) {
            health = .12;
            strength = .05;
        } else if (diffIs("Medium")) {
            health = .14;
            strength = .06;
        } else {
            health = .16;
            strength = .07;
        }
        health += rAddHP;
        strength += rAddDPS;
        return new Barbarian(health, strength);
    }

    /**
     * Creates a final boss room on the outside ring of the 13x13 dungeon
     */
    private void setFinalBossRoom() {
        // puts the final boss on the outside ring of the dungeon somewhere
        int row = (int) (Math.random() * 13);
        int col;
        if (row == 0 || row == 12) {
            // 0-6
            col = (int) (Math.random() * 13);
        } else {
            // 0-1
            col = (int) (Math.random() * 2);
            if (col == 0) {
                col = 12;
            } else {
                col = 0;
            }
        }
        fbrow = row;
        fbcol = col;
        dungeon[row][col] = new FinalBossRoom(createFinalBoss());
    }

    private boolean diffIs(String str) {
        return Player.getDifficulty().equals(str);
    }

    private FinalBoss createFinalBoss() {
        double health;
        double strength;
        if (diffIs("Easy")) {
            health = 1;
            strength = 0.04;
        } else if (diffIs("Medium")) {
            health = 1;
            strength = 0.075;
        } else {
            health = 1;
            strength = 0.1;
        }
        return new FinalBoss(health, strength);
    }

    /**
     * Returns the row of the final boss location in dungeon
     * @return row
     */
    public static int getFbrow() {
        return fbrow;
    }

    /**
     * Returns the col of the final boss location in dungeon
     * @return col
     */
    public static int getFbcol() {
        return fbcol;
    }

    /**
     * Creates a randomized room
     * @return the new room
     */
    private Room createRoom() {
        if (diffIs("Easy")) {
            return generateRoomType(60, 80);
        } else if (diffIs("Medium")) {
            return generateRoomType(50, 70);
        } else {
            return generateRoomType(40, 60);
        }
    }



    /**
     * Fixes a room type
     * @param lower the lower bound
     * @param upper the upper bound
     * @return the room type
     */
    private Room generateRoomType(int lower, int upper) {
        int random = (int) (Math.random() * 100 + 1);
        if (random < lower) {
            return new TreasureRoom(createGoblin(), createLoot());
        } else if (random < upper) {
            shopCounter++;
            if (shopCounter > 10) {
                return new TreasureRoom(createGoblin(), createLoot());
            }
            return new ShopRoom(createSerpent());
        } else {
            return new MinionRoom(createMinion());
        }
    }

    /**
     * Creates Minion based on difficulty, which guards nothing
     * @return a new randomized Minion
     */
    private Minion createMinion() {
        double rAddHP = (Math.random() * 0.05 - 0.025); // extra HP
        double rAddDPS = (Math.random() * 0.005 - 0.0025); // extra damage
        double health;
        double strength;
        if (diffIs("Easy")) {
            health = .12;
            strength = .01;
        } else if (diffIs("Medium")) {
            health = .14;
            strength = .01125;
        } else {
            health = .16;
            strength = .0125;
        }
        health += rAddHP;
        strength += rAddDPS;
        if (strength < 0.006) {
            strength = 0.008;
        }
        return new Minion(health, strength);
    }

    /**
     * Creates new Serpent based on difficulty, which guards Shops
     * @return a new randomized Serpent
     */
    private Serpent createSerpent() {
        double rAddHP = (Math.random() * 0.1 - 0.05); // extra HP
        double rAddDPS = (Math.random() * 0.01 - 0.005); // extra damage
        double health;
        double strength;
        if (diffIs("Easy")) {
            health = .6;
            strength = .004;
        } else if (diffIs("Medium")) {
            health = .65;
            strength = .005;
        } else {
            health = .7;
            strength = .006;
        }
        health += rAddHP;
        strength += rAddDPS;
        if (strength < 0.002) {
            strength = 0.003;
        }
        return new Serpent(health, strength);
    }

    public static int getRowDiff() {
        return row - fbrow;
    }

    public static int getColDiff() {
        return col - fbcol;
    }

    /**
     * Creates new Goblin based on difficulty, which guards Treasure
     * @return a new randomized Goblin
     */
    private Goblin createGoblin() {
        double health;
        double strength;
        double rAddHP = (Math.random() * 0.03 - 0.015); // extra HP
        double rAddDPS = (Math.random() * 0.02 - 0.01); // extra damage
        if (diffIs("Easy")) {
            health = .08;
            strength = .08;
        } else if (diffIs("Medium")) {
            health = .09;
            strength = .09;
        } else {
            health = .1;
            strength = .1;
        }
        health += rAddHP;
        strength += rAddDPS;
        if (strength < 0.06) {
            strength = 0.04;
        }
        return new Goblin(health, strength);
    }

    public Lootable createLoot() {
        Lootable loot;

        int rAddV = (int) (Math.random() * 51); // 0-50 extra coins
        double value;
        double hp = 1.0 - Player.getHealth();
        double dps = 0.1 * Player.getStrength();

        if (diffIs("Easy")) {
            value = 250;
        } else if (diffIs("Medium")) {
            value = 200;
        } else {
            value = 150;
        }

        value += rAddV;

        // determine loot: potion or treasure
        int rLoot = (int) (Math.random() * 21); // 0-20
        if (rLoot < 7) {
            loot = new Treasure(value);
        } else if (rLoot < 20) {
            int ran = (int) (Math.random() * 4); // 0-3
            if (ran == 0 || ran == 1 || ran == 2) {
                ran = (int) (Math.random() * 4); // 0-3
                if (ran == 1) {
                    if (diffIs("Hard")) {
                        loot = new Potion("Health", "Damage", hp * 0.15);
                    } else {
                        loot = new Potion("Health", "Add", hp);
                    }
                } else {
                    loot = new Potion("Health", "Add", hp);
                }
            } else {
                ran = (int) (Math.random() * 4); // 0-3
                if (ran == 2) {
                    if (diffIs("Hard")) {
                        loot = new Potion("Strength", "Damage", dps * 0.15);
                    } else {
                        loot = new Potion("Strength", "Add", dps);
                    }
                } else {
                    loot = new Potion("Strength", "Add", dps);
                }
            }
        } else {
            loot = new Weapon("Crossbow");
        }
        return loot;
    }

    /**
     * Returns the current room the player is at
     * @return the room
     */
    public static Room getRoom() {
        return dungeon[row][col];
    }

    /**
     * Returns the dungeon
     * @return the dungeon
     */
    public static Room[][] getDungeon() {
        return dungeon;
    }

    /**
     * Returns the row of the player
     * @return row
     */
    public static int getRow() {
        return row;
    }

    /**
     * Returns the col of the player
     * @return col
     */
    public static int getCol() {
        return col;
    }

    /**
     * Sets the row of the player
     * @param r new row
     */
    public static void setRow(int r) {
        row = r;
    }

    /**
     * Sets the col of the player
     * @param c new col
     */
    public static void setCol(int c) {
        col = c;
    }

    /**
     * Returns number of rooms player has visited
     * @return number of rooms
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * Sets the number of rooms the player has visited
     * @param c the incremented number
     */
    public static void setCounter(int c) {
        counter = c;
    }

    /**
     * Returns the dungeon as a string
     * @return the dungeon
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < 13; i++) {
            str += "[ ";
            for (int j = 0; j < 13; j++) {
                if (j == 12) {
                    str += "[" + dungeon[i][j].toString() + "]";
                } else {
                    str += "[" + dungeon[i][j].toString() + "], ";
                }
            }
            if (i == 12) {
                str += " ]";
            } else {
                str += " ]" + "\n";
            }
        }
        return str;
    }

    public static String prevButton() {
        // Left, Right, Forward, Back
        return prevButton;
    }

    public static void setPrevButton(String str) {
        prevButton = str;
    }

    public static  int[][] getShopArray() {
        return shopArray;
    }

    public void reset() {
        saCount = 0;
    }

    public static double totalCoinsCollected() {
        return totalCoinsCollected;
    }

    public static void addCoins(double d) {
        totalCoinsCollected += d;
    }

    public static void resetCoins() {
        totalCoinsCollected = 0;
    }
}

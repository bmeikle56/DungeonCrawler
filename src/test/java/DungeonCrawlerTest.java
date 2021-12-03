import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;

public class DungeonCrawlerTest extends ApplicationTest {

    public static final int TIMEOUT = 20000;
    private Object monsterRoom;
    private Object finalBossRoom;

    @Override
    public void start(Stage stage) throws Exception {
        DungeonCrawler controller = new DungeonCrawler();
        controller.start(stage);
    }
    // M2 Tests below
    /*
    @Test
    public void testStart() {
        // Carmichael's Test
        clickOn("Start");
        verifyThat("Name", NodeMatchers.isNotNull());
        verifyThat("Difficulty", NodeMatchers.isNotNull());
        verifyThat("Weapon", NodeMatchers.isNotNull());
    }

    @Test
    public void testPlay() {
        // Carmichael's Test
        clickOn("Start");
        clickOn("#name").write("ItsyaBoi");
        clickOn("#diff").clickOn("#easy");
        clickOn("#weapon").clickOn("#sword");
        clickOn("Play");
        verifyThat("Welcome to Dungeon Crawler! We start our journey in a dark, empty room.",
              NodeMatchers.isNotNull());
    }

    @Test
    public void testPlayerName() {
        // Braeden's Test
        clickOn("Start");

        // test the validity of the names
        assertFalse(ConfigController.nameIsValid("  "));
        assertFalse(ConfigController.nameIsValid(""));
        assertTrue(ConfigController.nameIsValid("br  aeden "));
        assertTrue(ConfigController.nameIsValid("braeden"));
        assertTrue(ConfigController.nameIsValid("  __braeden__  "));
    }

    @Test
    public void testMediumAxe() {
        // Braeden's Test
        clickOn("Start");

        // medium mode --> 150 coins
        clickOn("#name").write("braeden");
        clickOn("#diff").clickOn("Medium");
        clickOn("#weapon").clickOn("Axe");
        clickOn("Play");
        assertEquals(ConfigController.getPlayerCoins(), 150);
        assertEquals(ConfigController.getPlayerWeapon(), "Axe");
    }

    @Test
    //Trinity's Test
    public void testWeaponChoice() {
        // test that checks the user selection of a weapon is saved
        clickOn("Start");
        clickOn("#name").write("pillow");
        clickOn("#diff").clickOn("#easy");
        clickOn("#weapon").clickOn("#sword");
        clickOn("#play");
        assertEquals("Sword", ConfigController.getPlayerWeapon());
    }

    @Test
    //Trinity's Test
    public void testNavi() {
        // test that checks if all 4 direction buttons in initial screen are present
        clickOn("Start");
        clickOn("#name").write("TastyTimes");
        clickOn("#diff").clickOn("#medium");
        clickOn("#weapon").clickOn("#stick");
        clickOn("Play");
        verifyThat("#left", NodeMatchers.isNotNull());
        verifyThat("#back", NodeMatchers.isNotNull());
        verifyThat("#right", NodeMatchers.isNotNull());
        verifyThat("#forward", NodeMatchers.isNotNull());

    }

    @Test
    //Kent test check to see it returns correct name
    public void testCorrectName() {
        //test that it returns correct name
        clickOn("Start");

        clickOn("#name").write("Gunna");
        clickOn("#diff").clickOn("#easy");
        clickOn("#weapon").clickOn("#stick");
        clickOn("#play");
        assertTrue(ConfigController.getPlayerName().equals("Gunna"));
    }

    @Test
    //Kent test alert pops up
    public void testAlerts() {
        clickOn("Start");

        clickOn("#name").write("");
        clickOn("#diff").clickOn("#hard");
        clickOn("#weapon").clickOn("#stick");
        clickOn("#play");
        verifyThat("OK", NodeMatchers.isVisible());
    }

    @Test
    //Tan's test to check if difficulty selection is saved
    public void testDiff() {
        clickOn("Start");
        clickOn("#name").write("bob");
        clickOn("#diff").clickOn("#easy");
        clickOn("#weapon").clickOn("#sword");
        clickOn("#play");
        assertEquals("Easy", ConfigController.getPlayerDifficulty());
    }
    @Test
    //Tan's test to check if the proper amount of money is displayed for easy mode
    public void testEasyMoney() {
        clickOn("Start");
        clickOn("#name").write("bob");
        clickOn("#diff").clickOn("#easy");
        clickOn("#weapon").clickOn("#sword");
        clickOn("#play");
        assertEquals(250, ConfigController.getPlayerCoins());
    }
    */

    // M3 Tests below
    /*
    @Test (timeout = TIMEOUT)
    public void testExitDungeon() {
        // Braeden's test, testing a straight path to the final boss room
        //and clicking win exits properly
        clickOn("Start");
        clickOn("Name").write("braeden");
        clickOn("#diff").clickOn("Medium");
        clickOn("#weapon").clickOn("Axe");
        clickOn("Play");

        int rowDiff = Dungeon.getRow() - Dungeon.getFbrow();
        int colDiff = Dungeon.getCol() - Dungeon.getFbcol();

        System.out.println("rowDiff: " + rowDiff);
        System.out.println("colDiff: " + colDiff);

        while (rowDiff != 0) {
            if (rowDiff > 0) {
                clickOn("Forward");
                rowDiff--;
            } else {
                clickOn("Back");
                rowDiff++;
            }
            System.out.println("rowDiff: " + rowDiff);
        }

        while (colDiff != 0) {
            if (colDiff > 0) {
                clickOn("Left");
                colDiff--;
            } else {
                clickOn("Right");
                colDiff++;
            }
            System.out.println("colDiff: " + colDiff);
        }

        // reached final boss room
        assertTrue(Dungeon.getCounter() >= 6);
        clickOn("Click To Win!");
    }

    /*@Test (timeout = TIMEOUT)
    public void testPreviousRooms() {
        // Braeden's test, this test tests that the rooms are generated and when
        // the player returns to the room it will be the exact same room and not a
        // randomly newly generated room*/
    /*clickOn("Start");
        clickOn("Name").write("braeden");
        clickOn("#diff").clickOn("Hard");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");

        clickOn("#forward");
        Class c = Dungeon.getRoom().getClass();
        clickOn("#forward");
        clickOn("#back");
        assertEquals(Dungeon.getRoom().getClass(), c);

        clickOn("Back");
        clickOn("Back");
        c = Dungeon.getRoom().getClass();
        clickOn("Back");
        clickOn("#forward");
        assertEquals(Dungeon.getRoom().getClass(), c);

        clickOn("Left");
        clickOn("Left");
        c = Dungeon.getRoom().getClass();
        clickOn("Left");
        clickOn("Right");
        assertEquals(Dungeon.getRoom().getClass(), c);

        clickOn("Right");
        clickOn("Right");
        clickOn("Right");
        clickOn("Right");
        c = Dungeon.getRoom().getClass();
        clickOn("Right");
        clickOn("Right");
        clickOn("Right");
        clickOn("Left");
        clickOn("Left");
        clickOn("Left");
        assertEquals(Dungeon.getRoom().getClass(), c);
    }

    // Test to verify that left button disappears once it hits the left edge of the dungeon
    @Test
    public void testLeftButtonVisibility() {
        //Kent Test
        clickOn("Start");
        clickOn("Name").write("kent");
        clickOn("#diff").clickOn("Medium");
        clickOn("#weapon").clickOn("Axe");
        clickOn("Play");


        while (Dungeon.getCol() != 0) {
            clickOn("Left");
        }
        verifyThat("Left", NodeMatchers.isInvisible());
    }

    //Test to verify that room contains all required info from player
    @Test
    public void testRooms() {
        // Kent test
        clickOn("Start");
        clickOn("Name").write("kent");
        clickOn("#diff").clickOn("Medium");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");


        while (Dungeon.getCol() != 0) {
            clickOn("Left");
        }

        assertTrue(Player.getPlayerName().equals("kent"));
        assertEquals("Medium", Player.getPlayerDifficulty());
        assertEquals(150, Player.getPlayerCoins());
        assertEquals("Stick", Player.getPlayerWeapon());

    }
    /*Test to verify that you are actually switching rooms*/
    /*@Test
    public void testRoomSwitch() {
        //Tan's Test
        clickOn("Start");
        clickOn("Name").write("matilda");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");

        while (Dungeon.getRow() != 0) {
            clickOn("#forward");
        }
        Class c = Dungeon.getRoom().getClass();
        assertEquals(Dungeon.getRoom().getClass(), c);
    }
    //Test to verify that health bar is showing in each room
    @Test
    public void testHealth() {
        //Tan's Test
        clickOn("Start");
        clickOn("Name").write("tan");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");

        while (Dungeon.getRow() != 0) {
            clickOn("#forward");
        }
        assertEquals("" +  Room.getPlayerHealth(), ConfigController.getPlayerHealth());
    }
     */
    // Test to verify that right button disappears once it hits the right edge of the dungeon
    /*@Test
    public void testRightButtonVisibility() {
        //Carmichael's Test
        clickOn("Start");
        clickOn("Name").write("Carms");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");


        while (Dungeon.getCol() != 12) {
            clickOn("Right");
        }
        verifyThat("Right", NodeMatchers.isInvisible());
    }

    // Test to verify that forward button disappears once it hits the front edge of the dungeon
    /*@Test
    public void testForwardButtonVisibility() {
        //Carmichael's Test
        clickOn("Start");
        clickOn("Name").write("Carms");
        clickOn("#diff").clickOn("Hard");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");


        while (Dungeon.getRow() != 0) {
            clickOn("#forward");
        }
        verifyThat("#forward", NodeMatchers.isInvisible());
    }
    //Test to make sure that the back button disappears once it hits teh back edge of the dungeon
    /*@Test
    public void testBackButtonVisibility() {
        //Trinity !!
        clickOn("Start");
        clickOn("Name").write("matilda");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");


        while (Dungeon.getRow() != 12) {
            clickOn("#back");
        }
        verifyThat("#back", NodeMatchers.isInvisible());
    }

    //Test to make sure that the traversal of the rooms from start to end is 6 or greater
    /*@Test
    public void testRoomDistance() {
        //Trinity !!
        int count = 0;
        clickOn("Start");
        clickOn("Name").write("bob");
        clickOn("#diff").clickOn("Medium");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");

        int rowDiff = Dungeon.getRow() - Dungeon.getFbrow();
        int colDiff = Dungeon.getCol() - Dungeon.getFbcol();

        while (rowDiff != 0) {
            if (rowDiff > 0) {
                clickOn("#forward");
                count++;
                rowDiff--;
            } else {
                clickOn("#back");
                count++;
                rowDiff++;
            }
        }

        while (colDiff != 0) {
            if (colDiff > 0) {
                clickOn("#left");
                count++;
                colDiff--;
            } else {
                clickOn("#right");
                count++;
                colDiff++;
            }
        }
        assertTrue(count >= 6);

    }*/















    // M4 Tests below

    /*@Test
    public void testPrevRoomButton() {
        //Carmichael
        clickOn("Start");
        clickOn("Name").write("Carms");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");
        clickOn("Right");

        verifyThat("#back", NodeMatchers.isInvisible());
        verifyThat("#forward", NodeMatchers.isInvisible());
        verifyThat("#right", NodeMatchers.isInvisible());
        verifyThat("#left", NodeMatchers.isVisible());

    }

    @Test
    public void testFightButton() {
        //Carmichael
        clickOn("Start");
        clickOn("Name").write("Itsyaboi");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");
        clickOn("Right");

        verifyThat("#back", NodeMatchers.isInvisible());
        verifyThat("#forward", NodeMatchers.isInvisible());
        verifyThat("#right", NodeMatchers.isInvisible());
        verifyThat("#left", NodeMatchers.isVisible());

        double monsHealth = Dungeon.getRoom().getMonster().getHealth();

        while (!Dungeon.getRoom().getMonster().isDead()) {
            if (monsHealth != 0.00) {
                clickOn("Fight");
            }
        }

        verifyThat("#left", NodeMatchers.isVisible());
        verifyThat("#right", NodeMatchers.isVisible());
        verifyThat("#forward", NodeMatchers.isVisible());
        verifyThat("#back", NodeMatchers.isVisible());
    }

    /*
    Test to confirm that monster dies once health dips to 0
     */
    /*@Test
    public void testisDead() {
        //Kent test
        clickOn("Start");
        clickOn("Name").write("kent");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");
        clickOn("Right");

        double health = Dungeon.getRoom().getMonster().getHealth();
        while (!Dungeon.getRoom().getMonster().isDead()) {
            if (health != 0.00) {
                clickOn("Fight");
            }
        }

        assertEquals((int) health, 0);
        assertTrue(Dungeon.getRoom().getMonster().isDead());
    }

    /*
    Test to confirm that monster deals damage to the player
     */
    /*@Test
    public void testmonsterAttacks() {
        //Kent test
        clickOn("Start");
        clickOn("Name").write("kent");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");
        clickOn("Right");

        double health = Dungeon.getRoom().getMonster().getHealth();
        if (health != 0.00) {
            clickOn("Fight");
        }

        assertTrue(Player.getHealth() < 1);
    }

    @Test
    public void testFinalBossDistance() {
        /* Braeden's test: this test makes the Player travel directly
        to the Final Boss and makes sure that they have traveled at least
        6 rooms */

    /*travelToFB();
        clickOn("Exit Game");

        // reached final boss room
        assertTrue(Dungeon.getCounter() >= 6);
    }*/

    // Helper method to avoid duplicate code
    /*private void travelToFB() {
        clickOn("Start");
        clickOn("Name").write("brae");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");

        int rowDiff = Dungeon.getRow() - Dungeon.getFbrow();
        int colDiff = Dungeon.getCol() - Dungeon.getFbcol();

        while (rowDiff != 0) {
            if (rowDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Forward");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom().getController() instanceof TreasureRoomController) {
                    clickOn("Collect");
                }
                rowDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Back");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom().getController() instanceof TreasureRoomController) {
                    clickOn("Collect");
                }
                rowDiff++;
            }
        }

        while (colDiff != 0) {
            if (colDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Left");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom().getController() instanceof TreasureRoomController) {
                    clickOn("Collect");
                }
                colDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Right");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom().getController() instanceof TreasureRoomController) {
                    clickOn("Collect");
                }
                colDiff++;
            }
        }
    }

    //@Test
    //public void testRestart() {
        /* Braeden's test: this test takes the Player to Final Boss room
        and Restarts the game, reentering different name/weapon/difficulty and
        playing again */

    /*travelToFB();
        clickOn("Restart Game");

        clickOn("Name").write("v2");
        clickOn("#diff").clickOn("Medium");
        clickOn("#weapon").clickOn("Axe");
        clickOn("Play");

        assertEquals(Player.getHealth(), 0.95);
        assertEquals(Player.getCoins(), 225);
        assertEquals(Player.getDifficulty(), "Medium");
        assertEquals(Player.getName(), "v2");
    }

    /*
    Test that checks that leaving a room after using it does not make the dungeon
    re-initialize it (ie a killed monster and looted treasure stay that way)
    */
    /*@Test
    public void testPlayerDeath() {
        //Trin  @___@
        gameNoCollect();
        System.out.println(Player.getHealth());
        assertTrue(0 >= Player.getHealth());
        assertTrue(Player.isDead());
        verifyThat("#exit", NodeMatchers.isVisible());
        verifyThat("#restart", NodeMatchers.isVisible());
        verifyThat("#lost", NodeMatchers.isVisible());
    }

    /*
    Test checking that leaving a room after using it and then coming back
    does not make the dungeon re-initialize it
    (ie a killed monster and looted treasure stay that way)
    */
    /*@Test
    public void testRoomChanges() {
        //Trin test
        clickOn("Start");
        clickOn("Name").write("R2D2");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");
        clickOn("Right");
        Player.setHealth(1.0);
        Monster a  = Dungeon.getRoom().getMonster();
        Room b = Dungeon.getRoom();
        while (!a.isDead()) {
            clickOn("Fight");
        }
        assertTrue(a.isDead());
        if (b.getController() instanceof TreasureRoomController) {
            clickOn("Collect");
            clickOn("Right");
            clickOn("Left");
            assertEquals(b, Dungeon.getRoom());
            assertEquals(a, Dungeon.getRoom().getMonster());
            assertTrue(Dungeon.getRoom().getMonster().isDead());
            if (Dungeon.getRoom().getController() instanceof TreasureRoomController) {
                verifyThat("#collect", NodeMatchers.isInvisible());
            }
        }
    }

    private void gameNoCollect() {
        //helper method that also traverses the dungeon but without collecting anything
        // is on hard mode, so goo if you wanna die asap.
        clickOn("Start");
        clickOn("Name").write("fodder");
        clickOn("#diff").clickOn("Hard");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");

        int rowDiff = Dungeon.getRow() - Dungeon.getFbrow();
        int colDiff = Dungeon.getCol() - Dungeon.getFbcol();

        while (rowDiff != 0) {
            if (rowDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                clickOn("#forward");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                rowDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Back");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                rowDiff++;
            }
        }

        while (colDiff != 0) {
            if (colDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Left");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                colDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Right");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                colDiff++;
            }
        }
    }*/






















    // M5 Tests below







    // make sure Player has visited a TreasureRoom
    /*private boolean collectedTreasure;

    @Test
    public void testInventoryAfterAddedLoot() {
        // Braeden's test to test inventory when collecting treasure

        clickOn("Start");
        clickOn("Name").write("brae");
        clickOn("#diff").clickOn("Medium");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");

        assertFalse(Inventory.isEmpty());

        ArrayList<Lootable> arl = new ArrayList<>();
        arl.add(new Weapon("Sword"));
        assertEquals(Inventory.getItems().get(0).getName(), "Sword");
        assertNull(Player.getWeapon());
        assertEquals(Inventory.getItems().size(), arl.size());

        clickOn("#sword1");

        clickOn("Right");
        move("#forward");
        move("Right");
        move("Back");
        move("Back");
        move("Back");
        move("Left");
        move("Left");
        move("Left");
        move("#forward");
        move("Right");

        // Player will die eventually before getting through all rooms

        assertTrue(Inventory.getItems().size() > 0
                || Player.getCoins() > 225);
        clickOn("Restart Game");
        assertTrue(Inventory.getItems().size() == 0);
    }

    private void move(String dir) {
        if (!Player.isDead()) {
            while (!Dungeon.getRoom().getMonster().isDead()) {
                clickOn("Fight");
            }
            if (!Player.isDead()) {
                if (Dungeon.getRoom() instanceof TreasureRoom) {
                    clickOn("Collect");
                    collectedTreasure = true;
                }
                clickOn(dir);
            }
        }
    }

    private double health;
    private boolean collectedHeal = false;

    public double getHealth() {
        return health;
    }

    public void setHealth(double d) {
        health = d;
    }

    public boolean getCH() {
        return collectedHeal;
    }

    public void setCH(boolean b) {
        collectedHeal = b;
    }

    @Test
    public void testCollectPotion() {
        // Braeden's test to test collecting a heal Potion, which restores full health

        clickOn("Start");
        clickOn("Name").write("brae");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");

        clickOn("#sword1");


        clickOn("Right");
        moveCollectPotion("#forward");
        moveCollectPotion("Right");
        moveCollectPotion("Back");
        moveCollectPotion("Back");
        moveCollectPotion("Back");
        moveCollectPotion("Left");
        moveCollectPotion("Left");
        moveCollectPotion("Left");
        moveCollectPotion("#forward");
        moveCollectPotion("Right");

        assertTrue(Player.getHealth() == 1);
        assertTrue(Player.getHealth() > getHealth());
    }

*/

    /*

    private double strength = Player.getStrength();
    private boolean collectedStrength = false;

    public double getStrength() {
        return strength;
    }


    public boolean getCS() {
        return collectedStrength;
    }

    public void setCS(boolean a) {
        collectedHeal = a;
    }

    @Test
    public void testStrengthPotion() {
        //Carmichael's Test
        clickOn("Start");
        clickOn("Name").write("Yaboi");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");

        clickOn("#sword1");
        clickOn("Back");
        moveCollectStrength("Back");
        moveCollectStrength("Back");
        moveCollectStrength("Back");
        moveCollectStrength("Back");
        moveCollectStrength("Left");

        assertTrue(getStrength() < Player.getStrength());
    }

    private void moveCollectStrength(String button) {
        if (!getCS() && !Player.isDead()) {
            while (!Dungeon.getRoom().getMonster().isDead()) {
                clickOn("Fight");
            }
            if (!Player.isDead()) {
                if (Dungeon.getRoom() instanceof TreasureRoom) {
                    clickOn("Collect");
                    Lootable l = ((TreasureRoom) Dungeon.getRoom()).getTreasure();
                    if (l instanceof Potion) {
                        if (((Potion) l).getType().equals("Strength")) {
                            clickOn("#strength2");
                        }
                        setCS(true);
                        return;
                    }
                }
                clickOn(button);
            }
        }
    }


    @Test
    public void testWeaponSelect() {
        //Carmichael's Test
        clickOn("Start");
        clickOn("Name").write("Naruto");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");

        assertTrue(Player.getStrength() == 0);
        clickOn("#sword1");
        assertTrue(Player.getStrength() > 0);
    }

    /*
    Test to confirm a successful inventory switch on a player death
     */
    /*@Test
    public void testCorrectWeapon() {
        //Kent Test
        clickOn("Start");
        clickOn("Name").write("Kent");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Axe");
        clickOn("Play");

        assertTrue(Player.getStrength() == 0);
        clickOn("#axe1");
        assertTrue(Player.getStrength() > 0);
        clickOn("#forward");
        while (!Dungeon.getRoom().getMonster().isDead()) {
            clickOn("Fight");
        }

        Player.setHealth(0.00);
        clickOn("#forward");
        clickOn("Fight");
        clickOn("Restart Game");
        clickOn("Name").write("Kent");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");


        clickOn("#sword1");
        assertTrue(Player.getStrength() == 0);
        clickOn("#sword1");
        assertTrue(Player.getStrength() > 0);
    }

    /*
    Test to assure axe has a specific strength once the game is started
     */
    /*@Test
    public void testAxeStrength() {
        //Kent test
        clickOn("Start");
        clickOn("Name").write("Kent");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Axe");
        clickOn("Play");
        clickOn("#axe1");
        assertEquals(Player.getWeapon().getStrength(), .05);

    }

    /*
     Test to check the strength of stick
     */
    /*@Test
    //trin
    public void testStickStrength() {
        clickOn("Start");
        clickOn("Name").write("Cthulu");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");
        clickOn("#stick1");
        assertEquals(0.03, Player.getWeapon().getStrength());

    }

    /*
    Test to check inventory works when buying things from shop
    */
    /*@Test
    //trin trin
    public void testInventoryWithShop() {
        travelToShop();
        double ogHealth = Player.getHealth();
        assertEquals("Axe", Inventory.getItems().get(0).getName());
        assertEquals(1, Inventory.getItems().size());
        clickOn("#trade");
        clickOn("#weapons").clickOn("Spoon");
        if (Player.getCoins() < 300.00) {
            Player.setCoins(300.00);
        }
        clickOn("#potions").clickOn("Heal");
        clickOn("Purchase");
        clickOn("Exit");
        assertEquals(3, Inventory.getItems().size());
        assertEquals("Health Potion", Inventory.getItems().get(1).getName());
        assertEquals("Spoon", Inventory.getItems().get(2).getName());
        clickOn("#heal2");
        assertTrue(Player.getHealth() > ogHealth);
        assertEquals(2, Inventory.getItems().size());
    }



    private void travelToShop() {
        clickOn("Start");
        clickOn("Name").write("pog");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Axe");
        clickOn("Play");
        clickOn("#axe1");

        int rowDiff = Dungeon.getRow() - Dungeon.getShopArray()[0][0];
        int colDiff = Dungeon.getCol() - Dungeon.getShopArray()[0][1];

        while (rowDiff != 0) {
            if (rowDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                clickOn("#forward");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom() instanceof ShopRoom) {
                    return;
                }
                rowDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Back");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom() instanceof ShopRoom) {
                    return;
                }
                rowDiff++;
            }
        }

        while (colDiff != 0) {
            if (colDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Left");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom() instanceof ShopRoom) {
                    return;
                }
                colDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                clickOn("Right");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom() instanceof ShopRoom) {
                    return;
                }
                colDiff++;
            }
        }
    }


     */


















    // M6












    private void moveCollectPotion(String dir) {
        int index = 2;

        if (!Player.isDead()) {
            while (!Dungeon.getRoom().getMonster().isDead()) {
                clickOn("Fight");
            }
            if (!Player.isDead()) {
                Player.setStrength(10000);
                if (Dungeon.getRoom() instanceof TreasureRoom) {
                    clickOn("Collect");
                    Lootable l = ((TreasureRoom) Dungeon.getRoom()).getTreasure();
                    if (l instanceof Potion) {
                        if (((Potion) l).getType().equals("Health")) {
                            switch (index) {
                            case 2: clickOn("#heal2");
                            break;
                            case 3: clickOn("#heal3");
                            break;
                            case 4: clickOn("#heal4");
                            break;
                            case 5: clickOn("#heal5");
                            break;
                            default: break;
                            }
                        } else {
                            switch (index) {
                            case 2: clickOn("#strength2");
                            break;
                            case 3: clickOn("#strength3");
                            break;
                            case 4: clickOn("#strength4");
                            break;
                            case 5: clickOn("#strength5");
                            break;
                            default: break;
                            }
                        }
                    } else if (l instanceof Weapon) {
                        index++;
                    }
                } else if (Dungeon.getRoom() instanceof ChallengeRoom) {
                    return;
                }
                clickOn(dir);
            }
        }
    }


    @Test (timeout = TIMEOUT)
    public void testChallengeRoomSetup() {
        // Braeden's test to verify that challenge rooms are working when entered

        clickOn("Start");
        clickOn("Name").write("brae");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");

        clickOn("#sword1");


        clickOn("Right");

        System.out.println("ROW: " + Dungeon.getAChallengeRoomRow());
        System.out.println("COL: " + Dungeon.getAChallengeRoomCol());

        int rowDiff = Dungeon.getRow() - Dungeon.getAChallengeRoomRow();
        int colDiff = Dungeon.getCol() - Dungeon.getAChallengeRoomCol();

        while (rowDiff != 0) {
            if (rowDiff < 0) {
                moveCollectPotion("#forward");
            } else if (rowDiff > 0) {
                moveCollectPotion("Back");
            }
        }

        while (colDiff != 0) {
            if (colDiff < 0) {
                moveCollectPotion("Right");
            } else if (colDiff > 0) {
                moveCollectPotion("Left");
            }
        }

        verifyThat("barb1", NodeMatchers.isInvisible());
        verifyThat("barb2", NodeMatchers.isInvisible());
        verifyThat("barb3", NodeMatchers.isInvisible());
        verifyThat("fight1", NodeMatchers.isInvisible());
        verifyThat("fight2", NodeMatchers.isInvisible());
        verifyThat("fight3", NodeMatchers.isInvisible());

        clickOn("Challenge");

        assertFalse(((ChallengeRoom) Dungeon.getRoom()).getB1().isDead());
        assertFalse(((ChallengeRoom) Dungeon.getRoom()).getB2().isDead());
        assertFalse(((ChallengeRoom) Dungeon.getRoom()).getB3().isDead());
    }

    @Test
    public void testChallengeRoomLootSystem() {
        // Braeden's test to make sure that when monsters
        // are fought and killed they drop a huge loot reward

        testChallengeRoomSetup();

        clickOn("#fight1");
        clickOn("#fight2");
        clickOn("#fight3");

        assertTrue(((ChallengeRoom) Dungeon.getRoom()).getB1().isDead());
        assertTrue(((ChallengeRoom) Dungeon.getRoom()).getB2().isDead());
        assertTrue(((ChallengeRoom) Dungeon.getRoom()).getB3().isDead());

        assertTrue(Inventory.contains(new Weapon("Mace")));
        assertTrue(Inventory.contains(new Potion("Health", "Add", 1.0 - Player.getHealth())));
    }

    @Test
    public void testRoomsDiscoveredDataWinScreen() {
        //Carmichael's Test
        travelToFB();
        verifyThat("#roomsDiscovered", NodeMatchers.isNotNull());

    }

    @Test
    public void testTotalKilledDataWinScreen() {
        //Carmichael's Test
        travelToFB();
        verifyThat("#totalKilled", NodeMatchers.isNotNull());
    }
    //Helper method to get to final boss and kill it
    private void travelToFB() {
        clickOn("Start");
        clickOn("Name").write("YaBoi");
        clickOn("#diff").clickOn("Easy");
        clickOn("#weapon").clickOn("Sword");
        clickOn("Play");
        clickOn("#sword1");

        int index = 2;
        int rowDiff = Dungeon.getRow() - Dungeon.getFbrow();
        int colDiff = Dungeon.getCol() - Dungeon.getFbcol();

        while (rowDiff != 0) {
            if (rowDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                if (Dungeon.getRoom().getController() instanceof FinalBossRoomController) {
                    return;
                }
                clickOn("#forward");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom().getController() instanceof TreasureRoomController) {
                    clickOn("Collect");
                    healthPotion(index, colDiff);
                }
                rowDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                if (Dungeon.getRoom().getController() instanceof FinalBossRoomController) {
                    return;
                }
                clickOn("Back");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom().getController() instanceof TreasureRoomController) {
                    clickOn("Collect");
                    healthPotion(index, colDiff);
                }
                rowDiff++;
            }
        }
        while (colDiff != 0) {
            if (colDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                if (Dungeon.getRoom().getController() instanceof FinalBossRoomController) {
                    return;
                }
                clickOn("Left");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom().getController() instanceof TreasureRoomController) {
                    clickOn("Collect");
                    healthPotion(index, colDiff);
                }
                colDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                if (Dungeon.getRoom().getController() instanceof FinalBossRoomController) {
                    return;
                }
                clickOn("Right");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                if (Dungeon.getRoom().getController() instanceof TreasureRoomController) {
                    clickOn("Collect");
                    healthPotion(index, colDiff);
                }
            }
        }
    }

    //Helper method to drink potions when received
    private void healthPotion(int index, int colDiff) {
        Lootable l = ((TreasureRoom) Dungeon.getRoom()).getTreasure();
        if (l instanceof Potion) {
            if (((Potion) l).getType().equals("Health")) {
                switch (index) {
                    case 2:
                        clickOn("#heal2");
                        break;
                    case 3:
                        clickOn("#heal3");
                        break;
                    case 4:
                        clickOn("#heal4");
                        break;
                    case 5:
                        clickOn("#heal5");
                        break;
                    default:
                        break;
                }
            } else {
                switch (index) {
                    case 2: clickOn("#strength2");
                        break;
                    case 3: clickOn("#strength3");
                        break;
                    case 4: clickOn("#strength4");
                        break;
                    case 5: clickOn("#strength5");
                        break;
                    default: break;
                }
            }
            colDiff++;
        } else if (l instanceof Weapon) {
            index++;
        }
    }


    @Test
    //trin test
    public void testMonstersKilled() {

    }

    @Test
    public void exitAfterEndGame() {

    }

    /*
    A test method in order to verify lose stats has totalKilled stats
     */
    @Test
    public void testLoseStatsTotalKilled() {
        //kent test
       die();
       verifyThat("#totalKilled", NodeMatchers.isNotNull());
    }

    /*
    Test to verify that rooms discovered null stat will not be null
     */
    @Test
    public void testLoseStatsRoomsDiscovered() {
        //kent test
        die();
        verifyThat("#roomsDiscovered", NodeMatchers.isNotNull());
    }

    //Helper method to continue until death
    private void die() {
        clickOn("Start");
        clickOn("Name").write("YaBoi");
        clickOn("#diff").clickOn("Hard");
        clickOn("#weapon").clickOn("Stick");
        clickOn("Play");
        clickOn("#stick1");

        int index = 2;
        int rowDiff = Dungeon.getRow() - Dungeon.getFbrow();
        int colDiff = Dungeon.getCol() - Dungeon.getFbcol();

        while (rowDiff != 0) {
            if (rowDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                if (Dungeon.getRoom().getController() instanceof FinalBossRoomController) {
                    return;
                }
                clickOn("#forward");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                rowDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                if (Dungeon.getRoom().getController() instanceof FinalBossRoomController) {
                    return;
                }
                clickOn("Back");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                rowDiff++;
            }
        }
        while (colDiff != 0) {
            if (colDiff > 0) {
                if (Player.isDead()) {
                    return;
                }
                if (Dungeon.getRoom().getController() instanceof FinalBossRoomController) {
                    return;
                }
                clickOn("Left");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
                colDiff--;
            } else {
                if (Player.isDead()) {
                    return;
                }
                if (Dungeon.getRoom().getController() instanceof FinalBossRoomController) {
                    return;
                }
                clickOn("Right");
                while (!Dungeon.getRoom().getMonster().isDead()) {
                    if (Player.isDead()) {
                        return;
                    }
                    clickOn("Fight");
                }
            }
        }
    }

}

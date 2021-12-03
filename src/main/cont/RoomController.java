
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public abstract class RoomController {

    /**
     * Activated when the user clicks left
     * @param mouseEvent the event
     * @throws IOException if there is an issue
     */
    public void clickLeft(MouseEvent mouseEvent) throws IOException {
        Dungeon.setPrevButton("Left");
        loadRoom(mouseEvent);
    }

    /**
     * Activated when the user clicks right
     * @param mouseEvent the event
     * @throws IOException if there is an issue
     */
    public void clickRight(MouseEvent mouseEvent) throws IOException {
        Dungeon.setPrevButton("Right");
        loadRoom(mouseEvent);
    }

    /**
     * Activated when the user clicks forward
     * @param mouseEvent the event
     * @throws IOException if there is an issue
     */
    public void clickForward(MouseEvent mouseEvent) throws IOException {
        Dungeon.setPrevButton("Forward");
        loadRoom(mouseEvent);
    }

    /**
     * Activated when the user clicks back
     * @param mouseEvent the event
     * @throws IOException if there is an issue
     */
    public void clickBack(MouseEvent mouseEvent) throws IOException {
        Dungeon.setPrevButton("Back");
        loadRoom(mouseEvent);
    }

    public void clickShopExit(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShopRoom.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        RoomController room = loader.getController();
        display(room);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    /**
     * Loads the proper room in the dungeon
     * @param mouseEvent the event
     * @throws IOException if there is an exception
     */
    private void loadRoom(MouseEvent mouseEvent) throws IOException {
        int row = Dungeon.getRow();
        int col = Dungeon.getCol();
        Room[][] dungeon = Dungeon.getDungeon();

        FXMLLoader loader;
        Stage window;
        Parent parent;

        if (dungeon[row][col] instanceof TreasureRoom) {
            loader = new FXMLLoader(getClass().getResource("TreasureRoom.fxml"));
        } else if (dungeon[row][col] instanceof ShopRoom) {
            loader = new FXMLLoader(getClass().getResource("ShopRoom.fxml"));
        } else if (dungeon[row][col] instanceof MinionRoom) {
            loader = new FXMLLoader(getClass().getResource("MinionRoom.fxml"));
        } else if (dungeon[row][col] instanceof EmptyRoom) {
            loader = new FXMLLoader(getClass().getResource("EmptyRoom.fxml"));
        } else if (dungeon[row][col] instanceof ChallengeRoom) {
            loader = new FXMLLoader(getClass().getResource("ChallengeRoom.fxml"));
        } else {
            loader = new FXMLLoader(getClass().getResource("FinalBossRoom.fxml"));
            System.out.println("You reached the final boss! Good luck!");
        }

        parent = loader.load();
        RoomController room = loader.getController();
        display(room);
        window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(parent));
        window.show();

        Dungeon.setCounter(Dungeon.getCounter() + 1);

        System.out.println("Current row: " + Dungeon.getRow());
        System.out.println("Current col: " + Dungeon.getCol() + "\n");
        System.out.println("You have traveled to: " + Dungeon.getCounter() + " rooms\n");
        System.out.println("Health: " + (int) (100 * Player.round(Player.getHealth(), 2)));
        System.out.println("Strength: "
            + (int) (100 * Player.round(Player.getStrength(), 2)));
        System.out.println("Coins: " + Player.getCoins() + "\n");
        System.out.println("Inventory: " + Inventory.print());
    }

    /**
     * Displays proper attributes of the player
     * @param room the room the player is in
     */
    private void display(RoomController room) {
        room.showName(Player.getName());
        room.showStrength(Player.getStrength());
        room.showCoins(Player.getCoins());
        room.showHealthBar(Player.getHealth());
        if (room instanceof TreasureRoomController) {
            ((TreasureRoomController) room).checkLootStatus();
        } else if (room instanceof ShopRoomController) {
            ((ShopRoomController) room).checkTradeStatus();
        } else if (room instanceof ChallengeRoomController) {
            ((ChallengeRoomController) room).hideMonsters();
        }
        room.showInventory();
        room.setProperVis();
        room.fillGray(Player.selectedWeaponIndex());
        room.checkMonsterStatus();
        int c = (int) (Player.round(Player.getHealth(), 2) * 100);
        room.showHealthValue(c);
    }

    protected abstract void setProperVis();
    protected abstract void showInventory();
    protected abstract void checkSelectedWeapon(Weapon w, int i);
    protected abstract void setAllWhite();
    protected abstract void fillGray(int i);

    /**
     * Shows health bar
     * @param playerHealth the player's health
     */
    protected abstract void showHealthBar(double playerHealth);

    /**
     * Shows players coins
     * @param playerCoins the player's coins
     */
    protected abstract void showCoins(double playerCoins);

    protected abstract void showStrength(double strength);

    /**
     * Shows player's name
     * @param playerName the player's name
     */
    protected abstract void showName(String playerName);

    protected abstract void showHealthValue(int health);

    /**
     * Checks the location to make buttons invisible if needed
     */
    protected abstract void checkLocation();

    protected abstract void checkMonsterStatus();
}

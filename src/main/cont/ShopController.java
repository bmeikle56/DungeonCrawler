import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ShopController extends RoomController {

    @FXML
    private TextField name;
    @FXML
    private MenuButton weapons;
    @FXML
    private MenuButton potions;
    @FXML
    private MenuButton knowledge;
    @FXML
    private Label coinAmount;
    @FXML
    private Label strength;
    @FXML
    private Label nameLabel;
    @FXML
    private ProgressBar healthBar;
    @FXML
    private Label healthValue;
    @FXML
    private Label screenPrice;

    private double price = 0.0;
    private Weapon w = null;
    private Knowledge k = null;
    private Potion p = null;

    @FXML
    private Label finalBossLoc;

    public void clickShopExit(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShopRoom.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);

        ShopRoomController room = loader.getController();
        room.showName(Player.getName());
        room.showStrength(Player.getStrength());
        room.showCoins(Player.getCoins());
        room.showHealthBar(Player.getHealth());
        //((ShopRoomController) room).checkTradeStatus();
        room.showInventory();
        room.setProperVis();
        room.fillGray(Player.selectedWeaponIndex());
        room.checkMonsterStatus();
        int c = (int) (Player.round(Player.getHealth(), 2) * 100);
        room.showHealthValue(c);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @Override
    protected void setProperVis() {

    }

    @Override
    protected void showInventory() {

    }

    @Override
    protected void checkSelectedWeapon(Weapon w, int i) {

    }

    @Override
    protected void setAllWhite() {

    }

    @Override
    protected void fillGray(int i) {

    }

    public void clickPurchase(MouseEvent mouseEvent) {
        price += weaponPrice();
        price += potionPrice();
        price += knowledgePrice();

        if (Player.getCoins() < price) {
            throw new CannotAffordException("You cannot afford these items");
        }

        if (p != null && potions.getText().length() != 0) {
            Inventory.add(p);
        }
        if (w != null && weapons.getText().length() != 0) {
            Inventory.add(w);
        }
        if (k != null && knowledge.getText().length() != 0) {
            if (k.getDescription().equals("Collect Treasure")) {
                int ran = (int) (Math.random() * 2); // 0-1
                if (ran == 0) {
                    Inventory.add(new Potion("Health", "Add", 1.0 - Player.getHealth()));
                } else {
                    Inventory.add(new Potion("Strength", "Add", 0.1));
                }
            } else if (k.getDescription().equals("Show Final Boss")) {
                String rows = "";
                if (Dungeon.getRowDiff() < 0) {
                    rows = "" + (Dungeon.getRowDiff() * -1) + " rooms back";
                } else {
                    rows = "" + Dungeon.getRowDiff() + " rooms forward";
                }
                String cols = "";
                if (Dungeon.getColDiff() < 0) {
                    cols = "" + (Dungeon.getColDiff() * -1) + " rooms right";
                } else {
                    cols = "" + Dungeon.getColDiff() + " rooms left";
                }
                finalBossLoc.setText("Travel "
                    + rows + " and " + cols + " to reach the Final Boss!");
            }
        }

        Player.setCoins(Player.getCoins() - price);
        showCoins(Player.getCoins());

        System.out.println("Inventory: " + Inventory.print());
    }

    @Override
    public void showHealthBar(double health) {
        healthBar.setProgress(health);
    }

    @Override
    public void showCoins(double coins) {
        coinAmount.setText("$" + (int) coins);
    }

    @Override
    public void showStrength(double str) {
        strength.setText("" + (int) (Player.round(Player.getStrength(), 2) * 100));
    }

    public void showPrice() {
        screenPrice.setText("" + (int) price);
    }

    @Override
    public void showName(String name) {
        nameLabel.setText(name);
    }

    @Override
    public void showHealthValue(int health) {
        healthValue.setText(String.valueOf(health));
    }

    @Override
    protected void checkLocation() { }

    @Override
    protected void checkMonsterStatus() { }



    public void clickDagger() {
        weapons.setText("Dagger");
        w = new Weapon("Dagger");
        showRunningTotal();
    }
    public void clickMace() {
        weapons.setText("Mace");
        w = new Weapon("Mace");
        showRunningTotal();
    }
    public void clickSpoon() {
        weapons.setText("Spoon");
        w = new Weapon("Spoon");
        showRunningTotal();
    }



    public void clickIncStr() {
        potions.setText("Increase Strength");
        p = new Potion("Strength", "Add", 0.1);
        showRunningTotal();
    }
    public void clickHeal() {
        potions.setText("Heal Health");
        p = new Potion("Heal", "Add", 1);
        showRunningTotal();
    }



    public void clickShowFB() {
        knowledge.setText("Show Final Boss");
        k = new Knowledge("Show Final Boss");
        showRunningTotal();
    }
    public void clickColTr() {
        knowledge.setText("Collect Treasure");
        k = new Knowledge("Collect Treasure");
        showRunningTotal();
    }


    public void clickEmptyWeapon() {
        weapons.setText(null);
        w = null;
        showRunningTotal();
    }
    public void clickEmptyPotion() {
        potions.setText(null);
        p = null;
        showRunningTotal();
    }
    public void clickEmptyKnowledge() {
        knowledge.setText(null);
        k = null;
        showRunningTotal();
    }


    private void showRunningTotal() {
        screenPrice.setText("" + (int) (weaponPrice() + potionPrice() + knowledgePrice()));
    }

    private double knowledgePrice() {
        if (knowledge.getText() != null) {
            Knowledge hidden = new Knowledge(knowledge.getText());
            k = hidden;
            return k.getPrice();
        }
        return 0;
    }

    private double potionPrice() {
        if (potions.getText() != null) {
            String potionDescription = potions.getText();
            String type1 = "";
            String type2 = "";
            double value = 0;
            if (potionDescription.equals("Increase Strength")) {
                type1 = "Strength";
                type2 = "Add";
                value = 0.1 * Player.getStrength();
            } else if (potionDescription.equals("Heal Health")) {
                type1 = "Health";
                type2 = "Add";
                value = 1.0 - Player.getHealth();
            }
            Potion potion = new Potion(type1, type2, value);
            p = potion;
            return p.getPrice();
        }
        return 0;
    }

    private double weaponPrice() {
        if (weapons.getText() != null) {
            Weapon weapon = new Weapon(weapons.getText());
            w = weapon;
            return w.getPrice();
        }
        return 0;
    }
}



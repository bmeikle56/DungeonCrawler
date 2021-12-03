
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

//import java.time.Instant;

public class ConfigController {


    @FXML
    private TextField name;
    @FXML
    private MenuButton diff;
    @FXML
    private MenuButton weapon;


    /**
     * Player clicks the play button the config screen, which checks to make
     * Player clicks the play button the config screen, which checks to make
     * sure they entered a proper name, selected a mode and weapon, and
     * assigns coins
     * The method also pops alerts if the user didn't select a mode or weapon
     * or if they didn't enter a proper name
     * @param mouseEvent the event fired from the mouse click
     * @throws IOException if there is an error with mouseEvent
     */
    public void clickPlay(MouseEvent mouseEvent) throws IOException {
        Player.setName(name.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("InitGame.fxml"));
        Parent parent = loader.load();

        if (Player.nameIsValid(Player.getName())) {
            if (diff.getText().length() != 0 && weapon.getText().length() != 0) {
                initializePlayer();
                loadInit(loader);
                initializeDungeon();

                Scene scene = new Scene(parent);
                Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            } else {
                if (diff.getText().length() == 0) {
                    createAlert("Error", "No Difficulty", "Select a difficulty to begin the game");
                }
                if (weapon.getText().length() == 0) {
                    createAlert("Error", "No Weapon", "Select a weapon to begin the game");
                }
            }
        } else if (!Player.nameIsValid((Player.getName()))) {
            createAlert("Error", "Improper name", "Enter a proper name to begin the game");
        }
    }

    /**
     * Load initial screen
     * @param loader the loader
     */
    private void loadInit(FXMLLoader loader) {
        InitController initController = loader.getController();
        initController.showName(Player.getName());
        initController.showInventory();
        initController.setProperVis();
        initController.fillGray(Player.selectedWeaponIndex());
        initController.showCoins(Player.getCoins());
        initController.showStrength(Player.getStrength());
        initController.showHealthBar(Player.getHealth());
        initController.showHealthValue((int) Player.getHealth());
    }

    /**
     * Initializes player's values
     */
    private void initializePlayer() {
        int coins;
        double health;

        if (diff.getText().equals("Easy")) {
            coins = 250;
            health = 1;
        } else if (diff.getText().equals("Medium")) {
            coins = 225;
            health = 0.95;
        } else {
            coins = 200;
            health = .9;
        }

        Dungeon.addCoins(coins);
        Player.setCoins(coins);
        Player.setHealth(health);
        Weapon w = new Weapon(weapon.getText());
        Inventory.add(w);
        Player.setDifficulty(diff.getText());
    }

    /**
     * Creates and prints the dungeon, prints final boss and player locations
     */
    private void initializeDungeon() {
        Dungeon dungeon = new Dungeon();
        dungeon.createDungeon();
        System.out.println(dungeon.toString());

        System.out.println("FinalBossRoom row: " + Dungeon.getFbrow());
        System.out.println("FinalBossRoom col: " + Dungeon.getFbcol());

        System.out.println("Current row: " + Dungeon.getRow());
        System.out.println("Current col: " + Dungeon.getCol());
        System.out.println("You have traveled to: " + Dungeon.getCounter() + " rooms");
    }

    /**
     * Pops an alert up to the user, as this method is called
     * when an alert needs to be created for some sort of error
     * @param title the title of the alert
     * @param header the header of the alert
     * @param content the content of the alert
     */
    private void createAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Player clicks easy mode
     */
    public void clickEasy() {
        diff.setText("Easy");
    }

    /**
     * Player clicks medium mode
     */
    public void clickMed() {
        diff.setText("Medium");
    }

    /**
     * Player clicks hard mode
     */
    public void clickHard() {
        diff.setText("Hard");
    }

    /**
     * Player clicks sword
     */
    public void clickSword() {
        weapon.setText("Sword");

    }

    /**
     * Player clicks axe
     */
    public void clickAxe() {
        weapon.setText("Axe");
    }

    /**
     * Player clicks stick
     */
    public void clickStick() {
        weapon.setText("Stick");
    }


}

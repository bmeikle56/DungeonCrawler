import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

//import java.time.Duration;

public class WinController {
    @FXML
    private Button restart;
    @FXML
    private Button exit;
    @FXML
    private Label roomsDiscovered;
    @FXML
    private Label totalKilled;
    @FXML
    private Label time;

    /**
     * Player wins
     * @param mouseEvent the event
     * @throws IOException if there is an issue
     */
    public void clickRestart(MouseEvent mouseEvent) throws IOException {
        Player.revive();
        Inventory.clear();
        Dungeon.setCounter(0);
        Monster.resetKilled();
        Dungeon.resetCoins();
        Player.setWeapon(null);
        Player.setSelectedWeaponIndex(-1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Config.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    /**
     * Player wins
     */
    public void clickExit() {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void setStatsStats() {
        roomsDiscovered.setText("Total Rooms visited: " + String.valueOf(Dungeon.getCounter()));
        totalKilled.setText("Total monsters killed: " + Monster.getKilled());
        time.setText("Total coins collected : $" + Dungeon.totalCoinsCollected());
    }


}


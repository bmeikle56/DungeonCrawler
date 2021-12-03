

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class WelcomeController {

    @FXML
    private Button exit;

    /**
     * This method gets called when the player clicks Start, and begins the game,
     * proceeding to the config screen
     * @param mouseEvent the mouse event fired when Start is clicked
     * @throws IOException thrown if the mouse event has an error
     */
    public void clickStart(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Config.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    /**
     * This function gets called when the player clicks Exit and
     * decides to leave the game
     */
    public void clickExit() {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
}
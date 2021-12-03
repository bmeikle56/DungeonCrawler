import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonCrawler extends Application {

    private static final int LENGTH = 800;
    private static final int WIDTH = 800;

    private Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        String path = "images/test.mp3";
        //Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        //MediaPlayer mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        Scene home = new Scene(root, LENGTH, WIDTH);
        stage.setTitle("Dungeon Crawler");
        stage.setScene(home);
        stage.show();
        //mediaPlayer.setAutoPlay(true);
    }
}

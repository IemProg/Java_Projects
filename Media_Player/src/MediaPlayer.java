import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.MalformedURLException;


public class MediaPlayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Player player;
    FileChooser fileChooser;
    public void start(final Stage primaryStage) {
        MenuItem open = new MenuItem("Open");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        file.getItems().add(open);
        menu.getMenus().add(file);
        fileChooser = new FileChooser();

        open.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                player.player.pause();
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null){
                    try {
                        player = new Player(file.toURI().toURL().toExternalForm());
                        Scene scene = new Scene(player, 720, 535, Color.BLACK);
                        primaryStage.setScene(scene);
                    } catch (MalformedURLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        Player player = new Player("file:///Desktop.video.mp4");
        player.setTop(menu);
        Scene scene = new Scene(player, 720, 480, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.alertbox.SimpleAlertBox;

/**
 * In JavaFX:
 * the Frame is called Stage
 * the Content is called Scene
 */
public class Main extends Application {

    private Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        button = new Button("AlertBox");
        button.setOnAction(event -> SimpleAlertBox.display("SampleAlertBox", "WELCOME TO THE MALFORMED BOX!"));

        VBox layout = new VBox(3);
        layout.getChildren().add(button);

        primaryStage.setTitle("Main JavaFX");
        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.box.ConfirmBox;
import sample.box.SimpleAlertBox;
import sample.util.Util;

/**
 * In JavaFX:
 * the Frame is called Stage
 * the Content is called Scene
 */
public class Main extends Application {

    private Button buttonAlert, buttonConfirm;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        buttonAlert = new Button("AlertBox");
        buttonAlert.setOnAction(event -> SimpleAlertBox.display("SampleAlertBox", "WELCOME TO THE MALFORMED BOX!"));

        buttonConfirm = new Button("ConfirmBox");
        buttonConfirm.setOnAction(event -> {
            boolean result = ConfirmBox.display("Title", "Are you sure you want to obliterate your computer?");
            System.out.println(result);
            if (!result)
                Util.closeProgram(primaryStage);
        });

        VBox layout = new VBox(3);
        layout.getChildren().addAll(buttonAlert, buttonConfirm);

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            Util.closeProgram(primaryStage);
        });
        primaryStage.setTitle("Main JavaFX");
        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

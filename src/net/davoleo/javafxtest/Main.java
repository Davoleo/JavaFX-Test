package net.davoleo.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.davoleo.javafxtest.box.ConfirmBox;
import net.davoleo.javafxtest.box.SimpleAlertBox;
import net.davoleo.javafxtest.util.Util;

/**
 * In JavaFX:
 * the Frame is called Stage
 * the Content is called Scene
 */
public class Main extends Application {

    private Button buttonAlert, buttonConfirm;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        buttonAlert = new Button("AlertBox");
        //Example of a lambda expression used as a handler for a specific action to do when a button is clicked
        buttonAlert.setOnAction(event -> SimpleAlertBox.display("SampleAlertBox", "WELCOME TO THE MALFORMED BOX!"));

        buttonConfirm = new Button("ConfirmBox");
        //Example of a multi-line lambda expression
        buttonConfirm.setOnAction(event -> {
            boolean result = ConfirmBox.display("Title", "Are you sure you want to obliterate your computer?");
            System.out.println(result);
            if (!result)
                Util.closeProgram(primaryStage);
        });

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            Util.closeProgram(primaryStage);
        });

        VBox layout = new VBox(3);
        layout.getChildren().addAll(buttonAlert, buttonConfirm);

        primaryStage.setTitle("Main JavaFX");
        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

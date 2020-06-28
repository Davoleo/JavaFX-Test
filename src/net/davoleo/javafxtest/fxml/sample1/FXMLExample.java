package net.davoleo.javafxtest.fxml.sample1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLExample extends Application {

    @Override
    public void start(Stage primaryStage)
    {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (root != null) {
            primaryStage.setTitle("FXML Sample");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }
    }
}

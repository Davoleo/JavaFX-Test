package net.davoleo.javafxtest.fxml.sample2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Sample2 extends Application {

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
            primaryStage.setTitle("FXML Sample Num. 2");
            primaryStage.setScene(new Scene(root, 800, 500));
            primaryStage.show();
        }
    }
}

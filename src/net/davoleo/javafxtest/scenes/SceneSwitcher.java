package net.davoleo.javafxtest.scenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 17/03/2019 / 23:29
 * Class: SceneSwitcher
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class SceneSwitcher extends Application {

    private Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Label label1 = new Label("Welcome the the first scene!");
        Button button1 = new Button("Switch");
        button1.setOnAction(event -> primaryStage.setScene(scene2));

        //Layout 1 - VBox - vertical line
        VBox layout1 = new VBox(3);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);

        //Button 2
        Button button2 = new Button("Switch");
        button2.setOnAction(event -> primaryStage.setScene(scene1));

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene Switcher");
        primaryStage.show();
    }
}

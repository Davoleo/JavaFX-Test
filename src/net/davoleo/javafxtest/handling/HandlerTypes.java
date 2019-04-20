package net.davoleo.javafxtest.handling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 17/03/2019 / 23:24
 * Class: HandlerTypes
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class HandlerTypes extends Application implements EventHandler<ActionEvent> {

    private Button button, button2, button3;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("The Title!");

        //External Handler
        button = new Button("Click me!");
        button.setOnAction(this);

        //Inner Class Handler
        button2 = new Button("Anonymous Inner class");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                JOptionPane.showMessageDialog(null, "u clicked a button handled by an anonymous inner class");
            }
        });

        //Lambda expression handler
        button3 = new Button("Lambda Expression");
        button3.setOnAction(event -> JOptionPane.showMessageDialog(null, "u clicked a button handled by a lambda expression"));

        VBox layout = new VBox(5);
        layout.getChildren().addAll(button, button2, button3);

        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event)
    {
        if (event.getSource() instanceof Button)
            JOptionPane.showMessageDialog(null, "you clicked a button");
    }
}

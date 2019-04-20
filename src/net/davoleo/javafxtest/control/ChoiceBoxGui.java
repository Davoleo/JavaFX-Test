package net.davoleo.javafxtest.control;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.davoleo.javafxtest.box.SimpleAlertBox;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 11/04/2019 / 22:48
 * Class: ChoiceBoxGui
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class ChoiceBoxGui extends Application {

    private Button button;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("ChoiceBox!");

        button = new Button("Click Me!");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        //getItems returns an ObservableList object you can add items to
        choiceBox.getItems().addAll("Apples", "Oranges", "Bananas", "RASPBerries");
        choiceBox.setValue("Apples");

        button.setOnAction(event -> handleChoice(choiceBox));

        /*
            Listen for choiceBox changes
            observable: The list itself; oldValue & newValue
         */
        choiceBox.getSelectionModel().selectedItemProperty().addListener( ((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        }));

        VBox layout = new VBox(6);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layout, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleChoice(ChoiceBox<String> choiceBox)
    {
        String fruit = choiceBox.getValue();
        SimpleAlertBox.display("Favourite Fruit", "Your favourite fruit is " + fruit);
    }
}

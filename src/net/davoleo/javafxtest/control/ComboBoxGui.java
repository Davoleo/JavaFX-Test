package net.davoleo.javafxtest.control;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.davoleo.javafxtest.box.SimpleAlertBox;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 13/04/2019 / 20:36
 * Class: ComboBoxGui
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class ComboBoxGui extends Application {

    private Button button;
    private ComboBox<String> comboBox;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Combobox!");
        button = new Button("Submit");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Angel Beats",
                "Ano Hana",
                "Beatless",
                "Clockwork Planet",
                "Death Note",
                "Island",
                "Kill la Kill",
                "Knight's & Magic",
                "Made in Abyss",
                "My Hero Academia",
                "RErideD (Tokigoe no derrida)",
                "Re:Zero - Starting life in another world",
                "Steins;Gate",
                "That time I got reincarnated as a Slime",
                "Toradora!",
                "Vandread",
                "Violet Evergarden"
                );

        comboBox.setPromptText("Choose your favourite anime!");

        //Overrides setPromptText
        //Allows the user to type their own option
        // comboBox.setEditable(true);

        comboBox.setOnAction(event -> System.out.println(comboBox.getValue()));
        button.setOnAction(event -> displayChoice());

        VBox layout = new VBox(5);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(layout, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayChoice()
    {
        SimpleAlertBox.display("Choice", "You've chosen: " + comboBox.getValue());
    }


}

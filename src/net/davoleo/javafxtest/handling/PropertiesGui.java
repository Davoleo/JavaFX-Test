package net.davoleo.javafxtest.handling;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import net.davoleo.javafxtest.util.Person;

public class PropertiesGui extends Application {

    private Button button;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Properties");

        Person davoleo = new Person();

        davoleo.firstNameProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Name changed to: " + newValue);
            System.out.println("The Property object: " + davoleo.firstNameProperty());
            System.out.println("The String value: " + davoleo.getFirstName());
        });

        button = new Button("Submit");
        button.setOnAction(event -> davoleo.setFirstName("Tempest"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

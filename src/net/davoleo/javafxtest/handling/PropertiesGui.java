package net.davoleo.javafxtest.handling;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.davoleo.javafxtest.util.Person;

public class PropertiesGui extends Application {

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

        Button button = new Button("Submit");
        button.setOnAction(event -> davoleo.setFirstName("Tempest"));

        //-----------------------------------------------------------

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        //Y always depends from x being its value multiplied by 10
        y.bind(x.multiply(10));
        System.out.println(x.getValue() + " --- " + y.getValue());

        x.setValue(9);
        System.out.println(x.getValue() + " --- " + y.getValue());

        //-------------------------------------------------------

        TextField input = new TextField();
        input.setMaxWidth(200);

        Label welcomeLabel = new Label("Welcome to the Apocalypse ");
        Label inputLabel = new Label();
        inputLabel.textProperty().bind(input.textProperty());

        HBox textLayout = new HBox(welcomeLabel, inputLabel);
        textLayout.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, input, textLayout, button);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

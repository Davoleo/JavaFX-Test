package sample.control;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.box.SimpleAlertBox;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 06/04/2019 / 19:41
 * Class: CheckBoxGui
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class CheckBoxGui extends Application {

    private Scene scene;
    private Button button;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("CheckBox");

        //CheckBoxes
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Raspberries");
        CheckBox box3 = new CheckBox("Apples");

        //Button
        button = new Button("Order Now!");
        button.setOnAction(event -> {
            String message = checkCheckBoxes(box1, box2, box3);
            SimpleAlertBox.display("Result", message);
        });

        VBox layout = new VBox(4);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(box1, box2, box3, button);

        scene = new Scene(layout, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    //
    private String checkCheckBoxes(CheckBox... boxes)
    {
        String message = "The selected checkboxes are:\t";

        for (CheckBox box : boxes)
            if (box.isSelected())
                message = message.concat(box.getText() + "\t");

        return message;
    }
}

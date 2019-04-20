package net.davoleo.javafxtest.box;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 17/03/2019 / 23:53
 * Class: SimpleAlertBox
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class SimpleAlertBox {

    public static void display(String title, String message)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        //window.initStyle(StageStyle.UTILITY);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(100);
        window.setResizable(false);

        Label label = new Label(message);
        Button button = new Button("Close");
        button.setOnAction(event -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}

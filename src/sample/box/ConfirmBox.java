package sample.box;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 21/03/2019 / 22:49
 * Class: ConfirmBox
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class ConfirmBox {

    private static boolean answer;

    public static boolean display(String title, String message)
    {
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        Button yesB = new Button("Yes");
        Button noB = new Button("No");

        yesB.setOnAction(event -> {
            answer = true;
            stage.close();
        });

        noB.setOnAction(event -> {
            answer = false;
            stage.close();
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(label, yesB, noB);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();

        return answer;
    }

}

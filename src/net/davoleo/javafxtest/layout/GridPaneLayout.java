package net.davoleo.javafxtest.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import net.davoleo.javafxtest.box.SimpleAlertBox;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 04/04/2019 / 20:27
 * Class: GridPaneLayout
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class GridPaneLayout extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Grid Pane");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //UserName
        Label labelUser = new Label("Username:");
        GridPane.setConstraints(labelUser, 0, 0);
        TextField textboxUser = new TextField("Davoleo");
        GridPane.setConstraints(textboxUser, 1, 0);

        //Password
        Label labelPW = new Label("Password:");
        GridPane.setConstraints(labelPW, 0, 1);
        PasswordField textboxPW = new PasswordField();
        textboxPW.setPromptText("Write your password");
        GridPane.setConstraints(textboxPW, 1, 1);

        //Login button
        Button loginButton = new Button("LOGIN");
        loginButton.setOnAction(e -> SimpleAlertBox.display("Login Program", "Welcome " + textboxUser.getText()));
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(labelPW, labelUser, textboxPW, textboxUser, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

package net.davoleo.javafxtest.control;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.davoleo.javafxtest.box.SimpleAlertBox;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 16/04/2019 / 20:23
 * Class: ListViewGui
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class ListViewGui extends Application {

    private Button button;
    private ListView<String> listView;

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("List View!");
        button = new Button("Click Me");

        listView = new ListView<>();
        listView.getItems().addAll("Iron", "Gold", "Copper", "Silver", "Lead", "Platinum", "Bronze");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(event -> handleClick());

        VBox layout = new VBox(5);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(listView, button);

        Scene scene = new Scene(layout, 500, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleClick()
    {
        String result = "";
        ObservableList<String> materials;
        materials = listView.getSelectionModel().getSelectedItems();
        for (String material: materials)
            result = result + material + "\n";
        SimpleAlertBox.display("title", result);
    }
}

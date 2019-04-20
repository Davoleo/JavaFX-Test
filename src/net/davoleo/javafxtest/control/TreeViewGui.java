package net.davoleo.javafxtest.control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 20/04/2019 / 19:00
 * Class: TreeViewGui
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class TreeViewGui extends Application {

    TreeView<String> tree;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Tree View!");

        TreeItem<String> root, pinguini, eugenio;

        //Root: Container for all the branches
        root = new TreeItem<>("Artists");
        root.setExpanded(true);

        //Pinguini branch
        pinguini = createBranch("Pinguini Tattici Nucleari", root);
        createBranch("Fuori Dall'Hype", pinguini);
        createBranch("Gioventù brucata", pinguini);
        createBranch("Diamo un calcio all'aldilà", pinguini);
        createBranch("Il re è nudo", pinguini);


        //Eugenio branch
        eugenio = createBranch("Eugenio in via di gioia", root);
        createBranch("Natura Viva", eugenio);
        createBranch("Tutti su per terra", eugenio);
        createBranch("Lorenzo Federici", eugenio);

        //Create Tree
        tree = new TreeView<>(root);
        tree.setShowRoot(true);
        tree.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null)
                System.out.println(newValue.getValue());
        }));

        StackPane layout = new StackPane();
        layout.getChildren().add(tree);

        Scene scene = new Scene(layout, 500, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TreeItem<String> createBranch(String albumTitle, TreeItem<String> parent)
    {
        TreeItem<String> item = new TreeItem<>(albumTitle);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}

package net.davoleo.javafxtest.control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 12/05/2019 / 22:55
 * Class: MenuGui
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class MenuGui extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Menus");

        //File Menu
        Menu fileMenu = new Menu("_File");

        //File Menu Items
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(event -> System.out.println("Created a New File"));
        MenuItem openFile = new MenuItem("Open...");
        openFile.setOnAction(event -> System.out.println("Opened a File"));
        MenuItem saveFile = new MenuItem("Save...");
        saveFile.setOnAction(event -> System.out.println("Saved a File"));
        MenuItem settings = new MenuItem("Settings");
        settings.setOnAction(event -> System.out.println("Opened Settings"));
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> primaryStage.close());

        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(openFile);
        fileMenu.getItems().add(saveFile);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(settings);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(exit);

        //Edit Menu
        Menu editMenu = new Menu("_Edit");

        MenuItem undo = new MenuItem("Undo");
        undo.setDisable(true);

        editMenu.getItems().addAll(new MenuItem("Cut"), new MenuItem("Copy"), new MenuItem("Paste"), undo);

        //Help Menu
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(event -> {
            if (showLines.isSelected())
                System.out.println("Line Numbers Enabled");
            else
                System.out.println("Line Numbers Disabled");
        });

        CheckMenuItem autoSave = new CheckMenuItem("AutoSave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        //Mode Menu
        Menu modeMenu = new Menu("_Mode");

        ToggleGroup modes = new ToggleGroup();
        RadioMenuItem designerMode = new RadioMenuItem("Designer Mode");
        RadioMenuItem editorMode = new RadioMenuItem("Editor Mode");
        RadioMenuItem rendererMode = new RadioMenuItem("Renderer Mode");
        RadioMenuItem debugMode = new RadioMenuItem("Debug Mode");

        modes.getToggles().addAll(designerMode, editorMode, rendererMode, debugMode);
        designerMode.setSelected(true);

        modeMenu.getItems().addAll(designerMode, editorMode, rendererMode, debugMode);

        //MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(editMenu);
        menuBar.getMenus().add(modeMenu);
        menuBar.getMenus().add(helpMenu);

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

package net.davoleo.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.davoleo.javafxtest.box.ConfirmBox;
import net.davoleo.javafxtest.box.SimpleAlertBox;
import net.davoleo.javafxtest.control.*;
import net.davoleo.javafxtest.fxml.sample1.FXMLExample;
import net.davoleo.javafxtest.fxml.sample2.Sample2;
import net.davoleo.javafxtest.handling.HandlerTypes;
import net.davoleo.javafxtest.handling.PropertiesGui;
import net.davoleo.javafxtest.layout.EmbeddedLayouts;
import net.davoleo.javafxtest.layout.GridPaneLayout;
import net.davoleo.javafxtest.scenes.SceneSwitcher;
import net.davoleo.javafxtest.util.Util;

import java.net.URL;
import java.util.ResourceBundle;

/*
 * In JavaFX:
 * the Frame is called Stage
 * the Content is called Scene
 */
public class Main extends Application implements Initializable {

    private Stage primaryStage;

    @FXML
    private Button confirmBoxButton, alertBoxButton;
    @FXML
    private Button checkBoxGuiButton, choiceBoxGuiButton, comboBoxGuiButton, listViewGuiButton, menuGuiButton, tableViewGuiButton, treeViewGuiButton;
    @FXML
    private Button handlerTypesButton, propertiesGuiButton;
    @FXML
    private Button embeddedLayoutsButton, gridPaneLayoutButton;
    @FXML
    private Button sceneSwitcherButton;
    @FXML
    private Button fxmlExample1Button, fxmlExample2Button;

    //Windows
    //Controls
    CheckBoxGui checkBoxGui = new CheckBoxGui();
    ChoiceBoxGui choiceBoxGui = new ChoiceBoxGui();
    ComboBoxGui comboBoxGui = new ComboBoxGui();
    ListViewGui listViewGui = new ListViewGui();
    MenuGui menuGui = new MenuGui();
    TableViewGui tableViewGui = new TableViewGui();
    TreeViewGui treeViewGui = new TreeViewGui();
    //Handling
    HandlerTypes handlerTypes = new HandlerTypes();
    PropertiesGui propertiesGui = new PropertiesGui();
    //Layouts
    EmbeddedLayouts embeddedLayouts = new EmbeddedLayouts();
    GridPaneLayout gridPaneLayout = new GridPaneLayout();
    //Scenes
    SceneSwitcher sceneSwitcher = new SceneSwitcher();
    //FXML
    FXMLExample fxmlExample1 = new FXMLExample();
    Sample2 fxmlExample2 = new Sample2();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Main JavaFX");
        primaryStage.setScene(new Scene(root, 800, 275));
        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            Util.closeProgram(primaryStage);
        });
        primaryStage.show();
        this.primaryStage = primaryStage;
    }

    @Override
    public void init() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading main window");

        //Example of a lambda expression used as a handler for a specific action to do when a button is clicked
        alertBoxButton.setOnAction(event -> SimpleAlertBox.display("SampleAlertBox", "WELCOME TO THE MALFORMED BOX!"));

        //Example of a multi-line lambda expression
        confirmBoxButton.setOnAction(event -> {
            boolean result = ConfirmBox.display("Title", "Are you sure you want to obliterate your computer?");
            System.out.println(result);
            // FIXME: 28/06/2020 NPE
            if (!result)
                Util.closeProgram(primaryStage);
        });

        Stage secondaryStage = new Stage();
        secondaryStage.setX(20);
        secondaryStage.setY(20);

        //Controls
        checkBoxGuiButton.setOnAction(event -> checkBoxGui.start(secondaryStage));
        choiceBoxGuiButton.setOnAction(event -> choiceBoxGui.start(secondaryStage));
        comboBoxGuiButton.setOnAction(event -> comboBoxGui.start(secondaryStage));
        listViewGuiButton.setOnAction(event -> listViewGui.start(secondaryStage));
        menuGuiButton.setOnAction(event -> menuGui.start(secondaryStage));
        tableViewGuiButton.setOnAction(event -> tableViewGui.start(secondaryStage));
        treeViewGuiButton.setOnAction(event -> treeViewGui.start(secondaryStage));

        //Handlers
        handlerTypesButton.setOnAction(event -> handlerTypes.start(secondaryStage));
        propertiesGuiButton.setOnAction(event -> propertiesGui.start(secondaryStage));

        //Layouts
        embeddedLayoutsButton.setOnAction(event -> embeddedLayouts.start(secondaryStage));
        gridPaneLayoutButton.setOnAction(event -> gridPaneLayout.start(secondaryStage));

        //Scenes
        sceneSwitcherButton.setOnAction(event -> sceneSwitcher.start(secondaryStage));

        //FXML
        fxmlExample1Button.setOnAction(event -> fxmlExample1.start(secondaryStage));
        fxmlExample2Button.setOnAction(event -> fxmlExample2.start(secondaryStage));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

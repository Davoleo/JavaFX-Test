package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * In JavaFX:
 * the Frame is called Stage
 * the Content is called Scene
 */
public class Main extends Application implements EventHandler<ActionEvent> {

    private Button button, button2, button3;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("The Title!");

        button = new Button("Click me!");
        button.setOnAction(this);

        button2 = new Button("Anonymous Inner class");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                JOptionPane.showMessageDialog(null, "u clicked a button handled by an anonymous inner class");
            }
        });

        button3 = new Button("Lambda Expression");
        button3.setOnAction(event -> JOptionPane.showMessageDialog(null, "u clicked a button handled by a lambda expression"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event)
    {
        if (event.getSource() instanceof Button)
            JOptionPane.showMessageDialog(null, "you clicked a button");

    }

    public static void main(String[] args) {
        launch(args);
    }
}

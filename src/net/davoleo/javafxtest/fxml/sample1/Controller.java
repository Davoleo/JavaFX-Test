package net.davoleo.javafxtest.fxml.sample1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 27/05/2019 / 19:05
 * Class: Controller
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Controller implements Initializable {

    //Either public or annotated with @FXML
    @FXML
    private Button button;

    public void handleButtonClick()
    {
        System.out.println("The click of our Submit button has been handled");
        button.setText("Stop touching me!");
    }

//    Always Called when the programs UI is loaded
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("Loading User Data");
    }
}

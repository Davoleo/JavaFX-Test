package net.davoleo.javafxtest.util;

import javafx.stage.Stage;
import net.davoleo.javafxtest.box.ConfirmBox;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 21/03/2019 / 23:04
 * Class: Util
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Util {

    public static void closeProgram(Stage window)
    {
        boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");

        if (answer)
        {
            System.out.println("Shutting down... \n this code is absolutely not false!");
            window.close();
        }
    }
}

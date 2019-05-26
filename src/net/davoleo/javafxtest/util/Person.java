package net.davoleo.javafxtest.util;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 27/05/2019 / 01:12
 * Class: Person
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Person {

    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Returns the value of firstName
    public String getFirstName()
    {
        return firstName.get();
    }

    //Returns the StringProperty object
    public StringProperty firstNameProperty()
    {
        return firstName;
    }

    //Sets firstName value
    public void setFirstName(String firstName)
    {
        this.firstName.set(firstName);
    }
}

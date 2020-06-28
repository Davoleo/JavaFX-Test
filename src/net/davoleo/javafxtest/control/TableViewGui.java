package net.davoleo.javafxtest.control;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.davoleo.javafxtest.box.SimpleAlertBox;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 20/04/2019 / 19:27
 * Class: TableViewGui
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class TableViewGui extends Application {

    private TableView<Product> productsTable;
    TextField nameIn, priceIn, quantityIn;

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Table View!");


        //Columns: The type of the table, The Type of the field
        //CellValueFactory: Links column to the field of the object of your product
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Input init
        nameIn = new TextField();
        nameIn.setPromptText("Product Name");
        nameIn.setMinWidth(100);
        priceIn = new TextField();
        priceIn.setPromptText("Product Price");
        quantityIn = new TextField();
        quantityIn.setPromptText("Product Quantity");

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addEntry());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> removeEntry());

        HBox controlsBox = new HBox();
        controlsBox.setPadding(new Insets(8));
        controlsBox.setSpacing(8);
        controlsBox.getChildren().addAll(nameIn, priceIn, quantityIn, addButton, deleteButton);

        productsTable = new TableView<>();
        productsTable.setItems(createProductsList());
        productsTable.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        VBox layout = new VBox(5);
        layout.setPadding(new Insets(0));
        layout.getChildren().add(productsTable);
        layout.getChildren().add(controlsBox);

        Scene scene = new Scene(layout, 587, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @return A new sample list with some products
     */
    public ObservableList<Product> createProductsList()
    {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.addAll(
                new Product("Laptop", 859.00, 2),
                new Product("Ball", 2.49, 198   ),
                new Product("Jesus", 99.00, 77),
                new Product("DVD", 19.99, 12),
                new Product("Corn", 1.49, 856)
        );
        return products;
    }

    private void addEntry()
    {
        Product product = new Product();
        boolean isValid = true;

        if (!nameIn.getText().isEmpty())
            product.setName(nameIn.getText());
        else
        {
            SimpleAlertBox.display("Error", "You cannot leave the name field empty");
            isValid = false;
        }

        try {
            product.setPrice(Double.parseDouble(priceIn.getText()));
            product.setQuantity(Integer.parseInt(quantityIn.getText()));
        }
        catch (NumberFormatException e) {
            SimpleAlertBox.display("Error", "The formats of price and/or quantity fields are invalid");
            isValid = false;
        }

        if (isValid)
        {
            productsTable.getItems().add(product);
            nameIn.clear();
            priceIn.clear();
            quantityIn.clear();
        }
    }

    private void removeEntry()
    {
        ObservableList<Product> products, selectedProducts;
        products = productsTable.getItems();
        selectedProducts = productsTable.getSelectionModel().getSelectedItems();

//        for (Product product : productsTable.getItems())
//        {
//            if (product.equals(productsTable.getSelectionModel().getSelectedItem()))
//                productsTable.getItems().remove(product);
//        }

        selectedProducts.forEach(products::removeAll);

    }


    //Product Data type
    public static class Product {

        private String name;
        private double price;
        private int quantity;

        public Product()
        {
            this.name = "";
            this.price = 0;
            this.quantity = 0;
        }

        public Product(String name, double price, int quantity)
        {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName()
        {
            return name;
        }

        public Product setName(String name)
        {
            this.name = name;
            return this;
        }

        public double getPrice()
        {
            return price;
        }

        public Product setPrice(double price)
        {
            this.price = price;
            return this;
        }

        public int getQuantity()
        {
            return quantity;
        }

        public Product setQuantity(int quantity)
        {
            this.quantity = quantity;
            return this;
        }
    }
}
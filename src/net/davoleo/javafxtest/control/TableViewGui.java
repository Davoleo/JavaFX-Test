package net.davoleo.javafxtest.control;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 20/04/2019 / 19:27
 * Class: TableViewGui
 * Project: JavaFX-Test
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class TableViewGui extends Application {

    private TableView<Product> productsTable;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
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

        productsTable = new TableView<>();
        productsTable.setItems(createProductsList());
        productsTable.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        VBox layout = new VBox(5);
        layout.setPadding(new Insets(10));
        layout.getChildren().add(productsTable);

        Scene scene = new Scene(layout, 500, 250);
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
package com.example.ViewPKG;

import com.example.ControlPKG.CustomerControl;
import com.example.ControlPKG.ProductControl;
import com.example.ExceptionsPKG.InvalidDiscountCodeException;
import com.example.ExceptionsPKG.InvalidPurchaseException;
import com.example.ExceptionsPKG.ProductNotFoundException;
import com.example.ModelPKG.ProductModelPKG.CategoryModel;
import com.example.ModelPKG.ProductModelPKG.ProductModel;
import com.example.ModelPKG.UserModelPKG.AdminModel;
import com.example.ModelPKG.UserModelPKG.SessionManagerModel;
import com.example.onlineshopv2.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerMenuController implements Initializable
{
    @FXML
    private Button addFundsButton;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label cartProductAmount;
    @FXML
    private TableView<ProductModel> itemMenu;
    @FXML
    private Button logoutButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button checkoutButton;
    @FXML
    private TextField searchField;
    @FXML
    private Button selectProductButton;
    @FXML
    private Button viewBasketButton;
    @FXML
    private Button viewPersonalInfoButton;
    @FXML
    private Label welcomeTextLabel;
    @FXML
    private TextField discountCodeField;
    @FXML
    void checkout(ActionEvent event)
    {
        String discount = discountCodeField.getText();
        try
        {
            CustomerControl.checkout(SessionManagerModel.getCurrentCustomer() , discount);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Purchase Successfully Done! \nYour Receipt Detail : \n" + SessionManagerModel.getCurrentCustomer().getReceipts().get(SessionManagerModel.getCurrentCustomer().getReceipts().size() - 1));
            alert.showAndWait();
        }
        catch (InvalidPurchaseException | InvalidDiscountCodeException exception)
        {
            SessionManagerModel.getCurrentCustomer().getBasket().clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(exception.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    void selectProduct(ActionEvent event) throws IOException
    {
        SessionManagerModel.setCurrentProduct(itemMenu.getSelectionModel().getSelectedItem());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProductPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void addFund(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddFundPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void logout(ActionEvent event) throws IOException
    {
        SessionManagerModel.setLoggedInAsUser(false);
        SessionManagerModel.setLoggedInAsAdmin(false);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void search(ActionEvent event) throws ProductNotFoundException {
        String searchText = searchField.getText();
        String[] searchTextDetailed = searchText.split(" ");
        switch (searchTextDetailed[0].toLowerCase())
        {
            case "name" :
            {
                ArrayList<ProductModel> foundProducts = ProductControl.searchByName(searchTextDetailed[2]);
                ObservableList<ProductModel> list = FXCollections.observableArrayList(foundProducts);
                itemMenu.setItems(list);
                break;
            }
            case "category" :
            {
                switch (searchTextDetailed[2].toLowerCase())
                {
                    case "digital" :
                    {
                        ArrayList<ProductModel> foundProducts = ProductControl.searchByCategory(CategoryModel.DIGITAL);
                        ObservableList<ProductModel> list = FXCollections.observableArrayList(foundProducts);
                        itemMenu.setItems(list);

                        break;
                    }
                    case "food" :
                    {
                        ArrayList<ProductModel> foundProducts = ProductControl.searchByCategory(CategoryModel.FOOD);
                        ObservableList<ProductModel> list = FXCollections.observableArrayList(foundProducts);
                        itemMenu.setItems(list);
                        break;
                    }
                    case "vehicle" :
                    {
                        ArrayList<ProductModel> foundProducts = ProductControl.searchByCategory(CategoryModel.VEHICLE);;
                        ObservableList<ProductModel> list = FXCollections.observableArrayList(foundProducts);
                        itemMenu.setItems(list);
                        break;
                    }
                    case "stationary" :
                    {
                        ArrayList<ProductModel> foundProducts = ProductControl.searchByCategory(CategoryModel.STATIONARY);
                        ObservableList<ProductModel> list = FXCollections.observableArrayList(foundProducts);
                        itemMenu.setItems(list);
                        break;
                    }
                }
                break;
            }
            case "price" :
            {
                ArrayList<ProductModel> foundProducts = ProductControl.searchBetweenPrices(Integer.parseInt(searchTextDetailed[2]) , Integer.parseInt(searchTextDetailed[3]));
                ObservableList<ProductModel> list = FXCollections.observableArrayList(foundProducts);
                itemMenu.setItems(list);
                break;
            }
            case "availability" :
            {
                ArrayList<ProductModel> foundProducts = ProductControl.searchByAvailability();
                ObservableList<ProductModel> list = FXCollections.observableArrayList(foundProducts);
                itemMenu.setItems(list);
                break;
            }
        }
    }
    @FXML
    void seePersonalInformation(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerCredentialsPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void viewBasket(ActionEvent event) throws IOException
    {
        ObservableList<ProductModel> list = FXCollections.observableArrayList(SessionManagerModel.getCurrentCustomer().getBasket());
        itemMenu.setItems(list);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        balanceLabel.setText(SessionManagerModel.getCurrentCustomer().getCurrentBalance() + "");
        cartProductAmount.setText(SessionManagerModel.getCurrentCustomer().getBasket().size() + "");
        welcomeTextLabel.setText("Welcome " + SessionManagerModel.getCurrentCustomer().getUsername() + " !");
        ObservableList<ProductModel> list = FXCollections.observableArrayList(AdminModel.getAdmin().getAllProducts());
        TableColumn<ProductModel , String> productNameColumn = new TableColumn<>("productName");
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        TableColumn<ProductModel , Integer> productIDColumn = new TableColumn<>("productID");
        productIDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<ProductModel , Integer> productAmountAvailableColumn = new TableColumn<>("amountAvailable");
        productAmountAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("amountAvailable"));
        TableColumn<ProductModel , Integer> productPriceColumn = new TableColumn<>("price");
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        itemMenu.getColumns().addAll(productNameColumn , productPriceColumn , productIDColumn , productAmountAvailableColumn);
        itemMenu.setItems(list);
    }
}
package com.example.ViewPKG;

import com.example.ControlPKG.CustomerControl;
import com.example.ControlPKG.ProductControl;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class ProductPageController implements Initializable
{
    @FXML
    private Label productCategory;
    @FXML
    private Label productDescription;
    @FXML
    private Label productHasBeenBought;
    @FXML
    private Label productID;
    @FXML
    private ImageView productImage;
    @FXML
    private Label productName;
    @FXML
    private Label productPrice;
    @FXML
    private Label productScore;
    @FXML
    private Button backButton;
    @FXML
    private TableView<ProductModel> productTableView;
    @FXML
    private TextArea reviewTextArea;
    @FXML
    void back(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerMenu.fxml "));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void addReviewButton(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ReviewPage.fxml "));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void addScoreButton(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ScorePage.fxml "));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void addToCartButton(ActionEvent event)
    {
        CustomerControl.addToBasket(SessionManagerModel.getCurrentCustomer() , SessionManagerModel.getCurrentProduct());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Product Added Successfully!");
        alert.showAndWait();
    }
    @FXML
    void showProduct(ActionEvent event) throws IOException
    {
        SessionManagerModel.setCurrentProduct(productTableView.getSelectionModel().getSelectedItem());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProductPage.fxml "));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        boolean hasBought = false;
        StringBuilder reviewText = new StringBuilder();
        for (int i = 0 ; i < SessionManagerModel.getCurrentProduct().getReviews().size() ; i++)
        {
            reviewText.append(SessionManagerModel.getCurrentProduct().getReviews().get(i).toString() + "\n");
        }
        reviewTextArea.setText(reviewText.toString());
        TableColumn<ProductModel , String> productNameColumn = new TableColumn<>("productName");
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        TableColumn<ProductModel , Integer> productIDColumn = new TableColumn<>("productID");
        productIDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<ProductModel , Integer> productAmountAvailableColumn = new TableColumn<>("amountAvailable");
        productAmountAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("amountAvailable"));
        TableColumn<ProductModel , Integer> productPriceColumn = new TableColumn<>("price");
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        productTableView.getColumns().addAll(productNameColumn , productPriceColumn);
        if (SessionManagerModel.getCurrentProduct().getCategory() == CategoryModel.DIGITAL)
        {
            try
            {
                ObservableList<ProductModel> list = FXCollections.observableArrayList(ProductControl.searchByCategory(CategoryModel.DIGITAL));
                productTableView.setItems(list);
            }
            catch (ProductNotFoundException e)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("No Product Was Found!");
                alert.showAndWait();
            }
        }
        else if (SessionManagerModel.getCurrentProduct().getCategory() == CategoryModel.FOOD)
        {
            try
            {
                ObservableList<ProductModel> list = FXCollections.observableArrayList(ProductControl.searchByCategory(CategoryModel.FOOD));
                productTableView.setItems(list);
            }
            catch (ProductNotFoundException e)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("No Product Was Found!");
                alert.showAndWait();
            }
        }
        else if (SessionManagerModel.getCurrentProduct().getCategory() == CategoryModel.VEHICLE)
        {
            try
            {
                ObservableList<ProductModel> list = FXCollections.observableArrayList(ProductControl.searchByCategory(CategoryModel.VEHICLE));
                productTableView.setItems(list);
            }
            catch (ProductNotFoundException e)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("No Product Was Found!");
                alert.showAndWait();
            }
        }
        else
        {
            try
            {
                ObservableList<ProductModel> list = FXCollections.observableArrayList(ProductControl.searchByCategory(CategoryModel.STATIONARY));
                productTableView.setItems(list);
            }
            catch (ProductNotFoundException e)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("No Product Was Found!");
                alert.showAndWait();
            }
        }
        productName.setText("Name :" + SessionManagerModel.getCurrentProduct().getProductName());
        productID.setText("ID :" + SessionManagerModel.getCurrentProduct().getProductID() + "");
        productPrice.setText("Price :" + SessionManagerModel.getCurrentProduct().getPrice() + "");
        productScore.setText("Score :" + SessionManagerModel.getCurrentProduct().getAverageScore() + " / 10");
        productCategory.setText("Category :" + SessionManagerModel.getCurrentProduct().getCategory() + "");
        productDescription.setText("Description : \n" + SessionManagerModel.getCurrentProduct().toString());
        productImage.setImage(SessionManagerModel.getCurrentProduct().getProductImage());
        for (int i = 0 ; i < SessionManagerModel.getCurrentCustomer().getReceipts().size() ; i++)
        {
            if (SessionManagerModel.getCurrentCustomer().getReceipts().get(i).getProducts().contains(SessionManagerModel.getCurrentProduct()))
            {
                productHasBeenBought.setText("You Have Bought This Product");
                hasBought = true;
            }
        }
        if (!hasBought)
        {
            productHasBeenBought.setText("You Haven't Bought This Product");
        }
    }
}

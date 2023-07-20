package com.example.ViewPKG;

import com.example.ControlPKG.CustomerControl;
import com.example.ModelPKG.UserModelPKG.SessionManagerModel;
import com.example.onlineshopv2.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ReviewPageController
{
    @FXML
    private Button addReviewButton;
    @FXML
    private Button backButton;
    @FXML
    private TextArea reviewTextArea;
    @FXML
    void back(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProductPage.fxml "));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void addReview(ActionEvent event)
    {
        String reviewText = reviewTextArea.getText();
        CustomerControl.addReview(SessionManagerModel.getCurrentCustomer() , SessionManagerModel.getCurrentProduct() , reviewText);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Review Request Sent Successfully!");
        alert.showAndWait();
    }
}

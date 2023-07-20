package com.example.ViewPKG;

import com.example.ControlPKG.CustomerControl;
import com.example.ExceptionsPKG.InvalidScoreException;
import com.example.ExceptionsPKG.ProductNotBoughtException;
import com.example.ModelPKG.UserModelPKG.SessionManagerModel;
import com.example.onlineshopv2.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;

public class ScorePageController
{
    @FXML
    private Button addScoreButton;
    @FXML
    private Button backButton;
    @FXML
    private Slider scoreSlider;
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
    void addScore(ActionEvent event) throws InvalidScoreException
    {
        int score = (int)scoreSlider.getValue();
        try
        {
            CustomerControl.addScore(SessionManagerModel.getCurrentCustomer() , SessionManagerModel.getCurrentProduct() , score);
        }
        catch (InvalidScoreException exception)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(exception.getMessage());
            alert.showAndWait();
        }
    }
}

package com.example.ViewPKG;

import com.example.ControlPKG.CustomerControl;
import com.example.ExceptionsPKG.InvalidCredentialsException;
import com.example.ModelPKG.UserModelPKG.SessionManagerModel;
import com.example.onlineshopv2.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddFundPageController
{
    @FXML
    private TextField CVV2Field;
    @FXML
    private Button backButton;
    @FXML
    private TextField cardNumberField;
    @FXML
    private TextField cardPasswordField;
    @FXML
    private TextField depositoryField;
    @FXML
    private Label errorField;
    @FXML
    private Button submitAddFundButton;
    @FXML
    void back(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void submitAddFundButton(ActionEvent event) throws InvalidCredentialsException
    {
        String creditCardNumber = cardNumberField.getText();
        String cvv2 = CVV2Field.getText();
        String cardPassword = cardPasswordField.getText();
        int depository = Integer.parseInt(depositoryField.getText());
        try
        {
            CustomerControl.addFunds(SessionManagerModel.getCurrentCustomer() , creditCardNumber , cvv2 , cardPassword , depository);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Add Fund Request Has Been Sent To Admin!");
            alert.showAndWait();
        }
        catch (InvalidCredentialsException invalidCredentialsException)
        {
            errorField.setText(invalidCredentialsException.getMessage());
        }
    }
}

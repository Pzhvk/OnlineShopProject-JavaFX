package com.example.ViewPKG;

import com.example.ControlPKG.CustomerControl;
import com.example.ExceptionsPKG.InvalidEmailException;
import com.example.ExceptionsPKG.InvalidPhoneNumberException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CustomerCredentialsPageController implements Initializable
{
    @FXML
    private Button backButton;
    @FXML
    private TextField emailField;
    @FXML
    private Label errorLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private Button submitCredentialsChangeButton;
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
    void submitCredentialsChange(ActionEvent event)
    {
        String password = passwordField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        try
        {
            if (!Objects.equals(SessionManagerModel.getCurrentCustomer().getPassword(), password))
            {
                CustomerControl.changePassword(password , SessionManagerModel.getCurrentCustomer());
            }
            else if (!Objects.equals(SessionManagerModel.getCurrentCustomer().getEmail(), email))
            {
                CustomerControl.changeEmail(email , SessionManagerModel.getCurrentCustomer());
            }
            else if (!Objects.equals(SessionManagerModel.getCurrentCustomer().getPhoneNumber(), phoneNumber))
            {
                CustomerControl.changePhoneNumber(phoneNumber , SessionManagerModel.getCurrentCustomer());
            }
        }
        catch (InvalidEmailException | InvalidPhoneNumberException exception)
        {
            errorLabel.setText(exception.getMessage());
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resourceBundle)
    {
        emailField.setText(SessionManagerModel.getCurrentCustomer().getEmail());
        passwordField.setText(SessionManagerModel.getCurrentCustomer().getPassword());
        phoneNumberField.setText(SessionManagerModel.getCurrentCustomer().getPhoneNumber());
        usernameLabel.setText(SessionManagerModel.getCurrentCustomer().getUsername());
    }
}
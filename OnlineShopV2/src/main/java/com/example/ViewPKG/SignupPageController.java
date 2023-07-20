package com.example.ViewPKG;

import com.example.ControlPKG.SignupControl;
import com.example.ExceptionsPKG.InvalidCredentialsException;
import com.example.ExceptionsPKG.UserAlreadyExistsException;
import com.example.onlineshopv2.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SignupPageController
{
    @FXML
    private Button backButton;
    @FXML
    private TextField captchaCodeField;
    @FXML
    private Label captchaCodeLabel;
    @FXML
    private TextField emailField;
    @FXML
    private Label errorField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField usernameField;
    @FXML
    void back(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void submit(ActionEvent event) throws InvalidCredentialsException, UserAlreadyExistsException , IOException
    {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        try
        {
            SignupControl.SignUpAsCostumer(username , password , email , phoneNumber);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Signup Request Has Been Sent To Admin!");
            alert.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        catch (InvalidCredentialsException | UserAlreadyExistsException exception)
        {
            errorField.setText(exception.getMessage());
        }
    }
}
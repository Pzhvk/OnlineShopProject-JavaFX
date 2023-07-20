package com.example.ViewPKG;

import com.example.ControlPKG.LoginControl;
import com.example.ExceptionsPKG.ProductEditFailedException;
import com.example.ExceptionsPKG.UserNotFoundException;
import com.example.ModelPKG.UserModelPKG.SessionManagerModel;
import com.example.onlineshopv2.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class LoginPageController
{
    @FXML
    private Button backButton;
    @FXML
    private Label errorField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button submitButton;
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
    void submit(ActionEvent event) throws IOException
    {
        String username = usernameField.getText();
        String password = passwordField.getText();
        try
        {
            LoginControl.signInAsCustomer(username , password);
            if (SessionManagerModel.isLoggedInAsAdmin())
            {
                AdminView.adminMenu();
            }
            else if (SessionManagerModel.isLoggedInAsUser())
            {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerMenu.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }
        }
        catch (UserNotFoundException | ProductEditFailedException exception)
        {
            errorField.setText(exception.getMessage());
        }
    }
}
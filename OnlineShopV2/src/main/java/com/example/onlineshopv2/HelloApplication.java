package com.example.onlineshopv2;

import com.example.ControlPKG.AdminControl;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG.Pencil;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.VehiclePKG.Bicycle;
import com.example.ModelPKG.UserModelPKG.AdminModel;
import com.example.ModelPKG.UserModelPKG.CustomerModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args)
    {
        AdminControl.addFood("Chips" , 2 , 30 , 1401 , 1402);
        AdminControl.addCar("Civic" , 15000 , 5 , "Honda" , 3000 , false);
        AdminControl.addBicycle("BMX" , 350 , 5 , "Satrialle's" , Bicycle.type.CITY);
        AdminControl.addNotebook("Note-Book" , 5 , 30 , "Iran" , 60 , "Normal");
        AdminControl.addPen("Canco" , 1 , 60 , "Canada" , "Blue");
        AdminControl.addPencil("Drawing-Pencil" , 1 , 60 , "Japan" , Pencil.type.HB);
        AdminControl.addFlashMemory("Flash-Memory" , 15 , 20 , "SanDisk" , "3,1,1" , 20 , 64 , 3);
        AdminControl.addPersonalComputer("PC1" , 780 , 1 , "Gigabyte" , "40,60,20" , 2 , "i5-11400" , 16);
        AdminControl.addSolidStateDrive("SSD1" , 150 , 5 , "Samsung" , "10,7,1" , 300 , 512 , 500 , 300);
        AdminControl.addPen("Bic" , 5 , 5 , "Iran" , "Red");
        CustomerModel customer1 = new CustomerModel("user" , "123" , "rick3anchezz@gmail.com" , "9220525987");
        AdminModel.getAdmin().getCustomers().add(customer1);

        launch();
    }
}
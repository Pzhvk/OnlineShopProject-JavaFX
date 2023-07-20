package com.example.ModelPKG.ProductModelPKG.ProductsPKG.VehiclePKG;

import javafx.scene.image.Image;

public class Car extends Vehicle
{
    final private int engineVolume;
    final private boolean isAuto;

    public Car(String productName, int price, int amountAvailable, String companyName, int engineVolume, boolean isAuto)
    {
        super(productName , price , amountAvailable , companyName);
        this.engineVolume = engineVolume;
        this.isAuto = isAuto;
        Image image = new Image("file:C:\\Users\\OctavioX1\\IdeaProjects\\github-OnlineShopRamezoon" +
                "\\first-project-OctavioX1\\OnlineShopV2\\src\\main\\resources\\com\\example\\onlineshopv2\\carImage.png");
        super.setProductImage(image);
    }

    @Override
    public String toString()
    {
        return super.toString() + " , Engine Volume : " + engineVolume +  "\n" + " , Is Automatic : " + isAuto + "\n";
    }
}

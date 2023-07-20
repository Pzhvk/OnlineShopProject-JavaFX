package com.example.ModelPKG.ProductModelPKG.ProductsPKG.VehiclePKG;

import javafx.scene.image.Image;

public class Bicycle extends Vehicle
{
    public enum type
    {
        MOUNTAIN , ROAD , CITY , HYBRID
    }
    final private type bicycleType;
    public Bicycle(String productName, int price, int amountAvailable, String companyName, type bicycleType)
    {
        super(productName , price , amountAvailable , companyName);
        this.bicycleType = bicycleType;
        Image image = new Image("file:C:\\Users\\OctavioX1\\IdeaProjects\\github-OnlineShopRamezoon" +
                "\\first-project-OctavioX1\\OnlineShopV2\\src\\main\\resources\\com\\example\\onlineshopv2\\bicycleImage.png");
        super.setProductImage(image);
    }
    @Override
    public String toString()
    {
        return super.toString() + " , Type : " + bicycleType.toString() + "\n";
    }
}

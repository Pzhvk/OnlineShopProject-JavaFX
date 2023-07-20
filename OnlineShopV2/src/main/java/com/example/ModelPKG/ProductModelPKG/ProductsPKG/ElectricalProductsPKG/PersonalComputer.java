package com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG;

import javafx.scene.image.Image;

public class PersonalComputer extends DigitalProducts
{
    final private String cpuModel;
    final private int ramCapacity;

    public PersonalComputer(String productName, int price, int amountAvailable, String companyName, String dimensions, int weight, String cpuModel, int ramCapacity)
    {
        super(productName , price , amountAvailable , companyName , dimensions , weight);
        this.cpuModel = cpuModel;
        this.ramCapacity = ramCapacity;
        Image image = new Image("file:C:\\Users\\OctavioX1\\IdeaProjects\\github-OnlineShopRamezoon" +
                "\\first-project-OctavioX1\\OnlineShopV2\\src\\main\\resources\\com\\example\\onlineshopv2\\PCImage.png");
        super.setProductImage(image);
    }

    @Override
    public String toString()
    {
        return super.toString() + " , CPU Model : " + cpuModel + "\n"  + " , Ram Capacity : " + ramCapacity + "\n";
    }
}

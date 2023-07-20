package com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG;

import javafx.scene.image.Image;

public class SolidStateDrive extends StorageProducts
{
    final private int readRate;
    final private int writeRate;

    public SolidStateDrive(String productName, int price, int amountAvailable, String companyName, String dimensions, int weight, int storageCapacity, int readRate, int writeRate)
    {
        super(productName , price , amountAvailable , companyName , dimensions , weight , storageCapacity);
        this.readRate = readRate;
        this.writeRate = writeRate;
        Image image = new Image("file:C:\\Users\\OctavioX1\\IdeaProjects\\github-OnlineShopRamezoon" +
                "\\first-project-OctavioX1\\OnlineShopV2\\src\\main\\resources\\com\\example\\onlineshopv2\\SSDImage.png");
        super.setProductImage(image);
    }

    @Override
    public String toString()
    {
        return super.toString() + " , Reading Rate : " + readRate + "\n"  + " , Writing Rate : " + writeRate + "\n";
    }
}

package com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG;

import javafx.scene.image.Image;

public class FlashMemory extends StorageProducts
{
    final private int usbVersion;

    public FlashMemory(String productName, int price, int amountAvailable,
                       String companyName, String dimensions, int weight, int storageCapacity, int usbVersion)
    {
        super(productName , price , amountAvailable , companyName , dimensions , weight , storageCapacity);
        this.usbVersion = usbVersion;
        Image image = new Image("file:C:\\Users\\OctavioX1\\IdeaProjects\\github-OnlineShopRamezoon" +
                "\\first-project-OctavioX1\\OnlineShopV2\\src\\main\\resources\\com\\example\\onlineshopv2\\flashMemoryImage.png");
        super.setProductImage(image);
    }
    @Override
    public String toString()
    {
        return super.toString() + " , USB Version : " + usbVersion + "\n";
    }
}

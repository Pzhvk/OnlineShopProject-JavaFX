package com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG;

import javafx.scene.image.Image;

public class NoteBook extends StationaryProducts
{
    final private int pageNumber;
    final private String paperType;

    public NoteBook(String productName, int price, int amountAvailable, String country, int pageNumber, String paperType)
    {
        super(productName , price , amountAvailable , country);
        this.pageNumber = pageNumber;
        this.paperType = paperType;
        Image image = new Image("file:C:\\Users\\OctavioX1\\IdeaProjects\\github-OnlineShopRamezoon" +
                "\\first-project-OctavioX1\\OnlineShopV2\\src\\main\\resources\\com\\example\\onlineshopv2\\noteBookImage.png");
        super.setProductImage(image);
    }

    @Override
    public String toString()
    {
        return super.toString() + " , Page Number : " + pageNumber  + "\n" + " , Paper Type : " + paperType + "\n";
    }
}

package com.example.ModelPKG.ProductModelPKG.ProductsPKG.FoodProductsPKG;

import com.example.ModelPKG.ProductModelPKG.CategoryModel;
import com.example.ModelPKG.ProductModelPKG.ProductModel;
import javafx.scene.image.Image;

public class Food extends ProductModel
{
    final private int productionDate;
    final private int expirationDate;

    public Food(String productName, int price, int amountAvailable, int productionDate, int expirationDate)
    {
        super(productName , price , amountAvailable);
        this.category = CategoryModel.FOOD;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        Image image = new Image("file:C:\\Users\\OctavioX1\\IdeaProjects\\github-OnlineShopRamezoon" +
                "\\first-project-OctavioX1\\OnlineShopV2\\src\\main\\resources\\com\\example\\onlineshopv2\\foodImage.png");
        super.setProductImage(image);
    }

    @Override
    public String toString()
    {
        return "Production Date : " + productionDate + "\n" + " , Expiration Date : " + expirationDate + "\n";
    }
}

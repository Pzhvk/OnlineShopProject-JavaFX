package com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG;

import com.example.ModelPKG.ProductModelPKG.Discountable;
import com.example.ModelPKG.UserModelPKG.AdminModel;
import javafx.scene.image.Image;

public class Pen extends StationaryProducts implements Discountable
{
    final private String penColor;
    private int discountPercent;
    private int discountQuantity;
    public Pen(String productName, int price, int amountAvailable, String country, String penColor)
    {
        super(productName , price , amountAvailable , country);
        this.penColor = penColor;
        Image image = new Image("file:C:\\Users\\OctavioX1\\IdeaProjects\\github-OnlineShopRamezoon" +
                "\\first-project-OctavioX1\\OnlineShopV2\\src\\main\\resources\\com\\example\\onlineshopv2\\penImage.png");
        super.setProductImage(image);
    }

    @Override
    public String toString()
    {
        return super.toString() + " , Color : " + penColor + "\n";
    }
    @Override
    public int addDiscount(int percent, int productID , int amount)
    {
        for (int i = 0 ; i < AdminModel.getAdmin().getAllProducts().size() ; i++)
        {
            if (productID == AdminModel.getAdmin().getAllProducts().get(i).getProductID())
            {
                AdminModel.getAdmin().getAllProducts().get(i).setPrice(AdminModel.getAdmin().getAllProducts().get(i).getPrice() * (100 - percent) / 100);
                this.discountQuantity = amount;
                this.discountPercent = percent;
                return 0;
            }
        }
        return 1;
    }
    @Override
    public int removeDiscount(int productID)
    {
        for (int i = 0 ; i < AdminModel.getAdmin().getAllProducts().size() ; i++)
        {
            if (productID == AdminModel.getAdmin().getAllProducts().get(i).getProductID())
            {
                AdminModel.getAdmin().getAllProducts().get(i).setPrice(AdminModel.getAdmin().getAllProducts().get(i).getPrice() / (100 - this.discountPercent) * 100);
                this.discountQuantity = 0;
                this.discountPercent = 0;
                return 0;
            }
        }
        return 1;
    }
    public int getDiscountQuantity() {
        return discountQuantity;
    }
    public void setDiscountQuantity(int discountQuantity) {
        this.discountQuantity = discountQuantity;
    }
    public int getDiscountPercent() {
        return discountPercent;
    }
    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }
}

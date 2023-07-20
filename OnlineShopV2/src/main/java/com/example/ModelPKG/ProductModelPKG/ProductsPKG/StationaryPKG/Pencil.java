package com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG;

import com.example.ModelPKG.ProductModelPKG.Discountable;
import com.example.ModelPKG.UserModelPKG.AdminModel;
import javafx.scene.image.Image;

public class Pencil extends StationaryProducts implements Discountable
{
    public enum type
    {
        _2H , H , F , B , HB
    }
    final private type pencilType;
    private int discountQuantity;
    private int discountPercent;
    public Pencil(String productName, int price, int amountAvailable, String country, type pencilType)
    {
        super(productName , price , amountAvailable , country);
        this.pencilType = pencilType;
        Image image = new Image("file:C:\\Users\\OctavioX1\\IdeaProjects\\github-OnlineShopRamezoon" +
                "\\first-project-OctavioX1\\OnlineShopV2\\src\\main\\resources\\com\\example\\onlineshopv2\\pencilImage.png");
        super.setProductImage(image);
    }

    @Override
    public String toString()
    {
        return super.toString() + " , Pencil Type : " + pencilType + "\n";
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
}
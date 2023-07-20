package com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG;

import com.example.ModelPKG.ProductModelPKG.CategoryModel;
import com.example.ModelPKG.ProductModelPKG.Discountable;
import com.example.ModelPKG.ProductModelPKG.ProductModel;
import com.example.ModelPKG.UserModelPKG.AdminModel;

public abstract class DigitalProducts extends ProductModel implements Discountable
{
    private int discountQuantity;
    final private String companyName;
    final private String dimensions;
    final private int weight;
    private int discountPercent;

    DigitalProducts(String productName , int price , int amountAvailable , String companyName , String dimensions , int weight)
    {
        super(productName , price , amountAvailable);
        this.category = CategoryModel.DIGITAL;
        this.companyName = companyName;
        this.dimensions = dimensions;
        this.weight = weight;
    }
    @Override
    public String toString()
    {
        return "Company Name : " + companyName + "\n" + " , Dimensions : " + dimensions + "\n" + " , Weight " + weight + "\n";
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
                AdminModel.getAdmin().getAllProducts().get(i).setPrice(AdminModel.getAdmin().getAllProducts().get(i).getPrice() / (this.discountPercent) * 100);
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

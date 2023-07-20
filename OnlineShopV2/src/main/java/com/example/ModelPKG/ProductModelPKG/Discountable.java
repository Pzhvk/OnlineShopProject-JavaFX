package com.example.ModelPKG.ProductModelPKG;

public interface Discountable
{
    public int addDiscount(int percent , int productID , int amount);
    public int removeDiscount(int productID);
}

package com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG;

import com.example.ModelPKG.ProductModelPKG.CategoryModel;
import com.example.ModelPKG.ProductModelPKG.ProductModel;

public abstract class StationaryProducts extends ProductModel
{
    final private String country;

    StationaryProducts(String productName , int price , int amountAvailable , String country)
    {
        super(productName , price , amountAvailable);
        this.category = CategoryModel.STATIONARY;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Country Name : " + country + "\n";
    }
}

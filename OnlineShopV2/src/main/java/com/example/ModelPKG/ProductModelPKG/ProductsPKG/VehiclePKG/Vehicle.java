package com.example.ModelPKG.ProductModelPKG.ProductsPKG.VehiclePKG;

import com.example.ModelPKG.ProductModelPKG.CategoryModel;
import com.example.ModelPKG.ProductModelPKG.ProductModel;

public abstract class Vehicle extends ProductModel
{
    private final String companyName;

    Vehicle(String productName , int price , int amountAvailable , String companyName)
    {
        super(productName , price , amountAvailable);
        this.category = CategoryModel.VEHICLE;
        this.companyName = companyName;
    }

    @Override
    public String toString()
    {
        return "Company Name : " + companyName + "\n";
    }
}

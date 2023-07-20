package com.example.ControlPKG;

import com.example.ExceptionsPKG.ProductNotFoundException;
import com.example.ModelPKG.ProductModelPKG.CategoryModel;
import com.example.ModelPKG.ProductModelPKG.ProductModel;
import com.example.ModelPKG.UserModelPKG.AdminModel;

import java.util.ArrayList;

public class  ProductControl
{
    public static ArrayList<ProductModel> searchByName(String searchName) throws ProductNotFoundException
    {
        ArrayList<ProductModel> foundProducts = new ArrayList<>();
        for (ProductModel productModel : AdminModel.getAdmin().getAllProducts())
        {
            if (productModel.getProductName().toLowerCase().contains(searchName.toLowerCase()))
            {
                foundProducts.add(productModel);
            }
        }
        return foundProducts;
    }
    public static ArrayList<ProductModel> searchByCategory(CategoryModel category) throws ProductNotFoundException
    {
        ArrayList<ProductModel> foundProducts = new ArrayList<>();
        foundProducts.add(null);
        for (ProductModel productModel : AdminModel.getAdmin().getAllProducts())
        {
            if (productModel.getCategory() == category)
            {
                if (foundProducts.get(0) == null)
                {
                    foundProducts.remove(0);
                }
                foundProducts.add(productModel);
            }
        }
        if (foundProducts.get(0) == null)
        {
            throw new ProductNotFoundException();
        }
        return foundProducts;
    }
    public static ArrayList<ProductModel> searchBetweenPrices(int price1 , int price2) throws ProductNotFoundException
    {
        ArrayList<ProductModel> foundProducts = new ArrayList<>();
        foundProducts.set(0 , null);
        if (price1 >= price2)
        {
            for (ProductModel product : AdminModel.getAdmin().getAllProducts())
            {
                if (product.getPrice() >= price2 && product.getPrice() <= price1)
                {
                    if (foundProducts.get(0) == null)
                    {
                        foundProducts.remove(0);
                    }
                    foundProducts.add(product);
                }
            }
        }
        else
        {
            for (ProductModel product : AdminModel.getAdmin().getAllProducts())
            {
                if (product.getPrice() <= price2 && product.getPrice() >= price1)
                {
                    if (foundProducts.get(0) == null)
                    {
                        foundProducts.remove(0);
                    }
                    foundProducts.add(product);
                }
            }
        }
        if (foundProducts.get(0) == null)
        {
            throw new ProductNotFoundException();
        }
        return foundProducts;
    }
    public static ArrayList<ProductModel> searchByAvailability() throws ProductNotFoundException
    {
        ArrayList<ProductModel> foundProducts = new ArrayList<>();
        foundProducts.set(0 , null);
        for (ProductModel product : AdminModel.getAdmin().getAllProducts())
        {
            if (product.getAmountAvailable() > 0)
            {
                if (foundProducts.get(0) == null)
                {
                    foundProducts.remove(0);
                }
                foundProducts.add(product);
            }
        }
        if (foundProducts.get(0) == null)
        {
            throw new ProductNotFoundException();
        }
        return foundProducts;
    }
}
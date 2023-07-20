package com.example.ModelPKG.UserModelPKG;

import com.example.ModelPKG.ProductModelPKG.ProductModel;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReceiptModel
{
    private static int receiptIDNumber;
    final private String receiptID;
    final private LocalDateTime datePurchased;
    private int totalPrice;
    private ArrayList<ProductModel> products;

    public ReceiptModel(ArrayList<ProductModel> products)
    {
        for (ProductModel product : products)
        {
            this.totalPrice += product.getPrice();
        }
        this.datePurchased = LocalDateTime.now();
        this.products = products;
        receiptID = String.valueOf(receiptIDNumber);
        receiptIDNumber++;
    }
    @Override
    public String toString()
    {
        StringBuilder productList = new StringBuilder();
        String productListString;
        for (ProductModel product : products) {
            productList.append(product.toString());
            productList.append("\n");
        }
        productListString = productList.toString();
        return "Total Price : " + totalPrice + " Date : " + datePurchased + " Receipt ID : " + receiptID + "\nList Of Products : " + productListString + "\n";
    }
    public LocalDateTime getDatePurchased()
    {
        return datePurchased;
    }
    public String getReceiptID()
    {
        return receiptID;
    }
    public ArrayList<ProductModel> getProducts() {
        return products;
    }
    public int getTotalPrice()
    {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    public void setProducts (ArrayList<ProductModel> products)
    {
        this.products = products;
    }
}
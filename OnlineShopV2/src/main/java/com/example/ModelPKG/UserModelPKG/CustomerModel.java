package com.example.ModelPKG.UserModelPKG;

import com.example.ModelPKG.ProductModelPKG.ProductModel;

import java.util.ArrayList;

public class CustomerModel extends UserModel
{
    private ArrayList<ProductModel> basket;
    private final ArrayList<ReceiptModel> receipts;
    private final ArrayList<DiscountModel> discounts;
    private int currentBalance;
    public CustomerModel(String username, String password, String email, String phoneNumber)
    {
        super(username , email , phoneNumber , password);
        this.basket = new ArrayList<>();
        this.receipts = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.currentBalance = 0;
    }
    @Override
    public String toString()
    {
        return super.toString() + " Current Balance : " + currentBalance + "\n";
    }
    public ArrayList<ProductModel> getBasket() {
        return basket;
    }
    public void setBasket(ArrayList<ProductModel> basket)
    {
        this.basket = basket;
    }
    public ArrayList<ReceiptModel> getReceipts() {
        return receipts;
    }
    public int getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
    public ArrayList<DiscountModel> getDiscounts() {
        return discounts;
    }
}

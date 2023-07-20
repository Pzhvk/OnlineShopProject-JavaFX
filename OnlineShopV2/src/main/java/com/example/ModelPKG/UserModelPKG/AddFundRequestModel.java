package com.example.ModelPKG.UserModelPKG;

public class AddFundRequestModel
{
    final private CustomerModel customer;
    final private String cardNumber;
    final private String cvv2;
    final private String cardPassword;
    final private int depository;

    public AddFundRequestModel(CustomerModel customer, String cardNumber, String cvv2, String cardPassword, int depository)
    {
        this.customer = customer;
        this.cardNumber = cardNumber;
        this.cvv2 = cvv2;
        this.cardPassword = cardPassword;
        this.depository = depository;
    }

    @Override
    public String toString()
    {
        return "Username : " + customer.getUsername() + " , Card Number : " + cardNumber + " , CVV2 : " + cvv2 + " , Card Password : " + cardPassword + " , Deposition Amount : " + depository + "\n";
    }

    public CustomerModel getCustomer() {
        return customer;
    }
    public int getDepository() {
        return depository;
    }
}
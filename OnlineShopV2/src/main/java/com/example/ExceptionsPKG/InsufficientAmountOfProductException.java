package com.example.ExceptionsPKG;

public class InsufficientAmountOfProductException extends InvalidPurchaseException
{
    public InsufficientAmountOfProductException()
    {
        super("Insufficient Amount Of Product!");
    }
}

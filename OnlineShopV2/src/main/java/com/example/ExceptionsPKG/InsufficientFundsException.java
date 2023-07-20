package com.example.ExceptionsPKG;

public class InsufficientFundsException extends InvalidPurchaseException
{
    public InsufficientFundsException()
    {
        super("Insufficient Funds!");
    }
}

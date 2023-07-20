package com.example.ExceptionsPKG;

public class InvalidDiscountCodeException extends Exception
{
    public InvalidDiscountCodeException()
    {
        super("Invalid Discount Code!");
    }
}
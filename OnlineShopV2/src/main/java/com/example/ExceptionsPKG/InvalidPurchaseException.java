package com.example.ExceptionsPKG;

public class InvalidPurchaseException extends Exception
{
    InvalidPurchaseException(String message)
    {
        super("Invalid Purchase!" + message);
    }
}

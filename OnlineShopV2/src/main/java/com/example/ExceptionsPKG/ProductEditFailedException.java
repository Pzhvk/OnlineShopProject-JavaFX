package com.example.ExceptionsPKG;

public class ProductEditFailedException extends Exception
{
    public ProductEditFailedException(String message)
    {
        super(message);
    }
}
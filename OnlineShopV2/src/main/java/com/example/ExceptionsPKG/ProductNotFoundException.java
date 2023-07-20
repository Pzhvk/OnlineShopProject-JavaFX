package com.example.ExceptionsPKG;

public class ProductNotFoundException extends Exception
{
    public ProductNotFoundException()
    {
        super("No Products Were Found!");
    }
}

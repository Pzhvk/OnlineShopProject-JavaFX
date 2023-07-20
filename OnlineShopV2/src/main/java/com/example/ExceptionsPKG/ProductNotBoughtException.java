package com.example.ExceptionsPKG;

public class ProductNotBoughtException extends InvalidScoreException
{
    public ProductNotBoughtException()
    {
        super("You Haven't Bought This Product Yet!");
    }
}

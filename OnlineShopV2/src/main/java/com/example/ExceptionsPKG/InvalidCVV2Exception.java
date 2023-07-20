package com.example.ExceptionsPKG;

public class InvalidCVV2Exception extends InvalidCredentialsException
{
    public InvalidCVV2Exception()
    {
        super("CVV2 Format Is Invalid!");
    }
}

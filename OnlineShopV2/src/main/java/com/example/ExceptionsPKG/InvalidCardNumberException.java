package com.example.ExceptionsPKG;

public class InvalidCardNumberException extends InvalidCredentialsException
{
    public InvalidCardNumberException()
    {
        super("Card Number Format Is Invalid!");
    }
}
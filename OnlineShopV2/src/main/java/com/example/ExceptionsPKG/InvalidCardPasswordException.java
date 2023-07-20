package com.example.ExceptionsPKG;

public class InvalidCardPasswordException extends InvalidCredentialsException
{
    public InvalidCardPasswordException()
    {
        super("Your Password Is Incorrect!");
    }
}
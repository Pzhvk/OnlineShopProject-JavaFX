package com.example.ExceptionsPKG;

public class InvalidCredentialsException extends Exception
{
    public InvalidCredentialsException(String message)
    {
        super("Invalid Credentials!" + message);
    }
}
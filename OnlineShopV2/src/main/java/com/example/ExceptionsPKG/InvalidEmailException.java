package com.example.ExceptionsPKG;

public class InvalidEmailException extends InvalidCredentialsException
{
    public InvalidEmailException()
    {
        super("Invalid Email!");
    }
}

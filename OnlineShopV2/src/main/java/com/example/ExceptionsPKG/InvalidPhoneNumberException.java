package com.example.ExceptionsPKG;

public class InvalidPhoneNumberException extends InvalidCredentialsException
{
    public InvalidPhoneNumberException()
    {
        super("Invalid Phone Number!");
    }
}

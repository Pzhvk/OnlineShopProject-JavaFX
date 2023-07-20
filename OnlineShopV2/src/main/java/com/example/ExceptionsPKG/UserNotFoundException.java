package com.example.ExceptionsPKG;

public class UserNotFoundException extends Exception
{
    public UserNotFoundException()
    {
        super("User Not Found In The System!");
    }
}

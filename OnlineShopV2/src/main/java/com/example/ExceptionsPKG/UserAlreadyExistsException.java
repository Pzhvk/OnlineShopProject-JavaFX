package com.example.ExceptionsPKG;

public class UserAlreadyExistsException extends Exception
{
    public UserAlreadyExistsException()
    {
        super("User Already Exists In The System!");
    }
}

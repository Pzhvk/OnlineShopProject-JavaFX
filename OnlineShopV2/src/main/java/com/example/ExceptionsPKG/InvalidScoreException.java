package com.example.ExceptionsPKG;

public class InvalidScoreException extends Exception
{
    public InvalidScoreException(String message)
    {
        super("Your Score Was Not Registered!" + message);
    }
}
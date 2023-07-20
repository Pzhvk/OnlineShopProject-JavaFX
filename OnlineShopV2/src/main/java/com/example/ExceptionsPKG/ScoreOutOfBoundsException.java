package com.example.ExceptionsPKG;

public class ScoreOutOfBoundsException extends InvalidScoreException
{
    public ScoreOutOfBoundsException()
    {
        super("Score Must Be Between 0 and 10!");
    }
}
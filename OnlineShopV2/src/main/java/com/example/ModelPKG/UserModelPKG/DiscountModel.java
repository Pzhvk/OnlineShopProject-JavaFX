package com.example.ModelPKG.UserModelPKG;

import java.util.Date;
import java.util.Random;

public class DiscountModel
{
    final private int discount;
    final private String code;
    private int capacity;

    public DiscountModel(int discount, int capacity)
    {
        this.code = codeGenerator();
        this.discount = discount;
        this.capacity = capacity;
    }

    private String codeGenerator()
    {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return(generatedString);
    }
    public int getCapacity()
    {
        return capacity;
    }
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
    public int getDiscount()
    {
        return discount;
    }
    public String getCode()
    {
        return code;
    }
}
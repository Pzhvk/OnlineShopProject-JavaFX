package com.example.ModelPKG.SupportModelPKG;

import com.example.ModelPKG.ProductModelPKG.ProductModel;
import com.example.ModelPKG.UserModelPKG.CustomerModel;
import com.example.ModelPKG.UserModelPKG.UserModel;

public class ScoreModel
{
    final private CustomerModel user;
    final private ProductModel product;
    final private int score;

    public ScoreModel(CustomerModel user, ProductModel product, int score)
    {
        this.user = user;
        this.product = product;
        this.score = score;
    }

    public UserModel getUser() {
        return user;
    }
    public ProductModel getProduct() {
        return product;
    }
    public int getScore() {
        return score;
    }
}
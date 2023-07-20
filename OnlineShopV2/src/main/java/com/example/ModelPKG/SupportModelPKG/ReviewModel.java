package com.example.ModelPKG.SupportModelPKG;

import com.example.ModelPKG.UserModelPKG.CustomerModel;
import com.example.ModelPKG.UserModelPKG.UserModel;

import java.util.Objects;

public class ReviewModel
{
    final private CustomerModel user;
    final private int productID;
    final private String reviewText;
    private boolean hasUserBought;

    public ReviewModel(CustomerModel user, int productID, String reviewText)
    {
        this.user = user;
        this.productID = productID;
        this.reviewText = reviewText;
        this.hasUserBought = false;
        for (int i = 0 ; i < user.getReceipts().size() ; i++)
        {
            for (int j = 0 ; j < user.getReceipts().get(i).getProducts().size() ; j++)
            {
                if (Objects.equals(user.getReceipts().get(i).getProducts().get(j).getProductID(), productID)) {
                    this.hasUserBought = true;
                    break;
                }
            }
        }
    }

    @Override
    public String toString()
    {
        return "Username : " + user +  " , Product ID : " + productID + " , Has User Bought This Product : " + hasUserBought +  "\nReview Text : " + reviewText + "\n";
    }

    public UserModel getUser() {
        return user;
    }
    public int getProductID() {
        return productID;
    }
    public String getReviewText() {
        return reviewText;
    }
    public boolean getHasUserBought()
    {
        return hasUserBought;
    }
}

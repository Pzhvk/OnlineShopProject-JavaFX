package com.example.ModelPKG.SupportModelPKG;

import com.example.ModelPKG.UserModelPKG.CustomerModel;

import java.util.Objects;

public class ReviewRequestModel
{
    final private CustomerModel user;
    final private int productID;
    final private String reviewText;
    private boolean hasUserBought;
    private int isAccepted; /* 0 = Not Checked , 1 = Accepted , -1 = Not Accepted */

    public ReviewRequestModel(CustomerModel user, int productID, String reviewText)
    {
        this.user = user;
        this.productID = productID;
        this.reviewText = reviewText;
        this.isAccepted = 0;
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
        return "Username : " + user +  " , Product ID : " + productID + " , Has User Bought This Product : " + hasUserBought + "\nReview Text : " + reviewText + "\n";
    }

    public CustomerModel getUser() {
        return user;
    }
    public int getProductID() {
        return productID;
    }
    public String getReviewText() {
        return reviewText;
    }
    public int getIsAccepted() {
        return isAccepted;
    }
    public void setIsAccepted(int isAccepted) {
        this.isAccepted = isAccepted;
    }
}

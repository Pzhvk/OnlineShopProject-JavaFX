package com.example.ModelPKG.UserModelPKG;

import com.example.ModelPKG.ProductModelPKG.ProductModel;
import com.example.ModelPKG.SupportModelPKG.ReviewRequestModel;

import java.util.ArrayList;

public class AdminModel extends UserModel
{
    static private final AdminModel admin = new AdminModel("admin" , "admin@gmail.com" , "0123456789" , "123");
    private final ArrayList<ProductModel> allProducts;
    private final ArrayList<CustomerModel> customers;
    final private ArrayList<AddFundRequestModel> addFundRequests;
    final private ArrayList<SignupRequestModel> signupRequests;
    final private ArrayList<ReviewRequestModel> reviewRequests;
    final private ArrayList<DiscountModel> discounts;

    private AdminModel(String username , String email , String phoneNumber , String password)
    {
       super(username , email , phoneNumber , password);
       this.allProducts = new ArrayList<>();
       this.customers = new ArrayList<>();
       this.reviewRequests = new ArrayList<>();
       this.addFundRequests = new ArrayList<>();
       this.signupRequests = new ArrayList<>();
       this.discounts = new ArrayList<>();
    }

    public static AdminModel getAdmin() {
        return admin;
    }
    public ArrayList<ProductModel> getAllProducts() {
        return allProducts;
    }
    public ArrayList<CustomerModel> getCustomers() {
        return customers;
    }
    public ArrayList<AddFundRequestModel> getAddFundRequests() {
        return addFundRequests;
    }
    public ArrayList<SignupRequestModel> getSignupRequests() {
        return signupRequests;
    }
    public ArrayList<ReviewRequestModel> getReviewRequests() {
        return reviewRequests;
    }
    public ArrayList<DiscountModel> getDiscounts() {
        return discounts;
    }
}

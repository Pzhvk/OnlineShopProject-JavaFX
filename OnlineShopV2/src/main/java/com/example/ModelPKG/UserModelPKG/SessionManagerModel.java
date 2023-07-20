package com.example.ModelPKG.UserModelPKG;

import com.example.ModelPKG.ProductModelPKG.ProductModel;

public class SessionManagerModel
{
    private static CustomerModel currentCustomer;
    private static ProductModel currentProduct;
    private static boolean loggedInAsUser;
    private static boolean loggedInAsAdmin;

    public static void setLoggedInAsAdmin(boolean loggedInAsAdmin)
    {
        SessionManagerModel.loggedInAsAdmin = loggedInAsAdmin;
    }
    public static void setLoggedInAsUser(boolean loggedInAsUser)
    {
        SessionManagerModel.loggedInAsUser = loggedInAsUser;
    }
    public static void setCurrentCustomer(CustomerModel currentCustomer)
    {
        SessionManagerModel.currentCustomer = currentCustomer;
    }
    public static CustomerModel getCurrentCustomer()
   {
       return currentCustomer;
   }
    public static boolean isLoggedInAsUser()
   {
       return loggedInAsUser;
   }
    public static boolean isLoggedInAsAdmin()
   {
       return loggedInAsAdmin;
   }
    public static ProductModel getCurrentProduct() {
        return currentProduct;
    }
    public static void setCurrentProduct(ProductModel currentProduct) {
        SessionManagerModel.currentProduct = currentProduct;
    }
}

package com.example.ControlPKG;

import com.example.ExceptionsPKG.UserNotFoundException;
import com.example.ModelPKG.UserModelPKG.AdminModel;
import com.example.ModelPKG.UserModelPKG.SessionManagerModel;

import java.util.Objects;

public class LoginControl
{
    public static void signInAsCustomer(String username, String password) throws UserNotFoundException {
        for (int i = 0; i < AdminModel.getAdmin().getCustomers().size() ; i++)
        {
            if (Objects.equals(AdminModel.getAdmin().getCustomers().get(i).getUsername(), username)
                    && Objects.equals(AdminModel.getAdmin().getCustomers().get(i).getPassword(), password))
            {
                SessionManagerModel.setCurrentCustomer(AdminModel.getAdmin().getCustomers().get(i));
                SessionManagerModel.setLoggedInAsUser(true);
                SessionManagerModel.setLoggedInAsAdmin(false);
                return;
            }
        }
        signInAsAdmin(username , password);
    }
    public static void signInAsAdmin(String username, String password) throws UserNotFoundException
    {
        if (Objects.equals(AdminModel.getAdmin().getUsername(), username) && Objects.equals(AdminModel.getAdmin().getPassword(), password))
        {
            SessionManagerModel.setLoggedInAsUser(false);
            SessionManagerModel.setLoggedInAsAdmin(true);
            return;
        }
        throw new UserNotFoundException();
    }
}

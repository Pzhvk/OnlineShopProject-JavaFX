package com.example.ControlPKG;

import com.example.ExceptionsPKG.InvalidCredentialsException;
import com.example.ExceptionsPKG.InvalidEmailException;
import com.example.ExceptionsPKG.InvalidPhoneNumberException;
import com.example.ExceptionsPKG.UserAlreadyExistsException;
import com.example.ModelPKG.UserModelPKG.AdminModel;
import com.example.ModelPKG.UserModelPKG.SignupRequestModel;

import java.util.Objects;
import java.util.regex.Pattern;

public class SignupControl
{
    public static int SignUpAsCostumer(String username , String password , String email , String phoneNumber) throws InvalidCredentialsException , UserAlreadyExistsException
    {
        Pattern emailREGEX = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
        Pattern phoneNumberREGEX = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");

        for (int i = 0 ; i < AdminModel.getAdmin().getCustomers().size() ; i++)
        {
            if (Objects.equals(AdminModel.getAdmin().getCustomers().get(i).getUsername(), username))
            {
                throw new UserAlreadyExistsException();
            }
        }
        if (emailREGEX.matcher(email).matches())
        {
            if(phoneNumberREGEX.matcher(phoneNumber).matches())
            {
                SignupRequestModel signupRequest = new SignupRequestModel(username, email, phoneNumber, password);
                AdminModel.getAdmin().getSignupRequests().add(signupRequest);
                return 0;
            }
            throw new InvalidPhoneNumberException();
        }
        throw new InvalidEmailException();
    }
}

package com.example.ModelPKG.UserModelPKG;

public class SignupRequestModel
{
    final private String username;
    final private String email;
    final private String phoneNumber;
    final private String password;

    public SignupRequestModel(String username, String email, String phoneNumber, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString()
    {
        return "Username : " + username + " , Password : " + password + " , Email : " + email + " , Phone Number : " + phoneNumber + "\n";
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPassword() {
        return password;
    }
}

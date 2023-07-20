package com.example.ModelPKG.UserModelPKG;

import java.util.ArrayList;

public abstract class UserModel
{
    final private String username;
    private String email;
    private String phoneNumber;
    private String password;

    UserModel(String username , String email , String phoneNumber , String password)
    {
        this.username = username;
        this.password = password;
        this.email = email;
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
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
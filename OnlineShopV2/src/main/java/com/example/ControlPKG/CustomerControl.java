package com.example.ControlPKG;

import com.example.ExceptionsPKG.*;
import com.example.ModelPKG.ProductModelPKG.ProductModel;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG.DigitalProducts;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG.Pen;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG.Pencil;
import com.example.ModelPKG.SupportModelPKG.ReviewRequestModel;
import com.example.ModelPKG.UserModelPKG.AddFundRequestModel;
import com.example.ModelPKG.UserModelPKG.AdminModel;
import com.example.ModelPKG.UserModelPKG.CustomerModel;
import com.example.ModelPKG.UserModelPKG.ReceiptModel;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class CustomerControl
{
    public static void changePassword(String newPassword , CustomerModel customer)
    {
        customer.setPassword(newPassword);
    }
    public static int changeEmail(String newEmail , CustomerModel customer) throws InvalidEmailException
    {
        Pattern emailREGEX = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
        if (emailREGEX.matcher(newEmail).matches())
        {
            customer.setEmail(newEmail);
            return 0;
        }
        throw new InvalidEmailException();
    }
    public static int changePhoneNumber(String newPhoneNumber , CustomerModel customer) throws InvalidPhoneNumberException
    {
        Pattern phoneNumberREGEX = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");
        if (phoneNumberREGEX.matcher(newPhoneNumber).matches())
        {
            customer.setPhoneNumber(newPhoneNumber);
            return 0;
        }
        throw new InvalidPhoneNumberException();
    }
    public static void addToBasket(CustomerModel customer , ProductModel product)
    {
        customer.getBasket().add(product);
    }
    public static int checkout(CustomerModel customer , String discount) throws InvalidPurchaseException , InvalidDiscountCodeException
    {
        ArrayList<ProductModel> productModels = new ArrayList<>(customer.getBasket());
        ReceiptModel receipt = new ReceiptModel(productModels);
        if (customer.getCurrentBalance() >= receipt.getTotalPrice())
        {
            for (int i = 0 ; i < receipt.getProducts().size() ; i++)
            {
                if (receipt.getProducts().get(i).getAmountAvailable() == 0)
                {
                    throw new InsufficientAmountOfProductException();
                }
                else
                {
                    receipt.getProducts().get(i).setAmountAvailable(receipt.getProducts().get(i).getAmountAvailable() - 1);
                }
            }
            for (ProductModel product : receipt.getProducts())
            {
                if (product instanceof DigitalProducts && ((DigitalProducts) product).getDiscountPercent() != 0)
                {
                    if (((DigitalProducts) product).getDiscountQuantity() == 0)
                    {
                        product.setPrice(product.getPrice() / (((DigitalProducts) product).getDiscountPercent()) * 100);
                        ((DigitalProducts) product).setDiscountQuantity(0);
                        ((DigitalProducts) product).setDiscountPercent(0);
                    }
                    else
                    {
                        ((DigitalProducts) product).setDiscountQuantity(((DigitalProducts) product).getDiscountQuantity() - 1);
                    }
                }
                else if (product instanceof Pen && ((Pen) product).getDiscountPercent() != 0)
                {
                    if (((Pen) product).getDiscountQuantity() == 0)
                    {
                        product.setPrice(product.getPrice() / (((Pen) product).getDiscountPercent()) * 100);
                        ((Pen) product).setDiscountQuantity(0);
                        ((Pen) product).setDiscountPercent(0);
                    }
                    else
                    {
                        ((Pen) product).setDiscountQuantity(((Pen) product).getDiscountQuantity() - 1);
                    }
                }
                else if (product instanceof Pencil && ((Pencil) product).getDiscountPercent() != 0)
                {
                    if (((Pencil) product).getDiscountQuantity() == 0)
                    {
                        product.setPrice(product.getPrice() / (((Pencil) product).getDiscountPercent()) * 100);
                        ((Pencil) product).setDiscountQuantity(0);
                        ((Pencil) product).setDiscountPercent(0);
                    }
                    else
                    {
                        ((Pencil) product).setDiscountQuantity(((Pencil) product).getDiscountQuantity() - 1);
                    }
                }
            }
            if (!Objects.equals(discount, ""))
            {
                boolean userHasDiscount = false;
                int i = 0;
                for (i = 0 ; i < customer.getDiscounts().size() ; i++)
                {
                    if (Objects.equals(customer.getDiscounts().get(i).getCode(), discount))
                    {
                        if (customer.getDiscounts().get(i).getCapacity() == 0)
                        {
                            customer.getDiscounts().remove(i);
                            AdminModel.getAdmin().getDiscounts().remove(customer.getDiscounts().get(i));
                        }
                        else
                        {
                            customer.getDiscounts().get(i).setCapacity(customer.getDiscounts().get(i).getCapacity() - 1);
                            userHasDiscount = true;
                            break;
                        }
                    }
                }
                if (!userHasDiscount)
                {
                    throw new InvalidDiscountCodeException();
                }
                receipt.setTotalPrice(receipt.getTotalPrice() * customer.getDiscounts().get(i).getDiscount() / 100);
            }
            customer.setCurrentBalance(customer.getCurrentBalance() - receipt.getTotalPrice());
            customer.getReceipts().add(receipt);
            customer.getBasket().clear();
            return 0;
        }
        else
        {
            throw new InsufficientFundsException();
        }
    }
    public static void addReview(CustomerModel customer , ProductModel product , String reviewText)
    {
        int productID = product.getProductID();
        ReviewRequestModel review = new ReviewRequestModel(customer , productID , reviewText);
        AdminModel.getAdmin().getReviewRequests().add(review);
    }
    public static int addScore(CustomerModel customer , ProductModel product , int score) throws InvalidScoreException {
        if (score <= 10 && score >= 0)
        {
            for (int i = 0 ; i < customer.getReceipts().size() ; i++)
            {
                for (int j = 0 ; j < customer.getReceipts().get(i).getProducts().size() ; j++)
                {
                    if (customer.getReceipts().get(i).getProducts().get(j) == product)
                    {
                        product.setAverageScore(product.getAverageScore() + (score / product.getScoreQuantity()));
                        product.setScoreQuantity(product.getScoreQuantity() + 1);
                        return 0;
                    }
                }
                throw new ProductNotBoughtException();
            }
        }
         throw new ScoreOutOfBoundsException();

    }
    public static int addFunds(CustomerModel customer , String cardNumber , String cvv2 , String cardPassword , int depository) throws InvalidCredentialsException
    {
        Pattern card = Pattern.compile("^[0-9]{16}$");
        Pattern cvv = Pattern.compile("^[0-9]{3}$");
        Pattern password = Pattern.compile("^[0-9]{4}$");
        if (card.matcher(cardNumber).matches())
        {
            if (cvv.matcher(cvv2).matches())
            {
                if (password.matcher(cardPassword).matches())
                {
                    AddFundRequestModel addFundRequest = new AddFundRequestModel(customer , cardNumber , cvv2 , cardPassword , depository);
                    AdminModel.getAdmin().getAddFundRequests().add(addFundRequest);
                    return 0;
                }
                throw new InvalidCardPasswordException();
            }
            throw new InvalidCVV2Exception();
        }
        throw new InvalidCardNumberException();
    }
}

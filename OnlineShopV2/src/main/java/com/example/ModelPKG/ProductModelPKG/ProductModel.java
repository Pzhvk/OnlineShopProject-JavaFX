package com.example.ModelPKG.ProductModelPKG;

import com.example.ModelPKG.SupportModelPKG.ReviewModel;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class ProductModel implements Comparable
{
    @FXML
    private Image productImage;
    final private int productID;
    private String productName;
    private static int productNumber;
    private int price;
    private int amountAvailable;
    private int averageScore;
    private int scoreQuantity;
    protected CategoryModel category;
    final private ArrayList<ReviewModel> reviews;
    protected ProductModel(String productName, int price, int amountAvailable)
    {
        this.productName = productName;
        this.amountAvailable = amountAvailable;
        this.productID = productNumber;
        this.price = price;
        this.averageScore = 0;
        this.scoreQuantity = 1;
        this.reviews = new ArrayList<>();
        productNumber++;
    }
    @Override
    public int compareTo (Object productModel)
    {
        ProductModel product = (ProductModel) productModel;

        if (product.getCategory() == CategoryModel.DIGITAL && ((ProductModel) productModel).getCategory() != CategoryModel.DIGITAL)
        {
            return 1;
        }
        else if (product.getCategory() != CategoryModel.DIGITAL && ((ProductModel) productModel).getCategory() == CategoryModel.DIGITAL)
        {
            return -1;
        }
        else
        {
            if (product.getCategory() == CategoryModel.VEHICLE && ((ProductModel) productModel).getCategory() != CategoryModel.VEHICLE)
            {
                return 1;
            }
            else if (product.getCategory() != CategoryModel.VEHICLE && ((ProductModel) productModel).getCategory() == CategoryModel.VEHICLE)
            {
                return -1;
            }
            else
            {
                if (product.getCategory() == CategoryModel.STATIONARY && ((ProductModel) productModel).getCategory() != CategoryModel.STATIONARY)
                {
                    return 1;
                }
                else if (product.getCategory() != CategoryModel.STATIONARY && ((ProductModel) productModel).getCategory() == CategoryModel.STATIONARY)
                {
                    return -1;
                }
                else
                {
                    if (product.getCategory() == CategoryModel.FOOD && ((ProductModel) productModel).getCategory() != CategoryModel.FOOD)
                    {
                        return 1;
                    }
                    else if (product.getCategory() != CategoryModel.FOOD && ((ProductModel) productModel).getCategory() == CategoryModel.FOOD)
                    {
                        return -1;
                    }
                    else
                    {
                        if (product.getProductName().compareTo(this.getProductName()) > 0)
                        {
                            return 1;
                        }
                        else if (product.getProductName().compareTo(this.getProductName()) < 0)
                        {
                            return -1;
                        }
                        else
                        {
                            if (product.getAverageScore() > this.getAverageScore())
                            {
                                return 1;
                            }
                            else if (product.getAverageScore() < this.getAverageScore())
                            {
                                return -1;
                            }
                            else
                            {
                                if (product.getPrice() > this.getPrice())
                                {
                                    return 1;
                                }
                                else if (product.getPrice() < this.getPrice())
                                {
                                    return -1;
                                }
                                else
                                {
                                    if (product.getAmountAvailable() > this.getAmountAvailable())
                                    {
                                        return 1;
                                    }
                                    else if (product.getAmountAvailable() < this.getAmountAvailable())
                                    {
                                        return -1;
                                    }
                                    else
                                    {
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public int getProductID() {
        return productID;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getAmountAvailable() {
        return amountAvailable;
    }
    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }
    public int getAverageScore() {
        return averageScore;
    }
    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }
    public ArrayList<ReviewModel> getReviews()
    {
        return reviews;
    }
    public CategoryModel getCategory()
    {
        return category;
    }
    public int getScoreQuantity() {
        return scoreQuantity;
    }
    public void setScoreQuantity(int scoreQuantity) {
        this.scoreQuantity = scoreQuantity;
    }
    public Image getProductImage()
    {
        return productImage;
    }
    public void setProductImage(Image image)
    {
        this.productImage = image;
    }
}
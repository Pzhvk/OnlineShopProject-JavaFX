package com.example.ControlPKG;

import com.example.ExceptionsPKG.ProductEditFailedException;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG.FlashMemory;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG.PersonalComputer;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG.SolidStateDrive;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.FoodProductsPKG.Food;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG.NoteBook;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG.Pen;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG.Pencil;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.VehiclePKG.Bicycle;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.VehiclePKG.Car;
import com.example.ModelPKG.SupportModelPKG.ReviewModel;
import com.example.ModelPKG.SupportModelPKG.ReviewRequestModel;
import com.example.ModelPKG.UserModelPKG.AddFundRequestModel;
import com.example.ModelPKG.UserModelPKG.AdminModel;
import com.example.ModelPKG.UserModelPKG.CustomerModel;
import com.example.ModelPKG.UserModelPKG.SignupRequestModel;

import java.util.Objects;

public class AdminControl
{
    public static void addFlashMemory(String productName , int price , int amountAvailable , String companyName ,
                       String dimensions , int weight , int storageCapacity , int usbVersion)
    {
        FlashMemory newFlashMemory = new FlashMemory(productName , price , amountAvailable
                , companyName , dimensions , weight , storageCapacity ,usbVersion);

        AdminModel.getAdmin().getAllProducts().add(newFlashMemory);
    }
    public static void addSolidStateDrive(String productName , int price , int amountAvailable , String companyName ,
                           String dimensions , int weight , int storageCapacity , int readRate , int writeRate)
    {
        SolidStateDrive newSolidStateDrive = new SolidStateDrive(productName , price , amountAvailable ,
                companyName , dimensions , weight , storageCapacity , readRate , writeRate);

        AdminModel.getAdmin().getAllProducts().add(newSolidStateDrive);
    }
    public static void addPersonalComputer(String productName , int price , int amountAvailable , String companyName ,
                            String dimensions , int weight , String cpuModel , int ramCapacity)
    {
        PersonalComputer newPersonalComputer = new PersonalComputer(productName , price , amountAvailable ,
                companyName , dimensions , weight , cpuModel , ramCapacity);

        AdminModel.getAdmin().getAllProducts().add(newPersonalComputer);
    }
    public static void addFood(String productName, int price, int amountAvailable, int productionDate, int expirationDate)
    {
        Food food = new Food(productName, price, amountAvailable , productionDate , expirationDate);
        AdminModel.getAdmin().getAllProducts().add(food);
    }
    public static void addNotebook(String productName , int price , int amountAvailable , String country , int pageNumber , String paperType)
    {
        NoteBook noteBook = new NoteBook(productName , price , amountAvailable , country , pageNumber , paperType);
        AdminModel.getAdmin().getAllProducts().add(noteBook);
    }
    public static void addPen(String productName , int price , int amountAvailable , String country , String penColor)
    {
        Pen pen = new Pen(productName , price , amountAvailable , country , penColor);
        AdminModel.getAdmin().getAllProducts().add(pen);
    }
    public static void addPencil(String productName , int price , int amountAvailable , String country , Pencil.type pencilType)
    {
        Pencil pencil = new Pencil(productName , price , amountAvailable , country , pencilType);
        AdminModel.getAdmin().getAllProducts().add(pencil);
    }
    public static void addBicycle(String productName , int price , int amountAvailable , String companyName , Bicycle.type bicycleType)
    {
        Bicycle bicycle = new Bicycle(productName , price , amountAvailable , companyName , bicycleType);
        AdminModel.getAdmin().getAllProducts().add(bicycle);
    }
    public static void addCar(String productName , int price , int amountAvailable , String companyName , int engineVolume , boolean isAuto)
    {
        Car car = new Car(productName , price , amountAvailable , companyName , engineVolume , isAuto);
        AdminModel.getAdmin().getAllProducts().add(car);
    }
    public static int editName(String newName , String productName) throws ProductEditFailedException
    {
        for (int i = 0 ; i < AdminModel.getAdmin().getAllProducts().size() ; i++)
        {
            if (Objects.equals(AdminModel.getAdmin().getAllProducts().get(i).getProductName(), productName))
            {
                AdminModel.getAdmin().getAllProducts().get(i).setProductName(newName);
                return 0;
            }
        }
        throw new ProductEditFailedException("Product Not Found!");
    }
    public static int editAmountAvailable(int newAmountAvailable , String productName) throws ProductEditFailedException
    {
        for (int i = 0 ; i < AdminModel.getAdmin().getAllProducts().size() ; i++)
        {
            if (Objects.equals(AdminModel.getAdmin().getAllProducts().get(i).getProductName(), productName))
            {
                AdminModel.getAdmin().getAllProducts().get(i).setAmountAvailable(newAmountAvailable);
                return 0;
            }
        }
        throw new ProductEditFailedException("Product Not Found!");
    }
    public static int editPrice(int newPrice , String productName) throws ProductEditFailedException
    {
        for (int i = 0 ; i < AdminModel.getAdmin().getAllProducts().size() ; i++)
        {
            if (Objects.equals(AdminModel.getAdmin().getAllProducts().get(i).getProductName(), productName))
            {
                AdminModel.getAdmin().getAllProducts().get(i).setPrice(newPrice);
                return 0;
            }
        }
        throw new ProductEditFailedException("Product Not Found!");
    }
    public static int removeProduct(String productName) throws ProductEditFailedException
    {
        for (int i = 0 ; i < AdminModel.getAdmin().getAllProducts().size() ; i++)
        {
            if (Objects.equals(AdminModel.getAdmin().getAllProducts().get(i).getProductName(), productName))
            {
                AdminModel.getAdmin().getAllProducts().remove(AdminModel.getAdmin().getAllProducts().get(i));
                return 0;
            }
        }
        throw new ProductEditFailedException("Product Not Found!");
    }
    public static int manageReviewRequest(ReviewRequestModel reviewRequest , int indicator)
    {
        if (indicator == 1)
        {
            ReviewModel review = new ReviewModel(reviewRequest.getUser() , reviewRequest.getProductID() , reviewRequest.getReviewText());
            for (int i = 0 ; i < AdminModel.getAdmin().getAllProducts().size() ; i++)
            {
                if (Objects.equals(AdminModel.getAdmin().getAllProducts().get(i).getProductID(), reviewRequest.getProductID()))
                {
                    AdminModel.getAdmin().getAllProducts().get(i).getReviews().add(review);
                    AdminModel.getAdmin().getReviewRequests().remove(reviewRequest);
                    return 0;
                }
            }
        }
        else if (indicator == 2)
        {
            AdminModel.getAdmin().getReviewRequests().remove(reviewRequest);
            return 1;
        }
        return -1;
    }
    public static int manageAddFundRequest(AddFundRequestModel addFundRequest , int indicator)
    {
        if (indicator == 1)
        {
            addFundRequest.getCustomer().setCurrentBalance(addFundRequest.getCustomer().getCurrentBalance() + addFundRequest.getDepository());
            AdminModel.getAdmin().getAddFundRequests().remove(addFundRequest);
            return 0;
        }
        else if (indicator == 2)
        {
            AdminModel.getAdmin().getAddFundRequests().remove(addFundRequest);
            return 1;
        }
        return -1;
    }
    public static int manageSignupRequest(SignupRequestModel signupRequest , int indicator)
    {
        if (indicator == 1)
        {
            CustomerModel customer = new CustomerModel(signupRequest.getUsername(), signupRequest.getPassword(), signupRequest.getEmail(), signupRequest.getPhoneNumber());
            AdminModel.getAdmin().getCustomers().add(customer);
            AdminModel.getAdmin().getSignupRequests().remove(signupRequest);
            return 0;
        }
        else if (indicator == 2)
        {
            AdminModel.getAdmin().getSignupRequests().remove(signupRequest);
            return 1;
        }
        return -1;
    }
}
package com.example.ViewPKG;

import com.example.ControlPKG.AdminControl;
import com.example.ExceptionsPKG.ProductEditFailedException;
import com.example.ModelPKG.ProductModelPKG.CategoryModel;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG.DigitalProducts;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG.Pen;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.StationaryPKG.Pencil;
import com.example.ModelPKG.ProductModelPKG.ProductsPKG.VehiclePKG.Bicycle;
import com.example.ModelPKG.UserModelPKG.AdminModel;
import com.example.ModelPKG.UserModelPKG.CustomerModel;
import com.example.ModelPKG.UserModelPKG.DiscountModel;
import com.example.onlineshopv2.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class AdminView
{
    static Scanner scan = new Scanner(System.in);
    public static void adminMenu() throws ProductEditFailedException, IOException {
        boolean userWantToExit = false;
        System.out.println("Welcome To Admin Panel!");

        while(!userWantToExit)
        {
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.println("What Do You Want To Do (Add Item , Edit Item , Remove Item , Manage Requests , Add Discount Code , Help , Exit) , Enter Command Line : ");
            String command = scan.next();
            switch (command)
            {
                case "add" :
                {
                    String productType = scan.next();
                    switch (productType.toLowerCase())
                    {
                        case "digital" :
                        {
                            String productSubType = scan.next();
                            switch (productSubType.toLowerCase())
                            {
                                case "flash" :
                                {
                                    String productName = scan.next();
                                    int price = scan.nextInt();
                                    int amountAvailable = scan.nextInt();
                                    CategoryModel category = CategoryModel.DIGITAL;
                                    String companyName = scan.next();
                                    String dimensions = scan.next();
                                    int weight = scan.nextInt();
                                    int storageCapacity = scan.nextInt();
                                    int usbVersion = scan.nextInt();
                                    AdminControl.addFlashMemory(productName ,price , amountAvailable , companyName , dimensions , weight , storageCapacity , usbVersion);
                                    System.out.println("Product Added!");
                                    break;
                                }
                                case "pc" :
                                {
                                    String productName = scan.next();
                                    int price = scan.nextInt();
                                    int amountAvailable = scan.nextInt();
                                    CategoryModel category = CategoryModel.DIGITAL;
                                    String companyName = scan.next();
                                    String dimensions = scan.next();
                                    int weight = scan.nextInt();
                                    String cpuModel = scan.next();
                                    int ramCapacity = scan.nextInt();
                                    AdminControl.addPersonalComputer(productName , price , amountAvailable , companyName , dimensions , weight , cpuModel , ramCapacity);
                                    System.out.println("Product Added!");
                                    break;
                                }
                                case "ssd" :
                                {
                                    String productName = scan.next();
                                    int price = scan.nextInt();
                                    int amountAvailable = scan.nextInt();
                                    CategoryModel category = CategoryModel.DIGITAL;
                                    String companyName = scan.next();
                                    String dimension = scan.next();
                                    int weight = scan.nextInt();
                                    int storageCapacity = scan.nextInt();
                                    int readRate = scan.nextInt();
                                    int writeRate = scan.nextInt();
                                    AdminControl.addSolidStateDrive(productName , price , amountAvailable , companyName , dimension , weight , storageCapacity , readRate , writeRate);
                                    System.out.println("Product Added!");
                                    break;
                                }
                                default :
                                {
                                    System.out.println("Wrong Command");
                                }
                            }
                            break;
                        }
                        case "food" :
                        {
                            String productName = scan.next();
                            int price = scan.nextInt();
                            int amountAvailable = scan.nextInt();
                            int productionDate = scan.nextInt();
                            int expirationDate = scan.nextInt();
                            AdminControl.addFood(productName , price , amountAvailable , productionDate , expirationDate);
                            System.out.println("Product Added!");
                            break;
                        }
                        case "stationary" :
                        {
                            String productSubType = scan.next();

                            switch (productSubType.toLowerCase())
                            {
                                case "notebook" :
                                {
                                    String productName = scan.next();
                                    int price = scan.nextInt();
                                    int amountAvailable = scan.nextInt();
                                    String country = scan.next();
                                    int pageNumber = scan.nextInt();
                                    String paperType = scan.next();
                                    AdminControl.addNotebook(productName , price ,amountAvailable , country , pageNumber , paperType);
                                    System.out.println("Product Added!");
                                    break;
                                }
                                case "pen" :
                                {
                                    String productName = scan.next();
                                    int price = scan.nextInt();
                                    int amountAvailable = scan.nextInt();
                                    String country = scan.next();
                                    String penColor = scan.next();
                                    AdminControl.addPen(productName , price ,amountAvailable , country , penColor);
                                    System.out.println("Product Added!");
                                    break;
                                }
                                case "pencil" :
                                {
                                    String productName = scan.next();
                                    int price = scan.nextInt();
                                    int amountAvailable = scan.nextInt();
                                    String country = scan.next();
                                    String pencilType = scan.next();
                                    Pencil.type type = null;

                                    switch (pencilType.toLowerCase())
                                    {
                                        case "2h" :
                                        {
                                            type = Pencil.type._2H;
                                            break;
                                        }
                                        case "h" :
                                        {
                                            type = Pencil.type.H;
                                            break;
                                        }
                                        case "f" :
                                        {
                                            type = Pencil.type.F;
                                            break;
                                        }
                                        case "b" :
                                        {
                                            type = Pencil.type.B;
                                            break;
                                        }
                                        case "hb" :
                                        {
                                            type = Pencil.type.HB;
                                            break;
                                        }
                                    }
                                    AdminControl.addPencil(productName , price ,amountAvailable , country , type);
                                    System.out.println("Product Added!");
                                    break;
                                }
                                default :
                                {
                                    System.out.println("Wrong Command");
                                }
                            }
                            break;
                        }
                        case "vehicle" :
                        {
                            String productSubType = scan.next();

                            switch (productSubType.toLowerCase())
                            {
                                case "car" :
                                {
                                    String productName = scan.next();
                                    int price = scan.nextInt();
                                    int amountAvailable = scan.nextInt();
                                    String companyName = scan.next();
                                    int engineVolume = scan.nextInt();
                                    boolean isAuto = false;
                                    String isAutomatic = scan.next();
                                    if (isAutomatic.toLowerCase().equals("true"))
                                    {
                                        isAuto = true;
                                    }
                                    AdminControl.addCar(productName , price , amountAvailable , companyName , engineVolume , isAuto);
                                    System.out.println("Product Added!");
                                    break;
                                }
                                case "bicycle" :
                                {
                                    String productName = scan.next();
                                    int price = scan.nextInt();
                                    int amountAvailable = scan.nextInt();
                                    String companyName = scan.next();
                                    String bicycleType = scan.next();
                                    Bicycle.type type = null;

                                    switch (bicycleType.toLowerCase())
                                    {
                                        case "mountain" :
                                        {
                                            type = Bicycle.type.MOUNTAIN;
                                            break;
                                        }
                                        case "road" :
                                        {
                                            type = Bicycle.type.ROAD;
                                            break;
                                        }
                                        case "city" :
                                        {
                                            type = Bicycle.type.CITY;
                                            break;
                                        }
                                        case "hybrid" :
                                        {
                                            type = Bicycle.type.HYBRID;
                                            break;
                                        }
                                    }
                                    AdminControl.addBicycle(productName , price , amountAvailable , companyName , type);
                                    System.out.println("Product Added!");
                                    break;
                                }
                                default :
                                {
                                    System.out.println("Wrong Command");
                                }
                            }
                            break;
                        }
                        case "discountcode":
                        {
                            int i = 0;
                            int discount = scan.nextInt();
                            int capacity = scan.nextInt();
                            String username = scan.next();
                            if (discount <= 100 && discount > 0)
                            {
                                DiscountModel discountModel = new DiscountModel(discount, capacity);
                                AdminModel.getAdmin().getDiscounts().add(discountModel);
                                for (i = 0 ; i < AdminModel.getAdmin().getCustomers().size() ; i++)
                                {
                                    if (Objects.equals(AdminModel.getAdmin().getCustomers().get(i).getUsername(), username))
                                    {
                                        AdminModel.getAdmin().getCustomers().get(i).getDiscounts().add(discountModel);
                                        System.out.println("Discount Code " + discountModel.getCode() + " For " + discountModel.getDiscount() + "% Off For User " + AdminModel.getAdmin().getCustomers().get(i).getUsername() + " Created!");
                                        break;
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Discount Should Be Between 100% and 1%!");
                            }
                            break;
                        }
                        case "discount" :
                        {
                            int i = 0;
                            boolean foundProduct = false;
                            String productName = scan.next();
                            int discount = scan.nextInt();
                            int capacity = scan.nextInt();
                            for (i = 0 ; i < AdminModel.getAdmin().getAllProducts().size() ; i++)
                            {
                                if (Objects.equals(AdminModel.getAdmin().getAllProducts().get(i).getProductName(), productName))
                                {
                                    foundProduct = true;
                                    break;
                                }
                            }
                            if (foundProduct)
                            {
                                if (AdminModel.getAdmin().getAllProducts().get(i) instanceof DigitalProducts)
                                {
                                    ((DigitalProducts) AdminModel.getAdmin().getAllProducts().get(i)).addDiscount(discount , AdminModel.getAdmin().getAllProducts().get(i).getProductID() , capacity);
                                    System.out.println("Discount Added!");
                                }
                                else if (AdminModel.getAdmin().getAllProducts().get(i) instanceof Pen)
                                {
                                    ((Pen) AdminModel.getAdmin().getAllProducts().get(i)).addDiscount(discount , AdminModel.getAdmin().getAllProducts().get(i).getProductID() , capacity);
                                    System.out.println("Discount Added!");
                                }
                                else if (AdminModel.getAdmin().getAllProducts().get(i) instanceof Pencil)
                                {
                                    ((Pencil) AdminModel.getAdmin().getAllProducts().get(i)).addDiscount(discount , AdminModel.getAdmin().getAllProducts().get(i).getProductID() , capacity);
                                    System.out.println("Discount Added!");
                                }
                                else
                                {
                                    System.out.println("Invalid Product Type");
                                }
                            }
                            else
                            {
                                System.out.println("Product Was Not Found!");
                            }
                            break;
                        }
                        default :
                        {
                            System.out.println("Wrong Command");
                        }
                    }
                    break;
                }
                case "edit" :
                {
                    String editType = scan.next();

                    switch (editType.toLowerCase())
                    {
                        case "name" :
                        {
                            String productName = scan.next();
                            String to = scan.next();
                            String newName = scan.next();

                            try
                            {
                                if (AdminControl.editName(newName , productName) == 0)
                                {
                                    System.out.println("Product Edited!");
                                }
                                else
                                {
                                    System.out.println("Product Was Not Found!");
                                }
                            }
                            catch (ProductEditFailedException e)
                            {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case "price" :
                        {
                            String productName = scan.next();
                            String to = scan.next();
                            int newPrice = scan.nextInt();

                            if (AdminControl.editPrice(newPrice , productName) == 0)
                            {
                                System.out.println("Product Edited!");
                            }
                            else
                            {
                                System.out.println("Product Was Not Found!");
                            }
                            break;
                        }
                        case "amountavailable" :
                        {
                            String productName = scan.next();
                            String to = scan.next();
                            int newAmountAvailable = scan.nextInt();

                            if (AdminControl.editAmountAvailable(newAmountAvailable , productName) == 0)
                            {
                                System.out.println("Product Edited!");
                            }
                            else
                            {
                                System.out.println("Product Was Not Found!");
                            }
                            break;
                        }
                        default :
                        {
                            System.out.println("Wrong Command");
                        }
                    }
                    break;
                }
                case "remove" :
                {
                    String indicator = scan.next();
                    switch (indicator)
                    {
                        case "product" :
                        {
                            String productName = scan.next();

                            if (AdminControl.removeProduct(productName) == 0)
                            {
                                System.out.println("Product Removed!");
                            }
                            else
                            {
                                System.out.println("Product Was Not Found!");
                            }
                            break;
                        }
                        case "discountcode":
                        {
                            String code = scan.next();
                            boolean codeRemoved = false;
                            for (int i = 0 ; i < AdminModel.getAdmin().getDiscounts().size() ; i++)
                            {
                                if (Objects.equals(code, AdminModel.getAdmin().getDiscounts().get(i).getCode()))
                                {
                                    AdminModel.getAdmin().getDiscounts().remove(AdminModel.getAdmin().getDiscounts().get(i));
                                    for (CustomerModel customerModel : AdminModel.getAdmin().getCustomers())
                                    {
                                        customerModel.getDiscounts().remove(AdminModel.getAdmin().getDiscounts().get(i));
                                    }
                                    System.out.println("Code Removed!");
                                    codeRemoved = true;
                                    break;
                                }
                            }
                            if (!codeRemoved)
                            {
                                System.out.println("Code Doesn't Exist!");
                            }
                            break;
                        }
                        case "discount" :
                        {
                            int i = 0;
                            boolean foundProduct = false;
                            String productName = scan.next();
                            for (i = 0 ; i < AdminModel.getAdmin().getAllProducts().size() ; i++)
                            {
                                if (Objects.equals(AdminModel.getAdmin().getAllProducts().get(i).getProductName(), productName))
                                {
                                    foundProduct = true;
                                    break;
                                }
                            }
                            if (foundProduct)
                            {
                                if (AdminModel.getAdmin().getAllProducts().get(i) instanceof DigitalProducts)
                                {
                                    ((DigitalProducts) AdminModel.getAdmin().getAllProducts().get(i)).removeDiscount(AdminModel.getAdmin().getAllProducts().get(i).getProductID());
                                }
                                else if (AdminModel.getAdmin().getAllProducts().get(i) instanceof Pen)
                                {
                                    ((Pen) AdminModel.getAdmin().getAllProducts().get(i)).removeDiscount(AdminModel.getAdmin().getAllProducts().get(i).getProductID());
                                }
                                else if (AdminModel.getAdmin().getAllProducts().get(i) instanceof Pencil)
                                {
                                    ((Pencil) AdminModel.getAdmin().getAllProducts().get(i)).removeDiscount(AdminModel.getAdmin().getAllProducts().get(i).getProductID());
                                }
                                else
                                {
                                    System.out.println("Invalid Product Type");
                                }
                            }
                            else
                            {
                                System.out.println("Product Was Not Found!");
                            }
                            break;
                        }
                        default :
                        {
                            System.out.println("Wrong Command!");
                        }
                    }
                }
                case "manage" :
                {
                    String manageMethod = scan.next();

                    switch (manageMethod.toLowerCase())
                    {
                        case "signup" :
                        {
                            if (!AdminModel.getAdmin().getSignupRequests().isEmpty())
                            {
                                for (int i = 0 ; i < AdminModel.getAdmin().getSignupRequests().size() ; i++)
                                {
                                    System.out.println(i + ". " + AdminModel.getAdmin().getSignupRequests().toString());
                                }
                                System.out.println("Enter Request Index : ");
                                int cmd = scan.nextInt();

                                if (AdminModel.getAdmin().getSignupRequests().get(cmd) != null)
                                {
                                    System.out.println("What Do You Want To Do (1.Accept , 2.Decline)");
                                    int indicator = scan.nextInt();
                                    if (AdminControl.manageSignupRequest(AdminModel.getAdmin().getSignupRequests().get(cmd) , indicator) == 0)
                                    {
                                        System.out.println("Request Accepted!");
                                    }
                                    else
                                    {
                                        System.out.println("Request Declined!");
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("List Is Empty!");
                            }
                            break;
                        }
                        case "addfund" :
                        {
                            if (!AdminModel.getAdmin().getAddFundRequests().isEmpty())
                            {
                                for (int i = 0 ; i < AdminModel.getAdmin().getAddFundRequests().size() ; i++)
                                {
                                    System.out.println(i + ". " + AdminModel.getAdmin().getAddFundRequests().toString());
                                }
                                System.out.println("Enter Request Index : ");
                                int cmd = scan.nextInt();

                                if (AdminModel.getAdmin().getAddFundRequests().get(cmd) != null)
                                {
                                    System.out.println("What Do You Want To Do (1.Accept , 2.Decline)");
                                    int indicator = scan.nextInt();
                                    if (AdminControl.manageAddFundRequest(AdminModel.getAdmin().getAddFundRequests().get(cmd) , indicator) == 0)
                                    {
                                        System.out.println("Request Accepted!");
                                    }
                                    else
                                    {
                                        System.out.println("Request Declined!");
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("List Is Empty!");
                            }
                            break;
                        }
                        case "review" :
                        {
                            if (!AdminModel.getAdmin().getReviewRequests().isEmpty())
                            {
                                for (int i = 0 ; i < AdminModel.getAdmin().getReviewRequests().size() ; i++)
                                {
                                    System.out.println(i + ". " + AdminModel.getAdmin().getReviewRequests().toString());
                                }
                                System.out.println("Enter Request Index : ");
                                int cmd = scan.nextInt();

                                if (AdminModel.getAdmin().getReviewRequests().get(cmd) != null)
                                {
                                    System.out.println("What Do You Want To Do (1.Accept , 2.Decline)");
                                    int indicator = scan.nextInt();
                                    if (AdminControl.manageReviewRequest(AdminModel.getAdmin().getReviewRequests().get(cmd) , indicator) == 0)
                                    {
                                        System.out.println("Request Accepted!");
                                    }
                                    else
                                    {
                                        System.out.println("Request Declined!");
                                    }
                                }
                                else
                                {
                                    System.out.println("List Is Empty!");
                                }
                            }
                            break;
                        }
                        default :
                        {
                            System.out.println("Wrong Command");
                        }
                    }
                    break;
                }
                case "help" :
                {
                    System.out.println("For Adding product enter this : add + product type + product subType + details");
                    System.out.println("For Editing Product enter this : edit + name/price/amountAvailable/discount + productName + to + new name/price/amountAvailable/discount + capacity");
                    System.out.println("For Removing product enter this : remove + product + productName");
                    System.out.println("For Seeing available requests enter this : manage + signup/addfund/review");
                    System.out.println("For Adding Discount Codes Enter this : add + discount + percent + capacity + username (only number no % sign)");
                    System.out.println("For Removing Discount Codes Enter This : remove + discount + code");
                    break;
                }
                case "exit" :
                {
                    userWantToExit = true;
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerMenu.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    break;
                }
                default :
                {
                    System.out.println("Wrong Command");
                }
            }
        }
    }
}
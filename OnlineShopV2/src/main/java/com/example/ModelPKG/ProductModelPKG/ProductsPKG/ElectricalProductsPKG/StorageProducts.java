package com.example.ModelPKG.ProductModelPKG.ProductsPKG.ElectricalProductsPKG;
public abstract class StorageProducts extends DigitalProducts
{
    final private int storageCapacity;

    StorageProducts(String productName , int price , int amountAvailable , String companyName , String dimensions , int weight , int storageCapacity)
    {
        super(productName , price , amountAvailable , companyName , dimensions , weight);
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString()
    {
        return super.toString() + " , Storage Capacity : " + storageCapacity + "\n";
    }
}

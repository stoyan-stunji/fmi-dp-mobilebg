package Products.Bicycles;

import Products.Enums.*;
import Products.Product;

public class Bicycle extends Product
{
    private Brand brand;
    private BicycleType bicycleType;

    public Bicycle(Double price, Brand brand, BicycleType bicycleType)
    {
        super(price);
        this.brand = brand;
        this.bicycleType = bicycleType;
    }
}

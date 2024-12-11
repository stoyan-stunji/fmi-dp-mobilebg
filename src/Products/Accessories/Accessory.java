package Products.Accessories;

import Products.*;
import Products.Enums.*;

public class Accessory extends Product
{
    private ForVehicle forVehicle;
    private Category category;

    public Accessory(Double price, ForVehicle forVehicle, Category category)
    {
        super(price);
        this.forVehicle = forVehicle;
        this.category = category;
    }
}

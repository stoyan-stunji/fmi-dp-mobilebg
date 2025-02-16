package Products.StreetIllegalVehicles;

import Products.Product;
import Products.Enums.StreetIllegalVehicleType;

// Street Illegal Vehicle =def= {Agricultural, Industrial, Curry, Caravan, Yacht, Trailer};

public class StreetIllegalVehicle extends Product
{
    private final StreetIllegalVehicleType streetIllegalVehicleType;
    private final Integer year;

    public StreetIllegalVehicle(Double price, StreetIllegalVehicleType streetIllegalVehicleType, Integer year)
    {
        super(price);
        this.streetIllegalVehicleType = streetIllegalVehicleType;
        this.year = year;
    }

    public StreetIllegalVehicleType getType()
    {
        return this.streetIllegalVehicleType;
    }

    public Integer getYear()
    {
        return this.year;
    }
}

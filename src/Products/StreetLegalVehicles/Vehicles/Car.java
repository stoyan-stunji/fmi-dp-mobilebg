package Products.StreetLegalVehicles.Vehicles;

import Products.StreetLegalVehicles.*;
import Products.Enums.*;

public class Car extends StreetLegalVehicle
{
    // TO::DO Add specialized members;

    public Car(Double price, Brand brand, Model model, Integer year,
               Engine engine, Gearbox gearbox)
    {
        super(price, brand, model, year, engine, gearbox);
    }
}

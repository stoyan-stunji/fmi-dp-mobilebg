package Products.StreetLegalVehicles;

import Products.Product;
import Products.Enums.*;

// Street Legal Vehicle =def= {Car, Truck, Bus, Motorcycle};

public class StreetLegalVehicle extends Product
{
    protected Brand brand;
    protected Model model;
    protected Integer year;
    protected Engine engine;
    protected Gearbox gearbox;

    public StreetLegalVehicle(Double price, Brand brand, Model model,
                              Integer year, Engine engine, Gearbox gearbox)
    {
        super(price);

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.gearbox = gearbox;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public Model getModel()
    {
        return model;
    }

    public Integer getYear()
    {
        return year;
    }

    public Engine getEngine()
    {
        return engine;
    }

    public Gearbox getGearbox()
    {
        return gearbox;
    }
}


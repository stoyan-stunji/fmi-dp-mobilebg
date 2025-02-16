package Products;

import Products.Enums.*;
import Products.StreetLegalVehicles.Vehicles.*;
import Products.StreetLegalVehicles.*;
import Products.StreetIllegalVehicles.Vehicles.*;
import Products.StreetIllegalVehicles.*;
import Products.Bicycles.*;

import java.util.Scanner;

public class ProductFactory
{
    private static Scanner scanner = new Scanner(System.in);

    public static Product createProduct()
    {
        System.out.println("Select product type: \n1. Car\n2. Truck\n3. Bicycle\n4. Yacht");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Product product = null;

        switch (choice) {
            case 1:
                product = createStreetLegalVehicle(new CarCreator());
                break;
            case 2:
                product = createStreetLegalVehicle(new TruckCreator());
                break;
            case 3:
                product = createBicycle();
                break;
            case 4:
                product = createStreetIllegalVehicle(new YachtCreator());
                break;
            default:
                System.out.println("Invalid choice!");
        }

        return product;
    }

    private static StreetLegalVehicle createStreetLegalVehicle(VehicleCreator creator)
    {
        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter Brand: ");
        String brandName = scanner.nextLine();

        System.out.println("Enter Model: ");
        String modelName = scanner.nextLine();

        System.out.println("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Engine: ");
        String engineType = scanner.nextLine();

        System.out.println("Enter Gearbox: ");
        String gearboxType = scanner.nextLine();

        return creator.create(price, Brand.Default, Model.Default, year, Engine.Default, Gearbox.Default);
    }

    private static StreetIllegalVehicle createStreetIllegalVehicle(StreetIllegalVehicleCreator creator)
    {
        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter Type (Agricultural, Industrial, etc.): ");
        String type = scanner.nextLine();

        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        return creator.create(price, StreetIllegalVehicleType.Default, year);
    }

    private static Bicycle createBicycle()
    {
        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter Brand: ");
        String brandName = scanner.nextLine();

        System.out.println("Enter Type (Mountain, Road, etc.): ");
        String bikeType = scanner.nextLine();

        return new Bicycle(price, Brand.Default, BicycleType.Default);
    }

    interface VehicleCreator
    {
        StreetLegalVehicle create(double price, Brand brand, Model model, int year, Engine engine, Gearbox gearbox);
    }

    interface StreetIllegalVehicleCreator
    {
        StreetIllegalVehicle create(double price, StreetIllegalVehicleType vehicleType, int year);
    }

    static class CarCreator implements VehicleCreator
    {
        public StreetLegalVehicle create(double price, Brand brand, Model model, int year, Engine engine, Gearbox gearbox) {
            return new Car(price, brand, model, year, engine, gearbox);
        }
    }

    static class TruckCreator implements VehicleCreator
    {
        public StreetLegalVehicle create(double price, Brand brand, Model model, int year, Engine engine, Gearbox gearbox) {
            return new Truck(price, brand, model, year, engine, gearbox);
        }
    }

    static class YachtCreator implements StreetIllegalVehicleCreator
    {
        public StreetIllegalVehicle create(double price, StreetIllegalVehicleType vehicleType, int year) {
            return new Yacht(price, vehicleType, year);
        }
    }
}

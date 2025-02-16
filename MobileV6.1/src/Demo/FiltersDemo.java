package Demo;

import Filters.FieldExtractor;
import Filters.Filter;
import Filters.RespectiveFilters.ExactValueFilter;
import Filters.RespectiveFilters.RangeFilter;
import Listings.Listing;
import Listings.Repository.ListingRepository;
import Listings.Repository.ListingRepositoryImplementation;
import Listings.Service.ListingService;
import Listings.Service.ListingServiceImplementation;
import Products.Enums.*;
import Products.Parts.Part;
import Products.Product;
import Products.StreetIllegalVehicles.Vehicles.Yacht;
import Products.StreetLegalVehicles.Vehicles.Bus;
import Products.StreetLegalVehicles.Vehicles.Car;
import Products.StreetLegalVehicles.Vehicles.Motorcycle;
import Products.StreetLegalVehicles.Vehicles.Truck;
import Regions.Region;
import Subscribtions.Service.SubscribtionService;
import User.Repository.UserRepository;
import User.Repository.UserRepositoryImplementation;
import User.Roles.Dealership;
import User.Roles.Guest;
import User.Roles.RegisteredUser;
import User.Service.UserService;
import User.Service.UserServiceImplementation;

import java.util.List;

public class FiltersDemo
{
    public static void main(String[] args)
    {
        UserRepository userRepository = new UserRepositoryImplementation();
        UserService userService = new UserServiceImplementation(userRepository);

        Region r1 = new Region("Sliven", "Sliven");
        Region r2 = new Region("Sofia", "Sofia");
        Region r3 = new Region("Plovdiv", "Plovdiv");

        try
        {
            userService.addUser(new RegisteredUser("100", "StoyanStoyanovIvanov", "sustoyanivanov2@gmail.com", "123123123", r1, "089 089 4567"));
            userService.addUser(new RegisteredUser("200", "JessicaSamiBidgerano", "jessicab@abv.bg", "321321321", r2, "678 456 6789"));
            userService.addUser(new Dealership("300", "KrisRumenovStoimenov", "kris_stoimenov@email.com", "456789123", "Kris' Cars", "088 456 7890", r3));
            userService.addUser(new Guest("400"));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

        ListingRepository listingRepository = new ListingRepositoryImplementation();
        SubscribtionService subscribtionService = new SubscribtionService();
        ListingService listingService = new ListingServiceImplementation(listingRepository, userService, subscribtionService);

        Product p1 = new Car(1000.0, Brand.Honda, Model.CRV, 2011, Engine.Benzin, Gearbox.Manual);
        Product p2 = new Bus(1500.0, Brand.VW, Model.Cherry, 1986, Engine.Benzin, Gearbox.SemiAutomatic);
        Product p3 = new Truck(6000.0, Brand.Man, Model.Mack, 2017, Engine.Diesel, Gearbox.Automatic);
        Product p4 = new Motorcycle(750.0, Brand.HarleyDavidson, Model.Hummer, 1997, Engine.Benzin, Gearbox.Manual);
        Product p5 = new Part(50.0, "Door For Taxi", 2015);
        Product p6 = new Yacht(5000.0, StreetIllegalVehicleType.Jet, 2015);

        Listing l1 = new Listing("1a", p1, r1, "100", "10.10.24", false, "Honda CRV 2011");
        Listing l2 = new Listing("2b", p2, r2, "200", "11.11.24", false, "VW Cherry 1986");
        Listing l3 = new Listing("3c", p3, r1, "300", "12.12.24", false, "Man Mack 2017");
        Listing l4 = new Listing("4d", p4, r2, "300", "15.12.24", false, "Harley Hummer 1997");
        Listing l5 = new Listing("5e", p5, r3, "300", "16.12.24", false, "Taxi Door");
        Listing l6 = new Listing("6f", r2, "100", "13.12.25", true, "Tyre Change in Sofia!");
        Listing l7 = new Listing("7g", p6, r3, "200", "12.04.27", true, "Yacht Jet 2015");

        try
        {
            listingService.addListing(l1, "100");
            listingService.addListing(l2, "200");
            listingService.addListing(l4, "300");
            listingService.addListing(l5, "300");
            listingService.addListing(l6, "100");
            listingService.addListing(l7, "200");
        }
        catch (UnsupportedOperationException e)
        {
            System.out.println(e.getMessage());
        }

        FieldExtractor<Listing, Double> priceExtractor = listing -> listing.getProduct() != null ? listing.getProduct().getPrice() : null;
        Filter<Listing> priceFilter = new RangeFilter<>(priceExtractor, 500.0, 3000.0);

        FieldExtractor<Listing, Region> regionExtractor = Listing::getRegion;
        Filter<Listing> regionFilter = new ExactValueFilter<>(regionExtractor, r1);

        List<Listing> listingsByPrice = listingService.searchByFilter(priceFilter);
        System.out.println(listingsByPrice);

        List<Listing> listingsByRegion = listingService.searchByFilter(regionFilter);
        System.out.println(listingsByRegion);
    }
}

package Demo;

import Filters.FieldExtractor;
import Filters.RespectiveFilters.ExactValueFilter;
import Filters.RespectiveFilters.RangeFilter;
import Filters.CompositeFilters.AndFilter;
import Listings.Repository.ListingRepositoryImplementation;
import Listings.Service.ListingService;
import Listings.Service.ListingServiceImplementation;
import Products.Enums.Brand;
import Products.Enums.Engine;
import Products.Enums.Gearbox;
import Products.Enums.Model;
import Products.StreetLegalVehicles.Vehicles.Car;
import Regions.Region;
import Subscribtions.Notifiers.SmsNotifier;
import Subscribtions.Service.SubscribtionRule;
import Subscribtions.Service.SubscribtionService;
import Subscribtions.Subscribtions.SmsSubscribtion;
import User.Repository.UserRepository;
import User.Repository.UserRepositoryImplementation;
import User.Service.UserService;
import User.Service.UserServiceImplementation;
import Listings.Listing;

import java.util.List;

public class SubscribtionsDemo
{
    public static void main(String[] args)
    {
        UserRepository userRepository = new UserRepositoryImplementation();
        UserService userService = new UserServiceImplementation(userRepository);

        SubscribtionService subscribtionService = new SubscribtionService();
        ListingService listingService = new ListingServiceImplementation(new ListingRepositoryImplementation(), userService, subscribtionService);

        ExactValueFilter<Listing, Brand> brandFilter = new ExactValueFilter<>(new FieldExtractor<Listing, Brand>()
        {
            public Brand extractValue(Listing item) {
                if (item.getProduct() instanceof Car) {
                    return ((Car) item.getProduct()).getBrand();
                }
                return null;
            }
        }, Brand.AlfaRomeo);

        RangeFilter<Listing, Double> priceFilter = new RangeFilter<>(new FieldExtractor<Listing, Double>()
        {
            public Double extractValue(Listing item) {
                return item.getProduct().getPrice();
            }
        }, 10000.0, 20000.0);

        AndFilter<Listing> andFilter = new AndFilter<>(List.of(brandFilter, priceFilter));

        subscribtionService.subscribe(new SubscribtionRule(andFilter, new SmsSubscribtion(new SmsNotifier(), "089 987 5678")));

        Listing listing = new Listing("1a", new Car(15000.0, Brand.AlfaRomeo, Model.Cherry, 1997, Engine.Benzin, Gearbox.Manual), new Region("Stara Zagora", "Stara Zagora"), "Philip Yankov", "2025-12-31", true, "Alfa Romeo, nov vnos!");

        listingService.addListing(listing, "100");
    }
}

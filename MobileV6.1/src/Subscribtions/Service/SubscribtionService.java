package Subscribtions.Service;

import Filters.Filter;
import Listings.Listing;

import java.util.ArrayList;
import java.util.List;

public class SubscribtionService
{
    private final List<SubscribtionRule> subscribtionRules = new ArrayList<>();

    public void subscribe(SubscribtionRule rule)
    {
        subscribtionRules.add(rule);
    }

    public void newListingAdded(Listing listing)
    {
        for (SubscribtionRule rule : subscribtionRules)
        {
            boolean shouldNotify = rule.filter().visit(listing); 

            if (shouldNotify) {
                String message = listing.getProduct()
                        + " " + listing.getDescription()
                        + " " + listing.getProduct().getPrice();
                rule.type().update("New product found for you!", message);
            }
        }
    }
}

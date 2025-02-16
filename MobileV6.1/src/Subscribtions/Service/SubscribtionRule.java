package Subscribtions.Service;

import Filters.Filter;
import Listings.Listing;
import Subscribtions.Subscribtions.SubscribtionType;

public record SubscribtionRule(
        Filter<Listing> filter,
        SubscribtionType type
) {}
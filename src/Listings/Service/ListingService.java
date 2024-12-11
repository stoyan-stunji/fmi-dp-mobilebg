package Listings.Service;

import java.util.List;

import Listings.*;
import Filters.*;

public interface ListingService
{
    void addListing(Listing listing, String userId);
    void deleteById(String listingId, String userId);
    List<Listing> searchByFilter(Filter<Listing> filter);
}

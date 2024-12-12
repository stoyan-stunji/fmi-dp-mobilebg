package Listings.Repository;

import Listings.Listing;

import java.util.List;

public interface ListingRepository
{
    void addToRepo(Listing listing);
    void deleteById(String id);
    Listing findById(String id);
    List<Listing> findAll();
}


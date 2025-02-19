package Listings.Repository;

import Listings.Listing;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListingRepositoryImplementation implements ListingRepository
{
    private final List<Listing> listings = new ArrayList<>();

    public void addToRepo(Listing listing)
    {
        deleteById(listing.getId());
        listings.add(listing);
    }

    public void deleteById(String id)
    {
        listings.removeIf(listing -> listing.getId().equals(id));
    }

    public Listing findById(String id)
    {
        for (Listing listing : listings)
        {
            if(listing.getId().equals(id))
            {
                return listing;
            }
        }

        return null;
    }

    public List<Listing> findAll()
    {
        return new ArrayList<>(listings);
    }

    public List<Listing> findListingsByUserId(String userId) {
        return listings.stream()
                .filter(listing -> listing.getOwnerId().equals(userId)) // Assuming Listing has getUserId method
                .collect(Collectors.toList());
    }

}

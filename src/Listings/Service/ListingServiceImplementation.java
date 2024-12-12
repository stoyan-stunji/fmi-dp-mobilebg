package Listings.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Listings.*;
import Listings.Repository.ListingRepository;
import User.*;
import User.Service.*;
import User.Roles.*;
import Filters.*;

public class ListingServiceImplementation implements ListingService
{
    private final ListingRepository listingRepository;
    private final UserService userService;

    public ListingServiceImplementation(ListingRepository listingRepository, UserService userService)
    {
        this.listingRepository = listingRepository;
        this.userService = userService;
    }

    public List<Listing> searchByFilter(Filter<Listing> filter)
    {
        return listingRepository.findAll().stream().filter(filter::matches).collect(Collectors.toList());
    }

    public void addListing(Listing listing, String userId)
    {
        UserType user = userService.getUserById(userId);

        if (user instanceof Guest)
        {
            throw new UnsupportedOperationException("ListingServiceImplementation::guest_CANNOT_add_listings");
        }

        listingRepository.addToRepo(listing);
    }

    public void deleteById(String listingId, String userId)
    {
        UserType user = userService.getUserById(userId);

        if (user instanceof Guest)
        {
            throw new UnsupportedOperationException("ListingServiceImplementation::guest_CANNOT_delete_listings");
        }

        listingRepository.deleteById(listingId);
    }
}


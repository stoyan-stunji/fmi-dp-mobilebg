package Commands.ForListings;

import Commands.Command;
import Listings.Service.ListingService;
import Listings.Listing;

import java.util.List;

public class ShowAllListingsCommand implements Command
{
    private final ListingService listingService;
    private final String userId;

    public ShowAllListingsCommand(ListingService listingService, String userId)
    {
        this.listingService = listingService;
        this.userId = userId;
    }

    public void execute()
    {
        List<Listing> listings = listingService.getListingsByUser(userId);

        for (Listing listing : listings)
        {
            System.out.println(listing.toString() + '\n');
        }
    }
}

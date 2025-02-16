package Commands.ForListings;

import Commands.Command;
import Listings.Listing;
import Listings.Service.ListingService;

public class AddListingCommand implements Command
{
    private final ListingService listingService;
    private final Listing listing;
    private final String userId;

    public AddListingCommand(ListingService listingService, Listing listing, String userId) {
        this.listingService = listingService;
        this.listing = listing;
        this.userId = userId;
    }

    public void execute()
    {
        listingService.addListing(listing, userId);
    }
}

package Commands.ForListings;


import Commands.Command;
import Listings.Service.ListingService;

public class DeleteListingCommand implements Command
{
    private final ListingService listingService;
    private final String listingId;
    private final String userId;

    public DeleteListingCommand(ListingService listingService, String listingId, String userId)
    {
        this.listingService = listingService;
        this.listingId = listingId;
        this.userId = userId;
    }

    public void execute()
    {
        listingService.deleteById(listingId, userId);
    }
}

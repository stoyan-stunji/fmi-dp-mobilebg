package Demo;

import History.ListingHistory.ListingCaretaker;
import History.ListingHistory.ListingOriginator;
import Listings.Listing;

public class ListingHistoryDemo
{
    public static void main(String[] args)
    {
        Listing listing = new Listing("100", null, null, "1", "2024-12-31", false, "(0) Initial Description");

        ListingOriginator originator = new ListingOriginator(listing);
        ListingCaretaker caretaker = new ListingCaretaker();

        caretaker.saveState(originator.saveToMemento());

        listing.setDescription("(1) First Update");
        listing.setExpiryDate("2025-01-15");

        originator.setListing(listing);
        caretaker.saveState(originator.saveToMemento());

        listing.setDescription("(2) Second Update");
        listing.setExpiryDate("2025-06-30");

        originator.setListing(listing);
        caretaker.saveState(originator.saveToMemento());

        System.out.println("Latest Listing Description: "
                + originator.getListing().getDescription() + " " + originator.getListing().getExpiryDate());

        originator.restoreFromMemento(caretaker.restoreState(1));
        System.out.println("Restored Listing Description: "
                + originator.getListing().getDescription() + " " + originator.getListing().getExpiryDate());

        originator.restoreFromMemento(caretaker.restoreState(2));
        System.out.println("Restored Listing Description: "
                + originator.getListing().getDescription() + " " + originator.getListing().getExpiryDate());
    }
}

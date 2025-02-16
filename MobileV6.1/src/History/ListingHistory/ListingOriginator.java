package History.ListingHistory;

import Listings.Listing;

public class ListingOriginator
{
    private Listing currentListing;

    public ListingOriginator(Listing listing)
    {
        this.currentListing = listing;
    }

    public void setListing(Listing listing)
    {
        this.currentListing = listing;
    }

    public Listing getListing()
    {
        return this.currentListing;
    }

    public ListingMemento saveToMemento()
    {
        return new ListingMemento(this.currentListing.getCopy());
    }

    public void restoreFromMemento(ListingMemento memento)
    {
        this.currentListing = memento.getListingSnapshot();
    }
}

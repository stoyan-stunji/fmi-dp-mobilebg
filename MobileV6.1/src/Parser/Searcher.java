package Parser;

import java.util.List;

import Listings.Listing;

public interface Searcher
{
    List<Listing> search(List<Listing> listings, String query);
}

package Parser;

import Listings.Listing;
import Products.Enums.Brand;
import Products.Enums.Engine;
import Products.Enums.Gearbox;
import Products.Enums.Model;
import Products.Product;
import Products.StreetLegalVehicles.Vehicles.Car;
import Regions.Region;

import java.util.List;
import java.util.Map;

public class QueryTester
{
    public static Product c1 = new Car(10000.0, Brand.BMW, Model.x5, 2000, Engine.Benzin, Gearbox.Manual);
    public static Product c2 = new Car(7000.0, Brand.BMW, Model.e60, 2005, Engine.Benzin, Gearbox.Manual);
    public static Product c3 = new Car(5000.0, Brand.Audi, Model.a4, 2001, Engine.Benzin, Gearbox.Manual);
    public static Product c4 = new Car(5000.0, Brand.Audi, Model.a4, 2003, Engine.Benzin, Gearbox.Manual);

    public static Listing l1 = new Listing("1", c1, new Region("Sofia", "Sofia"), "100", "10.01.25", false, "desc");
    public static Listing l2 = new Listing("2", c2, new Region("Sofia", "Sofia"), "100", "10.01.25", false, "desc");
    public static Listing l3 = new Listing("3", c3, new Region("Sofia", "Sofia"), "100", "10.01.25", false, "desc");
    public static Listing l4 = new Listing("4", c4, new Region("Sofia", "Sofia"), "100", "10.01.25", false, "desc");

    public final static List<Listing> EXAMPLE_LISTINGS = List.of(l1, l2, l3, l4);

    public final static Map<String, List<Listing>> QUERY_TO_EXPECTED_RESULTS = Map.of(
        //"brand = 'bmw'", List.of(l1, l2),
        //"year < 2002", List.of(l1, l3),
        //"brand = 'bmw' | model = 'a4'", List.of(l1, l2, l3, l4),
        "( brand = 'bmw' & model = 'x5' ) | ( brand = 'audi' & model = 'a4' & year > 2002 )", List.of(l1, l3)
    );

    public void test(Searcher searcher)
    {
        QUERY_TO_EXPECTED_RESULTS.forEach((query, expected) -> test(searcher, query, expected));
    }

    private void test(Searcher searcher, String query, List<Listing> expected)
    {
        try {
            List<Listing> result = searcher.search(EXAMPLE_LISTINGS, query);
            if (result.equals(expected)) {
                System.out.println("Query: " + query + " passed :)");
            } else {
                System.out.println("Query: " + query + " failed :(");
                System.out.println("Expected: " + expected);
                System.out.println("Got: " + result);
            }
        } catch (Exception e) {
            System.out.println("Query: " + query + " failed with exception :(");
            System.out.println("Exception: " + e);
        }
    }
}

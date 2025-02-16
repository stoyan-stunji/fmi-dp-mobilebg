package Demo;

import History.ProductHistory.ProductCaretaker;
import History.ProductHistory.ProductGraph;
import History.ProductHistory.ProductOriginator;
import Listings.Listing;
import Products.Enums.Brand;
import Products.Enums.Engine;
import Products.Enums.Gearbox;
import Products.Enums.Model;
import Products.Product;
import Products.StreetLegalVehicles.Vehicles.Car;
import Regions.Region;

import javax.swing.*;

public class ProductHistoryDemo
{
    public static void main(String[] args)
    {
        Region r1 = new Region("Sliven", "Sliven");
        Product p1 = new Car(1000.0, Brand.Honda, Model.CRV, 2011, Engine.Benzin, Gearbox.Manual);
        Listing l1 = new Listing("1a", p1, r1, "100", "10.10.24", false, "Honda CRV 2011");

        ProductOriginator originator = new ProductOriginator(l1.getProduct());
        ProductCaretaker caretaker = new ProductCaretaker();

        caretaker.saveState(originator.saveToMemento(), "30.01.2015");

        l1.getProduct().setPrice(1200.0);
        originator.setProduct(l1.getProduct());
        caretaker.saveState(originator.saveToMemento(), "31.01.2015");

        l1.getProduct().setPrice(700.0);
        originator.setProduct(l1.getProduct());
        caretaker.saveState(originator.saveToMemento(), "01.02.2015");

        l1.getProduct().setPrice(1100.0);
        originator.setProduct(l1.getProduct());
        caretaker.saveState(originator.saveToMemento(), "02.02.2015");

        System.out.println("(3) Latest: " + originator.getProduct().getPrice());

        originator.restoreFromMemento(caretaker.restoreState(1));
        System.out.println("(2) Restored: " + originator.getProduct().getPrice());

        originator.restoreFromMemento(caretaker.restoreState(2));
        System.out.println("(1) Restored: " + originator.getProduct().getPrice());

        originator.restoreFromMemento(caretaker.restoreState(3));
        System.out.println("(0) Initial: " + originator.getProduct().getPrice());

        ProductGraph productGraph = new ProductGraph(caretaker);

        JFrame frame = new JFrame("Product Price History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(productGraph);
        frame.setVisible(true);
    }
}

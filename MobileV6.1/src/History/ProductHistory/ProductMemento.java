package History.ProductHistory;

import Products.Product;

public class ProductMemento
{
    private final Product productSnapshot;

    public ProductMemento(Product product)
    {
        this.productSnapshot = product;
    }

    public Product getProductSnapshot()
    {
        return this.productSnapshot;
    }
}

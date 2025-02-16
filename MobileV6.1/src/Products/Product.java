package Products;

public class Product
{
    protected Double price;

    public Product(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product clone() {
        return new Product(this.price);
    }
}

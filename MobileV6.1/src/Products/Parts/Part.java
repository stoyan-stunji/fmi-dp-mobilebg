package Products.Parts;

import Products.Product;

public class Part extends Product
{
    private String description;
    private Integer year;

    public Part(Double price, String description, Integer year)
    {
        super(price);
        this.description = description;
        this.year = year;
    }

    public String getDescription()
    {
        return this.description;
    }

    public Integer getYear()
    {
        return this.year;
    }
}

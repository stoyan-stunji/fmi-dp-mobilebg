package Listings;

import Products.*;
import Regions.*;

public record Listing
        (
                String id,

                Product product,
                Region region,

                String ownerId,
                String expiryDate,

                Boolean isVip,
                String description,

                Boolean isService
        )
{
    public Listing(String id, Product product, Region region, String ownerId, String expiryDate,
                   Boolean isVip, String description)
    {
        this(id, product, region, ownerId, expiryDate, isVip, description, false);
    }

    public Listing(String id, Region region, String ownerId, String expiryDate, Boolean isVip,
                   String description)
    {
        this(id, null, region, ownerId, expiryDate, isVip, description, true);
    }

    public String getId()
    {
        return this.id;
    }

    public Region getRegion()
    {
        return this.region;
    }

    public Product getProduct()
    {
        return this.product;
    }

    public String getOwnerId()
    {
        return this.ownerId;
    }

    public String getExpiryDate()
    {
        return this.expiryDate;
    }

    public Boolean getIsVip()
    {
        return this.isVip;
    }

    public String getDescription()
    {
        return this.description;
    }

    public Boolean getIsService() {
        return this.isService;
    }

}

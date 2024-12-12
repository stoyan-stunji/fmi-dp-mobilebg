package User.Roles;

import User.UserType;
import Regions.Region;

public class Dealership extends UserType
{
    private final String userName;
    private final String email;
    private final String password;

    private final String name;
    private final String contactInfo;
    private final Region region;

    public Dealership(String id, String userName, String email, String password,
                      String name, String contactInfo, Region region)
    {
        super(id);
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.name = name;
        this.contactInfo = contactInfo;
        this.region = region;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getName()
    {
        return this.name;
    }

    public String getContactInfo()
    {
        return this.contactInfo;
    }

    public Region getRegion()
    {
        return this.region;
    }
}

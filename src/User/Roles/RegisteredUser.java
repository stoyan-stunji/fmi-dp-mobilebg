package User.Roles;

import User.UserType;
import Regions.Region;

public class RegisteredUser extends UserType
{
    private final String userName;
    private final String email;
    private final String password;
    private final Region region;

    public RegisteredUser(String id, String userName, String email, String password, Region region)
    {
        super(id);
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.region = region;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public Region getRegion()
    {
        return this.region;
    }
}

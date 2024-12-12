package User;

public abstract class UserType
{
    protected final String id;

    public UserType(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }
}

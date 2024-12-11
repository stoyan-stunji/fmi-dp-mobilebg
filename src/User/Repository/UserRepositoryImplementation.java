package User.Repository;

import User.UserType;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImplementation implements UserRepository
{
    private final Map<String, UserType> storage = new HashMap<>();
    
    public void addToRepo(UserType user)
    {
        storage.put(user.getId(), user);
    }

    public void deleteById(String id)
    {
        storage.remove(id);
    }

    public UserType findById(String id)
    {
        return storage.get(id);
    }

}
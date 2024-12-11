package User.Repository;

import User.UserType;

import java.util.Map;

public interface UserRepository
{
    void addToRepo(UserType user);
    void deleteById(String id);
    UserType findById(String id);
}
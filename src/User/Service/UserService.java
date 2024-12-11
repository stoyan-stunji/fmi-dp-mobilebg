package User.Service;

import User.UserType;

public interface UserService
{
    void addUser(UserType user);
    void deleteUser(String id);
    UserType getUserById(String id);
}
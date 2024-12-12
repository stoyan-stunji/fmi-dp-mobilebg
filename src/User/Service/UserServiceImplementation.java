package User.Service;

import User.Repository.UserRepository;
import User.Roles.Guest;
import User.Roles.RegisteredUser;
import User.UserType;

public class UserServiceImplementation implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void addUser(UserType user)
    {
        if (userRepository.findById(user.getId()) != null)
        {
            return;
        }
        userRepository.addToRepo(user);
    }

    public void deleteUser(String id)
    {
        if (userRepository.findById(id) == null)
        {
            return;
        }
        userRepository.deleteById(id);
    }

    public UserType getUserById(String id)
    {
        return userRepository.findById(id);
    }
}

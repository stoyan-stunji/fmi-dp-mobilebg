package Commands.ForUsers;

import Commands.Command;
import User.Service.UserService;
import User.UserType;

public class AddUserCommand implements Command
{
    private final UserService userService;
    private final UserType user;

    public AddUserCommand(UserService userService, UserType user) {
        this.userService = userService;
        this.user = user;
    }

    public void execute()
    {
        userService.addUser(user);
    }
}

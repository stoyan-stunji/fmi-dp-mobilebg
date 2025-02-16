package Commands.ForUsers;

import Commands.Command;
import User.Service.UserService;
import User.UserType;

import java.util.Map;

public class ShowAllUsersCommand implements Command
{
    private final UserService userService;

    public ShowAllUsersCommand(UserService userService)
    {
        this.userService = userService;
    }

    public void execute()
    {
        Map<String, UserType> users = userService.getUserRepository().getStorage();

        for (UserType user : users.values())
        {
            System.out.println("ID: " + user.getId());
        }
    }
}

package Commands.ForUsers;

import Commands.Command;
import User.Roles.Dealership;
import User.Roles.RegisteredUser;
import User.Service.UserService;
import User.UserType;

public class LoginCommand implements Command
{
    private final UserService userService;
    private final String userId;
    private final String enteredPassword;
    private String message = "Error404";

    public LoginCommand(UserService userService, String userId, String enteredPassword)
    {
        this.userService = userService;
        this.userId = userId;
        this.enteredPassword = enteredPassword;
    }

    public String getMessage()
    {
        return message;
    }

    public void execute()
    {
        UserType user = userService.getUserById(userId);

        String correctPassword = "";
        if(user instanceof RegisteredUser)
        {
            correctPassword = ((RegisteredUser) user).getPassword();
        }
        else if(user instanceof Dealership)
        {
            correctPassword = ((Dealership) user).getPassword();
        }

        if(enteredPassword.equals(correctPassword))
        {
            message = "";
        }
    }
}

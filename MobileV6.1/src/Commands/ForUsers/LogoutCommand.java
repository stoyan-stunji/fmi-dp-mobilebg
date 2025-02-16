package Commands.ForUsers;

import Commands.Command;

public class LogoutCommand implements Command
{
    private final String userId;

    public LogoutCommand(String userId) {
        this.userId = userId;
    }

    public void execute()
    {
        System.out.println("Logging out...");
    }
}

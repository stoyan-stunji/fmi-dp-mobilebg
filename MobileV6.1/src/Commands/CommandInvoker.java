package Commands;

public class CommandInvoker
{
    private Command command;

    public void setCommand(Command command)
    {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null)
        {
            command.execute();
        }
    }

    public Command getCommand()
    {
        return this.command;
    }
}

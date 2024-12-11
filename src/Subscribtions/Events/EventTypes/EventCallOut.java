package Subscribtions.Events.EventTypes;

import Subscribtions.Events.EventFunction;
import User.UserType;

public class EventCallOut implements EventFunction
{
    public void execute(UserType user)
    {
        System.out.println("Call out event executed for user: " + user);
    }
}

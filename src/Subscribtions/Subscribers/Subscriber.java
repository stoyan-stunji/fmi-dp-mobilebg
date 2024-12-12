package Subscribtions.Subscribers;

import Subscribtions.Events.EventFunction;
import User.UserType;

public interface Subscriber
{
    void update(EventFunction eventFunction, UserType user);
}
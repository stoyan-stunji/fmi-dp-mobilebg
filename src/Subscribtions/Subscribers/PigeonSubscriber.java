package Subscribtions.Subscribers;

import Subscribtions.Events.EventFunction;
import Subscribtions.Notifiers.PigeonNotifier;
import User.UserType;

public class PigeonSubscriber implements Subscriber
{
    private final PigeonNotifier pigeonNotifier;
    private final String address;
    private final Integer pigeonNumber;
    private final String message;

    public PigeonSubscriber(PigeonNotifier pigeonNotifier, String address, String message, Integer pigeonNumber)
    {
        this.pigeonNotifier = pigeonNotifier;
        this.address = address;
        this.message = message;
        this.pigeonNumber = pigeonNumber;
    }

    public void update(EventFunction eventFunction, UserType user)
    {
        pigeonNotifier.sendPigeon(this.address, this.pigeonNumber, this.message);
    }
}


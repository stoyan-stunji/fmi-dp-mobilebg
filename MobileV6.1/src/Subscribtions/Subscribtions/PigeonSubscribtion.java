package Subscribtions.Subscribtions;

import Subscribtions.Notifiers.PigeonNotifier;

public class PigeonSubscribtion implements SubscribtionType
{
    private final PigeonNotifier pigeonNotifier;
    private final String address;

    public PigeonSubscribtion(PigeonNotifier pigeonNotifier, String address) {
        this.pigeonNotifier = pigeonNotifier;
        this.address = address;
    }

    public void update(String title, String message)
    {
        pigeonNotifier.sendPigeon(address, 1, title + System.lineSeparator() + message);
    }
}

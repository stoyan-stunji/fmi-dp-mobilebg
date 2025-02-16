package Subscribtions.Subscribtions;

import Subscribtions.Notifiers.OnFootNotifier;

public class OnFootSubscribtion implements SubscribtionType
{
    private final OnFootNotifier onFootNotifier;
    private final String address;

    public OnFootSubscribtion(OnFootNotifier onFootNotifier, String address)
    {
        this.onFootNotifier = onFootNotifier;
        this.address = address;
    }

    public void update(String title, String message)
    {
        onFootNotifier.deliverOnFoot(address, title + message);
    }
}

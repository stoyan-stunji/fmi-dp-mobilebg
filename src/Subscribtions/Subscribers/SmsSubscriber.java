package Subscribtions.Subscribers;

import Subscribtions.Events.EventFunction;
import Subscribtions.Notifiers.SmsNotifier;
import User.UserType;

public class SmsSubscriber implements Subscriber
{
    private final SmsNotifier smsNotifier;
    private final String phoneNumber;
    private final String message;

    public SmsSubscriber(SmsNotifier smsNotifier, String phoneNumber, String message)
    {
        this.smsNotifier = smsNotifier;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public void update(EventFunction eventFunction, UserType user)
    {
        smsNotifier.sendSms(this.phoneNumber, this.message);
    }
}


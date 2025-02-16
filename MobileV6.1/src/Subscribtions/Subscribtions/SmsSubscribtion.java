package Subscribtions.Subscribtions;

import Subscribtions.Notifiers.SmsNotifier;

public class SmsSubscribtion implements SubscribtionType
{
    private final SmsNotifier smsNotifier;
    private final String phoneNumber;

    public SmsSubscribtion(SmsNotifier smsNotifier, String phoneNumber)
    {
        this.smsNotifier = smsNotifier;
        this.phoneNumber = phoneNumber;
    }

    public void update(String title, String message)
    {
        smsNotifier.sendSms(phoneNumber, title + System.lineSeparator() + message);
    }
}
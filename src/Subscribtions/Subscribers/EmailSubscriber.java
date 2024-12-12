package Subscribtions.Subscribers;

import Subscribtions.Events.EventFunction;
import Subscribtions.Notifiers.EmailNotifier;
import User.UserType;

public class EmailSubscriber implements Subscriber
{
    private final EmailNotifier emailNotifier;
    private final String email;
    private final String title;
    private final String message;

    public EmailSubscriber(EmailNotifier emailNotifier, String email, String title, String message)
    {
        this.emailNotifier = emailNotifier;
        this.email = email;
        this.message = message;
        this.title = title;
    }

    public void update(EventFunction eventFunction, UserType user)
    {
        emailNotifier.sendEmail(this.email, this.title, this.message);
    }
}

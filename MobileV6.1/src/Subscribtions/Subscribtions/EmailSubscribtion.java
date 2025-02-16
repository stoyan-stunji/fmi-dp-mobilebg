package Subscribtions.Subscribtions;

import Subscribtions.Notifiers.EmailNotifier;

public class EmailSubscribtion implements SubscribtionType
{
    private final EmailNotifier emailNotifier;
    private final String email;

    public EmailSubscribtion(EmailNotifier emailNotifier, String email) {
        this.emailNotifier = emailNotifier;
        this.email = email;
    }

    public void update(String title, String message) {
        emailNotifier.sendEmail(email, title, message);
    }
}

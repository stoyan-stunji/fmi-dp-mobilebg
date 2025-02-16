package Subscribtions.Notifiers;

public class OnFootNotifier
{
    public void deliverOnFoot(String address, String message)
    {
        System.out.println("Delivering message on foot to " + address + " with message: " + message);
    }
}

package Subscribtions.Notifiers;

public class PigeonNotifier
{
    public void sendPigeon(String address, Integer pigeonNumber, String message)
    {
        System.out.println("Sending pigeon to " + address + " with message: " + message);
    }
}
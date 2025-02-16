package User;

public class IdGenerator
{
    private static int count = 0;

    public static int increment() {
        return ++count;
    }

    public static int getCount() {
        return count;
    }
}


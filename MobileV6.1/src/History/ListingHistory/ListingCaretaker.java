package History.ListingHistory;

import java.util.Stack;

public class ListingCaretaker
{
    private final Stack<ListingMemento> historyStack = new Stack<>();

    public void saveState(ListingMemento memento)
    {
        historyStack.push(memento);
    }

    public ListingMemento restoreState(int stepsBack)
    {
        Stack<ListingMemento> tempStack = new Stack<>();
        ListingMemento memento = null;

        while (stepsBack > 0 && !historyStack.isEmpty())
        {
            tempStack.push(historyStack.pop());
            stepsBack--;
        }

        if (!historyStack.isEmpty())
        {
            memento = historyStack.peek();
        }

        while (!tempStack.isEmpty())
        {
            historyStack.push(tempStack.pop());
        }

        return memento;
    }
}
package History.ProductHistory;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ProductCaretaker
{
    private final Stack<ProductMemento> historyStack = new Stack<>();
    private final List<ProductMemento> productList = new ArrayList<>();
    private final List<String> productDates = new ArrayList<>();

    public void saveState(ProductMemento memento, String date)
    {
        historyStack.push(memento);
        productList.add(memento);
        productDates.add(date);
    }

    public List<ProductMemento> getProductList()
    {
        return productList;
    }

    public List<String> getProductDates()
    {
        return productDates;
    }

    public Double getAvgPrice()
    {
        double sum = 0.0;
        for(ProductMemento list : productList)
        {
            sum += list.getProductSnapshot().getPrice();
        }
        return sum / productList.size();
    }

    public ProductMemento restoreState(int stepsBack)
    {
        Stack<ProductMemento> tempStack = new Stack<>();
        ProductMemento memento = null;

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

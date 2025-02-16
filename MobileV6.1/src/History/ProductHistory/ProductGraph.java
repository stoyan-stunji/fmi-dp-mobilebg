package History.ProductHistory;

import Products.Product;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductGraph extends JPanel {

    private final ProductCaretaker productCaretaker;

    public ProductGraph(ProductCaretaker productCaretaker)
    {
        this.productCaretaker = productCaretaker;
        setLayout(null);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        drawChart(g2d);
        drawAveragePrice(g2d);
    }

    private void drawChart(Graphics2D g2d)
    {
        List<ProductMemento> productList = productCaretaker.getProductList();
        List<String> productDates = productCaretaker.getProductDates();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        int padding = 50;
        int graphWidth = getWidth() - 2 * padding;
        int graphHeight = getHeight() - 100;

        g2d.drawLine(padding, graphHeight + padding, graphWidth + padding, graphHeight + padding);
        g2d.drawLine(padding, padding, padding, graphHeight + padding);

        g2d.drawString("Price ($)", graphWidth / 2, graphHeight + padding + 20);
        g2d.drawString("Date", padding - 40, graphHeight / 2);

        Date firstDate = parseDate(productDates.get(0), sdf);
        Date lastDate = parseDate(productDates.get(productDates.size() - 1), sdf);
        long timeSpan = lastDate.getTime() - firstDate.getTime();

        int prevX = -1, prevY = -1;

        for (int i = 0; i < productList.size(); i++)
        {
            Product product = productList.get(i).getProductSnapshot();
            Double price = product.getPrice();
            String dateStr = productDates.get(i);

            try {
                Date date = parseDate(dateStr, sdf);
                long dateInMillis = date.getTime();

                int x = (int) ((double) (dateInMillis - firstDate.getTime()) / timeSpan * graphWidth);
                int y = (int) ((1 - (price / getMaxPrice())) * graphHeight);

                if (prevX != -1 && prevY != -1) {
                    g2d.drawLine(prevX + padding, prevY + padding, x + padding, y + padding);
                }

                prevX = x;
                prevY = y;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void drawAveragePrice(Graphics2D g2d)
    {
        double avgPrice = this.productCaretaker.getAvgPrice();

        String avgPriceStr = String.format("Average Price: $%.2f", avgPrice);
        g2d.drawString(avgPriceStr, 50, getHeight() - 50);
    }

    private Date parseDate(String dateStr, SimpleDateFormat sdf)
    {
        try
        {
            return sdf.parse(dateStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private double getMaxPrice()
    {
        double maxPrice = 0.0;

        for (ProductMemento memento : productCaretaker.getProductList())
        {
            double price = memento.getProductSnapshot().getPrice();

            if (price > maxPrice)
            {
                maxPrice = price;
            }
        }

        return maxPrice;
    }
}

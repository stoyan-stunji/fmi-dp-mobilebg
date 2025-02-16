package History.ProductHistory;

import Products.Product;

public class ProductOriginator
{
    private Product currentProduct;

    public ProductOriginator(Product product)
    {
        this.currentProduct = product;
    }

    public void setProduct(Product product)
    {
        this.currentProduct = product;
    }

    public Product getProduct() {
        return this.currentProduct;
    }

    public ProductMemento saveToMemento()
    {
        return new ProductMemento(this.currentProduct.clone());
    }

    public void restoreFromMemento(ProductMemento memento) {
        this.currentProduct = memento.getProductSnapshot();
    }
}
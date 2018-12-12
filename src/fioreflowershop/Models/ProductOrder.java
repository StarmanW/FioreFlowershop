package fioreflowershop.Models;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class ProductOrder {

    private Product product;
    private int quantity;

    // Default Contructor
    public ProductOrder() {
        this(new Product(), 0);
    }

    // Parameterized Contructor
    public ProductOrder(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

package ShoppingApp;

public class CartBuilder {
    private Cart cart;

    public CartBuilder() {
        this.cart = Cart.getInstance();
    }

    public CartBuilder addProduct(Product product) {
        cart.addItem(product);
        return this;
    }

    public CartBuilder removeProduct(Product product) {
        cart.removeItem(product);
        return this;
    }

    public Cart build() {
        return cart;
    }
}

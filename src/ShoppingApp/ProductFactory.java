package ShoppingApp;

public class ProductFactory {
    public Product createProduct(String type, String name, double price, String description, String additionalInfo) {
        if ("Electronics".equalsIgnoreCase(type)) {
            return new Electronics(name, price, description, additionalInfo);
        } else if ("Clothing".equalsIgnoreCase(type)) {
            return new Clothing(name, price, description, additionalInfo);
        } else {
            throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}

package ShoppingApp;

import java.util.Scanner;

public interface IProductCatalog {
    void loadProducts();
    void displayProducts();
    void addProductToCart(Scanner scanner, Cart cart);
}

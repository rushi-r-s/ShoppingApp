package ShoppingAppTest;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ShoppingApp.Cart;
import ShoppingApp.ProductCatalog;

import java.util.Scanner;

public class ProductCatalogTest {
    private ProductCatalog productCatalog;
    private Cart cart;

    @BeforeEach
    public void setUp() {
        productCatalog = new ProductCatalog();
        productCatalog.loadProducts();
        cart = Cart.getInstance(); 
        cart.clearItems(); 
    }

    @Test
    public void testLoadProducts() {
        assertFalse(productCatalog.getProducts().isEmpty(), "Products should be loaded.");
    }
    
    @Test
    public void testAddProductToCart() {
        Scanner scanner = new Scanner("Laptop");
        productCatalog.addProductToCart(scanner, cart);
        assertFalse(cart.getItems().isEmpty(), "Cart should not be empty after adding a product.");
        assertTrue(cart.getItems().get(0).getName().equalsIgnoreCase("Laptop"), "Cart should contain the added product.");
        scanner.close(); 
    }
}

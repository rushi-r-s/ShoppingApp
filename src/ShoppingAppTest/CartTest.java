package ShoppingAppTest;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


import ShoppingApp.Cart;
import ShoppingApp.Electronics;
import ShoppingApp.Product;

public class CartTest {
    private Cart cart;
    private Product laptop;

    @Before
    public void setUp() {
        cart = Cart.getInstance();
        cart.clearItems();  
        laptop = new Electronics("Laptop", 1000.00, "laptop", "2 years");
    }

    @Test
    public void testAddItem() {
        cart.addItem(laptop);
        assertEquals("Cart should have 1 item after adding one product.", 1, cart.getItems().size());
    }

    @Test
    public void testRemoveItem() {
        cart.addItem(laptop);
        cart.removeItem(laptop);
        assertTrue("Cart should be empty after removing the product.", cart.getItems().isEmpty());
    }

    @Test
    public void testCalculateTotal() {
        cart.addItem(laptop);
        cart.addItem(new Electronics("Mobile", 400.00, "mobile", "1 year"));
        assertEquals("Total should be correctly calculated.", 1400.00, cart.calculateTotal(), 0.001);
    }
}

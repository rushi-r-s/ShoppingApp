package ShoppingAppTest;

import static org.junit.Assert.assertNotNull;


import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import ShoppingApp.Cart;
import ShoppingApp.Electronics;
import ShoppingApp.OrderProcessing;
import ShoppingApp.User;
import ShoppingApp.Order;

public class OrderProcessingTest {
    private OrderProcessing processor;
    private Cart cart;
    private User user;

    @Before
    public void setUp() {
        user = new User("testUser", "password");
        cart = Cart.getInstance();
        cart.clearItems();
        processor = new OrderProcessing(cart, user);
        cart.addItem(new Electronics("Laptop", 1000.00, "High-performance laptop", "2 years"));
    }

    @Test
    public void testOrderCreation() {
        Order order = processor.createAndProcessOrder(new Scanner("1"));  
        assertNotNull("Order should be created when there are items in the cart and a valid payment method is selected.", order);
    }

    @Test
    public void testOrderPayment() {
        Order order = processor.createAndProcessOrder(new Scanner("1"));
        String status = order.getOrderStatus();
        assertTrue("Order status should be either 'Completed' or 'Failed'",
                   "Completed".equals(status) || "Failed".equals(status));
    }
}

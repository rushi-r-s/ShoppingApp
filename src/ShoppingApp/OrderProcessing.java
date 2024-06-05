package ShoppingApp;

import java.util.Scanner;

public class OrderProcessing {
    private Cart cart;
    private User user;

    public OrderProcessing(Cart cart, User user) {
        this.cart = cart;
        this.user = user;
    }

    public Order createAndProcessOrder(Scanner scanner) {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty.");
            return null;
        }

        System.out.println("Please select a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        String paymentMethod = choice == 1 ? "Credit Card" : "PayPal";

        Order order = new Order(user, cart.getItems(), cart.calculateTotal(), paymentMethod);
        Logger.log("Order created for user: " + user.getUsername() + " with total amount: $" + order.getTotalAmount());

        boolean paymentSuccess = PaymentProcessor.processPayment(order.getTotalAmount(), order.getPaymentMethod());

        if (paymentSuccess) {
            order.setOrderStatus("Completed");
            Logger.log("Payment successful for order: " + order.getOrderStatus());
            cart.clearItems(); 
        } else {
            order.setOrderStatus("Failed");
            Logger.log("Payment failed for order: " + order.getOrderStatus());
        }

        return order;
    }
}

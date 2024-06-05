package ShoppingApp;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


public class Cart {
    private static Cart instance;
    private List<Product> items;

    private Cart() {
        items = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println("Added " + product.getName() + " to cart.");
    }

    public void removeItem(Product product) {
        items.remove(product);
        System.out.println("Removed " + product.getName() + " from cart.");
    }

    public List<Product> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void clearItems() {
        items.clear();
        System.out.println("Cart cleared!");
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            double total = 0;
            for (Product item : items) {
                System.out.println(item.getName() + " - $" + item.getPrice());
                total += item.getPrice();
            }
            System.out.println("Total amount of items in cart to be paid: $" + String.format("%.2f", total));
        }
    }
}


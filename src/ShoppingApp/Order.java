package ShoppingApp;
import java.util.Date;
import java.util.List;

public class Order {
    private User user;
    private List<Product> items;
    private double totalAmount;
    private Date orderDate;
    private String paymentMethod;
    private String orderStatus;

    public Order(User user, List<Product> items, double totalAmount, String paymentMethod) {
        this.user = user;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = new Date();
        this.paymentMethod = paymentMethod;
        this.orderStatus = "Pending"; 
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void displayOrderDetails() {
        System.out.println("Order Details:");
        System.out.println("User: " + user.getUsername());
        System.out.println("Total Amount: $" + String.format("%.2f", totalAmount));
        System.out.println("Order Date: " + orderDate);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Order Status: " + orderStatus);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
